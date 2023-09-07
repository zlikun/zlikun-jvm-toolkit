plugins {
    id("java")
    `maven-publish`

    // https://plugins.gradle.org/plugin/io.freefair.lombok
    id("io.freefair.lombok") version "8.3"
}

group = "io.github.zlikun.jvm"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.projectlombok:lombok:1.18.28")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    withJavadocJar()
    withSourcesJar()
}

// Publishing Maven
// https://docs.gradle.org/current/userguide/publishing_maven.html
publishing {
    publications {
        create<MavenPublication>("maven") {
            group = "io.github.zlikun.jvm"
            artifactId = "zlikun-jvm-toolkit"
            version = "1.0-SNAPSHOT"
            from(components["java"])
        }
    }
}