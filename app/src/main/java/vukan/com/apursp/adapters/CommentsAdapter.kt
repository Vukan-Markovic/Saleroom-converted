package vukan.com.apursp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vukan.com.apursp.R
import vukan.com.apursp.adapters.CommentsAdapter.CommentsViewHolder
import vukan.com.apursp.models.Comment

class CommentsAdapter(private val comments: List<Comment>) :
    RecyclerView.Adapter<CommentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        return CommentsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rating_comment, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    inner class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val comment: TextView = itemView.findViewById(R.id.comment)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)

        fun bind(index: Int) {
            comment.text = comments[index].comment
            ratingBar.rating = comments[index].grade
        }
    }
}