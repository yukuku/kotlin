description = "Simple Annotation Processor for testing kapt"

plugins {
    kotlin("jvm")
    `maven`
}

dependencies {
    compile(projectDist(":kotlin-stdlib"))
}

sourceSets {
    "test" {}
}

