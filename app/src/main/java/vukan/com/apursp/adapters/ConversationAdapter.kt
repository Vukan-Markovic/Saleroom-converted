package vukan.com.apursp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import vukan.com.apursp.R
import vukan.com.apursp.adapters.ConversationAdapter.ConversationViewHolder
import vukan.com.apursp.models.Conv
import vukan.com.apursp.ui.user_messages.UserMessagesFragmentDirections
import java.text.SimpleDateFormat
import java.util.*

class ConversationAdapter(private val listener: ListItemClickListener) :
    RecyclerView.Adapter<ConversationViewHolder>() {

    private var conversations: List<Conv> = ArrayList()
    private val sfd: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    fun setConversations(conversations: List<Conv>) {
        this.conversations = conversations
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        return ConversationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.conversation, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(
                UserMessagesFragmentDirections.obavestenjaToPorukeFragmentAction(conversations[position].messages.toTypedArray())
            )
        }

        holder.itemView.setOnLongClickListener { view: View ->
            listener.onListItemClick(conversations[position], view)
            true
        }
    }

    override fun getItemCount(): Int {
        return conversations.size
    }

    inner class ConversationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val senderName: TextView = itemView.findViewById(R.id.sender_name)
        private val adName: TextView = itemView.findViewById(R.id.ad_name)
        private val lastMessage: TextView = itemView.findViewById(R.id.last_message)
        private val date: TextView = itemView.findViewById(R.id.date)

        fun bind(index: Int) {
            adName.text = conversations[index].productName
            senderName.text = conversations[index].userName

            lastMessage.text =
                conversations[index].messages[conversations[index].messages.size - 1].content

            date.text =
                sfd.format(conversations[index].messages[conversations[index].messages.size - 1].dateTime!!.toDate())
        }

    }

    interface ListItemClickListener {
        fun onListItemClick(conv: Conv?, view: View?)
    }
}