package com.easycashwallet.tasks.utils

import android.content.Context
import android.os.Build
import java.io.File
import android.provider.Settings.Global
import androidx.annotation.Nullable


object SecurityUtils {

    private const val GOLDFISH = "goldfish"
    private const val RANCHU = "ranchu"
    private const val SDK = "sdk"

    fun isRooted(): Boolean {
        // No reliable way to determine if an android phone is rooted, since a rooted phone could
        // always disguise itself as non-rooted. Some common approaches can be found on SO:
        //   http://stackoverflow.com/questions/1101380/determine-if-running-on-a-rooted-device
        //
        // http://stackoverflow.com/questions/3576989/how-can-you-detect-if-the-device-is-rooted-in-the-app
        //
        // http://stackoverflow.com/questions/7727021/how-can-androids-copy-protection-check-if-the-device-is-rooted
        val isEmulator = isEmulator()
        val buildTags = Build.TAGS
        if (!isEmulator && buildTags != null && buildTags.contains("test-keys")) {
            return true
        }

        // Superuser.apk would only exist on a rooted device:
        var file = File("/system/app/Superuser.apk")
        if (file.exists()) {
            return true
        }

        // su is only available on a rooted device (or the emulator)
        // The user could rename or move to a non-standard location, but in that case they
        // probably don't want us to know they're root and they can pretty much subvert
        // any check anyway.
        file = File("/system/xbin/su")
        return !isEmulator && file.exists()
    }


    fun isEmulator(): Boolean {

        return (Build.PRODUCT.contains(SDK)
                || Build.HARDWARE.contains(GOLDFISH)
                || Build.HARDWARE.contains(RANCHU))
    }

     fun isUsbDebuggingEnabled(context: Context): Boolean {
        return Global.getInt(context.contentResolver, Global.ADB_ENABLED, 0) != 0
    }
}