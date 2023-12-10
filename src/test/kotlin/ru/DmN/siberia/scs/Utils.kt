package ru.DmN.siberia.scs

import ru.DmN.phtx.pcl.compiler.json.utils.indent
import ru.DmN.phtx.pcl.compiler.json.utils.out
import ru.DmN.phtx.pcl.laxer.Laxer
import ru.DmN.siberia.Compiler
import ru.DmN.siberia.compiler.ctx.CompilationContext
import ru.DmN.siberia.scs.ast.INodeArray
import ru.DmN.siberia.scs.ast.NodeLazyMap
import ru.DmN.siberia.utils.TypesProvider
import ru.DmN.siberia.utils.readBytes
import kotlin.test.assertEquals

class Test(val file: String) {
    fun json() {
        val node = Laxer(Test::class.java.getResourceAsStream("/$file.scs")!!.readBytes().decodeToString()).parse(0)
        val ctx = CompilationContext.of(SCS).apply {
            this.out = StringBuilder()
            this.indent = if (node is INodeArray) 0 else 1
        }
        val compiler = Compiler(TypesProvider.void())
        compiler.compile(node, ctx)
        compiler.stageManager.runAll()
        assertEquals(processJsonStringForTest(Test::class.java.getResourceAsStream("/$file.json")!!.readBytes().decodeToString()), processJsonStringForTest(processJsonOutput(ctx.out)))
    }

    fun jsonText(): String {
        val node = Laxer(Test::class.java.getResourceAsStream("/$file.scs")!!.readBytes().decodeToString()).parse(0)
        val ctx = CompilationContext.of(SCS).apply {
            this.out = StringBuilder()
            this.indent = if (node is INodeArray) 0 else 1
        }
        val compiler = Compiler(TypesProvider.void())
        compiler.compile(node, ctx)
        compiler.stageManager.runAll()
        return processJsonOutput(ctx.out)
    }

    private fun processJsonOutput(out: StringBuilder): String {
        if (out.startsWith('{') || out.startsWith('['))
            return out.toString()
        return out.insert(0, "{\n\t").append("\n}").toString()
    }

    private fun processJsonStringForTest(str: String): String =
        str.replace(" ", "").replace("\t", "")
}