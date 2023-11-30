plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.easycashwallet.tasks.EC"
    compileSdk = Versions.SDK.compile

    defaultConfig {
        applicationId = "com.easycashwallet.tasks.EC"
        minSdk = Versions.SDK.miniumum
        targetSdk = Versions.SDK.compile
        versionCode = Versions.APP.versionCode
        versionName = Versions.APP.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            // Enables code shrinking, obfuscation, and optimization for only
            // your project's release build type. Make sure to use a build
            // variant with `isDebuggable=false`.
            isMinifyEnabled = true

            // Enables resource shrinking, which is performed by the
            // Android Gradle plugin.
            isShrinkResources = true
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //region internal modules
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":utils"))
    //endregion

    implementCoreCommonLibs()

    implementation(Libs.AndroidX.constraint)
    implementation(Libs.KotlinX.coroutinesCore)

    implementCoreComposeLibs()
    implementCoreLifecycleLibs()
    implementCoreTestLibs()
    implementCoreKoinLibs()

}