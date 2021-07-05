package com.example.calculadorakt.ui.view

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadorakt.data.AdDataSource
import com.example.calculadorakt.databinding.ActivityAdItemBinding
import com.example.calculadorakt.extensions.text

class ItemAdActivity: AppCompatActivity() {

    private lateinit var binding: ActivityAdItemBinding
    private val adapter by lazy { ReportListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

// Ao clicar no botão para adicionar um anuncio
// é redirecionado para o layout de adição de report
// os itens são preenchidos, é gerado um ID
// e ele é salvo num report quando ocorre o click no botão Save
// e fecha o layout de inclusão de report

        fun itemReports(
            cliente: String, anuncio: String,
            valorInvestidoDia: Double, data: String,
            id: Int) {

        }

        fun insertNewAdd() {
            binding.btnSave.setOnClickListener {
                val newReport = itemReports(
                    cliente = binding.edtNameAddItem.toString(),
                    anuncio = binding.edtAdAddItem.toString(),
                    valorInvestidoDia = binding.edtAmountInvestedDayAdd.toString().toDouble(),
                    data = binding.txtInputDate.text,
                    id = intent.getIntExtra(AddReportsActivity.AD_ID, 0)
                )
                AdDataSource.insertReport(
                    report = itemReports(
                        "", "",
                        1000.00, "Sucesso", 1,
                    )
                        .setResult(Activity.RESULT_OK),
                )
                    finish()

            }
        }
    }
}

private fun Any.setResult(resultOk: Int) {

}

