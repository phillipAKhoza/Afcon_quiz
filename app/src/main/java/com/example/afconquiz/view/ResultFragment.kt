package com.example.afconquiz.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.afconquiz.R
import com.example.afconquiz.databinding.FragmentQuizBinding
import com.example.afconquiz.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    lateinit var fmResultBinding : FragmentResultBinding
    var correctNum = 0
    var wrongNum = 0
    var emptyNum = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fmResultBinding = FragmentResultBinding.inflate(inflater,container,false)

        val arg = arguments?.let {
            ResultFragmentArgs.fromBundle(it)
        }

        arg?.let {
            correctNum = it.correct
            wrongNum= it.wrong
            emptyNum= it.empty
        }

        fmResultBinding.btnNewQuiz.setOnClickListener {  }
        fmResultBinding.btnExit.setOnClickListener {  }
        return fmResultBinding.root
    }

}