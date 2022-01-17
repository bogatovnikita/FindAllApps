package com.bogatovnikita.findallapps.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.AppItemBinding
import com.bogatovnikita.findallapps.viewmodel.InstalledApps

class AllAppsAdapter :
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
        return holder.bind(allAppsData[position])
    }

    override fun getItemCount(): Int {
        return allAppsData.size
    }

    inner class MainViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = AppItemBinding.bind(item)
        fun bind(app: InstalledApps) = with(binding) {
            appName.text = app.appName
            appPackage.text = app.appPackageName
        }
    }

    fun addApp(app: InstalledApps) {
        allAppsData.add(app)
        notifyDataSetChanged()
    }
}