/*
 * Purpose:
 * - Headless Roomba simulation starter project using Java 17 + Gradle.
 * - Includes IHMC Euclid for vectors/points.
 * - Runs from com.practice.roomba.Main
 */
plugins {
    application
    java
}

repositories { mavenCentral() }

dependencies {
    implementation("us.ihmc:euclid:0.22.5")
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(17)) }
}

application {
    mainClass.set("com.practice.roomba.Main")
}
