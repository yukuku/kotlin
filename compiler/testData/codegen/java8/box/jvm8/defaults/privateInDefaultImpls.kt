// !API_VERSION: 1.3
// JVM_TARGET: 1.8
// WITH_RUNTIME

interface Test {
    @kotlin.annotations.JvmDefault
    fun test(): String {
        return privateFun()
    }

    private fun privateFun(): String {
        return "OK"
    }
}

class TestImpl: Test

fun box(): String {
    return TestImpl().test()
}