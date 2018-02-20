// !LANGUAGE: +InlineClasses

inline class AsNonNullPrimitive(val i: Int)

inline class AsNonNullReference(val s: String) // 2 assertions (constructor + box method)

fun f(a: AsNonNullPrimitive) {}

fun g1(b: AsNonNullReference) {} // assertion
fun AsNonNullReference.g2(b1: AsNonNullReference) {} // 2 assertions

fun h1(c: AsNonNullPrimitive?) {}
fun h2(c: AsNonNullReference?) {}
