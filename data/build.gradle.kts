import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

plugins {
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.jvm")
}

group = "com.bapi.data"
version = "0.0.1-SNAPSHOT"

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":platform")))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    /*implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")*/

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}