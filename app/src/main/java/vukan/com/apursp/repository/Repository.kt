package vukan.com.apursp.repository

import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import vukan.com.apursp.R
import vukan.com.apursp.callbacks.*
import vukan.com.apursp.firebase.Database
import vukan.com.apursp.models.*
import java.util.*

class Repository {
    private val database: Database = Database()
    private val mProducts: MutableLiveData<MutableList<Product>> = MutableLiveData()
    private var mFavouritesProducts: List<FavoriteProduct> = ArrayList()
    private val mCategories: MutableLiveData<List<ProductCategory>> = MutableLiveData()
    private val mProduct: MutableLiveData<Product> = MutableLiveData()
    private val mProductImages: MutableLiveData<List<ProductImage>> = MutableLiveData()
    private val mProductCategory: MutableLiveData<ProductCategory> = MutableLiveData()
    private val mUser: MutableLiveData<User> = MutableLiveData()
    private val mUserRating: MutableLiveData<Float> = MutableLiveData()
    private val mUserProducts: MutableLiveData<List<Product>> = MutableLiveData()
    private var user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private val mMessages: MutableLiveData<MutableList<Message>> = MutableLiveData()
    private val mConv: MutableLiveData<MutableList<Conv>> = MutableLiveData()
    private val mProductUser: MutableLiveData<User> = MutableLiveData()
    private val mUserComments: MutableLiveData<List<Comment>> = MutableLiveData()

    fun reportUser(userID: String?) {
        database.reportUser(userID)
    }

    fun deleteConversation(conv: Conv?) {
        database.deleteConversation(conv!!)
    }

    fun deleteProductImage(url: String?) {
        database.deleteProductImage(url)
    }

    fun deleteUserData(userID: String?) {
        database.deleteUserData(userID)
    }

    fun deleteProduct(id: String?) {
        database.deleteProduct(id)
    }

    val categories: MutableLiveData<List<ProductCategory>>
        get() {
            database.getCategories(mCategories::setValue)
            return mCategories
        }

    fun getProductUser(id: String?): MutableLiveData<User> {
        database.getProductUser(id, mProductUser::setValue)
        return mProductUser
    }

    fun addUser() {
        user = FirebaseAuth.getInstance().currentUser
        database.addUser(user)
    }

    fun updateProfilePicture(imageUrl: Uri?) {
        database.updateProfilePicture(imageUrl)
    }

    fun updateProfilePictureBitmap(imageBitmap: Bitmap?) {
        database.updateProfilePictureBitmap(imageBitmap)
    }

    fun sendMessage(m: Message) {
        database.sendMessage(m)
    }

    fun addProduct(p: Product, productID: String): String {
        return database.addProduct(p, productID)
    }

    fun addProductImage(pi: ProductImage) {
        database.addProductImage(pi)
    }

    fun getUserMessages(
        sender: String,
        receiver: String,
        productID: String
    ): MutableLiveData<MutableList<Message>> {
        database.getUserMessages(sender, receiver, productID, mMessages::setValue)
        return mMessages
    }

    fun getAllUserMessages(sender: String?): MutableLiveData<MutableList<Conv>> {
        if (sender != null) database.getAllUserMessages(sender, mConv::setValue)
        return mConv
    }

    fun getProducts(): MutableLiveData<MutableList<Product>> {
        database.getProducts(mProducts::setValue)
        return mProducts
    }

    val favouriteProducts: MutableLiveData<MutableList<Product>>
        get() {
            val products: MutableList<Product> = ArrayList()
            mProducts.value = products

            database.getFavouriteProducts(user?.uid, object : FavoritesCallback {
                override fun onCallback(favoritesProducts: List<FavoriteProduct>) {
                    mFavouritesProducts = favoritesProducts

                    for (product in mFavouritesProducts) {
                        database.getProduct(product.productID, object : ProductCallback {
                            override fun onCallback(product: Product) {
                                products.add(product)
                                mProducts.value = products
                            }
                        })
                    }
                }
            })

            return mProducts
        }

    fun filterProducts(filters: Array<String?>): MutableLiveData<MutableList<Product>> {
        database.filterProducts(filters, mProducts::setValue)
        return mProducts
    }

    fun isFavourite(productID: String?, v: View) {
        database.isFavourite(productID.toString(), user?.uid.toString(), object : FavoriteCallback {
            override fun onCallback(isFavorite: Boolean) {
                if (isFavorite)
                    v.background = ContextCompat.getDrawable(v.context, R.drawable.ic_star)
                else
                    v.background = ContextCompat.getDrawable(v.context, R.drawable.ic_star_border)
            }
        })
    }

    fun incrementCounter(id: String?) {
        database.incrementCounter(id, user?.uid.toString())
    }

    fun getProductDetails(id: String?): MutableLiveData<Product> {
        database.getProductDetails(id, mProduct::setValue)
        return mProduct
    }

    fun getProductImages(id: String?): MutableLiveData<List<ProductImage>> {
        database.getProductImages(id, mProductImages::setValue)
        return mProductImages
    }

    fun getUser(userID: String?): MutableLiveData<User> {
        database.getUser(userID, mUser::setValue)
        return mUser
    }

    fun getUserRating(userID: String?): MutableLiveData<Float> {
        database.getUserRating(userID, mUserRating::setValue)
        return mUserRating
    }

    fun getCategory(id: String?): MutableLiveData<ProductCategory> {
        database.getCategory(id, mProductCategory::setValue)
        return mProductCategory
    }

    fun getUserProducts(userID: String?): MutableLiveData<List<Product>> {
        database.getUserProducts(userID, mUserProducts::setValue)
        return mUserProducts
    }

    fun addNewUserComment(newComment: Comment) {
        database.addUserComment(newComment)
    }

    fun getUserComments(userID: String?): MutableLiveData<List<Comment>> {
        database.getUserComments(userID, mUserComments::setValue)
        return mUserComments
    }

    fun addProductToFavourites(productID: String) {
        database.addProductToFavourites(productID, user?.uid.toString())
    }

    fun removeProductFromFavourites(productID: String) {
        database.removeProductFromFavourites(productID, user?.uid.toString())
    }

    fun editUserInfo(user: User) {
        database.editUserInfo(user)
    }

    fun reportAd(productID: String) {
        database.reportAd(productID)
    }
}