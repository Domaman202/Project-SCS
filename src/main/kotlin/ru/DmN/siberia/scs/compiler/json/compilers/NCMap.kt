package ru.DmN.phtx.pcl.compiler.json.compilers

import ru.DmN.siberia.scs.ast.NodeLazyMap
import ru.DmN.phtx.pcl.compiler.json.utils.indent
import ru.DmN.phtx.pcl.compiler.json.utils.out
import ru.DmN.phtx.pcl.compiler.json.utils.with
import ru.DmN.siberia.Compiler
import ru.DmN.siberia.compiler.ctx.CompilationContext
import ru.DmN.siberia.compilers.INodeCompiler

object NCMap : INodeCompiler<NodeLazyMap> {
    override fun compile(node: NodeLazyMap, compiler: Compiler, ctx: CompilationContext) {
        NCArray.compile('{', '}', node, compiler, ctx)
    }
}