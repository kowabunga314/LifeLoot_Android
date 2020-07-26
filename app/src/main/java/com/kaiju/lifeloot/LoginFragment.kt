package com.kaiju.lifeloot

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kaiju.lifeloot.WelcomeActivity

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LoginFragment : Fragment() {

//    val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_login_sign_up).setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_SignupFragment)
        }

        view.findViewById<Button>(R.id.button_login_log_in).setOnClickListener {
            // First send login request to server

            // If successful go to game activity
            var activity = this.activity
            val intent = Intent(activity, GameActivity::class.java)
            startActivity(intent)
        }
    }
}