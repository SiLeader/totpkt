package net.sileader.net.sileader.totpkt

class OtpAuth(
    private val type: Type,
    private val issuer: String,
    private val account: String,
    private val secret: ByteArray
) {
    enum class Type {
        Totp,
        Hotp,
        ;

        override fun toString(): String = when (this) {
            Totp -> "totp"
            Hotp -> "hotp"
        }
    }

    fun toUrlString(): String =
        "otpauth://$type/$issuer:$account?secret=${Base32.encodeNoPadded(secret)}&issuer=$issuer&algorithm=SHA1&digits=6&period=30"
}
