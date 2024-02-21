package com.example.afconquiz.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.afconquiz.R
import com.example.afconquiz.database.DatabaseCopyHelper
import com.example.afconquiz.database.FlagsDao
import com.example.afconquiz.databinding.FragmentQuizBinding
import com.example.afconquiz.model.FlagsModel


class QuizFragment : Fragment() {
    lateinit var fmQuizBinding: FragmentQuizBinding
    var flagList = ArrayList<FlagsModel>()
    var correctNumber = 0
    var wrongNumber = 0
    var emptyNumber = 0
    var questionNumber = 0

    lateinit var correctFlag : FlagsModel

    var wrongFlag = ArrayList<FlagsModel>()
    val dao = FlagsDao()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fmQuizBinding = FragmentQuizBinding.inflate(inflater,container,false)


        flagList = dao.getTenRandomQuestion(DatabaseCopyHelper(requireActivity()))

        for (flag in flagList){
            Log.d("flags", flag.flagName)
            Log.d("flags", "************************")
        }

        showData()
        fmQuizBinding.buttonA.setOnClickListener {
            answerControl(fmQuizBinding.buttonA)
        }
        fmQuizBinding.buttonB.setOnClickListener {
            answerControl(fmQuizBinding.buttonB)

        }
        fmQuizBinding.buttonC.setOnClickListener {
            answerControl(fmQuizBinding.buttonC)

        }
        fmQuizBinding.buttonD.setOnClickListener {
            answerControl(fmQuizBinding.buttonD)

        }
        fmQuizBinding.btnNext.setOnClickListener {
            questionNumber++
            showData()
        }

        return fmQuizBinding.root
    }

    @SuppressLint("DiscouragedApi")
    private  fun showData(){
        fmQuizBinding.tvQuestion.text = resources.getString(R.string.question_number)
            .plus(" ").plus(questionNumber+1)

        correctFlag = flagList[questionNumber]

        fmQuizBinding.igmFlag.setImageResource(resources.getIdentifier(correctFlag.countryName,"drawable",requireActivity().packageName))

        wrongFlag = dao.getThreeRandomQuestion(DatabaseCopyHelper(requireActivity()), correctFlag.id)

        val mixOptions = HashSet<FlagsModel>()
        mixOptions.clear()

        mixOptions.add(correctFlag)
        mixOptions.add(wrongFlag[0])
        mixOptions.add(wrongFlag[1])
        mixOptions.add(wrongFlag[2])

        val options = ArrayList<FlagsModel>()
        options.clear()

        for(flag in mixOptions){
            options.add(flag)
        }

        fmQuizBinding.buttonA.text = options[0].countryName
        fmQuizBinding.buttonB.text = options[1].countryName
        fmQuizBinding.buttonC.text = options[2].countryName
        fmQuizBinding.buttonD.text = options[3].countryName

    }
    private fun answerControl(button : Button){
        val clickedButton = button.text.toString()
        val correctAnswer = correctFlag.countryName

        if(clickedButton == correctAnswer){
            correctNumber++
            fmQuizBinding.tvCorrect.text = correctNumber.toString()
            button.setBackgroundColor(Color.GREEN)
        }else{
            wrongNumber++
            fmQuizBinding.tvWrong.text = wrongNumber.toString()
            button.setBackgroundColor(Color.RED)
            button.setTextColor(Color.WHITE)

            when(correctAnswer){
                fmQuizBinding.buttonA.text -> fmQuizBinding.buttonA.setBackgroundColor(Color.GREEN)
                fmQuizBinding.buttonB.text -> fmQuizBinding.buttonB.setBackgroundColor(Color.GREEN)
                fmQuizBinding.buttonC.text -> fmQuizBinding.buttonC.setBackgroundColor(Color.GREEN)
                fmQuizBinding.buttonD.text -> fmQuizBinding.buttonD.setBackgroundColor(Color.GREEN)

            }
        }

        fmQuizBinding.buttonA.isClickable = false
        fmQuizBinding.buttonB.isClickable = false
        fmQuizBinding.buttonC.isClickable = false
        fmQuizBinding.buttonD.isClickable = false

    }

}