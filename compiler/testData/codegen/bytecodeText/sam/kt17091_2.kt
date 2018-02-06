// WITH_RUNTIME
// FILE: JClass.java

public class JClass {
    public static void test(Runnable run) {
        run.run();
    }
}

// FILE: 2.kt
@file:JvmName("testX")
package test

class A {
    fun doWork(job: () -> Unit) {
        JClass.test(job)
    }
}

// 1 class test/A\$sam\$Runnable\$36fc6471