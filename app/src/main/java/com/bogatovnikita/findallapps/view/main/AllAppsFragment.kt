package com.bogatovnikita.findallapps.view.main

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.FragmentAllAppsBinding
import com.bogatovnikita.findallapps.databinding.FragmentButtonBinding
import com.bogatovnikita.findallapps.viewmodel.InstalledApps

class AllAppsFragment : Fragment() {

    private val adapter = AllAppsAdapter()
    private val packages: List<ApplicationInfo>? = null
    private val pm: PackageManager? = context?.packageManager
    private var _binding: FragmentAllAppsBinding? = null
    private val binding: FragmentAllAppsBinding
        get() {
            return _binding!!
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllAppsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPackageManager()
        initRecyclerView()
    }

    companion object {
        fun newInstance() = AllAppsFragment()
    }


    fun initRecyclerView() {
        binding.apply {
            mainFragmentRecyclerView.layoutManager = GridLayoutManager(context, 3)
            mainFragmentRecyclerView.adapter = adapter
            if (packages != null) {
                for (packageInfo in packages) {
                    val tempApp =
                        InstalledApps(pm?.let { packageInfo.loadLabel(it) } as String,
                            packageInfo.packageName)
                    adapter.addApp(tempApp)
                }
            }

        }
    }

    private fun initPackageManager() {
        var packages = pm?.getInstalledApplications(PackageManager.GET_META_DATA)
    }
}