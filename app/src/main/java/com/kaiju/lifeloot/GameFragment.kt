package com.kaiju.lifeloot

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "playerPosition"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var playerPosition: Int? = null
    private lateinit var names: Array<String>
    private lateinit var ids: Array<String>

    companion object {

        fun newInstance(): GameFragment {
            return GameFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Get dog names and descriptions.
        val resources = context.resources
        names = resources.getStringArray(R.array.player_names)
        ids = resources.getStringArray(R.array.player_ids)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playerPosition = it.getInt(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_game, container, false)

        val activity = activity as Context

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
            Doing this the brute force way for now: just manually set onClick listeners for each
                player's up and down buttons. In the future this should be dynamically populating
                player slots based on game type.
        */

        view.findViewById<Button>(R.id.button_game_up1).setOnClickListener {
            handleIncrementScore(view, 1)
        }

        view.findViewById<Button>(R.id.button_game_down1).setOnClickListener {
            handleDecrementScore(view, 1)
        }

        view.findViewById<Button>(R.id.button_game_up2).setOnClickListener {
            handleIncrementScore(view, 2)
        }

        view.findViewById<Button>(R.id.button_game_down2).setOnClickListener {
            handleDecrementScore(view, 2)
        }

        view.findViewById<Button>(R.id.button_game_reset).setOnClickListener {
            handleResetScore(view)
        }
    }

    private fun handleIncrementScore(view: View, player: Int) {
        // Get current score TextView
        val scoreField = if (player == 1) {
            view.findViewById<TextView>(R.id.textview_game_score1)
        } else {
            view.findViewById<TextView>(R.id.textview_game_score2)
        }
        // Get score as integer from TextView
        val scoreText = scoreField.text.toString()
        // Calculate new score
        val newScore = scoreText.toInt() + 1
        // Set TextView value to new score
        scoreField.text = newScore.toString()
    }

    private fun handleDecrementScore(view: View, player: Int) {
        // Get current score TextView
        val scoreField = if (player == 1) {
            view.findViewById<TextView>(R.id.textview_game_score1)
        } else {
            view.findViewById<TextView>(R.id.textview_game_score2)
        }
        // Get current score from TextView
        val scoreText = scoreField.text.toString()
        // Calculate new score
        val newScore = scoreText.toInt() - 1

        // Check to see if this action will send player life into negative range
        if (newScore < 0) {
            // STOP RESISTING
            val toast = Toast.makeText(context, "He's dead, Jim", Toast.LENGTH_SHORT)
            toast.show()
        }

        // Set TextView value to new score
        scoreField.text = newScore.toString()

    }

    private fun handleResetScore(view: View) {
        // Get the default starting life value
        val newScore = getString(R.string.default_life_value)
        // Set both scores to starting value
        view.findViewById<TextView>(R.id.textview_game_score1).text = newScore
        view.findViewById<TextView>(R.id.textview_game_score2).text = newScore
    }

}