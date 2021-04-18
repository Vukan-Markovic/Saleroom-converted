package vukan.com.apursp.ui.new_ad_window

import androidx.lifecycle.ViewModel
import vukan.com.apursp.models.Product
import vukan.com.apursp.models.ProductImage
import vukan.com.apursp.repository.Repository

class NewAdWindowViewModel : ViewModel() {
    private val repository: Repository = Repository()

    fun addProduct(p: Product, productID: String): String {
        return repository.addProduct(p, productID)
    }

    fun addProductImage(pi: ProductImage) {
        repository.addProductImage(pi)
    }

    fun deleteProductImage(url: String?) {
        repository.deleteProductImage(url)
    }
}