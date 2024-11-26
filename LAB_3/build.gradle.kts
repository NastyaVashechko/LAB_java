plugins {
    kotlin("jvm") version "1.8.0"
    id("application")
    id("java")
}



application {
    mainClass.set("lab3.Main")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.0")  // Для JSON анотацій
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.0") // для підтримки LocalDate
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}
