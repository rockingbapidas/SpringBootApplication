import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

plugins {
    id("java")
    id("org.springframework.boot") version ("2.7.6")
    id("io.spring.dependency-management") version ("1.0.15.RELEASE")
    id("org.jetbrains.kotlin.jvm") version ("1.7.22")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

group = "com.bapi.springbackend"
version = "0.0.1-SNAPSHOT"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(mapOf("path" to ":api")))
    implementation(project(mapOf("path" to ":auth")))
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":platform")))
    implementation(project(mapOf("path" to ":service")))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("com.graphql-java:graphql-java-extended-scalars:20.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    named<Test>("test") {
        testLogging.showExceptions = true
    }
}
