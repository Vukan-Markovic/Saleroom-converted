package vukan.com.apursp.ui.my_ads

import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vukan.com.apursp.models.Comment
import vukan.com.apursp.models.Product
import vukan.com.apursp.models.User
import vukan.com.apursp.repository.Repository

class MyAdsViewModel : ViewModel() {
    private val repository: Repository = Repository()
    private var mUser: MutableLiveData<User> = MutableLiveData()
    private var mUserRating: MutableLiveData<Float> = MutableLiveData()
    private var mProduct: MutableLiveData<List<Product>> = MutableLiveData()
    private var mComments: MutableLiveData<List<Comment>> = MutableLiveData()

    fun reportUser(userID: String?) {
        repository.reportUser(userID)
    }

    fun updateProfilePicture(imageUrl: Uri?) {
        repository.updateProfilePicture(imageUrl)
    }

    fun updateProfilePictureBitmap(imageBitmap: Bitmap?) {
        repository.updateProfilePictureBitmap(imageBitmap)
    }

    fun getUser(userID: String?): MutableLiveData<User> {
        mUser = repository.getUser(userID)
        return mUser
    }

    fun getUserRating(userID: String?): MutableLiveData<Float> {
        mUserRating = repository.getUserRating(userID)
        return mUserRating
    }

    fun deleteUserData(userID: String?) {
        repository.deleteUserData(userID)
    }

    fun addNewUserComment(newComment: Comment) {
        repository.addNewUserComment(newComment)
    }

    fun addUser() {
        repository.addUser()
    }

    fun getUserProducts(userID: String?): MutableLiveData<List<Product>> {
        mProduct = repository.getUserProducts(userID)
        return mProduct
    }

    fun getUserComments(userID: String?): MutableLiveData<List<Comment>> {
        mComments = repository.getUserComments(userID)
        return mComments
    }

    fun editUserInfo(user: User) {
        repository.editUserInfo(user)
    }
}