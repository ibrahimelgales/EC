plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.easycashwallet.tasks.utils"
    compileSdk = Versions.SDK.compile

    defaultConfig {
        minSdk = Versions.SDK.miniumum

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA.version
        targetCompatibility = Versions.JAVA.version
    }
    kotlinOptions {
        jvmTarget = Versions.JAVA.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.AndroidX.Compose.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementCoreCommonLibs()
    implementCoreTestLibs()
    implementation(Libs.AndroidX.Lifecycle.lifecycleViewmodel)
    api(Libs.Squareup.converterGson)
    api(Libs.Koin.koinCore)
    implementCoreComposeLibs()
    implementation(Libs.Coil.coilCompose)
    implementFirebaseDB()
}