package com.example.calculadorakt.data

import com.example.calculadorakt.model.ItemReports


object AdDataSource {
    private val list = arrayListOf<ItemReports>()

    fun getList() = list.toList()

    fun insertReport(report: Unit){
        var id : Int = 0
        if(id == 0){
            list.add(report
                .copy(id = list.size+1))
        }else{
            list.remove(report)
            list.add(report)
        }

    }



    fun findById(reportId: Int) = list.find {
        it.id == reportId
    }

private fun <E> ArrayList<E>.add(element: Unit) {

}

private fun Unit.copy(id: Int) {

}

private fun <E> ArrayList<E>.remove(element: Unit) {

}

    fun deleteReport(it: ItemReports) {

    }
}