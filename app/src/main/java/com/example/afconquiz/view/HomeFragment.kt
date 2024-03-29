package com.example.afconquiz.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.afconquiz.R
import com.example.afconquiz.database.DatabaseCopyHelper
import com.example.afconquiz.databinding.FragmentHomeBinding
import java.lang.Exception

class HomeFragment : Fragment() {
    lateinit var fmBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fmBinding = FragmentHomeBinding.inflate(inflater,container,false)
        createAndOpenDB()
        fmBinding.btnBegin.setOnClickListener {

        val direction = HomeFragmentDirections.actionHomeFragmentToQuizFragment()
            this.findNavController().navigate(direction)

        }
        // Inflate the layout for this fragment
        return fmBinding.root
    }

    private fun createAndOpenDB(){
        try {
            val helper = DatabaseCopyHelper(requireActivity())
            helper.createDataBase()
            helper.openDataBase()
        }catch (error : Exception){
            error.printStackTrace()
        }
    }

}