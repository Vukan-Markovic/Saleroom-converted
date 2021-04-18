package vukan.com.apursp.ui.user_messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import vukan.com.apursp.R
import vukan.com.apursp.adapters.ConversationAdapter
import vukan.com.apursp.models.Conv
import java.util.*

class UserMessagesFragment : Fragment(), ConversationAdapter.ListItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConversationAdapter
    private var conversations: MutableList<Conv> = mutableListOf()
    private lateinit var userMessagesViewModel: UserMessagesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getString(R.string.conversations)
        conversations = ArrayList()
        recyclerView = view.findViewById(R.id.recview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ConversationAdapter(this)
        adapter.setHasStableIds(true)
        recyclerView.adapter = adapter
        userMessagesViewModel = ViewModelProvider(this).get(UserMessagesViewModel::class.java)

        userMessagesViewModel.getAllUserMessages(FirebaseAuth.getInstance().currentUser?.uid)
            .observe(viewLifecycleOwner, { conv: MutableList<Conv> ->
                conversations = conv
                adapter.setConversations(conversations)
                recyclerView.adapter = adapter
            })
    }

    override fun onListItemClick(conv: Conv?, view: View?) {
        val popupMenu = PopupMenu(requireContext(), requireView())
        popupMenu.inflate(R.menu.popup_menu_delete)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            if (item.itemId == R.id.delete_conversation) {
                Toast.makeText(requireActivity(), R.string.conversation_deleted, Toast.LENGTH_SHORT)
                    .show()

                userMessagesViewModel.deleteConversation(conv)
                conversations.remove(conv)
                adapter.setConversations(conversations)
                recyclerView.adapter = adapter
            }

            true
        }

        popupMenu.show()
    }
}