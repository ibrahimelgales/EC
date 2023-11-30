package com.easycashwallet.tasks.utils

import com.easycashwallet.tasks.utils.base_views.SingleLiveEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class AppLoader {

    //region vars
    private var loaderCount = 0
    private var _isLoading = SingleLiveEvent<Boolean>()
    val isLoading = _isLoading
    //endregion


    fun <T> hookThisFlow(flow: Flow<T>): Flow<T> {
        return flow.onStart {
            publishLoader(true)
        }.onCompletion {
            publishLoader(false)

        }

    }

    private fun publishLoader(b: Boolean) {
        loaderCount = if (b) loaderCount + 1 else loaderCount - 1
        if (shouldWeEmitLoader(b))
            _isLoading.postValue(b)
    }

    private fun shouldWeEmitLoader(b: Boolean): Boolean {
        val tempLoading = isLoading.value
        return tempLoading == null || (b != isLoading.value && loaderCount <= 0)
    }
}