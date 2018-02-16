description = "Kotlin Annotation Processing Runtime"

plugins { kotlin("jvm") }

jvmTarget = "1.6"

sourceSets {
    "main" { projectDefault() }
    "test" {}
}

runtimeJar()
sourcesJar()
javadocJar()

dist(targetName = "kotlin-annotation-processing-runtime.jar")

publish()
