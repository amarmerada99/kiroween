plugins {
    //facilitates executable JVM app
    application
}
dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.guava)
}
application{
    mainClass = "org.example.App"
}