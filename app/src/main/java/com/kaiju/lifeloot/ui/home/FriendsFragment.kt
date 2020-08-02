package com.kaiju.lifeloot.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kaiju.lifeloot.R

class FriendsFragment : Fragment() {

    private lateinit var homeViewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(FriendsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_friends, container, false)

        return root
    }
}