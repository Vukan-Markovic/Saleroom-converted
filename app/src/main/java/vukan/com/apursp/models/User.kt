package vukan.com.apursp.models

data class User(
    var userID: String? = "",
    var username: String? = "",
    var location: String? = "",
    var grade: Float? = 0f,
    var phone: String? = "",
    var imageUrl: String? = ""
)