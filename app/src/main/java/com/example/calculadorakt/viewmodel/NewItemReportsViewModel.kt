package com.example.calculadorakt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculadorakt.model.ItemReports
import com.example.calculadorakt.repository.AddReportsRepository
import kotlinx.coroutines.launch

class NewItemReportsViewModel(private val repository: AddReportsRepository): ViewModel() {
    fun insertNewItemReports(reportsName: String, reportsAd: String, reportsTotalInvested: Double, reportsInvested: Double,
    reportsView: Int, reportsShare: Int, reportsClicks: Int, reportsDate: String, reportsPeriod: Int){
        viewModelScope.launch {
            val reports = ItemReports(reportsName: String, reportsAd, reportsTotalInvested, reportsInvested,
                reportsView, reportsShare, reportsClicks, reportsDate, reportsPeriod)
            repository.insertNewItemReports(reports)
        }
    }
}
