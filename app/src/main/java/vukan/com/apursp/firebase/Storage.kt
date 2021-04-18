package vukan.com.apursp.firebase

import android.graphics.Bitmap
import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageMetadata
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.util.*

class Storage {
    private val storage: StorageReference = FirebaseStorage.getInstance().reference
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getProductImage(productID: String): StorageReference {
        return storage.child("$productID.jpg")
    }

    fun updateProfilePicture(userID: String, imageUrl: Uri?) {
        val filePath = storage.child(userID + UUID.randomUUID().toString())

        if (imageUrl != null) {
            filePath.putFile(
                imageUrl,
                StorageMetadata.Builder().setContentType("image/jpg").build()
            )
                .addOnSuccessListener {
                    filePath.downloadUrl.addOnSuccessListener { uri: Uri ->
                        update(userID, uri)
                    }
                }
        }
    }

    fun updateProfilePictureBitmap(userID: String, imageBitmap: Bitmap) {
        val baos = ByteArrayOutputStream()
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val filePath = storage.child(userID + UUID.randomUUID().toString())

        filePath.putBytes(
            baos.toByteArray(),
            StorageMetadata.Builder().setContentType("image/jpg").build()
        )
            .addOnSuccessListener {
                filePath.downloadUrl.addOnSuccessListener { uri: Uri ->
                    update(userID, uri)
                }
            }
    }

    private fun update(userID: String, imageUrl: Uri) {
        firestore.collection("users").document(userID).update("imageUrl", imageUrl.toString())
        val builder = UserProfileChangeRequest.Builder()
        builder.photoUri = imageUrl
        FirebaseAuth.getInstance().currentUser?.updateProfile(builder.build())
    }
}