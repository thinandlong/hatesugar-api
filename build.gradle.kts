import Build_gradle.DependencyVersion.APACHE_HTTP_CLIENT_VERSION
import Build_gradle.DependencyVersion.KOTLIN_LOGGING_VERSION
import Build_gradle.DependencyVersion.SWAGGER_VERSION
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.thinandlong"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

object DependencyVersion {
    const val KOTLIN_LOGGING_VERSION = "2.1.20"
    const val SWAGGER_VERSION = "2.10.5"
    const val APACHE_HTTP_CLIENT_VERSION = "4.5.13"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("mysql:mysql-connector-java")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    if (isSnapshotVersion) {
        implementation("io.springfox:springfox-swagger2:$SWAGGER_VERSION")
        implementation("io.springfox:springfox-swagger-ui:$SWAGGER_VERSION")
        implementation("io.springfox:springfox-spring-webmvc:$SWAGGER_VERSION")
    }

    // kotlin logger
    implementation("io.github.microutils:kotlin-logging-jvm:$KOTLIN_LOGGING_VERSION")

    // rest template
    implementation("org.apache.httpcomponents:httpclient:$APACHE_HTTP_CLIENT_VERSION")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val Project.isSnapshotVersion: Boolean get() = version.toString().endsWith("SNAPSHOT")
