// !API_VERSION: 1.3
// !JVM_TARGET: 1.6
interface B {

    <!JVM_DEFAULT_IN_JVM6_TARGET!>@kotlin.annotations.JvmDefault<!>
    fun test() {}

    <!JVM_DEFAULT_IN_JVM6_TARGET!>@kotlin.annotations.JvmDefault<!>
    abstract fun test2(s: String = "")

    <!JVM_DEFAULT_IN_JVM6_TARGET!>@kotlin.annotations.JvmDefault<!>
    abstract fun test3()
}