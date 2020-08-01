package com.kaiju.lifeloot.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kaiju.lifeloot.R

class QuickstartFragment : Fragment() {

    private lateinit var quickstartViewModel: QuickstartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        quickstartViewModel =
            ViewModelProviders.of(this).get(QuickstartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quickstart, container, false)
//        val textView: TextView = root.findViewById(R.id.text_quickstart)
//        quickstartViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })



        return root
    }
}