plugins {
    kotlin("jvm") version "1.9.21"
    `maven-publish`
}

group = "ru.DmN.siberia"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("ru.DmN.siberia:Project-Siberia:1.5.5")
    implementation(kotlin("reflect"))
    implementation("org.ow2.asm:asm:9.5")
    implementation("org.ow2.asm:asm-tree:9.5")
    implementation("org.ow2.asm:asm-util:9.5")
    implementation("org.ow2.asm:asm-commons:9.5")
    testImplementation(kotlin("test"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    java {
        withSourcesJar()
    }

    test {
        useJUnitPlatform()
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group as String
            artifactId = "Project-SCS"
            version = project.version as String
            from(components["java"])
        }
    }
}