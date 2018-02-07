// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FULL_JDK

import java.util.concurrent.Executors

typealias Z = String

class A {
    fun doWork(job: () -> Unit) {
        Executors.callable(job).call()
    }
}

fun box(): String {
    var result = "fail"
    A().doWork { result = "OK" }

    if (java.lang.Class.forName("Kt17091Kt\$sam\$java_lang_Runnable$0") == null) return "fail: can't find sam wrapper"

    return result
}