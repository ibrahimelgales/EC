package com.easycashwallet.tasks.utils.base_views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easycashwallet.tasks.utils.AppLoader
import com.easycashwallet.tasks.utils.exception_handler.CustomExceptionManager

import kotlinx.coroutines.Dispatchers


open class BaseViewModel : ViewModel(), NetworkViewModel {

    //region vars
    override val coroutineScope = viewModelScope
    override val mainDispatchers = Dispatchers.Main
    override val customException: SingleLiveEvent<CustomExceptionManager.EcThrowable> =
        SingleLiveEvent()
    val appLoader by lazy { AppLoader() }
    //endregion


}