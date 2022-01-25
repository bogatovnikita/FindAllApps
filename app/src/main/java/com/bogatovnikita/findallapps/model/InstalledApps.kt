package com.bogatovnikita.findallapps.model

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class InstalledApps(
    val appName: @RawValue String?,
    val imageView: @RawValue Drawable?,
    val sizeApp: @RawValue Int?,
    val targetSDKVersion: @RawValue Int?,
    val installationData: @RawValue Long?,
) : Parcelable


