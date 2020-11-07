package org.fhossyl.packets.common

import io.ktor.utils.io.core.*
import kotlin.experimental.and
import kotlin.js.JsName

object PacketIO {

    @JsName("value0x7FL")
    private const val `0x7FL`: Byte = 0x7FL.toByte()

    @JsName("zero")
    private const val `0`: Byte = 0

    @JsName("value0x80")
    private const val `0x80`: Byte = 0x80.toByte()

    fun decode(buffer: Input): Long {
        var result: Long = 0
        var shift = 0
        while(shift < 64) {
            val b: Byte = buffer.readByte()
            result = result or (b and `0x7FL`).toLong() shl shift
            if(b and `0x80` != `0`) {
                return result
            }
            shift += 7
        }
        throw ArithmeticException("VarInt or VarLong was too large")
    }

    fun encode(buffer: Output, value: Long) {
        var value = value
        while(true) {
            value = if(value and 0x7FL.inv() == 0L) {
                buffer.writeByte(value.toByte())
                break
            } else {
                buffer.writeByte((value.toInt() and 0x7F or 0x80).toByte())
                value ushr 7
            }
        }
    }

}