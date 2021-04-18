package vukan.com.apursp.models

import com.google.firebase.Timestamp

data class Product(
    var productID: String? = "",
    var name: String? = "",
    var description: String? = "",
    var price: Double? = 0.0,
    var datetime: Timestamp? = Timestamp.now(),
    var categoryID: String? = "",
    var userID: String? = "",
    var homePhotoUrl: String? = "",
    var seen: Long? = 0,
    var fixPrice: Boolean? = false,
    var currency: String? = ""
)