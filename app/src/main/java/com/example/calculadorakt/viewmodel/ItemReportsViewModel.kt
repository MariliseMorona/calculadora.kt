package com.example.calculadorakt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadorakt.model.ItemReports
import com.example.calculadorakt.repository.AddReportRepository
import kotlinx.coroutines.launch

class ItemReportsViewModel(private var repository: AddReportRepository): ViewModel() {
    val addReports = repository.addReports

    fun insertNewItemReports(reports: ItemReports){
        viewModelScope.launch {
            repository.insertNewItemReports(reports)
        }
    }

}
