package com.mdev.secretmessage

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import androidx.navigation.findNavController

class MessageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        val nextButton = view.findViewById<Button>(R.id.next)

        //  Messages
        val messageView = view.findViewById<EditText>(R.id.message)
        val secondMessageView = view.findViewById<EditText>(R.id.secondMessage)
        val encryptConformationView = view.findViewById<CheckBox>(R.id.encryptConformation)

        nextButton.setOnClickListener {
            val message = messageView.text.toString()
            val secondMessage = secondMessageView.text.toString()
            var encryptConformation = false

            if (encryptConformationView.isChecked) {encryptConformation = true}

            // Pass both the values to Next Fragment. (EncryptFragment)
            val action = MessageFragmentDirections.actionMessageFragmentToEncryptFragment(message, secondMessage, encryptConformation)
            view.findNavController().navigate(action)

            // view.findNavController().navigate(R.id.action_messageFragment_to_encryptFragment)
        }

        return view
    }
}