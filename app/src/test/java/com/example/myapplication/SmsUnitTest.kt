package com.example.myapplication

import com.example.myapplication.io.Translator
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException


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

    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    @Test
    fun `should translate properly`() {
        assertEquals("2", Translator.translateLetter('A'))
    }

    @Test
    fun `should translate letter D into 3`() {
        assertEquals("3", Translator.translateLetter('D'))
    }

    @Test
    fun `should translate letter B into 22`() {
        assertEquals("22", Translator.translateLetter('B'))

    }

    @Test
    fun `should translate BOLA into 226665552`() {
        assertEquals("226665552", Translator.translateWord("BOLA"))

    }

    @Test
    fun `should translate one sentence properly`() {
        assertEquals("22666555202", Translator.translateWord("BOLA A"))

    }

    @Test
    fun `should translate CASA`() {
        assertEquals("222_277772", Translator.translateWord("CASA"))

    }

    @Test
    fun `should translate SEMPRE ACESSO O DOJOPUZZLES`() {
        assertEquals(
            "77773367_7773302_222337777_777766606660366656667889999_9999555337777",
            Translator.translateWord("SEMPRE ACESSO O DOJOPUZZLES")
        )

    }

    @Test
    fun `should throw IllegalStateException when phrase contains invalid characters`() {
        thrown.expect(IllegalStateException::class.java)
        thrown.expectMessage("Invalid letter to translate")

        assertEquals(
            "77773367_7773302_222337777_777766606660366656667889999_9999555337777",
            Translator.translateWord("S3mPRE AC3SSO 0 D0J0PUZZLES")
        )

    }
}
