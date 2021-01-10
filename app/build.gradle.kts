plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("androidx.navigation.safeargs")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "com.confy"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(AndroidX.appCompat)
    implementation(Google.android.material)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.Legacy.supportV4)
    implementation(AndroidX.Navigation.fragment)
    implementation(AndroidX.Navigation.ui)
    implementation(AndroidX.Lifecycle.liveData)
    implementation(AndroidX.Lifecycle.viewModel)
    implementation(AndroidX.recyclerView)
    implementation(platform("com.google.firebase:firebase-bom:26.2.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database")

    api("com.jakewharton.timber:timber:4.7.1")
    implementation(AndroidX.Room.runtime)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    annotationProcessor(AndroidX.Room.compiler)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.1")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}