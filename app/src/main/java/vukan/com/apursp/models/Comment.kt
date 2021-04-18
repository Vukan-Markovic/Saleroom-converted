package vukan.com.apursp.models

data class Comment(
    var fromUserID: String? = "",
    var toUserID: String? = "",
    var grade: Float = 0f,
    var comment: String? = ""
)