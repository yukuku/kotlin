// WITH_RUNTIME
// FILE: JClass.java

public class JClass {
    public static void test(Runnable run) {
        run.run();
    }
}

// FILE: 2.kt
@file:JvmMultifileClass
@file:JvmName("testX")
package test

class A {
    fun doWork(job: () -> Unit) {
        JClass.test(job)
    }
}

// 1 class test/A\$sam\$java_lang_Runnable\$0