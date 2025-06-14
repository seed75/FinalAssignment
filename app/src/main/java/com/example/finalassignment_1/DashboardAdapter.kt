package com.example.finalassignment_1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DashboardAdapter(
    private val items: List<Map<String, Any>>,
    private val onClick: (Map<String, Any>) -> Unit
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.assetTypeTextView)
        val tickerText: TextView = view.findViewById(R.id.tickerTextView)
        val priceText: TextView = view.findViewById(R.id.priceTextView)
        val yieldText: TextView = view.findViewById(R.id.yieldTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        val title = item["assetType"] as? String
            ?: item["name"] as? String
            ?: item.keys.firstOrNull()?.let { "$it: ${item[it]}" }
            ?: "Untitled"

        val ticker = item["ticker"] as? String ?: "N/A"
        val price = (item["currentPrice"] as? Number)?.toString()
            ?: (item["price"] as? Number)?.toString()
            ?: "0.0"
        val yield = (item["dividendYield"] as? Number)?.toString()
            ?: (item["yield"] as? Number)?.toString()
            ?: "0.0"

        // Exclude description from the summary
        val excludedKeys = setOf("assetType", "name", "description")
        val details = item.filterKeys { it !in excludedKeys }
            .entries.joinToString("\n") { "${it.key}: ${it.value}" }

        holder.titleText.text = title
        holder.tickerText.text = details
        holder.priceText.text = ""
        holder.yieldText.text = ""

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<Map<String, Any>>) {
        (items as MutableList).clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}