package ru.DmN.phtx.pcl.compiler.json

import ru.DmN.phtx.pcl.compiler.json.compilers.NCArray
import ru.DmN.phtx.pcl.compiler.json.compilers.NCMap
import ru.DmN.phtx.pcl.compiler.json.compilers.NCNamed
import ru.DmN.phtx.pcl.compiler.json.compilers.NCValue
import ru.DmN.siberia.scs.SCS
import ru.DmN.siberia.utils.ModuleCompilers

object SCSJson : ModuleCompilers(SCS) {
    override fun onInitialize() {
        // a
        add("array", NCArray)
        // m
        add("map",   NCMap)
        // n
        add("named", NCNamed)
        // v
        add("value", NCValue)
    }
}