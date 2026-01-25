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
    implementation("us.ihmc:ihmc-yovariables:0.13.6")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")

}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(17)) }
}

application {
    mainClass.set("com.practice.roomba.Main")
}

tasks.test {
    useJUnitPlatform()
    
    testLogging {
      events("passed", "skipped", "failed")
      showStandardStreams = true
   }
}

