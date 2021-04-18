package vukan.com.apursp.ui.user_messages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vukan.com.apursp.models.Conv
import vukan.com.apursp.repository.Repository

class UserMessagesViewModel : ViewModel() {
    private val repository: Repository = Repository()

    fun getAllUserMessages(sender: String?): MutableLiveData<MutableList<Conv>> {
        return repository.getAllUserMessages(sender)
    }

    fun deleteConversation(conv: Conv?) {
        repository.deleteConversation(conv)
    }
}