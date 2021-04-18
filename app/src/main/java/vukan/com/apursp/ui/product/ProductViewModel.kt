package vukan.com.apursp.ui.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vukan.com.apursp.models.Product
import vukan.com.apursp.models.ProductCategory
import vukan.com.apursp.models.ProductImage
import vukan.com.apursp.models.User
import vukan.com.apursp.repository.Repository

class ProductViewModel : ViewModel() {
    private val repository: Repository = Repository()
    private var mProductImages: MutableLiveData<List<ProductImage>> = MutableLiveData()
    private var mProductDetails: MutableLiveData<Product> = MutableLiveData()
    private var mProductCategory: MutableLiveData<ProductCategory> = MutableLiveData()
    private var mProductUser: MutableLiveData<User> = MutableLiveData()

    fun getProductImages(id: String?): MutableLiveData<List<ProductImage>> {
        mProductImages = repository.getProductImages(id)
        return mProductImages
    }

    fun getProductDetails(id: String?): MutableLiveData<Product> {
        mProductDetails = repository.getProductDetails(id)
        return mProductDetails
    }

    fun getProductUser(id: String?): MutableLiveData<User> {
        mProductUser = repository.getProductUser(id)
        return mProductUser
    }

    fun getCategory(id: String?): MutableLiveData<ProductCategory> {
        mProductCategory = repository.getCategory(id)
        return mProductCategory
    }

    fun deleteProduct(id: String?) {
        repository.deleteProduct(id)
    }

    fun incrementCounter(id: String?) {
        repository.incrementCounter(id)
    }

    fun reportAd(productID: String) {
        repository.reportAd(productID)
    }
}