package vukan.com.apursp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vukan.com.apursp.models.Product
import vukan.com.apursp.repository.Repository

class HomeViewModel : ViewModel() {
    private val repository: Repository = Repository()
    private var mProducts: MutableLiveData<MutableList<Product>> = MutableLiveData()

    val products: MutableLiveData<MutableList<Product>>
        get() {
            mProducts = repository.getProducts()
            return mProducts
        }

    fun filterProducts(filters: Array<String>?): MutableLiveData<MutableList<Product>> {
        if (filters != null) mProducts = repository.filterProducts(filters)
        return mProducts
    }

    fun addProductToFavourites(productID: String) {
        repository.addProductToFavourites(productID)
    }

    fun removeProductFromFavourites(productID: String) {
        repository.removeProductFromFavourites(productID)
    }
}