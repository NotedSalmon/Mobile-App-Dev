package com.example.wagonersexperts.Payment

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wagonersexperts.Menu.Menu_DataFiles
import com.example.wagonersexperts.R

class MenuAdapter(private val itemList: Menu_DataFiles) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_payment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Bind data to views
        fun bind(menuItem: MenuItem) {
            // Implement binding logic for each view
        }
    }
}
