package ru.DmN.phtx.pcl.compiler.json.compilers

import ru.DmN.siberia.scs.ast.NodeLazyArray
import ru.DmN.phtx.pcl.compiler.json.utils.indent
import ru.DmN.phtx.pcl.compiler.json.utils.out
import ru.DmN.phtx.pcl.compiler.json.utils.with
import ru.DmN.siberia.Compiler
import ru.DmN.siberia.compiler.ctx.CompilationContext
import ru.DmN.siberia.compilers.INodeCompiler
import ru.DmN.siberia.scs.ast.INodeArray

object NCArray : INodeCompiler<NodeLazyArray> {
    override fun compile(node: NodeLazyArray, compiler: Compiler, ctx: CompilationContext) {
        compile('[', ']', node, compiler, ctx)
    }

    fun compile(open: Char, close: Char, node: INodeArray, compiler: Compiler, ctx: CompilationContext) {
        val out = ctx.out
        val indent = ctx.indent
        //
        out.append(open)
        if (node.size > 0) {
            var i = 0
            node.forEach {
                out.append('\n').append("\t".repeat(indent + 1))
                compiler.compile(it, ctx.with(indent + 1))
                if (++i != node.size)
                    out.append(',')
                else out.append('\n').append("\t".repeat(indent))
            }
        }
        out.append(close)
    }
}