package com.bogatovnikita.findallapps.view.main

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bogatovnikita.findallapps.APP_PARCELABLE
import com.bogatovnikita.findallapps.R
import com.bogatovnikita.findallapps.databinding.FragmentAllAppsBinding
import com.bogatovnikita.findallapps.model.InstalledApps
import com.bogatovnikita.findallapps.view.details.InfoAppScreenFragment

class AllAppsFragment : Fragment(), OnMyItemClickListener {


    private val adapter: AllAppsAdapter by lazy { AllAppsAdapter(this) }
    private val dataApps: MutableList<InstalledApps> = mutableListOf()
    private var _binding: FragmentAllAppsBinding? = null
    private val binding: FragmentAllAppsBinding
        get() {
            return _binding!!
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true)
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
        adapter.setApp(dataApps)
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
                    val appName = packageInfo.loadLabel(pm) as String
                    val imageView = packageInfo.loadIcon(pm)
                    val sizeApp = packageInfo.publicSourceDir.length
                    val targetSDKVersion = packageInfo.targetSdkVersion
                    val installationData =
                        context?.let { pm.getPackageInfo(it.packageName, 0) }?.firstInstallTime
                    val tempApp =
                        InstalledApps(
                            appName,
                            imageView,
                            sizeApp,
                            targetSDKVersion,
                            installationData
                        )
                    dataApps.add(tempApp)
                }
            }
        }
    }

    override fun onItemClick(installedApps: InstalledApps) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, InfoAppScreenFragment.newInstance(Bundle().apply {
                putParcelable(APP_PARCELABLE, installedApps)
            })).addToBackStack("").commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}