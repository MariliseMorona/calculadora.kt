package com.example.calculadorakt.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class CalculatorFragment : Fragment() {
    private var binding: FragmentCalculatorBinding? = null
    private val inputValueReals = binding?.edtInsertTheValue?.text.toString().toFloat()
    var outputValue = binding?.txtValueReturn?.text.toString()


    // Inflando o layout com as seus devidos values
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = com.example.calculadorakt.databinding.FragmentCalculatorBinding

        // Criar métodos de cálculo de conversão de anuncio:
    fun convertInputInViews(): Int {
         // a cada R$ 1,00 investido 30 pessoas visualizam o anuncio original
         var views = (inputValueReals / 30).toInt()

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
                 return newViews

             } else {
                 val newShare = 3
                 val newViews = newShare * 40
                 return newViews
             }

         } else {
             var click = 12
             val newShare = 3
             val maxShareForView = (newShare / 5) * 4
             val newViews = maxShareForView * 40
             return newViews
         }
         outputValue = convertInputInViews().toString()


        }
        return binding?.root
    }
}