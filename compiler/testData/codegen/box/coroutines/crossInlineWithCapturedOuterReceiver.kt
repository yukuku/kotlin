// WITH_RUNTIME
// WITH_COROUTINES
import helpers.*
import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*

interface Consumer { fun consume(s: String) }

inline fun crossInlineBuilderConsumer(crossinline block: (String) -> Unit) = object : Consumer {
    override fun consume(s: String) {
        block(s)
    }
}

inline fun crossInlineBuilder(crossinline block: () -> Consumer) = block()

fun builder(c: suspend () -> Unit) {
    c.startCoroutine(EmptyContinuation)
}

fun builderConsumer(c: suspend () -> Consumer): Consumer {
    var res: Consumer? = null
    c.startCoroutine(object : Continuation<Consumer> {
        override fun resume(value: Consumer) {
            res = value
        }

        override fun resumeWithException(e: Throwable) {
            throw e
        }

        override val context = EmptyCoroutineContext
    })
    return res!!
}

class Container {
    var y: String = "FAIL 1"

    val consumer1 = crossInlineBuilderConsumer { s ->
        builder {
            y = s
        }
    }

    val consumer2 = crossInlineBuilder {
        object : Consumer {
            override fun consume(s: String) {
                builder {
                    y = s
                }
            }
        }
    }

    val consumer3 = crossInlineBuilder {
        builderConsumer {
            object : Consumer {
                override fun consume(s: String) {
                    y = s
                }
            }
        }
    }
}

fun box(): String {
    val c = Container()
    c.consumer1.consume("OK")
    if (c.y != "OK") return c.y
    c.y = "FAIL 2"
    c.consumer2.consume("OK")
    if (c.y != "OK") return c.y
    c.y = "FAIL 3"
    c.consumer3.consume("OK")
    if (c.y != "OK") return c.y
    return c.y
}
