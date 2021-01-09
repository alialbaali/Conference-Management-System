plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "com.confy"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation(Google.android.material)
    implementation(AndroidX.constraintLayout)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation(AndroidX.Navigation.fragment)
    implementation(AndroidX.Navigation.ui)
    implementation(AndroidX.Lifecycle.liveData)
    implementation(AndroidX.Lifecycle.viewModel)
    implementation(AndroidX.recyclerView)
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation("com.android.support.recyclerview-v7:23.1.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}