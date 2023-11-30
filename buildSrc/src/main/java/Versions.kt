import org.gradle.api.JavaVersion

object Versions {
    object SDK {
        const val compile = 34
        const val miniumum = 24
    }
    object JAVA {
        const val jvmTarget = "17"
        val version = JavaVersion.VERSION_17
    }
    object APP {
        const val versionCode = 1
        const val versionName = "1.0"
    }
    object AndroidX {
        const val coreKTX = "1.12.0"
        const val androidxAppCompat = "1.6.1"
        const val compose = "1.0.2"
        const val constraint = "2.1.4"
        const val lifecycle = "2.6.2"
        object Compose {
            const val kotlinCompilerExtensionVersion = "1.4.3"
            const val composeBOM = "2023.03.00"
            const val composeActivity = "1.8.1"
        }
        object Security {
            const val crypto = "1.0.0"
        }
    }
    object Google{
        const val material = "1.10.0"
        const val locationGMS = "21.0.1"
    }
    object Test {
        const val junit = "4.13.2"
        const val junitEXT = "1.1.5"
        const val espressoCore = "3.5.1"
        const val mockito = "4.11.0"
        const val mockitoKotlin = "5.1.0"
    }
    object Squareup {
        const val retrofitVersion = "2.9.0"
        const val okhttpLogVersion = "4.10.0"
    }
    object Koin {
        const val koinVersion = "3.4.0"
    }
    object KotlinX {
        const val coroutines = "1.7.0"
    }
    object Coil {
        const val coilCompose = "2.5.0"
    }
    object Firebase {
        const val firebaseBOM = "32.6.0"
    }
}