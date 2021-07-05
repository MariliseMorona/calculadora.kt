package com.example.calculadorakt.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.calculadorakt.R
import com.example.calculadorakt.data.AdDataSource
import com.example.calculadorakt.data.ItemReportsDatabase
import com.example.calculadorakt.databinding.ActivityReportsListBinding
import com.example.calculadorakt.repository.AddReportRepository
import com.example.calculadorakt.viewmodel.ItemReportsViewModel
import com.example.calculadorakt.viewmodel.ItemReportsViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class AddReportsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityReportsListBinding
    private val adapter by lazy { ReportListAdapter() }


    // Criar e inflar o layout da Lista de Relatórios
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcvReports.adapter = adapter
        updateList()

        val database = ItemReportsDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO))
        val itemReportsDao = database.addReportsDao()
        val repository = AddReportRepository(itemReportsDao)

        val viewModelFactory = ItemReportsViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ItemReportsViewModel::class.java)

        val itemReports = viewModel.addReports
        itemReports.observe(this, Observer {
            adapter.data = it
        })

// Se houver itens na lista, será inflada a recycler view
//        insertListeners()
//    }

// Inflando o Float Action Button para adicionar um novo relatório
// e inflar o layout Relatório
//    private fun insertListeners(){
//        binding.fbtNewTask.setOnClickListener{
//           R.layout.activity_ad_item
//            startActivityForResult(Intent(this, AddReportsActivity::class.java), CREATE_NEW_AD)
//        }

// Se o Recycler inflar, habilita a ação do menu com as funções:
// Abrir relatório do item
        adapter.listenerOpen = {
            val intent = Intent (this, AddReportsActivity::class.java)
            intent.putExtra(AD_ID, it.id)
                R.layout.report
    }

// Habilitar a função de edição do item
        adapter.listenerEdit = {
            val intent = Intent (this, AddReportsActivity::class.java)
            intent.putExtra(AD_ID, it.id)
            CREATE_NEW_AD
//            startActivityForResult(intent, CREATE_NEW_AD)
        }

// Habilitar a função de deletar o item e atualizar a lista
        adapter.listenerDelete = {
            AdDataSource.deleteReport(it)
            updateList()
        }

// Ao pressionar o float action button para adicionar um novo item
// ocorre o redirecionamento para a ItemAdActivity, via intent
      binding.fbtNewTask.setOnClickListener {
          val addNewReportView = Intent(this, ItemAdActivity::class.java)
          startActivity(addNewReportView)
      }
    }

    companion object{
        const val AD_ID = "task_id"
        const val CREATE_NEW_AD = 1000
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CREATE_NEW_AD && resultCode == Activity.RESULT_OK) updateList()
    }

    private fun updateList(){
        val list = AdDataSource.getList()
        binding.ncdEmptyState.ltEmptyState.visibility = if(list.isEmpty()) View.VISIBLE
        else View.GONE
        /*if(list.isEmpty()){
            binding.ncdEmptyState.ltEmptyState.visibility = View.VISIBLE
        }else{
            binding.ncdEmptyState.ltEmptyState.visibility = View.GONE
        }*/
       // adapter.submitList(list)
    }
}