plugins {
    id("java")
    id("org.springframework.boot") version ("3.1.4")
    id("io.spring.dependency-management") version ("1.1.3")
    id("org.jetbrains.kotlin.jvm") version ("1.7.22")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    named<Test>("test") {
        testLogging.showExceptions = true
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
