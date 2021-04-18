package vukan.com.apursp.firebase

import android.graphics.Bitmap
import android.net.Uri
import com.google.android.gms.tasks.Task
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.*
import vukan.com.apursp.callbacks.FavoriteCallback
import vukan.com.apursp.callbacks.FavoritesCallback
import vukan.com.apursp.callbacks.ProductCallback
import vukan.com.apursp.models.*
import java.util.*
import kotlin.reflect.KFunction1

class Database {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var products: MutableList<Product> = ArrayList()
    private var categories: MutableList<ProductCategory> = ArrayList()
    private var favouritesProducts: MutableList<FavoriteProduct> = ArrayList()
    private var productImages: MutableList<ProductImage> = ArrayList()
    private var userProducts: MutableList<Product> = ArrayList()
    private var userMessages: MutableList<Message> = ArrayList()
    private var userallMessages: MutableList<Message> = ArrayList()
    private var allUserConv: MutableList<Conv> = ArrayList()
    private var userComments: MutableList<Comment> = ArrayList()
    private var listOfsenders: MutableList<String?> = ArrayList()
    private var listOfproductid: MutableList<String?> = ArrayList()
    private val firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private val storage: Storage = Storage()

    fun deleteConversation(conv: Conv) {
        for (m in conv.messages) {
            firestore.collection("messages").whereEqualTo("productID", m.productID)
                .whereEqualTo("senderID", m.senderID)
                .whereEqualTo("receiverID", m.receiverID).get()
                .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) document.reference.delete()
                    }
                }
        }
    }

    fun deleteProductImage(url: String?) {
        firestore.collection("productsImages").whereEqualTo("imageUrl", url).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) document.reference.delete()
                }
            }
    }

    fun updateProfilePicture(imageUrl: Uri?) {
        storage.updateProfilePicture(firebaseUser?.uid.toString(), imageUrl)
    }

    fun updateProfilePictureBitmap(imageBitmap: Bitmap?) {
        if (imageBitmap != null)
            storage.updateProfilePictureBitmap(firebaseUser?.uid.toString(), imageBitmap)
    }

    fun deleteUserData(userID: String?) {
        firestore.collection("products").whereEqualTo("userID", userID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) document.reference.delete()
                }
            }

        firestore.collection("messages").whereEqualTo("receiverID", userID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) document.reference.delete()
                }
            }

        firestore.collection("messages").whereEqualTo("senderID", userID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) document.reference.delete()
                }
            }
    }

    fun deleteProduct(id: String?) {
        if (id != null) firestore.collection("products").document(id).delete()
    }

    fun getProductUser(id: String?, callback: KFunction1<User, Unit>) {
        firestore.collection("users").whereEqualTo("userID", id).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val user = User(
                            userID = id.toString(),
                            username = document.getString("username"),
                            imageUrl = document.getString("imageUrl"),
                            phone = document.getString("phone"),
                            location = document.getString("location")
                        )

                        callback(user)
                    }
                }
            }
    }

    fun isFavourite(productID: String, userID: String, callback: FavoriteCallback) {
        firestore.collection("favouriteProducts").document(productID + userID).get()
            .addOnCompleteListener { task: Task<DocumentSnapshot?> ->
                if (task.isSuccessful) {
                    callback.onCallback(task.result!!.exists())
                }
            }
    }

    fun addUser(user: FirebaseUser?) {
        val doc = firestore.collection("users").document(user?.uid.toString())

        firestore.runTransaction { transaction: Transaction ->
            val snapshot = transaction[doc]

            if (!snapshot.exists()) {
                val databaseUser = User(
                    userID = user?.uid,
                    username = user?.displayName,
                    imageUrl = user?.photoUrl.toString()
                )

                firestore.collection("users")
                    .document(databaseUser.userID.toString())[databaseUser] = SetOptions.merge()
            }

            null
        }
    }

    fun sendMessage(m: Message) {
        firestore.collection("messages").whereEqualTo("productID", m.productID)
            .whereEqualTo("senderID", m.senderID)
            .whereEqualTo("receiverID", m.receiverID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    if (task.result!!.isEmpty) {
                        val emptyMessage = Message(
                            receiverID = m.senderID,
                            productID = m.productID,
                            senderID = m.receiverID,
                            dateTime = Timestamp(Date(1)),
                            content = ""
                        )

                        firestore.collection("messages").add(emptyMessage)
                    }

                    firestore.collection("messages").add(m)
                }
            }
    }

    fun addProduct(p: Product, productID: String): String {
        val newProductRef: DocumentReference =
            if (productID == "0") firestore.collection("products").document()
            else firestore.collection("products").document(productID)

        newProductRef.set(
            Product(
                categoryID = p.categoryID,
                datetime = p.datetime,
                description = p.description,
                homePhotoUrl = p.homePhotoUrl,
                name = p.name,
                price = p.price,
                productID = newProductRef.id,
                seen = p.seen,
                userID = p.userID,
                currency = p.currency,
                fixPrice = p.fixPrice
            ), SetOptions.merge()
        )

        return newProductRef.id
    }

    fun addProductImage(pi: ProductImage) {
        firestore.collection("productsImages").document(pi.imageUrl.toString())[pi] =
            SetOptions.merge()
    }

    fun getUserMessages(
        senderId: String,
        receiverId: String,
        productID: String?,
        callback: KFunction1<MutableList<Message>, Unit>
    ) {
        userMessages = ArrayList()

        firestore.collection("messages").orderBy("dateTime").whereEqualTo("productID", productID)
            .whereIn("senderID", listOf(receiverId, senderId)).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        if (document.getString("senderID") == receiverId) {
                            if (document.getString("receiverID") != senderId) continue
                        }

                        val message = Message(
                            content = document.getString("content"),
                            dateTime = document.getTimestamp("dateTime"),
                            senderID = document.getString("senderID"),
                            productID = document.getString("productID"),
                            receiverID = document.getString("receiverID")
                        )

                        userMessages.add(message)
                    }

                    callback(userMessages)
                }
            }
    }

    fun getAllUserMessages(user: String, callback: KFunction1<MutableList<Conv>, Unit>) {
        userallMessages = ArrayList()
        allUserConv = ArrayList()
        listOfsenders = ArrayList()
        listOfproductid = ArrayList()

        firestore.collection("messages").orderBy("dateTime").whereEqualTo("receiverID", user).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val sender: String? = document.getString("senderID")
                        if (!listOfsenders.contains(sender)) listOfsenders.add(sender)
                        val productid: String? = document.getString("productID")
                        if (!listOfproductid.contains(productid)) listOfproductid.add(productid)
                    }
                }

                firestore.collection("messages").orderBy("dateTime").get()
                    .addOnCompleteListener { taskk: Task<QuerySnapshot?> ->
                        if (taskk.isSuccessful) {
                            for (document in taskk.result!!) {
                                val message = Message(
                                    content = document.getString("content"),
                                    dateTime = document.getTimestamp("dateTime"),
                                    senderID = document.getString("senderID"),
                                    productID = document.getString("productID"),
                                    receiverID = document.getString("receiverID")
                                )

                                userallMessages.add(message)
                            }
                        }

                        for (prodid in listOfproductid) {
                            for (sendid in listOfsenders) {
                                val jednakonverzacija = Conv()

                                for (message in userallMessages) {
                                    if (message.productID == prodid && (message.receiverID == sendid && message.senderID == user
                                                || message.senderID == sendid && message.receiverID == user)
                                    )
                                        jednakonverzacija.messages.add(message)
                                }

                                if (jednakonverzacija.messages.size > 0)
                                    allUserConv.add(jednakonverzacija)
                            }
                        }

                        for (c in allUserConv) {
                            var id = c.messages[0].receiverID

                            if (id == Objects.requireNonNull(firebaseUser)?.uid)
                                id = c.messages[0].senderID

                            firestore.collection("users").whereEqualTo("userID", id).get()
                                .addOnCompleteListener { task1: Task<QuerySnapshot?> ->
                                    if (task1.isSuccessful) {
                                        for (document in task1.result!!)
                                            c.userName = document.getString("username")

                                        firestore.collection("products")
                                            .whereEqualTo("productID", c.messages[0].productID)
                                            .get()
                                            .addOnCompleteListener { task2: Task<QuerySnapshot?> ->
                                                if (task2.isSuccessful) {
                                                    for (document in task2.result!!)
                                                        c.productName = document.getString("name")

                                                    callback(allUserConv)
                                                }
                                            }
                                    }
                                }
                        }
                    }
            }
    }

    fun getProducts(callback: KFunction1<MutableList<Product>, Unit>) {
        products = ArrayList()

        firestore.collection("products").orderBy("datetime", Query.Direction.DESCENDING).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val product = Product(
                            name = document.getString("name"),
                            description = document.getString("description"),
                            homePhotoUrl = document.getString("homePhotoUrl"),
                            productID = document.getString("productID"),
                            userID = document.getString("userID")
                        )

                        products.add(product)
                        callback(products)
                    }

                    if (task.result!!.documents.isEmpty()) callback(products)
                }
            }
    }

    fun getCategories(callback: KFunction1<List<ProductCategory>, Unit>) {
        categories = ArrayList()

        firestore.collection("productCategories").get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val category = ProductCategory()
                        category.name = document.getString("name")
                        category.categoryID = document.getString("categoryID")
                        categories.add(category)
                    }

                    callback(categories)
                }
            }
    }

    fun getCategory(categoryID: String?, callback: KFunction1<ProductCategory, Unit>) {
        firestore.collection("productCategories").whereEqualTo("categoryID", categoryID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val category = ProductCategory()
                        category.name = document.getString("name")
                        category.categoryID = document.getString("categoryID")
                        callback(category)
                    }
                }
            }
    }

    fun getProduct(id: String?, callback: ProductCallback) {
        firestore.collection("products").whereEqualTo("productID", id).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val product = Product(
                            name = document.getString("name"),
                            productID = document.getString("productID"),
                            homePhotoUrl = document.getString("homePhotoUrl")
                        )

                        callback.onCallback(product)
                    }
                }
            }
    }

    fun getFavouriteProducts(userID: String?, callback: FavoritesCallback) {
        favouritesProducts = ArrayList()

        firestore.collection("favouriteProducts").whereEqualTo("userID", userID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val product = FavoriteProduct()
                        product.userID = userID
                        product.productID = document.getString("productID")
                        favouritesProducts.add(product)
                    }

                    callback.onCallback(favouritesProducts)
                }
            }
    }

    fun filterProducts(filters: Array<String?>, callback: KFunction1<MutableList<Product>, Unit>) {
        products = ArrayList()
        var query: Query = firestore.collection("products")

        if (filters[0] == null && filters[1] == null && filters[2] == null && filters[3] == null) {
            query = query.orderBy("datetime", Query.Direction.DESCENDING)
        }

        if (filters[0]?.isNotEmpty() == true)
            query = query.whereGreaterThanOrEqualTo("price", java.lang.Double.valueOf(filters[0]!!))

        if (filters[1]?.isNotEmpty() == true)
            query = query.whereLessThanOrEqualTo("price", java.lang.Double.valueOf(filters[1]!!))

        if (filters[2]?.isNotEmpty() == true) {
            query =
                if (filters[2] == "opadajuce") query.orderBy("price", Query.Direction.DESCENDING)
                else query.orderBy("price", Query.Direction.ASCENDING)
        }

        if (filters[3]?.isNotEmpty() == true)
            query = query.whereEqualTo("categoryID", filters[3])

        query.get().addOnCompleteListener { task: Task<QuerySnapshot?> ->
            if (task.isSuccessful) {
                for (document in task.result!!) {
                    val product = Product(
                        name = document.getString("name"),
                        homePhotoUrl = document.getString("homePhotoUrl"),
                        productID = document.getString("productID"),
                        userID = document.getString("userID")
                    )

                    products.add(product)
                    callback(products)
                }

                if (task.result!!.documents.isEmpty()) callback(products)
            }
        }
    }

    fun incrementCounter(productID: String?, id: String) {
        val doc = firestore.collection("products").document(productID!!)

        firestore.runTransaction { transaction: Transaction ->
            val snapshot = transaction[doc]

            if (snapshot.getString("userID") != id) {
                val seen = Objects.requireNonNull(snapshot.getLong("seen"))?.plus(1)
                transaction.update(doc, "seen", seen)
            }

            null
        }
    }

    fun getProductImages(id: String?, callback: KFunction1<List<ProductImage>, Unit>) {
        productImages = ArrayList()

        firestore.collection("productsImages").whereEqualTo("productID", id).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val productImage = ProductImage(imageUrl = document.getString("imageUrl"))
                        productImages.add(productImage)
                    }

                    callback(productImages)
                }
            }
    }

    fun getProductDetails(id: String?, callback: KFunction1<Product, Unit>) {
        firestore.collection("products").whereEqualTo("productID", id).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val product = Product(
                            homePhotoUrl = document.getString("homePhotoUrl"),
                            categoryID = document.getString("categoryID"),
                            description = document.getString("description"),
                            name = document.getString("name"),
                            price = document.getDouble("price"),
                            productID = document.getString("productID"),
                            datetime = document.getTimestamp("datetime"),
                            seen = document.getLong("seen"),
                            userID = document.getString("userID"),
                            currency = document.getString("currency"),
                            fixPrice = document.getBoolean("fixPrice")
                        )

                        callback(product)
                    }
                }
            }
    }

    fun getUser(userID: String?, callback: KFunction1<User, Unit>) {
        if (userID != null) {
            firestore.collection("users").whereEqualTo("userID", userID).get()
                .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            val user = User(
                                userID = document.getString("userID"),
                                username = document.getString("username"),
                                location = document.getString("location"),
                                phone = document.getString("phone"),
                                imageUrl = document.getString("imageUrl")
                            )

                            callback(user)
                        }
                    }
                }
        }
    }

    fun getUserProducts(userID: String?, callback: KFunction1<List<Product>, Unit>) {
        userProducts = ArrayList()

        firestore.collection("products").whereEqualTo("userID", userID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val product = Product(
                            name = document.getString("name"),
                            homePhotoUrl = document.getString("homePhotoUrl"),
                            productID = document.getString("productID"),
                            datetime = document.getTimestamp("datetime")
                        )

                        userProducts.add(product)
                    }

                    callback(userProducts)
                }
            }
    }

    fun addUserComment(newComment: Comment) {
        val newCommentRef = firestore.collection("comments").document()

        newCommentRef.set(
            Comment(
                fromUserID = newComment.fromUserID,
                toUserID = newComment.toUserID,
                comment = newComment.comment,
                grade = newComment.grade
            )
        )
    }

    fun getUserComments(userID: String?, callback: KFunction1<List<Comment>, Unit>) {
        userComments = ArrayList()

        firestore.collection("comments").whereEqualTo("toUserID", userID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val comment = Comment(
                            toUserID = userID,
                            fromUserID = document.getString("fromUserID"),
                            comment = document.getString("comment"),
                            grade = java.lang.Float.valueOf(document.getDouble("grade").toString())
                        )

                        userComments.add(comment)
                    }

                    callback(userComments)
                }
            }
    }

    fun getUserRating(userID: String?, callback: KFunction1<Float, Unit>) {
        val sums = ArrayList<Double?>()

        firestore.collection("comments").whereEqualTo("toUserID", userID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val value = document.getDouble("grade")
                        sums.add(value)
                    }
                }

                var count = 0
                var sum = 0.0

                while (sums.size > count) {
                    sum += sums[count]!!
                    count++
                }

                if (count == 0) callback(0.toFloat())
                val grade = sum.toFloat() / count
                callback(grade)
            }
    }

    fun addProductToFavourites(productID: String, userID: String) {
        val product = FavoriteProduct()
        product.productID = productID
        product.userID = userID
        firestore.collection("favouriteProducts").document(productID + userID).set(product)
    }

    fun removeProductFromFavourites(productID: String, userID: String) {
        firestore.collection("favouriteProducts").document(productID + userID).delete()
    }

    fun editUserInfo(user: User) {
        firebaseUser?.updateProfile(
            UserProfileChangeRequest.Builder()
                .setDisplayName(user.username)
                .build()
        )

        firestore.collection("users").document(user.userID.toString())
            .update("phone", user.phone, "username", user.username, "location", user.location)
    }

    fun reportAd(productID: String?) {
        val reportProduct = ReportProduct()
        reportProduct.userID = firebaseUser?.uid
        reportProduct.productID = productID
        firestore.collection("reportsProducts").document()[reportProduct] = SetOptions.merge()
    }

    fun reportUser(userID: String?) {
        val reportUser = ReportUser()
        reportUser.reporterUserID = firebaseUser?.uid
        reportUser.reportedUserID = userID
        firestore.collection("reportsUsers").document()[reportUser] = SetOptions.merge()

        firestore.collection("messages").whereEqualTo("senderID", reportUser.reportedUserID)
            .whereEqualTo("receiverID", reportUser.reporterUserID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) document.reference.delete()
                }
            }

        firestore.collection("messages").whereEqualTo("senderID", reportUser.reporterUserID)
            .whereEqualTo("receiverID", reportUser.reportedUserID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) document.reference.delete()
                }
            }

        firestore.collection("comments").whereEqualTo("fromUserID", reportUser.reporterUserID)
            .whereEqualTo("toUserID", reportUser.reportedUserID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) document.reference.delete()
                }
            }

        firestore.collection("messages").whereEqualTo("fromUserID", reportUser.reportedUserID)
            .whereEqualTo("toUserID", reportUser.reporterUserID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in task.result!!) document.reference.delete()
                }
            }

        firestore.collection("products").whereEqualTo("userID", userID).get()
            .addOnCompleteListener { task: Task<QuerySnapshot?> ->
                if (task.isSuccessful) {
                    for (document in Objects.requireNonNull(task.result)!!) {
                        firestore.collection("favouriteProducts")
                            .whereEqualTo("userID", firebaseUser?.uid)
                            .whereEqualTo("productID", document.getString("productID")).get()
                            .addOnCompleteListener { task1: Task<QuerySnapshot?> ->
                                if (task1.isSuccessful) {
                                    for (document1 in task1.result!!) document1.reference.delete()
                                }
                            }
                    }
                }
            }
    }
}