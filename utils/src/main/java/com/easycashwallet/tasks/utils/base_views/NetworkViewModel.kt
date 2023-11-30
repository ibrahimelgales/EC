package com.easycashwallet.tasks.utils.base_views



import com.easycashwallet.tasks.utils.exception_handler.CustomExceptionManager
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.launch

interface NetworkViewModel {
    val coroutineScope: CoroutineScope
    val mainDispatchers: MainCoroutineDispatcher
    val customException: SingleLiveEvent<CustomExceptionManager.EcThrowable>

    /**
     * This function catch our custom exception and post value to our custom exception LiveEvent
     */
    fun launchViewModelScope(block: suspend CoroutineScope.() -> Unit): Job {
        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            if (exception is CustomExceptionManager.EcThrowable)
                customException.postValue(exception)

        }
        return coroutineScope.launch(exceptionHandler, block = block)
    }
}
