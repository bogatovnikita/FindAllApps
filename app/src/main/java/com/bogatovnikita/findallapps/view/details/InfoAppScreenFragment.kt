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
import java.util.*

class InfoAppScreenFragment : Fragment() {
    private lateinit var app: InstalledApps
    private var _binding: FragmentInfoAppScreenBinding? = null
    private val binding: FragmentInfoAppScreenBinding
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
        _binding =
            FragmentInfoAppScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            it.getParcelable<InstalledApps>(APP_PARCELABLE)?.let { app = it }
        }
        initView()
    }

    private fun initView() {
        with(binding) {
            appName.text = app.appName
            imageView.setImageDrawable(app.imageView)
            size_app.text = app.sizeApp.toString() + "MB"
            targetSdkVersion.text = app.targetSDKVersion.toString()
            installationData.text = app.installationData?.let { parseDate(it) }
            backBtn.setOnClickListener {
                activity?.supportFragmentManager?.popBackStack()
            }
        }
    }

    companion object {
        fun newInstance(bundle: Bundle) = InfoAppScreenFragment().apply { arguments = bundle }
    }

    private fun parseDate(date: Long): String {
        val sdf = SimpleDateFormat("dd.MM.yyyy")
        return sdf.format(date).toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}