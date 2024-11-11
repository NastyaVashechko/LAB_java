plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // TestNG
    testImplementation("org.testng:testng:7.10.2")

    // SLF4J API
    implementation("org.slf4j:slf4j-api:2.0.7")

    // Logback implementation
    implementation("ch.qos.logback:logback-classic:1.4.11")
}

tasks.test {
    useTestNG()
}
