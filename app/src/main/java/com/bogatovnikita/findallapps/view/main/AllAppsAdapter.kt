package com.bogatovnikita.findallapps.view.main

import android.annotation.SuppressLint
import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.AppItemBinding
import com.bogatovnikita.findallapps.viewmodel.InstalledApps
import kotlin.math.log

class AllAppsAdapter(val listener: OnMyItemClickListener) :
    RecyclerView.Adapter<AllAppsAdapter.MainViewHolder>() {

    private var allAppsData: MutableList<InstalledApps> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllAppsAdapter.MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.app_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AllAppsAdapter.MainViewHolder, position: Int) {
        holder.bind(allAppsData[position])
    }

    override fun getItemCount(): Int {
        return allAppsData.size
    }

    inner class MainViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = AppItemBinding.bind(item)
        fun bind(app: InstalledApps) {
            with(binding) {
                appName.text = app.appName
                imageView.setImageDrawable(app.imageView)
            }
            itemView.setOnClickListener { listener.onItemClick(app) }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addApp(app: InstalledApps) {
        allAppsData.add(app)
        notifyDataSetChanged()
    }
}