package com.example.calculadorakt.ui.view


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.calculadorakt.R
import com.example.calculadorakt.databinding.ItemReportsBinding
import com.example.calculadorakt.model.ItemReports


class ReportListAdapter : RecyclerView.Adapter<ReportListAdapter.ReportViewHolder>(){
var data = listOf<ItemReports>()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    var listenerOpen : (ItemReports) -> Unit = {}
    var listenerEdit : (ItemReports) -> Unit = {}
    var listenerDelete : (ItemReports) -> Unit = {}


// Cria o View Holder, infla o layout do item da recyclerView
// e habilita uma posição para cada item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemReportsBinding.inflate(inflater, parent, false)
        return ReportViewHolder(binding)
    }
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int){
        val reports = data[position]
        holder.bind(reports)
//                reports.cliente, reports.anuncio
//            , reports.valorInvestidoTotal,
//            reports.valorInvestidoDia, reports.cliquesMax, reports.data,
//            reports.periodo, reports.compartilhamentosMax, reports.id
//        )
    }

    inner class ReportViewHolder(bindind: ItemReportsBinding
    ) : RecyclerView.ViewHolder(bindind.root){
        private val reportsNameClient = itemView.findViewById<TextView>(R.id.text_client_add_item)
        private val reportsAd = itemView.findViewById<TextView>(R.id.edt_name_add_item)
        private val btnMore = itemView.findViewById<Button>(R.id.mgv_more)

// Reporta os valores presentes nos itens da recyclerView
// nome do cliente, nome do anúncio e o botão de menu
        fun bind(reports: ItemReports){
            reportsNameClient.text = reports.cliente
            reportsAd.text = reports.anuncio
            btnMore.setOnClickListener {
                showPopup(reports)
            }
        }

//  Infla o menu
        private fun showPopup(reports: ItemReports){
            val ivMore = btnMore
            val popupMenu = PopupMenu(ivMore.context, ivMore)
            popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_open -> listenerOpen(reports)
                    R.id.action_edit -> listenerEdit(reports)
                    R.id.action_delete -> listenerDelete(reports)
                }
                return@setOnMenuItemClickListener true
            }
            popupMenu.show()
        }
    }

    }
class DiffCallBack : DiffUtil.ItemCallback<ItemReports>(){
    override fun areItemsTheSame(oldItem: ItemReports, newItem: ItemReports) = oldItem == newItem
    override fun areContentsTheSame(oldItem: ItemReports, newItem: ItemReports) = oldItem.id  == newItem.id
}
