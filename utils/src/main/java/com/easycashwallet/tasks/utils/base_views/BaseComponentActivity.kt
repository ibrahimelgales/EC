package com.easycashwallet.tasks.utils.base_views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.easycashwallet.tasks.utils.R
import com.easycashwallet.tasks.utils.SecurityUtils
import com.easycashwallet.tasks.utils.ui.LoaderDialog
import com.easycashwallet.tasks.utils.ui.USBDebuggingPopup

abstract class BaseComponentActivity<VM : BaseViewModel> : ComponentActivity() {

    //region vars
    abstract val viewModel: VM
    private var isLoading by mutableStateOf(true)
    private var isDebuggingEnabled: Boolean? by mutableStateOf(null)
    private val usbSettingsLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // Handle the result here
            if (result.resultCode == Activity.RESULT_OK) {
                isDebuggingEnabled = SecurityUtils.isUsbDebuggingEnabled(this)
            }
        }

    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)

        if (SecurityUtils.isEmulator() || SecurityUtils.isRooted()) {
            showRootedDeviceAlert()
            finishAffinity()
        }

        viewModel.appLoader.isLoading.observe(this) {
            isLoading = it
        }
        viewModel.customException.observe(this) {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }

    }



    override fun onResume() {
        super.onResume()
        isDebuggingEnabled = SecurityUtils.isUsbDebuggingEnabled(this)
        if (isDebuggingEnabled == false)
            saveToCallAPIs()
    }


    //region compose
    @Composable
    fun CheckDebuggingMode() {
        USBDebuggingPopup(
            isDebuggingEnabled == true,
            onClickChargeOnly = {
                val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
                usbSettingsLauncher.launch(intent)
            },
            onClickQuitApp = {
                finishAffinity()
            }
        )
    }

    @Composable
    fun Loading() {
        LoaderDialog(isLoading = isLoading)
    }
    //endregion

    //region functions
    abstract fun saveToCallAPIs()
    private fun showRootedDeviceAlert() {
        Toast.makeText(
            this, R.string.rooted_device_alert, Toast.LENGTH_SHORT
        ).show()
    }
    //endregion
}