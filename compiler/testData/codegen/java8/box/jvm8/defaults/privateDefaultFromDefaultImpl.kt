// !API_VERSION: 1.3
// JVM_TARGET: 1.8
// WITH_RUNTIME

interface Test {
    fun test(): String {
        return privateFun()
    }

    @kotlin.annotations.JvmDefault
    private fun privateFun(): String {
        return "OK"
    }
}

class TestImpl: Test

fun box(): String {
    return TestImpl().test()
}