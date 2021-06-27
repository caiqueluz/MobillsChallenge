package com.caiqueluz.mobillschallenge

import android.app.Activity
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

fun AppCompatActivity.enableToolbarBackButton(toolbar: Toolbar) {
    setSupportActionBar(toolbar)

    supportActionBar?.setDisplayShowHomeEnabled(true)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

inline fun <reified VALUE> Activity.extra(key: String): VALUE =
    intent.extras?.get(key) as VALUE ?: throw IllegalStateException(
        "ERROR: could not get extra of type '${VALUE::class.java.simpleName}' " +
                "associated with key '$key', from activity '${this::class.java.simpleName}'"
    )

/**
 *
 * FragmentContainerView navigation bug. See this: https://stackoverflow.com/a/59275182
 *
 */
fun FragmentActivity.findFragmentViewNavController(@IdRes containerId: Int): NavController {
    val navHostFragment = supportFragmentManager.findFragmentById(containerId) as NavHostFragment
    return navHostFragment.findNavController()
}
