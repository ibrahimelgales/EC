import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandler.implementation(dependencyNotation: Any) =
    add("implementation", dependencyNotation)

fun DependencyHandler.debugImplementation(dependencyNotation: Any) =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.api(dependencyNotation: Any) =
    add("api", dependencyNotation)

fun DependencyHandlerScope.implementCoreComposeLibs() {
    implementation(Libs.AndroidX.Compose.composeActivity)
    implementation(platform(Libs.AndroidX.Compose.composeBom))
    implementation(Libs.AndroidX.Compose.composeUi)
    implementation(Libs.AndroidX.Compose.composeUiGraphics)
    implementation(Libs.AndroidX.Compose.composeUiPreview)
    implementation(Libs.AndroidX.Compose.composeRuntimeLiveData)
    implementation(Libs.AndroidX.Compose.composeMaterial3)
    implementation(Libs.AndroidX.Compose.composeMaterial3IconExtened)
    debugImplementation(Libs.AndroidX.Compose.composeDebugUiTooling)
    debugImplementation(Libs.AndroidX.Compose.composeDebugUiTestManifest)
}

fun DependencyHandlerScope.implementCoreLifecycleLibs() {
    implementation(Libs.AndroidX.Lifecycle.lifecycleRuntime)
    implementation(Libs.AndroidX.Lifecycle.lifecycleViewmodel)
    implementation(Libs.AndroidX.Lifecycle.lifecycleLivedata)
}

fun DependencyHandlerScope.implementCoreTestLibs() {
    testImplementation(Libs.Test.junit)
    testImplementation(Libs.Test.mockitoKotlin)
    testImplementation(Libs.Test.mockitoCore)
    androidTestImplementation(Libs.Test.junitExt)
    androidTestImplementation(Libs.Test.espressoCore)
}

fun DependencyHandlerScope.implementCoreCommonLibs() {
    implementation(Libs.AndroidX.coreKTX)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.Google.material)
}

fun DependencyHandlerScope.implementCoreRetrofitLibs() {
    implementation(Libs.Squareup.retrofit)
    implementation(Libs.Squareup.converterGson)
    implementation(Libs.Squareup.loggingInterceptor)
}

fun DependencyHandlerScope.implementCoreKoinLibs() {
    implementKoinCore()
    implementation(Libs.Koin.koinAndroid)
}

fun DependencyHandlerScope.implementKoinCore() {
    implementation(Libs.Koin.koinCore)
}

fun DependencyHandlerScope.implementFirebaseDB() {
    implementation(platform(Libs.Firebase.firebaseBOM))
    implementation(Libs.Firebase.database)
}