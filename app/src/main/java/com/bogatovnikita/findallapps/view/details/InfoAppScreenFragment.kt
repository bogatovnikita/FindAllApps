package com.bogatovnikita.findallapps.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bogatovnikita.findallapps.APP_PARCELABLE
import com.bogatovnikita.findallapps.databinding.FragmentInfoAppScreenBinding
import com.bogatovnikita.findallapps.model.InstalledApps
import kotlinx.android.synthetic.main.fragment_info_app_screen.*
import java.text.SimpleDateFormat

class InfoAppScreenFragment() : Fragment() {
    private lateinit var app: InstalledApps
    private var _binding: FragmentInfoAppScreenBinding? = null
    private val binding: FragmentInfoAppScreenBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentInfoAppScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            it.getParcelable<InstalledApps>(APP_PARCELABLE)?.let { app = it }
        }
        with(binding) {
            appName.text = app.appName
            imageView.setImageDrawable(app.imageView)
            size_app.text = app.sizeApp.toString()
            targetSdkVersion.text = app.targetSDKVersion.toString()
            installationData.text = app.installationData?.let { parseDate(it) }
        }
    }

    companion object {
        fun newInstance(bundle: Bundle) = InfoAppScreenFragment().apply { arguments = bundle }
    }

    fun parseDate(date: Long): String {
        val sdf = SimpleDateFormat("MM.dd.yyyy")
        return sdf.format(date)
    }

}