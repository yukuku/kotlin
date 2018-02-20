// !API_VERSION: 1.3
// JVM_TARGET: 1.8
// WITH_RUNTIME

interface Test {
    @kotlin.annotations.JvmDefault
    fun test(): String {
        return "OK"
    }
}

interface Test2 : Test {
    @kotlin.annotations.JvmDefault
    override fun test(): String {
        return super.test()
    }
}


class TestClass : Test2 {

}


fun box(): String {
    return TestClass().test()
}