package net.sileader.totpkt

import net.sileader.net.sileader.totpkt.Hotp
import kotlin.test.Test
import kotlin.test.assertEquals

class HotpTest {
    private fun test_rfc4226(
        counter: Long,
        token: String,
    ) {
        val hotp = Hotp(
            byteArrayOf(
                0x31,
                0x32,
                0x33,
                0x34,
                0x35,
                0x36,
                0x37,
                0x38,
                0x39,
                0x30,
                0x31,
                0x32,
                0x33,
                0x34,
                0x35,
                0x36,
                0x37,
                0x38,
                0x39,
                0x30
            )
        )

        assertEquals(token, hotp.generate(counter, 6))
    }

    @Test
    fun test_rfc4226_appendix_d_0() {
        test_rfc4226(
            counter = 0,
            token = "755224",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_1() {
        test_rfc4226(
            counter = 1,
            token = "287082",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_2() {
        test_rfc4226(
            counter = 2,
            token = "359152",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_3() {
        test_rfc4226(
            counter = 3,
            token = "969429",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_4() {
        test_rfc4226(
            counter = 4,
            token = "338314",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_5() {
        test_rfc4226(
            counter = 5,
            token = "254676",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_6() {
        test_rfc4226(
            counter = 6,
            token = "287922",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_7() {
        test_rfc4226(
            counter = 7,
            token = "162583",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_8() {
        test_rfc4226(
            counter = 8,
            token = "399871",
        )
    }

    @Test
    fun test_rfc4226_appendix_d_9() {
        test_rfc4226(
            counter = 9,
            token = "520489",
        )
    }
}