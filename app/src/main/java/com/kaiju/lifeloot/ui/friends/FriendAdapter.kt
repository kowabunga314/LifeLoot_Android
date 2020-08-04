package com.kaiju.lifeloot.ui.friends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.kaiju.lifeloot.R
import kotlinx.android.synthetic.main.friend_view.view.*

class FriendAdapter(private val friendList: List<FriendView>) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.imageview_friend_card
        val nameView: TextView = itemView.textview_friend_name
        val descriptionView: TextView = itemView.textview_friend_description

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.friend_view,
            parent, false)

        val friendToggle = itemView.findViewById<ImageView>(R.id.imageview_add_friend_toggle)
        friendToggle.setOnClickListener {
            friendToggle.setImageResource(R.drawable.ic_friend_activated_24)

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


        // TODO: move this to FriendViewHolder in accordance with best practices
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.nameView.text = currentItem.name
        holder.descriptionView.text = currentItem.description

    }

    override fun getItemCount() = friendList.size
}