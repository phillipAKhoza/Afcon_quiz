package com.example.afconquiz.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.afconquiz.R
import com.example.afconquiz.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    lateinit var fmQuizBinding: FragmentQuizBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fmQuizBinding = FragmentQuizBinding.inflate(inflater,container,false)

        fmQuizBinding.buttonA.setOnClickListener {  }
        fmQuizBinding.buttonB.setOnClickListener {  }
        fmQuizBinding.buttonC.setOnClickListener {  }
        fmQuizBinding.buttonD.setOnClickListener {  }
        fmQuizBinding.btnNext.setOnClickListener {  }

        return fmQuizBinding.root
    }

}