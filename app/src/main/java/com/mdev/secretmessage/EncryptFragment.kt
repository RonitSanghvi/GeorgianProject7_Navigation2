package com.mdev.secretmessage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class EncryptFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        val nextButton = view.findViewById<Button>(R.id.nextEncryptionButton)

        // To receive data from Bundle.
        val message = EncryptFragmentArgs.fromBundle(requireArguments()).message
        val secondMessage = EncryptFragmentArgs.fromBundle(requireArguments()).secondMessage

        // Take Encrypted-TextView by ID and printed 1st Secret message their.
        val encryptedView = view.findViewById<TextView>(R.id.encrypted_message)
        encryptedView.text = message.reversed()

        nextButton.setOnClickListener{
            val action = EncryptFragmentDirections.actionEncryptFragmentToSecondEncryptFragment(secondMessage)
            view.findNavController().navigate(action)
        }

        return view
    }
}