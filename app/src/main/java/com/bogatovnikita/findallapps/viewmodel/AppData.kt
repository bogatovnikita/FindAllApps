package com.bogatovnikita.findallapps.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class AppData : ViewModel() {
    val appModel: MutableLiveData<InstalledApps> by lazy {
        MutableLiveData<InstalledApps>()
    }
}