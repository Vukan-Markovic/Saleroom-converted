package vukan.com.apursp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import de.hdodenhof.circleimageview.CircleImageView
import vukan.com.apursp.GlideApp
import vukan.com.apursp.R
import vukan.com.apursp.models.Message
import vukan.com.apursp.ui.messages.MessagesFragmentDirections
import java.text.SimpleDateFormat
import java.util.*

class MessageAdapter(private var messages: MutableList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val sfd: SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    private var userName = ""
    private var image = ""
    private val fireUser = FirebaseAuth.getInstance().currentUser

    fun addMessage(message: Message) {
        messages.add(message)
    }

    fun setMessages(messages: MutableList<Message>, userName: String, image: String) {
        this.messages = messages
        this.userName = userName
        this.image = image
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].receiverID == fireUser?.uid) 1 else 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1)
            MessageViewHolder1(
                LayoutInflater.from(parent.context).inflate(R.layout.sender_message, parent, false)
            )
        else
            MessageViewHolder2(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.receiver_message, parent, false)
            )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == 1) {
            if (userName.isNotEmpty() && image.isNotEmpty()) {
                val messageViewHolder1 = holder as MessageViewHolder1
                messageViewHolder1.username.text = userName
                messageViewHolder1.content.text = messages[position].content

                messageViewHolder1.dateTime.text =
                    sfd.format(messages[position].dateTime!!.toDate())

                GlideApp.with(messageViewHolder1.senderImage.context)
                    .load(image)
                    .into(messageViewHolder1.senderImage)
            }

            holder.itemView.findViewById<View>(R.id.message_sender_image)
                .setOnClickListener { view: View ->
                    val action = MessagesFragmentDirections.porukeToMojiOglasiFragmentAction()
                    action.userId = messages[position].senderID.toString()
                    Navigation.findNavController(view).navigate(action)
                }
        } else {
            val messageViewHolder2 = holder as MessageViewHolder2
            messageViewHolder2.username.text = fireUser?.displayName
            messageViewHolder2.dateTime.text = sfd.format(messages[position].dateTime!!.toDate())
            messageViewHolder2.content.text = messages[position].content

            GlideApp.with(messageViewHolder2.receiverImage.context)
                .load(fireUser?.photoUrl)
                .into(messageViewHolder2.receiverImage)

            holder.itemView.findViewById<View>(R.id.message_receiver_image)
                .setOnClickListener { view: View ->
                    val action = MessagesFragmentDirections.porukeToMojiOglasiFragmentAction()
                    action.userId = messages[position].senderID.toString()
                    Navigation.findNavController(view).navigate(action)
                }
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    internal class MessageViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderImage: CircleImageView = itemView.findViewById(R.id.message_sender_image)
        val content: TextView = itemView.findViewById(R.id.message_content)
        val dateTime: TextView = itemView.findViewById(R.id.message_datetime)
        val username: TextView = itemView.findViewById(R.id.message_sender)
    }

    internal class MessageViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val receiverImage: CircleImageView = itemView.findViewById(R.id.message_receiver_image)
        val content: TextView = itemView.findViewById(R.id.message_content_r)
        val dateTime: TextView = itemView.findViewById(R.id.message_datetime_r)
        val username: TextView = itemView.findViewById(R.id.message_receiver)
    }
}