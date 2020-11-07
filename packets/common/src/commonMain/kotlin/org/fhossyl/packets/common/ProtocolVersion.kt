package org.fhossyl.packets.common

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.js.JsName

@Serializable(with = ProtocolVersion.Companion::class)
enum class ProtocolVersion(val int: Int) {

    @JsName("v1_16_4")
    `1_16_4`(754),

    @JsName("v1_16_3")
    `1_16_3`(753);

    companion object: KSerializer<ProtocolVersion> {

        override val descriptor = PrimitiveSerialDescriptor("ProtocolVersion", PrimitiveKind.INT)

        override fun deserialize(decoder: Decoder): ProtocolVersion {
            return values().first(decoder.decodeInt()::equals)
        }

        override fun serialize(encoder: Encoder, value: ProtocolVersion) {
            return encoder.encodeInt(value.int)
        }

    }

}