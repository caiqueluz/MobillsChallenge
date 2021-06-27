package com.caiqueluz.mobillschallenge

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.openKeyboard() {
    requestFocus()

    val inputMethodManager = context.getInputMethodManager()
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.closeKeyboard() {
    val inputMethodManager = context.getInputMethodManager()
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

private fun Context.getInputMethodManager() =
    getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
