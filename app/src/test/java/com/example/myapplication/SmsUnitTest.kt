package com.example.myapplication

import com.example.myapplication.io.Translator
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SmsUnitTest {

    @Test
    fun `should translate properly`() {
        val translator = Translator()
        assertEquals("A", translator.translate(2))
    }

}
