// TARGET_BACKEND: JVM
// WITH_RUNTIME

fun box(): String {
    if (java.lang.Class.forName("Kt17091_3Kt\$sam\$java_util_concurrent_Callable$0") == null) return "fail: can't find sam wrapper"

    return A().foo().call()
}

class A {
    val f = {"OK"}
    fun foo() = java.util.concurrent.Callable(f)
}