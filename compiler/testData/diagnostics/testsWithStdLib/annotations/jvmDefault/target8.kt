// !API_VERSION: 1.3
// !JVM_TARGET: 1.8
interface B {

    @kotlin.annotations.JvmDefault
    fun test() {}

    @kotlin.annotations.JvmDefault
    abstract fun test2(s: String = "")

    @kotlin.annotations.JvmDefault
    abstract fun test3()
}