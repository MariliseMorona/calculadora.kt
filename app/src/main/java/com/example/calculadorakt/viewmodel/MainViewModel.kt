package com.example.calculadorakt.viewmodel

import androidx.lifecycle.ViewModel
import com.example.calculadorakt.repository.AddReportsRepository

class MainViewModel(private val repository: AddReportsRepository): ViewModel() {
    val addReports = repository.addReports
}