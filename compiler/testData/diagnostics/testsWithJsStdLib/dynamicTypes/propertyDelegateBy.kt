// !DIAGNOSTICS: -UNUSED_VARIABLE

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

class C {
    val a: dynamic by <!PROPERTY_DELEGATION_BY_DYNAMIC!>x<!>
}

class A {
    operator fun provideDelegate(host: Any?, p: Any): dynamic = TODO("")
}

val z: Any? by <!PROPERTY_DELEGATION_BY_DYNAMIC!>A()<!>

class DynamicHandler {
    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): dynamic = 23
}

class B {
    val x: dynamic by DynamicHandler()
}