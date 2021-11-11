package com.example.almin.retrofit

import android.media.Rating
import android.net.Network


data class Show(
    val averageRuntime: Int,
    val dvdCountry: Any,
    val ended: String,
    val genres: List<Any>,
    val pk: Int=0,
    val image: Image,
    val language: String,
    val name: String,
    val network: Network,
    val officialSite: String,
    val premiered: String,
    val rating: Rating,
    val runtime: Int,
    val status: String,
    val summary: String,
    val type: String,
    val updated: Int,
    val url: String,
    val weight: Int
)