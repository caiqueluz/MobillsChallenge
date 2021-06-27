package com.mobillschallenge.buildsrc

object Versions {

    object Generic {

        const val KOTLIN = "1.4.30"
        const val BUILD_GRADLE = "4.1.2"
        const val JVM_TARGET = "1.8"
    }

    object Library {

        object Android {

            const val LIFECYCLE = "2.3.0"
            const val KTX = "1.3.2"
            const val NAVIGATION_KTX = "2.3.5"
            const val ARCH = "2.1.0"

            const val MATERIAL = "1.3.0"
            const val APP_COMPAT = "1.2.0"
            const val CONSTRAINT_LAYOUT = "2.0.4"
            const val VIEW_PAGER_2 = "1.0.0"
        }

        const val KOIN = "2.2.2"
    }

    object Test {

        const val JUNIT = "4.12"
        const val EXT_JUNIT = "1.1.2"

        const val FRAGMENT_TESTING = "1.3.3"
        const val ANDROID_TEST_RUNNER = "1.3.0"

        const val MOCKITO_CORE = "3.8.0"
        const val MOCKITO_KOTLIN = "2.2.0"
        const val COROUTINES_TEST = "1.4.2"
        const val ESPRESSO_CORE = "3.3.0"
        const val ROBOLECTRIC = "4.5.1"
    }
}
