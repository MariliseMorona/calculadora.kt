package com.example.calculadorakt.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.calculadorakt.model.ItemReports

@Dao
interface AddReportsDao {
@Query("SELECT * FROM add_reports ORDER BY reports_name_client ASC")
fun getAll() {
}

    @Insert
    fun insert(reports: ItemReports) {
    }

}