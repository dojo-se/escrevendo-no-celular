package com.example.myapplication.io

object Translator {
    fun translate(string: String): Int {
        val list = listOf(
            Pair("ABC", 2),
            Pair("DEF", 3),
            Pair("GHI", 4),
            Pair("JKL", 5),
            Pair("MNO", 6),
            Pair("PQRS", 7),
            Pair("TUV", 8),
            Pair("WXYZ", 9)
        )

        val find = list.first {
            it.first.contains(string)
        }
        return find.second
    }
}