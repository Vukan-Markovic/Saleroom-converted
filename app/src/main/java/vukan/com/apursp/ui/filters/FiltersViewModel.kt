package vukan.com.apursp.ui.filters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vukan.com.apursp.models.ProductCategory
import vukan.com.apursp.repository.Repository

class FiltersViewModel : ViewModel() {
    private val repository: Repository = Repository()
    private var mCategories: MutableLiveData<List<ProductCategory>> = MutableLiveData()

    val categories: MutableLiveData<List<ProductCategory>>
        get() {
            mCategories = repository.categories
            return mCategories
        }
}