package com.example.calculadorakt.repository

import com.example.calculadorakt.data.AddReportsDao
import com.example.calculadorakt.model.ItemReports

class AddReportRepository(private val dao: AddReportsDao) {
    val addReports = dao.getAll()

    suspend fun insertNewItemReports(reports: ItemReports){
        dao.insert(reports)
    }
}