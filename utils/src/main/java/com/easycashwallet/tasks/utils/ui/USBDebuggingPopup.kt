package com.easycashwallet.tasks.utils.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun USBDebuggingPopup(
    isUsbDebuggingEnabled: Boolean,
    onClickChargeOnly: () -> Unit,
    onClickQuitApp: () -> Unit
) {
    if (isUsbDebuggingEnabled)
        AlertDialog(
            onDismissRequest = { },
            title = {
                Text("USB Debugging Enabled")
            },
            text = {
                Text(
                    "It seems you have USB debugging enabled on your device. Please turn it off to use our app."
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onClickChargeOnly()
                    }
                ) {
                    Text("Turn Off")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        onClickQuitApp()
                    }
                ) {
                    Text("Quit APP")
                }
            }
        )
}