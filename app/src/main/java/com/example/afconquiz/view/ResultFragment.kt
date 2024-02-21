package com.example.afconquiz.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.afconquiz.R
import com.example.afconquiz.databinding.FragmentQuizBinding
import com.example.afconquiz.databinding.FragmentResultBinding
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class ResultFragment : Fragment() {
    lateinit var fmResultBinding : FragmentResultBinding
    var correctNum = 0F
    var wrongNum = 0F
    var emptyNum = 0F
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
            correctNum = it.correct.toFloat()
            wrongNum= it.wrong.toFloat()
            emptyNum= it.empty.toFloat()
        }

        val barCorrectList = ArrayList<BarEntry>()
        val barWrongList = ArrayList<BarEntry>()
        val barEmptyList = ArrayList<BarEntry>()

        barCorrectList.add(BarEntry(0F,correctNum))
        barWrongList.add(BarEntry(1F,wrongNum))
        barEmptyList.add(BarEntry(2F,emptyNum))

        val barCorrectDataSet = BarDataSet(barCorrectList,"Correct Answers").apply {
            color = Color.GREEN
            valueTextSize= 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }
        val barWrongDataSet = BarDataSet(barWrongList,"Wrong Answers").apply {
            color = Color.RED
            valueTextSize= 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }
        val barEmptyDataSet = BarDataSet(barEmptyList,"Empty Answers").apply {
            color = Color.YELLOW
            valueTextSize= 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }

        val barData = BarData(barCorrectDataSet,barWrongDataSet,barEmptyDataSet)

        fmResultBinding.barChart.data = barData

        fmResultBinding.btnNewQuiz.setOnClickListener {
            this.findNavController().popBackStack(R.id.homeFragment,false)
        }
        fmResultBinding.btnExit.setOnClickListener {

            requireActivity().finish()
//            finishAffinity

        }
        return fmResultBinding.root
    }

}