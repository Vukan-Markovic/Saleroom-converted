package vukan.com.apursp.models

data class Conv(
    val messages: MutableList<Message> = mutableListOf(),
    var productName: String? = "",
    var userName: String? = ""
)