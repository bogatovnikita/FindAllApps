package com.bogatovnikita.findallapps.view.main

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.FragmentAllAppsBinding
import com.bogatovnikita.findallapps.view.details.InfoAppScreenFragment
import com.bogatovnikita.findallapps.viewmodel.InstalledApps

class AllAppsFragment : Fragment(), OnMyItemClickListener {

    private val adapter: AllAppsAdapter by lazy { AllAppsAdapter(this) }
    private var _binding: FragmentAllAppsBinding? = null
    private val binding: FragmentAllAppsBinding
        get() {
            return _binding!!
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
        initView()
    }

    companion object {
        fun newInstance() = AllAppsFragment()
    }

    private fun initView() {
        val pm: PackageManager? = activity?.packageManager
        val packages: List<ApplicationInfo>? =
            pm?.getInstalledApplications(PackageManager.GET_META_DATA)
        binding.apply {
            mainFragmentRecyclerView.layoutManager = GridLayoutManager(context, 2)
            mainFragmentRecyclerView.adapter = adapter
            if (packages != null) {
                for (packageInfo in packages) {
                    val tempApp =
                        InstalledApps(packageInfo.loadLabel(pm) as String, packageInfo.loadIcon(pm))
                    adapter.addApp(tempApp)
                }
            }
        }
    }

    override fun onItemClick(installedApps: InstalledApps) {
        requireActivity().run {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, InfoAppScreenFragment.newInstance())
                .addToBackStack("")
                .commit()
        }
    }
}