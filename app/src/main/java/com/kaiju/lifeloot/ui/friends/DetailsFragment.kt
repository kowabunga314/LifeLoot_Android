package com.kaiju.lifeloot.ui.friends

import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kaiju.lifeloot.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_USERNAME = "username"
private const val ARG_DESCRIPTION = "description"
private const val ARG_IMAGE = "image"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var username: String? = null
    private var description: String? = null
    private var image: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString(ARG_USERNAME)
            description = it.getString(ARG_DESCRIPTION)
            image = it.getInt(ARG_IMAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameField = view.findViewById<TextView>(R.id.user_detail_title)
        nameField.text = this.username

        val descriptionField = view.findViewById<TextView>(R.id.user_detail_description)
        descriptionField.text = this.description

        val imageField = view.findViewById<ImageView>(R.id.user_detail_image)
        this.image?.let { imageField.setImageResource(it) }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param username Username of user to be loaded into fragment.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(username: String, description: String, image: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USERNAME, username)
                    putString(ARG_DESCRIPTION, description)
                    putInt(ARG_IMAGE, image)
                }
            }
    }
}