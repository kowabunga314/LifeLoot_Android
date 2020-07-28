package com.kaiju.lifeloot

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Signup : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_signup_sign_up).setOnClickListener {
            this.handleOnSignUp(view)
        }

        view.findViewById<Button>(R.id.button_signup_log_in).setOnClickListener {
            this.handleOnLogIn(view)
        }

        view.findViewById<Button>(R.id.button_signup_guest).setOnClickListener {
            this.handleOnGuest()
        }
    }

    private fun handleOnSignUp(view: View) {
        // Get signup field values
        val username = view.findViewById<TextView>(R.id.textview_signup_username).text.toString()
        val email = view.findViewById<TextView>(R.id.textview_signup_email).text.toString()
        val password = view.findViewById<TextView>(R.id.textview_signup_password).text.toString()

        // Send signup params to backend
        this.sendShortToast(username)
    }

    private fun handleOnLogIn(view: View) {
        val username = view.findViewById<TextView>(R.id.textview_signup_username).text.toString()
        val password = view.findViewById<TextView>(R.id.textview_signup_password)

        this.sendShortToast("Redirecting to login page")

        val action = SignupDirections.actionSignupFragmentToLoginFragment()

        findNavController().navigate(action)

    }

    private fun handleOnGuest() {
        this.sendShortToast("Skipping authentication")
        skipLogin()
    }

    private fun skipLogin() {
        var activity = this.activity
        val intent = Intent(activity, GameActivity::class.java)
        startActivity(intent)
    }

    private fun sendShortToast(message: String) {
        val myToast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        myToast.show()
    }
}