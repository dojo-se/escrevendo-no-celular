package com.example.myapplication

import com.example.myapplication.io.Translator
import org.junit.Assert.assertEquals
import org.junit.Test

/**
Letras ->
ABC -> 2
DEF -> 3
GHI -> 4
JKL -> 5
MNO -> 6
PQRS -> 7
TUV -> 8
WXYZ -> 9
Espaço -> 0

Desenvolva um programa que, dada uma mensagem de texto limitada a 255 caracteres, retorne a seqüência de números que precisa ser digitada. Uma pausa, para ser possível obter duas letras referenciadas pelo mesmo número, deve ser indicada como _.

Por exemplo, para digitar "SEMPRE ACESSO O DOJOPUZZLES", você precisa digitar:

77773367_7773302_222337777_777766606660366656667889999_9999555337777*/
class SmsUnitTest {
    @Test
    fun `should translate properly`() {
        assertEquals(2, Translator.translate("A"))
    }

    @Test
    fun `should translate letter D into 3`() {
        assertEquals(3, Translator.translate("D"))
    }
}
