import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // developmentOnly
    developmentOnly ("org.springframework.boot:spring-boot-devtools")

    // validation
    implementation ("org.springframework.boot:spring-boot-starter-validation:2.7.3")

    // jwt
    implementation ("io.jsonwebtoken:jjwt:0.9.1")

    // security
    implementation ("org.springframework.boot:spring-boot-starter-security")

    // web
    implementation ("org.springframework.boot:spring-boot-starter-web")

    // lombok
    compileOnly ("org.projectlombok:lombok")
    annotationProcessor ("org.projectlombok:lombok")

    // database
    implementation ("mysql:mysql-connector-java:8.0.28")
    implementation ("org.springframework.boot:spring-boot-starter-data-redis")

    implementation ("com.amazonaws:aws-java-sdk-s3:1.12.281")
    annotationProcessor ("org.springframework.boot:spring-boot-configuration-processor")

    // jpa
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
