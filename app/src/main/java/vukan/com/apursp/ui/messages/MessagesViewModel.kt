package vukan.com.apursp.ui.messages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vukan.com.apursp.models.Message
import vukan.com.apursp.models.Product
import vukan.com.apursp.repository.Repository

class MessagesViewModel : ViewModel() {
    private val repository: Repository = Repository()

    fun getmMessages(
        sender: String?,
        receiver: String,
        productID: String
    ): MutableLiveData<MutableList<Message>> {
        return repository.getUserMessages(sender.toString(), receiver, productID)
    }

    fun sendMessage(m: Message) {
        repository.sendMessage(m)
    }

    fun getProductDetails(id: String?): MutableLiveData<Product> {
        return repository.getProductDetails(id)
    }
}