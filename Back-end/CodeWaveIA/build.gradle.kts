plugins {
    id("java")
}

group = "com.codewave"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("dev.langchain4j:langchain4j:0.21.0")
    implementation ("org.netbeans.external:AbsoluteLayout:RELEASE190")
}

tasks.test {
    useJUnitPlatform()
}