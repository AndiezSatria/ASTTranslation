package com.example.android_ta

import kotlinx.ast.common.AstSource
import kotlinx.ast.common.ast.Ast
import kotlinx.ast.common.ast.rawAstOrNull
import kotlinx.ast.common.klass.detachRaw
import kotlinx.ast.common.print
import kotlinx.ast.common.printString
import kotlinx.ast.grammar.kotlin.common.KotlinGrammarParserType
import kotlinx.ast.grammar.kotlin.common.summary
import kotlinx.ast.grammar.kotlin.target.antlr.kotlin.KotlinGrammarAntlrKotlinParser
import java.io.File

/**
 * Created by AndiezSatria on 09/04/2023.
 */

fun main() {
    val source = AstSource.File(
        "app/src/main/java/com/example/android_ta/<File Name>.kt"
    )
    val kotlinFile = KotlinGrammarAntlrKotlinParser.parseKotlinFile(source)
    kotlinFile.summary(attachRawAst = true)
        .onSuccess { astList ->
            astList.forEach {
                it.rawAstOrNull()?.ast?.print()
            }
            astList.forEach(Ast::print)
        }.onFailure { errors ->
            errors.forEach(::println)
        }
}