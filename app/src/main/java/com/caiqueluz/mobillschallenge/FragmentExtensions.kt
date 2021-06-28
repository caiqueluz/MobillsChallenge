package com.caiqueluz.mobillschallenge

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

fun Fragment.enableToolbarBackButton(toolbar: Toolbar) {
    val activity = this.requireActivity() as AppCompatActivity
    activity.setSupportActionBar(toolbar)

    activity.supportActionBar?.setDisplayShowHomeEnabled(true)
    activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

inline fun <reified VALUE> Fragment.extra(key: String): VALUE =
    requireArguments().get(key) as VALUE ?: throw IllegalStateException(
        "ERROR: could not get extra of type '${VALUE::class.java.simpleName}' " +
                "associated with key '$key', from fragment '${this::class.java.simpleName}'"
    )
