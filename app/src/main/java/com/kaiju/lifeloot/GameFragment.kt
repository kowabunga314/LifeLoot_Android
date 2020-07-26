package com.kaiju.lifeloot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_game_up).setOnClickListener {
            handleIncrementScore(view)
        }

        view.findViewById<Button>(R.id.button_game_down).setOnClickListener {
            handleDecrementScore(view)
        }

        view.findViewById<FloatingActionButton>(R.id.floating_button_game_reset).setOnClickListener {
            handleResetScore(view)
        }
    }

    private fun handleIncrementScore(view: View) {
        var scoreField = view.findViewById<TextView>(R.id.textview_game_score)
        var scoreText = scoreField.text.toString()
        val newScore = scoreText.toInt() + 1
        scoreField.text = newScore.toString()
    }

    private fun handleDecrementScore(view: View) {
        var scoreField = view.findViewById<TextView>(R.id.textview_game_score)
        var scoreText = scoreField.text.toString()
        val newScore = scoreText.toInt() - 1
        scoreField.text = newScore.toString()
    }

    private fun handleResetScore(view: View) {
        var newScore = getString(R.string.default_life_value)
        view.findViewById<TextView>(R.id.textview_game_score).text = newScore
    }

}