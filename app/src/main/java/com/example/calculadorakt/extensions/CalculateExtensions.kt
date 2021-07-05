package com.example.calculadorakt.extensions

import android.widget.Button
import android.widget.EditText
import com.example.calculadorakt.R

fun convertValue() {
    val input = (R.id.edt_total_amount_invested_calculator) as EditText
    val btn = (R.id.btn_calculate) as Button

    btn.setOnClickListener {

        val inputValue = input.text.toString().toFloat()

// a cada R$ 1,00 investido 30 pessoas visualizam o anuncio original
        val views = (inputValue / 30).toInt()

// a cada 100 pessoas que visualizam o anuncio, 12 clicam nele
        var click = 0
        var newShare = 0
        var maxShareForView = 0


        if (views >= 100)  click = (views / 100) * 12 else click = 12

// a cada 20 pessoas que clicam no anuncio, 3 compartilham nas redes sociais
        if (click >= 20) newShare = (click / 20) * 3 else newShare = 3

// o mesmo anúncio é compartilhado no máximo 4 vezes em sequência
        if (newShare > 0) maxShareForView = ((newShare / 5) * 4)

// cada compartilhamento gera 40 novas visualizações
        var newViews = maxShareForView * 40

        return@setOnClickListener
    }

}