plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":lib"))
    implementation(project(":book-reader"))
}

tasks.test {
    useJUnitPlatform()
}

//task 3 - checking if file exists
// command ./gradlew ifFileExists
tasks.register("ifFileExists") {
    doFirst {
        val filePath = "D:\\java_auto\\Lab_3\\app\\src\\main\\resources\\list_books.txt"
        if (file(filePath).exists()) {
            println("this file exists :)")
        } else {
            println("this file doesn't exist :(")
        }
    }
}