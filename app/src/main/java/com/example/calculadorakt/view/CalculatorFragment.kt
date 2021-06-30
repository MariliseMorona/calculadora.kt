package com.example.calculadorakt.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.calculadorakt.R


class CalculatorFragment : Fragment() {


    var newViews = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = inflater.inflate(
            R.layout.fragment_calculator, container, false
        )


        @SuppressLint("SetTextI18n")
        fun convertValue(): TextView? {
            val input = binding.findViewById<EditText>(R.id.edt_insertTheValue)
            val output = binding.findViewById<EditText>(R.id.edt_valueReturn)
            val btn = binding.findViewById<Button>(R.id.btn_calcule)

            btn?.setOnClickListener {
                val inputValue = input.text.toString().toFloat()
                // a cada R$ 1,00 investido 30 pessoas visualizam o anuncio original
                val views = (inputValue / 30).toInt()

                // a cada 100 pessoas que visualizam o anuncio, 12 clicam nele
                if (views >= 100) {
                    val click = (views / 100) * 12
                    // a cada 20 pessoas que clicam no anuncio, 3 compartilham nas redes sociais
                    if (click >= 20) {
                        val newShare = (click / 20) * 3
                        // o mesmo anúncio é compartilhado no máximo 4 vezes em sequência
                        val maxShareForView = (newShare / 5) * 4
                        // cada compartilhamento gera 40 novas visualizações
                        val newViews = maxShareForView * 40
                    } else {
                        val newShare = 3
                        val newViews = newShare * 40
                    }
                } else {
                    var click = 12
                    val newShare = 3
                    val maxShareForView = (newShare / 5) * 4
                    val newViews = maxShareForView * 40

                }
                output?.setText(newViews.toString())
            }
            return output
        }
        return binding
    }

}



