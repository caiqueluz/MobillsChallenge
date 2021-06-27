package com.caiqueluz.mobillschallenge

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

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
private fun FragmentActivity.findFragmentViewNavController(): NavController {
    val navHostFragment = supportFragmentManager
        .findFragmentById(R.id.revenue_navigation_container) as NavHostFragment

    return navHostFragment.navController
}
