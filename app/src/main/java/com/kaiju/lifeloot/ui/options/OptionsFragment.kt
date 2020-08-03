package com.kaiju.lifeloot.ui.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaiju.lifeloot.R
import kotlinx.android.synthetic.main.fragment_options.*

data class OptionsMenuItem(val title: String, val description: String)

class OptionsFragment : Fragment() {

    private lateinit var notificationsViewModel: OptionsViewModel
    private val optionsMenuItems = listOf(
        OptionsMenuItem("Log Out", "Sign out of LifeLoot")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(OptionsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_options, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        recycler_view_options.apply {
//            layoutManager = LinearLayoutManager(activity)
//            adapter = ListAdapter(optionsMenuItems)
//        }

    }
}