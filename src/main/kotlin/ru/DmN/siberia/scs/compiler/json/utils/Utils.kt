package ru.DmN.phtx.pcl.compiler.json.utils

import ru.DmN.siberia.utils.IContextCollection

fun <T : IContextCollection<T>> IContextCollection<T>.with(indent: Int) =
    this.with("phtx/pcl/indent", indent)

var <T : IContextCollection<T>> IContextCollection<T>.out: StringBuilder
    set(value) { this.contexts["phtx/pcl/out"] = value }
    get() = this.contexts["phtx/pcl/out"] as StringBuilder

var <T : IContextCollection<T>> IContextCollection<T>.indent: Int
    set(value) { this.contexts["phtx/pcl/indent"] = value }
    get() = this.contexts["phtx/pcl/indent"] as Int
