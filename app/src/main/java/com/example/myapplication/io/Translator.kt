package com.example.myapplication.io

object Translator {
    private const val SPACE_KEY = "0"
    private const val UNDERSCORE = "_"

    private val KEYBOARD = listOf(
        NoQwerty(group = "ABC", key = "2"),
        NoQwerty(group = "DEF", key = "3"),
        NoQwerty(group = "GHI", key = "4"),
        NoQwerty(group = "JKL", key = "5"),
        NoQwerty(group = "MNO", key = "6"),
        NoQwerty(group = "PQRS", key = "7"),
        NoQwerty(group = "TUV", key = "8"),
        NoQwerty(group = "WXYZ", key = "9")
    )

    fun translateLetter(character: Char): String {
        check(character.isWhitespace() || character.isLetter()) {
            "Invalid character to translate. It should be letter or whitespace"
        }

        // Don't need repeat if character is whitespace ;)
        if (character.isWhitespace()) {
            return SPACE_KEY
        }

        val letterUpper = character.toUpperCase()

        // Search optimized with binarySearch and ASCII table
        val noQwertyWithLetterIndex = KEYBOARD.binarySearch {
            val firstGroupLetter = it.group.first()
            // Should I search on the left side?
            if (firstGroupLetter > letterUpper) {
                return@binarySearch 1
            }
            val lastGroupLetter = it.group.last()
            // Should I search on the right side?
            if (lastGroupLetter < letterUpper) {
                return@binarySearch -1
            }
            return@binarySearch 0 // You found me :D
        }

        val noQwerty = KEYBOARD[noQwertyWithLetterIndex]

        val letterIndex = noQwerty.group.indexOf(letterUpper)

        // Built-in extension function to repeat same character
        return noQwerty.key.repeat(letterIndex + 1)
    }

    fun translateWord(phrase: String): String = phrase
        .map { translateLetter(it) } // Convert each phrase character in numbers
        .reduce { previous, next ->
            // If last item character is equals to next item start character,
            // put an underscore between them
            val separator = if (previous.last() == next.first()) UNDERSCORE else ""
            return@reduce previous + separator + next
        }
}