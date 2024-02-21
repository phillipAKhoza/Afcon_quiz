package com.example.afconquiz.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.afconquiz.R
import com.example.afconquiz.database.DatabaseCopyHelper
import com.example.afconquiz.database.FlagsDao
import com.example.afconquiz.databinding.FragmentQuizBinding
import com.example.afconquiz.model.FlagsModel


class QuizFragment : Fragment() {
    lateinit var fmQuizBinding: FragmentQuizBinding
    var flagList = ArrayList<FlagsModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fmQuizBinding = FragmentQuizBinding.inflate(inflater,container,false)

        val dao = FlagsDao()
        flagList = dao.getTenRandomQuestion(DatabaseCopyHelper(requireActivity()))

        for (flag in flagList){
            Log.d("flags", flag.id.toString())
            Log.d("flags", flag.flagName)
            Log.d("flags", flag.countryName)
            Log.d("flags", "************************")
        }
        fmQuizBinding.buttonA.setOnClickListener {  }
        fmQuizBinding.buttonB.setOnClickListener {  }
        fmQuizBinding.buttonC.setOnClickListener {  }
        fmQuizBinding.buttonD.setOnClickListener {  }
        fmQuizBinding.btnNext.setOnClickListener {  }

        return fmQuizBinding.root
    }

}