package com.example.calculadorakt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.calculadorakt.repository.AddReportRepository
import com.example.calculadorakt.repository.AddReportsRepository

class ItemReportsViewModelFactory(private val repository: AddReportRepository): ViewModelProvider.Factory{
    override fun <T: ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(ItemReportsViewModel::class.java)){
            return ItemReportsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class NewItemReportsViewModelFactory(private val repository: AddReportsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewItemReportsViewModel::class.java)) {
            return NewItemReportsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}