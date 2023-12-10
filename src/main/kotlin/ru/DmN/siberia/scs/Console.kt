package ru.DmN.siberia.scs

import ru.DmN.phtx.pcl.compiler.json.utils.indent
import ru.DmN.phtx.pcl.compiler.json.utils.out
import ru.DmN.phtx.pcl.laxer.Laxer
import ru.DmN.siberia.Compiler
import ru.DmN.siberia.Console
import ru.DmN.siberia.ConsoleOld.initHelp
import ru.DmN.siberia.ConsoleOld.initModuleInfo
import ru.DmN.siberia.compiler.ctx.CompilationContext
import ru.DmN.siberia.scs.ast.INodeArray
import ru.DmN.siberia.utils.TypesProvider
import ru.DmN.siberia.utils.readBytes
import java.io.File

object Console : Console() {
    @JvmStatic
    fun Console.initProgramInfo() {
        this.actions.add(Triple("О программе", "Выводит информацию о программе.", Runnable {
            println("""
                Проект: Сибирская Система Конфигураций
                Версия: 1.0.0
                Авторы: DomamaN202
            """.trimIndent())
        }))
    }

    @JvmStatic
    fun Console.initCompileJson() {
        this.actions.add(Triple("Собрать 'json'", "Собирает файл конфигурации в формат 'json'.", Runnable {
            print("Введите расположение файла: ")
            val path = readln()
            val node = Laxer((Console::class.java.getResourceAsStream(path)?.readBytes() ?: File(path).readBytes()).decodeToString()).parse(0)
            val ctx = CompilationContext.of(SCS).apply {
                this.out = StringBuilder()
                this.indent = if (node is INodeArray) 0 else 1
            }
            val compiler = Compiler(TypesProvider.void())
            compiler.compile(node, ctx)
            compiler.stageManager.runAll()
            val outPath = if (path.contains('/')) path.substring(path.lastIndexOf('/') + 1) else path
            File("dump").mkdir()
            File("dump/$outPath.json").writeText(processJsonOutput(ctx.out))
        }))
    }

    @JvmStatic
    fun main(args: Array<String>) {
        initHelp()
        initProgramInfo()
        initModuleInfo()
        initCompileJson()
        run()
    }

    @JvmStatic
    fun processJsonOutput(out: StringBuilder): String {
        if (out.startsWith('{') || out.startsWith('['))
            return out.toString()
        return out.insert(0, "{\n\t").append("\n}").toString()
    }
}