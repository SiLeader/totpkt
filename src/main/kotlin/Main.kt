package net.sileader

import net.sileader.net.sileader.totpkt.Totp

fun main() {
    val totp = Totp(
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
    println(totp.toOtpAuth(issuer = "Test", account = "TestAccount").toUrlString())
    while (true) {
        println(totp.generate())
        Thread.sleep(1000)
    }
}
