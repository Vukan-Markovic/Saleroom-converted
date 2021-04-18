package vukan.com.apursp.callbacks

import vukan.com.apursp.models.Product

interface ProductCallback {
    fun onCallback(product: Product)
}