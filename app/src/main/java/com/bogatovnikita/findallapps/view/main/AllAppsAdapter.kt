package com.bogatovnikita.findallapps.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.AppItemBinding
import com.bogatovnikita.findallapps.model.InstalledApps

class AllAppsAdapter(val listener: OnMyItemClickListener) :
    RecyclerView.Adapter<AllAppsAdapter.MainViewHolder>() {

    private var allAppsData: List<InstalledApps> = listOf()

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

    fun setApp(app: List<InstalledApps>) {
        this.allAppsData = app
        notifyDataSetChanged()
    }
}