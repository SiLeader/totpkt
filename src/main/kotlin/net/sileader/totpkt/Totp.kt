package net.sileader.net.sileader.totpkt

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class Totp(
    private val hotp: Hotp
) {
    constructor(secretKey: ByteArray) : this(Hotp(secretKey))

    fun generate(
        timestamp: Instant = Clock.System.now(),
        digit: Int = 6,
        period: Duration = 30.toDuration(DurationUnit.SECONDS)
    ): String {
        val periodInSeconds = period.inWholeSeconds
        val epochSeconds = timestamp.epochSeconds

        return hotp.generate(
            counter = epochSeconds / periodInSeconds,
            digit = digit,
        )
    }

    fun toOtpAuth(issuer: String, account: String): OtpAuth = OtpAuth(
        type = OtpAuth.Type.Totp,
        issuer = issuer,
        account = account,
        secret = hotp.secretKey
    )
}
