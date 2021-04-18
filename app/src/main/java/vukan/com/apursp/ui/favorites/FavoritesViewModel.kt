package vukan.com.apursp.ui.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vukan.com.apursp.models.Product
import vukan.com.apursp.repository.Repository

class FavoritesViewModel : ViewModel() {
    private val repository: Repository = Repository()
    private var mProducts: MutableLiveData<MutableList<Product>> = MutableLiveData()

    val favouriteProducts: MutableLiveData<MutableList<Product>>
        get() {
            mProducts = repository.favouriteProducts
            return mProducts
        }

    fun removeProductFromFavourites(productID: String?) {
        if (productID != null) repository.removeProductFromFavourites(productID)
    }
}