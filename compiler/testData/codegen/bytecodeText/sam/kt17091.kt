// WITH_RUNTIME
// FILE: JClass.java

public class JClass {
    public static void test(Runnable run) {
        run.run();
    }
}

// FILE: 2.kt

class A {
    fun doWork(job: () -> Unit) {
        JClass.test(job)
    }
}

// 1 class A\$sam\$java_lang_Runnable\$0