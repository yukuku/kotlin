
apply { plugin("kotlin") }

jvmTarget = "1.6"

dependencies {
    compile(project(":compiler:util"))
    compile(intellijDep())
    compile(project(":compiler:frontend"))
}

sourceSets {
    "main" { projectDefault() }
    "test" {}
}

