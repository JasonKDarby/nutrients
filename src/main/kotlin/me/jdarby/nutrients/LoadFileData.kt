package me.jdarby.nutrients

import java.io.File

private fun <T> classToFilePath(c: Class<T>) = Class::class.java.getResource("/${c.simpleName}.txt").path

private fun parseLine(s: String) = s.split('^').map { it.removeSurrounding("~") }

private fun <T> fileToParsedLines(c: Class<T>) = File(classToFilePath(c)).readLines().map(::parseLine)

private fun <T> loadFile(c: Class<T>, f: (List<String>) -> T): List<T> = fileToParsedLines(c).map(f)

private fun String.toDoubleOrNull(): Double? = if(this.isBlank() or this.isEmpty()) null else this.toDouble()

private fun String.toIntOrNull(): Int? = if(this.isBlank() or this.isEmpty()) null else this.toInt()

fun load_DATA_SRC(): List<DATA_SRC> = loadFile(DATA_SRC::class.java)
    { DATA_SRC(it[0], it[1].split(','), it[2], it[3], it[4], it[5], it[6], it[7], it[8]) }

fun load_DATSRCLN(): List<DATSRCLN> = loadFile(DATSRCLN::class.java)
    { DATSRCLN(it[0], it[1], it[2]) }

fun load_DERIV_CD(): List<DERIV_CD> = loadFile(DERIV_CD::class.java)
    { DERIV_CD(it[0], it[1]) }

fun load_FD_GROUP(): List<FD_GROUP> = loadFile(FD_GROUP::class.java)
    { FD_GROUP(it[0], it[1]) }

fun load_FOOD_DES(): List<FOOD_DES> = loadFile(FOOD_DES::class.java)
    { FOOD_DES(it[0], it[1], it[2], it[3], it[4], it[5], it[6], it[7],
            it[8].toIntOrNull(), it[9],
            it[10].toDoubleOrNull(),
            it[11].toDoubleOrNull(),
            it[12].toDoubleOrNull(),
            it[13].toDoubleOrNull()) }

fun load_FOOTNOTE(): List<FOOTNOTE> = loadFile(FOOTNOTE::class.java)
    { FOOTNOTE(it[0], it[1], it[2], it[3], it[4]) }

fun load_LANGDESC(): List<LANGDESC> = loadFile(LANGDESC::class.java)
    { LANGDESC(it[0], it[1]) }

fun load_LANGUAL(): List<LANGUAL> = loadFile(LANGUAL::class.java)
    { LANGUAL(it[0], it[1]) }

fun load_NUT_DATA(): List<NUT_DATA> = loadFile(NUT_DATA::class.java)
    { NUT_DATA(it[0], it[1], it[2].toDouble(), it[3].toInt(),
            it[4].toDoubleOrNull(),
            it[5], it[6], it[7], it[8],
            it[9].toIntOrNull(),
            it[10].toDoubleOrNull(),
            it[11].toDoubleOrNull(),
            it[12].toIntOrNull(),
            it[13].toDoubleOrNull(),
            it[14].toDoubleOrNull(),
            it[15], it[16], it[17]) }

fun load_NUTR_DEF(): List<NUTR_DEF> = loadFile(NUTR_DEF::class.java)
    { NUTR_DEF(it[0], it[1], it[2], it[3], it[4], it[5].toInt()) }

fun load_SRC_CD(): List<SRC_CD> = loadFile(SRC_CD::class.java)
    { SRC_CD(it[0], it[1]) }

fun load_WEIGHT(): List<WEIGHT> = loadFile(WEIGHT::class.java)
    { WEIGHT(it[0], it[1], it[2].toDouble(), it[3], it[4].toDouble(),
            it[5].toIntOrNull(),
            it[6].toDoubleOrNull()) }