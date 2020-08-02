package com.kaiju.lifeloot.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kaiju.lifeloot.GameActivity
import com.kaiju.lifeloot.R
import com.kaiju.lifeloot.StartupActivity

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

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_quickstart_go).setOnClickListener {
            this.startGame()
        }

    }


    private fun startGame() {
        var activity = this.activity
        val intent = Intent(activity, GameActivity::class.java)
//        val intent = Intent(activity, GameActivity::class.java)
        startActivity(intent)
    }
}