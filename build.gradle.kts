import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"
}

group = "luckytime"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.projectlombok:lombok:1.18.18")
    implementation("org.projectlombok:lombok:1.18.18")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //JSR-374 API(인터페이스) 의존성 추가
    implementation("javax.json:javax.json-api:1.1.4")
    implementation ("org.glassfish:javax.json:1.1.4")
    implementation ("com.fasterxml.jackson.datatype:jackson-datatype-jsr353")

    implementation ("io.springfox:springfox-boot-starter:3.0.0")
    implementation ("io.springfox:springfox-swagger-ui:3.0.0")

    // mapstruct
    implementation ("org.mapstruct:mapstruct:1.4.2.Final")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.4.2.Final")

    //openfeign
    implementation ("com.googlecode.json-simple")

    implementation ("org.apache.commons:commons-lang3:3.12.0")
    implementation ("com.google.code.gson")

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("Hoxton.SR3")}")
    }
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
