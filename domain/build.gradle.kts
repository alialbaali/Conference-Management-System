plugins {
    `java-library`
}

dependencies {

    api(AndroidX.Room.common)
    api("io.reactivex.rxjava3:rxjava:3.0.9")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}