package com.example.myapplication.io

object Translator {
    private const val UNDERSCORE = "_"

    private val KEYBOARD = listOf(
        NoQwerty(group = "ABC", key = "2"),
        NoQwerty(group = "DEF", key = "3"),
        NoQwerty(group = "GHI", key = "4"),
        NoQwerty(group = "JKL", key = "5"),
        NoQwerty(group = "MNO", key = "6"),
        NoQwerty(group = "PQRS", key = "7"),
        NoQwerty(group = "TUV", key = "8"),
        NoQwerty(group = "WXYZ", key = "9"),
        NoQwerty(group = " ", key = "0")
    )

    fun translateLetter(letter: Char): String {
        check(letter.isWhitespace() || letter.isLetter()) {
            "Invalid letter to translate"
        }

        val letterUpper = letter.toUpperCase()

        val noQwerty = KEYBOARD.first {
            val firstLetter = it.group.first()
            val lastLetter = it.group.last()
            return@first letterUpper in firstLetter..lastLetter
        }

        val letterIndex = noQwerty.group.indexOf(letterUpper)

        return noQwerty.key.repeat(letterIndex + 1)
    }

    fun translateWord(phrase: String): String = phrase
        .map { translateLetter(it) }
        .reduce { previous, next ->
            val separator = if (previous.last() == next.first()) UNDERSCORE else ""
            return@reduce previous + separator + next
        }
}