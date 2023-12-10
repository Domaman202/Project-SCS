package ru.DmN.phtx.pcl.compiler.json.utils

import ru.DmN.siberia.utils.IContextCollection

fun <T : IContextCollection<T>> IContextCollection<T>.with(indent: Int) =
    this.with("siberia/scs/indent", indent)

var <T : IContextCollection<T>> IContextCollection<T>.out: StringBuilder
    set(value) { this.contexts["siberia/scs/out"] = value }
    get() = this.contexts["siberia/scs/out"] as StringBuilder

var <T : IContextCollection<T>> IContextCollection<T>.indent: Int
    set(value) { this.contexts["siberia/scs/indent"] = value }
    get() = this.contexts["siberia/scs/indent"] as Int
