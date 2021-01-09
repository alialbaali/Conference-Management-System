plugins {
    `java-library`
}

dependencies {

    api(AndroidX.Room.common)
    api(AndroidX.Room.rxJava2)
//    api("io.reactivex.rxjava3:rxjava:2.2.19")

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}