// TARGET_BACKEND: JVM
// WITH_RUNTIME

fun box(): String {
    if (java.lang.Class.forName("Kt17091_3Kt\$sam\$Callable\$f8c5758f") == null) return "fail: can't find sam wrapper"

    return A().foo().call()
}

class A {
    val f = {"OK"}
    fun foo() = java.util.concurrent.Callable(f)
}