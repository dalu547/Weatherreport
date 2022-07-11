package com.dalu.weatherreport.ui

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.dalu.weatherreport.R

object CommonDialogs {
    fun showAlert(context: Context, message: String) {
        AlertDialog.Builder(context)
            .setTitle(context.getString(R.string.error))
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(context.getString(R.string.ok)) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }
}