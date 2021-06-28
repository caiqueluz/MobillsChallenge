package com.caiqueluz.mobillschallenge

import androidx.fragment.app.Fragment

inline fun <reified VALUE> Fragment.extra(key: String): VALUE =
    requireArguments().get(key) as VALUE ?: throw IllegalStateException(
        "ERROR: could not get extra of type '${VALUE::class.java.simpleName}' " +
                "associated with key '$key', from fragment '${this::class.java.simpleName}'"
    )
