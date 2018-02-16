/*
 * Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.codegen.inline

import org.jetbrains.kotlin.codegen.InlineCycleReporter
import org.jetbrains.kotlin.diagnostics.DiagnosticSink
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import java.util.*

class GlobalInlineContext(diagnostics: DiagnosticSink) {

    private val inlineCycleReporter: InlineCycleReporter = InlineCycleReporter(diagnostics)

    val state = LinkedList<MutableSet<String>>()

    fun enterIntoInlining(call: ResolvedCall<*>?) =
        inlineCycleReporter.enterIntoInlining(call).also {
            if (it) state.push(hashSetOf())
        }

    fun exitFromInliningOf(call: ResolvedCall<*>?) {
        inlineCycleReporter.exitFromInliningOf(call)
        val pop = state.pop()
        state.peek()?.addAll(pop)
    }

    fun recordTypeFromInlineFunction(type: String) = state.peek().add(type)

    fun isTypeFromInlineFunction(type: String) = state.peek().contains(type)
}