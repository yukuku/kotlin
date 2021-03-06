import java.util.Properties

description = "Kotlin IDE Lazy Resolver"

apply { plugin("java") }

val versions by configurations.creating
val versionFilePath = "$rootDir/dependencies/dependencies.properties"
val ideaVersion = findProperty("versions.intellijSdk").toString()
val markdownVersion = findProperty("markdownParserVersion").toString()

val writeVersions by tasks.creating {
    val versionFile = File(versionFilePath)
    inputs.property("ideaVersion", ideaVersion)
    inputs.property("markdownVersion", markdownVersion)

    outputs.file(versionFile)
    doLast {
        versionFile.parentFile.mkdirs()
        val properties = Properties()
        properties.setProperty("idea.build.id", ideaVersion)
        properties.setProperty("markdown.build.id", markdownVersion)
        properties.store(versionFile.outputStream(), "")
    }
}

runtimeJar {
    dependsOn(writeVersions)
    archiveName = "kotlin-ide-common.jar"
    dependsOn(":idea:ide-common:classes")
    project(":idea:ide-common").let { p ->
        p.pluginManager.withPlugin("java") {
            from(p.the<JavaPluginConvention>().sourceSets.getByName("main").output)
        }
    }
    from(fileTree("$rootDir/idea/ide-common")) { include("src/**") } // Eclipse formatter sources navigation depends on this
}

sourceSets {
    "main" {}
    "test" {}
}

