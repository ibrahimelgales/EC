package com.easycashwallet.tasks.data.competitions.dto.common

import com.google.gson.annotations.SerializedName

data class Season(
    @SerializedName("currentMatchday") val currentMatchDay: Int,
    val endDate: String,
    val id: Int,
    val stages: List<String>,
    val startDate: String,
    val winner: Winner?
)