package ru.DmN.siberia.scs

import ru.DmN.phtx.pcl.compiler.json.SCSJson
import ru.DmN.siberia.utils.Module

/**
 * Siberian Config System
 */
object SCS : Module("siberia/scs") {
    init {
        SCSJson.init()
    }
}