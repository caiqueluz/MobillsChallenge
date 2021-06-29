package com.caiqueluz.mobillschallenge

import android.app.Activity
import android.content.DialogInterface
import android.content.res.Resources
import androidx.appcompat.app.AlertDialog

class DialogFactory(
    private val resources: Resources
) {

    fun createDialog(
        activity: Activity,
        title: String,
        message: String,
        onPositiveButtonClicked: (DialogInterface) -> Unit
    ): AlertDialog = AlertDialog.Builder(activity)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton(
            resources.getString(R.string.add_transaction_success_dialog_positive_button)
        ) { dialogInterface, _ ->
            onPositiveButtonClicked.invoke(dialogInterface)
        }
        .create()
}
