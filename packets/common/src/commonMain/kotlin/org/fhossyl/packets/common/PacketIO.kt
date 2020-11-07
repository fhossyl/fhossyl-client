package org.fhossyl.packets.common

import io.ktor.utils.io.core.*
import kotlin.experimental.and
import kotlin.js.JsName

abstract class PacketIO {

    companion object {
        @JsName("value0x7FL")
        private const val `0x7FL`: Byte = 0x7FL.toByte()

        @JsName("zero")
        private const val `0`: Byte = 0

        @JsName("value0x80")
        private const val `0x80`: Byte = 0x80.toByte()
    }

    open fun decodeString(buffer: Input, maxStringLength: Int = 0): String {
        val length = decode(buffer).toInt()
            .takeIf { it > 0 && maxStringLength <= 0 || it < maxStringLength * 4 }
            ?: error("Unsupported buffer length for decodeString.")

        return buffer.readBytes(length).decodeToString().takeIf { it.length < maxStringLength }
            ?: error("The string length should be lower than $maxStringLength.")
    }

    open fun decodeVector3F(buffer: Input): Vector3F {
        return with(buffer) {
            Vector3F(readFloatLittleEndian(), readFloatLittleEndian(), readFloatLittleEndian())
        }
    }

    open fun decode(buffer: Input): Long {
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

    open fun encode(buffer: Output, value: Long) {
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