package com.example.almin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class mainFragment : Fragment() {
    //Declare Button
    lateinit var apiBtn: Button
    lateinit var dbBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_main, container, false)

        //initialization
        apiBtn = view.findViewById(R.id.api_btn)
        dbBtn = view.findViewById(R.id.db_btn)
        apiBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_TV_ShowFragment)

        }

        // يفضل اشيك اذا فيه داتا او لا
        dbBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_fav_Fragment)

        }
        return view
    }


}