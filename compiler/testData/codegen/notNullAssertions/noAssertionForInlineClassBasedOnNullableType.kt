// !LANGUAGE: +InlineClasses

inline class AsAny(val a: Any?)

fun f(a: AsAny) {}
fun AsAny.g(b: AsAny): AsAny = this
