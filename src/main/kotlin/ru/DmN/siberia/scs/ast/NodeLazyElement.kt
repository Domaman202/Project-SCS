package ru.DmN.siberia.scs.ast

import ru.DmN.phtx.pcl.laxer.Laxer
import ru.DmN.siberia.lexer.Token

open class NodeLazyElement(token: Token, offset: Int, val laxer: Laxer) : NodeElement(token, offset)