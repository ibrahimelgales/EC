plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.easycashwallet.tasks.domain"
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
}

dependencies {
    implementation(project(":utils"))
    implementCoreCommonLibs()
    implementCoreTestLibs()
}