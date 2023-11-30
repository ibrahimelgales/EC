object Libs {
    object AndroidX {
        const val coreKTX = "androidx.core:core-ktx:${Versions.AndroidX.coreKTX}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.androidxAppCompat}"
        const val constraint =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraint}"

        object Lifecycle {
            const val lifecycleRuntime =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycle}"
            const val lifecycleLivedata =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.AndroidX.lifecycle}"
            const val lifecycleViewmodel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycle}"
        }

        object Compose {
            const val composeActivity =
                "androidx.activity:activity-compose:${Versions.AndroidX.Compose.composeActivity}"
            const val composeBom =
                "androidx.compose:compose-bom:${Versions.AndroidX.Compose.composeBOM}"
            const val composeMaterial3 = "androidx.compose.material3:material3"
            const val composeMaterial3IconExtened =
                "androidx.compose.material:material-icons-extended"
            const val composeUi = "androidx.compose.ui:ui"
            const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
            const val composeUiPreview = "androidx.compose.ui:ui-tooling-preview"
            const val composeRuntimeLiveData = "androidx.compose.runtime:runtime-livedata"
            const val composeDebugUiTooling = "androidx.compose.ui:ui-tooling"
            const val composeDebugUiTestManifest = "androidx.compose.ui:ui-test-manifest"
        }

        object Security {
            const val securityCrypto =
                "androidx.security:security-crypto:${Versions.AndroidX.Security.crypto}"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.Google.material}"
        const val locationService =
            "com.google.android.gms:play-services-location:${Versions.Google.locationGMS}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.Test.junitEXT}"
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.Test.mockitoKotlin}"
        const val mockitoCore = "org.mockito:mockito-core:${Versions.Test.mockito}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Versions.Test.espressoCore}"
    }

    object Squareup {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Squareup.retrofitVersion}"
        const val converterGson =
            "com.squareup.retrofit2:converter-gson:${Versions.Squareup.retrofitVersion}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Squareup.okhttpLogVersion}"
    }

    object Koin {
        const val koinCore = "io.insert-koin:koin-core:${Versions.Koin.koinVersion}"
        const val koinAndroid = "io.insert-koin:koin-android:${Versions.Koin.koinVersion}"
    }

    object KotlinX {
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KotlinX.coroutines}"
    }

    object Coil {
        const val coilCompose = "io.coil-kt:coil-compose:${Versions.Coil.coilCompose}"
    }

    object Firebase {
        const val firebaseBOM = "com.google.firebase:firebase-bom:${Versions.Firebase.firebaseBOM}"
        const val database = "com.google.firebase:firebase-database-ktx"
    }
}