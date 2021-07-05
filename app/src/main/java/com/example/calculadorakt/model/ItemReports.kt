package com.example.calculadorakt.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "add_reports")
data class ItemReports(
    @ColumnInfo(name = "reports_total_value_invested")
    var valorInvestidoTotal: Double,
    @ColumnInfo(name = "reports_views")
    val visualizacoesMax: Int,
    @ColumnInfo(name = "reports_name_client")
    val cliente: String,
    @ColumnInfo(name = "reports_add")
    val anuncio: String,
    @ColumnInfo(name = "reports_date")
    val data: Int,
    @ColumnInfo(name = "reports_period")
    val periodo: Int,
    @ColumnInfo(name = "reports_clicks")
    val cliquesMax: Int,
    @ColumnInfo(name = "reports_shares")
    val compartilhamentosMax: Int,
    @ColumnInfo(name = "reports_value_invested_day")
    val valorInvestidoDia: Double,
    @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "reports_id")
    val id: Int = 0
    ){

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as ItemReports

        if(id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}
