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
}

tasks.test {
    useJUnitPlatform()
}

//task 4 Create a task related to the assembly of your project (task of your choice)
// this method will create new file with books if there is no file in that path
val checkOrCreateBookFile = tasks.register("checkOrCreateBookFile") {
    doLast {
        val filePath = "app\\src\\main\\resources\\list_books.txt"
        val file = File(filePath)
        println("Create new: $filePath")
        file.createNewFile()
        val books = listOf(
            "Автор 1, Назва 1, 1997",
            "Автор 2, , 1949",
            ", , 1960",
            "Автор 3, , "
        )
        file.bufferedWriter().use { writer ->
            books.forEach { book ->
                writer.write(book)
                writer.newLine()
            }
        }
        println("Done.")
    }
}

//task 3 - checking if file exists
tasks.register("ifFileExists") {
    doFirst {
        val filePath = "app/src/main/resources/list_books.txt"
        if (File(filePath).exists()) {
            println("This file exists :): $filePath")
        } else {
            println("This file doesn't exist :( $filePath")
            // it's addition for task 4.
            checkOrCreateBookFile.get().actions.forEach { action ->
                action.execute(checkOrCreateBookFile.get())
            }
        }
    }
}

// so ifFileExists is done after build
rootProject.tasks.getByName("build").dependsOn(tasks.getByName("ifFileExists"))