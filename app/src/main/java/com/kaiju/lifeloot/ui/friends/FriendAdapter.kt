package com.kaiju.lifeloot.ui.friends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaiju.lifeloot.R
import kotlinx.android.synthetic.main.friend_view.view.*

//class ContentItem(val name: String, val imageUrl: String)

class FriendAdapter(private val friendList: List<FriendView>,
                    private val listener: FriendsFragment
) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.imageview_friend_card
        private val nameView: TextView = itemView.textview_friend_name
        private val descriptionView: TextView = itemView.textview_friend_description

        fun bind(friendView: FriendView) {
            nameView.text = friendView.name
            descriptionView.text = friendView.description
            imageView.setImageResource(friendView.imageResource)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.friend_view,
            parent, false)

        // Click profile picture to view profile details
        val challenge = itemView.findViewById<ImageView>(R.id.imageview_challenge_user)
        challenge.setOnClickListener {
            // TODO: call out to create game endpoint and start game activity
        }

        // Set functionality for friendship toggle
        val friendToggle = itemView.findViewById<ImageView>(R.id.imageview_add_friend_toggle)
        friendToggle.setOnClickListener {
            friendToggle.setImageResource(R.drawable.ic_friend_activated_24)

            // TODO: fix this toggle thing
//            if (friendToggle.drawable.constantState?.equals(getDrawable(parent.context, R.drawable.ic_friend_deactivated_24)?.constantState)!!) {
//                friendToggle.setImageResource(R.drawable.ic_friend_activated_24)
//            } else {
//                friendToggle.setImageResource(R.drawable.ic_friend_deactivated_24)
//            }
        }

        return FriendViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val currentItem = friendList[position]

        when (holder) {

            is FriendViewHolder -> {
                holder.bind(friendList[position])
            }
        }
    }

    override fun getItemCount() = friendList.size


}

class FriendListener(val clickListener: (name: String) -> Unit) {
    fun onClick(friend: FriendView) = clickListener(friend.name)
}