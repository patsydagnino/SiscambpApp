package mx.gob.fondofuturo.siscambpmovil.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object Permissions {
    fun cameraPermission(
        context: Context?,
        activity: Activity?,
        request: Int
    ): Boolean {
        return if (ContextCompat.checkSelfPermission(
                context!!,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                activity!!,
                arrayOf(Manifest.permission.CAMERA),
                request
            )
            false
        } else {
            true
        }
    }

    fun storagePermission(
        context: Context?,
        activity: Activity?,
        request: Int
    ): Boolean {
        return if (ContextCompat.checkSelfPermission(
                context!!,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
            && ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                activity!!,
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                request
            )
            false
        } else {
            true
        }
    }

}