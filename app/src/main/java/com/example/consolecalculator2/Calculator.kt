package com.example.consolecalculator2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.consolecalculator2.databinding.CalcScr01Binding

class Calculator : Fragment() {

    private var _binding: CalcScr01Binding? = null
    private val binding get() = requireNotNull(_binding) { "Unsuccessful binding" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return CalcScr01Binding.inflate(inflater, container, false)
            .also{ _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            displayField.text = "0"
            var line: String = ""
            var action: String = ""
            var operand1: Double = 0.0
            var operand2: Double = 0.0
            var result: Double = 0.0
            fun errorToast() {
                Toast.makeText(root.context, "error", Toast.LENGTH_SHORT)
                    .show()
                displayField.text = "e 0"
            }

            button0.setOnClickListener {
                line += "0"
                displayField.text = line
            }
            button1.setOnClickListener {
                line += "1"
                displayField.text = line
            }
            button2.setOnClickListener {
                line += "2"
                displayField.text = line
            }
            button3.setOnClickListener {
                line += "3"
                displayField.text = line
            }
            button4.setOnClickListener {
                line += "4"
                displayField.text = line
            }
            button5.setOnClickListener {
                line += "5"
                displayField.text = line
            }
            button6.setOnClickListener {
                line += "6"
                displayField.text = line
            }
            button7.setOnClickListener {
                line += "7"
                displayField.text = line
            }
            button8.setOnClickListener {
                line += "8"
                displayField.text = line
            }
            button9.setOnClickListener {
                line += "9"
                displayField.text = line
            }
            buttonC.setOnClickListener {
                line = ""
                displayField.text = "0"
            }
            buttonDot.setOnClickListener {
                line += "."
                displayField.text = line
            }
            buttonDel.setOnClickListener {
                if (line.length != 0) {
                    line = line.substring(0, line.length - 1)
                    displayField.text = line
                } else {
                    displayField.text = "0"
                }

            }
            buttonDiv.setOnClickListener {
                if (line.length != 0) {
                    operand1 = line.toDouble()
                    action = "/"
                    line = ""
                } else {
                    displayField.text = "0"
                }
            }
            buttonMult.setOnClickListener {
                if (line.length != 0) {
                    operand1 = line.toDouble()
                    action = "*"
                    line = ""
                } else {
                    displayField.text = "0"
                }
            }
            buttonMinus.setOnClickListener {
                if (line.length != 0) {
                    operand1 = line.toDouble()
                    action = "-"
                    line = ""
                } else {
                    displayField.text = "0"
                }
            }
            buttonPlus.setOnClickListener {
                if (line.length != 0) {
                    operand1 = line.toDouble()
                    action = "+"
                    line = ""
                } else {
                    displayField.text = "0"
                }
            }
            buttonEquals.setOnClickListener {
                if (line.length != 0) {
                    operand2 = line.toDouble()
                    when (action) {
                        "/" -> if (operand2 != 0.0) {
                            displayField.text = (operand1 / operand2).toString()
                        } else {
                            errorToast()
                        }
                        "*" -> displayField.text = (operand1 * operand2).toString()
                        "-" -> displayField.text = (operand1 - operand2).toString()
                        "+" -> displayField.text = (operand1 + operand2).toString()
                        "" -> displayField.text = operand2.toString()
                        else -> displayField.text = "0"
                    }
                    operand1 = 0.0
                    action = ""
                } else {
                    displayField.text = "0"
                }
                line = ""
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}