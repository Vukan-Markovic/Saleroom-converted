package vukan.com.apursp.models

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.firebase.Timestamp
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Message(
    var content: String? = "",
    var dateTime: Timestamp? = Timestamp.now(),
    var productID: String? = "",
    var senderID: String? = "",
    var receiverID: String? = ""
) : Parcelable