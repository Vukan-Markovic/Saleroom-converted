package vukan.com.apursp.ui.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import vukan.com.apursp.R
import vukan.com.apursp.adapters.MessageAdapter
import vukan.com.apursp.models.Message
import vukan.com.apursp.models.Product
import vukan.com.apursp.ui.my_ads.MyAdsViewModel
import java.util.*

class MessagesFragment : Fragment() {
    private lateinit var adapter: MessageAdapter
    private lateinit var text: TextView
    private var productID = "0"
    private var receiverID = "0"
    private lateinit var recyclerView: RecyclerView
    private var messages: MutableList<Message> = ArrayList()
    private var userName = ""
    private var image = ""
    private var id = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.messages)
        val messagesViewModel = ViewModelProvider(this).get(MessagesViewModel::class.java)
        val myAdsViewModel = ViewModelProvider(this).get(MyAdsViewModel::class.java)
        recyclerView = view.findViewById(R.id.list_of_messages)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val sendMess: FloatingActionButton = view.findViewById(R.id.btnSend)
        text = view.findViewById(R.id.messageField)
        val fireUser = FirebaseAuth.getInstance().currentUser
        adapter = MessageAdapter(messages)
        adapter.setMessages(messages, userName, image)
        recyclerView.adapter = adapter
        val mAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.fade)
        mAnimation.duration = 150

        if (arguments != null) {
            if (MessagesFragmentArgs.fromBundle(requireArguments()).messages != null) {
                val message = MessagesFragmentArgs.fromBundle(requireArguments()).messages
                Collections.addAll(messages, *message)
                if (messages.isNotEmpty()) messages.removeAt(0)
                recyclerView.scrollToPosition(adapter.itemCount - 1)

                for (m in messages) {
                    if (m.receiverID == fireUser?.uid) {
                        myAdsViewModel.getUser(m.senderID)
                            .observe(viewLifecycleOwner, { (_, username, _, _, _, imageUrl) ->
                                userName = username.toString()
                                image = imageUrl.toString()
                                adapter.setMessages(messages, userName, image)
                                recyclerView.adapter = adapter
                                recyclerView.scrollToPosition(adapter.itemCount - 1)
                            })
                    }
                }
            }

            productID = MessagesFragmentArgs.fromBundle(requireArguments()).productId

            if (productID != "0") {
                messagesViewModel.getProductDetails(productID)
                    .observe(viewLifecycleOwner, { product: Product? ->
                        receiverID = product?.userID.toString()

                        messagesViewModel.getmMessages(
                            fireUser?.uid,
                            product?.userID.toString(),
                            productID
                        ).observe(viewLifecycleOwner, { message: MutableList<Message> ->
                            messages = message
                            if (messages.isNotEmpty()) messages.removeAt(0)

                            for (m in messages) {
                                if (m.receiverID == fireUser?.uid) {
                                    myAdsViewModel.getUser(m.senderID).observe(viewLifecycleOwner,
                                        { (_, username, _, _, _, imageUrl) ->
                                            userName = username.toString()
                                            image = imageUrl.toString()
                                            adapter.setMessages(messages, userName, image)
                                            recyclerView.adapter = adapter
                                            recyclerView.scrollToPosition(adapter.itemCount - 1)
                                        })
                                }
                            }

                            adapter.setMessages(messages, userName, image)
                            recyclerView.adapter = adapter
                            recyclerView.scrollToPosition(adapter.itemCount - 1)
                        })
                    })
            }
        }

        sendMess.setOnClickListener { v: View ->
            if (text.text.toString().trim { it <= ' ' }.isNotEmpty()) {
                v.startAnimation(mAnimation)

                val newMessage = Message(
                    content = text.text.toString(),
                    senderID = fireUser?.uid,
                    dateTime = Timestamp(Date())
                )

                text.text = ""

                if (productID == "0") {
                    id = messages[0].receiverID.toString()
                    if (id == fireUser?.uid) id = messages[0].senderID.toString()
                    newMessage.receiverID = id
                    newMessage.productID = messages[0].productID
                } else {
                    newMessage.receiverID = receiverID
                    newMessage.productID = productID
                }

                adapter.addMessage(newMessage)
                messagesViewModel.sendMessage(newMessage)
                recyclerView.adapter = adapter
                recyclerView.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}