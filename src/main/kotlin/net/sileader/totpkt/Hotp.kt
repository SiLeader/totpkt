package net.sileader.net.sileader.totpkt

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

@OptIn(ExperimentalUnsignedTypes::class)
class Hotp(
    internal val secretKey: ByteArray,
) {
    private fun Long.toByteArray(): ByteArray = ByteArray(8) { index ->
        ((this.toULong() shr (index * 8)) and 0xffu).toByte()
    }.reversedArray()

    private fun computeHmacSha1(counter: Long): UByteArray {
        val mac = Mac.getInstance(ALGORITHM)

        mac.init(SecretKeySpec(secretKey, "RAW"))

        val counterBytes = counter.toByteArray()
        return mac.doFinal(counterBytes).toUByteArray()
    }

    fun generate(counter: Long, digit: Int): String {
        val hs1 = computeHmacSha1(counter)
        val offset = (hs1[19] and 0x0fu).toInt()
        val binCode = ((hs1[offset] and 0x7fu).toUInt() shl 24) or
                (hs1[offset + 1].toUInt() shl 16) or
                (hs1[offset + 2].toUInt() shl 8) or
                hs1[offset + 3].toUInt()

        val d = binCode.toString(10)
        return d.substring(d.length - digit)
    }

    fun toOtpAuth(issuer: String, account: String): OtpAuth = OtpAuth(
        type = OtpAuth.Type.Hotp,
        issuer = issuer,
        account = account,
        secret = secretKey
    )

    companion object {
        private const val ALGORITHM = "HmacSHA1"
    }
}
