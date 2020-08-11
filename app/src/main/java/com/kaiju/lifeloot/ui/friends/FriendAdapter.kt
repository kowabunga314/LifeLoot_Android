package com.kaiju.lifeloot.ui.friends

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kaiju.lifeloot.R
import kotlinx.android.synthetic.main.friend_view.view.*


class FriendAdapter(private val friendList: List<FriendView>,
                    private val activity: AppCompatActivity
) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    class FriendViewHolder(itemView: View, private var activity: AppCompatActivity) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.imageview_friend_card
        private val nameView: TextView = itemView.textview_friend_name
        private val descriptionView: TextView = itemView.textview_friend_description

        var itemClick: ((String) -> Unit)? = null

        fun bind(friendView: FriendView) {
            val name = friendView.name
            nameView.text = friendView.name
            descriptionView.text = friendView.description
            imageView.setImageResource(friendView.imageResource)
            itemView.setOnClickListener {
                itemClick?.invoke(friendView.name)
                Toast.makeText(itemView.context, "Thanks for clicking $name!", Toast.LENGTH_SHORT).show()
                openUserDetails(friendView.name)
            }
        }

        private fun openUserDetails(username: String) {
            val action = FriendsFragmentDirections.actionNavigationFriendsToFragmentUserDetails(username)
            itemView.findNavController().navigate(action)
        }
    }

    var itemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.friend_view,
            parent, false)

        itemClick = { name ->
            this@FriendAdapter.itemClick?.invoke(name)
        }

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

        return FriendViewHolder(itemView, activity)
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
