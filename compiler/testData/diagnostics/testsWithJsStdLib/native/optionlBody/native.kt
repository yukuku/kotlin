// !DIAGNOSTICS: -UNREACHABLE_CODE
// unreachable code suppressed due to KT-9586

external val baz: Int
external val boo: Int = definedExternally

external val x: dynamic
external val x1: Int

var y: Any? by <!PROPERTY_DELEGATION_BY_DYNAMIC!>x<!>
var yd = x
var y1: Any? by lazy { x1 }
var y2 = x1

fun fooo() {
    x
    x1
}


val a = baz
val b by lazy { baz }

external fun foo()
external fun bar() { definedExternally }

external interface T {
    val baz: Int

    fun foo()
    fun bar()
}

external class C {
    val baz: Int
    val boo: Int = definedExternally

    fun foo()
    fun bar() { definedExternally }

    companion object {
        val baz: Int
        val boo: Int = definedExternally

        fun foo()
        fun bar(): String = definedExternally
    }
}

external object O {
    val baz: Int
    val boo: Int = definedExternally

    fun foo(s: String): String
    fun bar(s: String): String = definedExternally
}

fun testRefs(t: T, c: C) {
    baz
    boo
    foo()
    bar()
    t.baz
    t.foo()
    t.bar()
    c.baz
    c.boo
    c.foo()
    c.bar()
    C.baz
    C.boo
    C.foo()
    C.bar()
    O.baz
    O.boo
    O.foo("")
    O.bar("")
}
