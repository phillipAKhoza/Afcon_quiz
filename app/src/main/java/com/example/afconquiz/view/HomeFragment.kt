package com.example.afconquiz.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.afconquiz.R
import com.example.afconquiz.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var fmBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fmBinding = FragmentHomeBinding.inflate(inflater,container,false)

        fmBinding.btnBegin.setOnClickListener {



        }
        // Inflate the layout for this fragment
        return fmBinding.root
    }

}