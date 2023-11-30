package com.easycashwallet.tasks.utils.exception_handler

import com.google.gson.annotations.SerializedName


data class ApiErrorResponse(
    @SerializedName("message") val message: String? = "",
    val responseCode: Int? = null,
) {


    fun errorMessage() = when (responseCode) {
        500 -> "Can't reach to server now, please try again later."
        else -> message ?: "Unknown Error"
    }

}
