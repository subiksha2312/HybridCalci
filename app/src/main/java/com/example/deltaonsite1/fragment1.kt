package com.example.deltaonsite1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_1.*

class fragment1 : Fragment() {

    private lateinit var viewModel: ResultSet
    private  var number1: Long = 0L
    private var operator = ""
    private var subCounter = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_1,container,false)
        return view

    }

    fun completeOperation() {
        if(inputValue.text.toString().isEmpty()) {
            return
        }

        when(operator) {
            "+" -> {
                number1 += inputValue?.text.toString().toLong()
            }
            "-" -> {
                number1 -= inputValue?.text.toString().toLong()
            }
            "*" -> {
                number1 *= inputValue?.text.toString().toLong()
            }
            "/" -> {

                number1 /= inputValue?.text.toString().toLong()
            }
            "=" -> {
                number1 = number1
            }

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val equalTo = getView()?.findViewById<Button>(R.id.equal)
        val num1 = getView()?.findViewById<Button>(R.id.number1)
        val num2 = getView()?.findViewById<Button>(R.id.number2)
        val num3 = getView()?.findViewById<Button>(R.id.number3)
        val num4 = getView()?.findViewById<Button>(R.id.number4)
        val num5 = getView()?.findViewById<Button>(R.id.number5)
        val num6 = getView()?.findViewById<Button>(R.id.number6)
        val num7 = getView()?.findViewById<Button>(R.id.number7)
        val num8 = getView()?.findViewById<Button>(R.id.number8)
        val num9 = getView()?.findViewById<Button>(R.id.number9)
        val num0 = getView()?.findViewById<Button>(R.id.number0)
        val clear = getView()?.findViewById<Button>(R.id.clear)

        val addition = getView()?.findViewById<Button>(R.id.addition)
        val subtraction = getView()?.findViewById<Button>(R.id.subtract)
        val multiplication = getView()?.findViewById<Button>(R.id.multiply)
        val division = getView()?.findViewById<Button>(R.id.division)
        val inputValue = getView()?.findViewById<TextView>(R.id.inputValue)

        clear?.setOnClickListener {
            number1 = 0
            inputValue?.text =  ""
            subCounter = 0
            operator=""
            viewModel.setResult(number1)


        }

        num1?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "1"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num2?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "2"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num3?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "3"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num4?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "4"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num5?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "5"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num6?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "6"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num7?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "7"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num8?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "8"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num9?.setOnClickListener {
            inputValue?.text = inputValue?.text.toString() + "9"
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
        }

        num0?.setOnClickListener {
            if (operator == "/") {
                Toast.makeText(activity?.applicationContext,"Cannot divide by 0",Toast.LENGTH_LONG).show()
            }
            inputValue?.text = inputValue?.text.toString() + "0"
        }
        viewModel = ViewModelProvider(requireActivity()).get(ResultSet::class.java)

        //viewModel = ViewModelProvider(this).get(ResultSet::class.java)

        addition?.setOnClickListener {
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
            if (operator.isNotEmpty()) {
                completeOperation()
            }
            else {
                number1 = inputValue?.text.toString().toLong()
            }
            inputValue?.text = ""
            operator = "+"
            viewModel.setResult(number1)
        }


        subtraction?.setOnClickListener {
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
            if (operator.isNotEmpty()) {
                completeOperation()
            }
            else {
                number1 = inputValue?.text.toString().toLong()
            }

            inputValue?.text = ""
            operator = "-"
            viewModel.setResult(number1)
        }
        multiplication?.setOnClickListener {
            if (operator == "/") {
                num0?.visibility = View.VISIBLE
            }
            if (operator.isNotEmpty()) {
                completeOperation()
            }
            else {
                number1 = inputValue?.text.toString().toLong()
            }

            inputValue?.text = ""
            operator = "*"
            viewModel.setResult(number1)
        }

        division?.setOnClickListener {
            if (operator.isNotEmpty()) {
                completeOperation()
            }
            else {
                number1 = inputValue?.text.toString().toLong()
            }
            inputValue?.text = ""
            operator = "/"
            viewModel.setResult(number1)
        }

        equalTo?.setOnClickListener{

            completeOperation()
            operator = "="
            viewModel.setResult(number1)
        }

    }

}