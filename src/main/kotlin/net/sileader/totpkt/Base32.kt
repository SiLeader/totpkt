package net.sileader.net.sileader.totpkt

object Base32 {
    fun encodeNoPadded(ba: ByteArray): String = org.apache.commons.codec.binary.Base32().encodeToString(ba)
}
