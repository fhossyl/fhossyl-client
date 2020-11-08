package org.fhossyl.packets.protocol

import io.ktor.utils.io.core.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.internal.TaggedEncoder
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import org.fhossyl.packets.common.MinecraftOutputEncoding
import org.fhossyl.packets.common.annotation
import org.fhossyl.packets.protocol.datatypes.EnumOrdinal
import org.fhossyl.packets.protocol.datatypes.ProtocolEnumDataType
import org.fhossyl.packets.protocol.datatypes.ProtocolNumberDataType

@OptIn(
    InternalSerializationApi::class,
    ExperimentalSerializationApi::class,
    ExperimentalUnsignedTypes::class
)
open class TaggedProtocolEncoder(
    open val output: Output,
    override val serializersModule: SerializersModule = EmptySerializersModule
): TaggedEncoder<ProtocolNumberDescription>() {

    final override fun beginStructure(descriptor: SerialDescriptor): CompositeEncoder {
        return when(descriptor.kind) {
            is PrimitiveKind -> {
                val description = ProtocolNumberDescription(ProtocolNumberDataType.Signed, 0)
                StaticTaggedProtocolEncoder(output, description, serializersModule)
            }
            else -> super.beginStructure(descriptor)
        }
    }

    final override fun shouldEncodeElementDefault(descriptor: SerialDescriptor, index: Int) = true

    override fun SerialDescriptor.getTag(index: Int) = getTagFor(this, index)

    final override fun encodeTaggedInt(tag: ProtocolNumberDescription, value: Int) = when(tag.type) {
        ProtocolNumberDataType.Signed -> output.writeInt(value)
        ProtocolNumberDataType.Unsigned -> output.writeUInt(value.toUInt())
        ProtocolNumberDataType.Var -> MinecraftOutputEncoding(output).encode(value.toLong())
    }

    final override fun encodeTaggedLong(tag: ProtocolNumberDescription, value: Long) = when(tag.type) {
        ProtocolNumberDataType.Signed -> output.writeLong(value)
        ProtocolNumberDataType.Unsigned -> output.writeULong(value.toULong())
        ProtocolNumberDataType.Var -> MinecraftOutputEncoding(output).encode(value)
    }

    final override fun encodeTaggedByte(tag: ProtocolNumberDescription, value: Byte) = when(tag.type) {
        ProtocolNumberDataType.Unsigned -> output.writeUByte(value.toUByte())
        else -> output.writeByte(value)
    }

    final override fun encodeTaggedShort(tag: ProtocolNumberDescription, value: Short) = when(tag.type) {
        ProtocolNumberDataType.Unsigned -> output.writeUShort(value.toUShort())
        else -> output.writeShort(value)
    }

    final override fun encodeTaggedFloat(tag: ProtocolNumberDescription, value: Float) =
        output.writeFloat(value)

    final override fun encodeTaggedDouble(tag: ProtocolNumberDescription, value: Double) =
        output.writeDouble(value)

    final override fun encodeTaggedBoolean(tag: ProtocolNumberDescription, value: Boolean) =
        output.writeByte(if(value) 0x01 else 0x00)

    final override fun encodeTaggedString(tag: ProtocolNumberDescription, value: String) =
        MinecraftOutputEncoding(output).encodeString(value)

    final override fun encodeTaggedEnum(
        tag: ProtocolNumberDescription,
        descriptor: SerialDescriptor,
        baseOrdinal: Int
    ) {
        val ordinal = descriptor.annotation<EnumOrdinal>(baseOrdinal)?.int ?: baseOrdinal
        return when(extractEnum(tag, descriptor).type) {
            ProtocolEnumDataType.Var -> MinecraftOutputEncoding(output).encode(ordinal.toLong())
            ProtocolEnumDataType.Byte -> output.writeByte(ordinal.toByte())
            ProtocolEnumDataType.UnsignedByte -> output.writeUByte(ordinal.toUByte())
            ProtocolEnumDataType.Int -> output.writeInt(ordinal)
            ProtocolEnumDataType.String -> MinecraftOutputEncoding(output).encodeString(
                descriptor.getElementName(ordinal)
            )
        }
    }

}

private class StaticTaggedProtocolEncoder(
    override val output: Output,
    private val description: ProtocolNumberDescription,
    override val serializersModule: SerializersModule
): TaggedProtocolEncoder(output, serializersModule) {

    override fun SerialDescriptor.getTag(index: Int): ProtocolNumberDescription {
        return description
    }

}