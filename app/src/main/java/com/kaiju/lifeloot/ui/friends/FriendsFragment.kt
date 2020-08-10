package com.kaiju.lifeloot.ui.friends

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaiju.lifeloot.R

class FriendsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_friends, container, false)
        val exampleList = generateDummyList(500)

        var recyclerViewFriends = view.findViewById<RecyclerView>(R.id.recycler_view_friends)

        recyclerViewFriends.adapter = FriendAdapter(exampleList, this)
        recyclerViewFriends.layoutManager = LinearLayoutManager(activity?.applicationContext)
        recyclerViewFriends.setHasFixedSize(true)

        return view
    }

    private fun generateDummyList(size: Int): List<FriendView> {
        // Just generate a fake list of friends for now

        val list = ArrayList<FriendView>()

        for (i in 0 until size) {
            val drawable = when (i % 4) {
                0 -> R.drawable.profile_bot
                1 -> R.drawable.profile_face
                2 -> R.drawable.profile_smile
                else -> R.drawable.profile_tea
            }

            val item = FriendView(drawable, "Friend $i", "You go back $i years!")
            list += item
        }

        return list
    }

    operator fun invoke(currentItem: FriendView) {
        TODO("Not yet implemented")
        val fragment = DetailsFragment.newInstance(currentItem.name, "wumbo")
        val transaction = fragmentManager?.beginTransaction()
        if (transaction != null) {
            transaction.replace(R.id.content, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}