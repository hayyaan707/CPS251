package com.example.fragmentyt
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
class BlankFragment3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank3, container, false)
        val button = view.findViewById<Button>(R.id.button3)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment3_to_homeFragment)
        }
        return view
    }
}