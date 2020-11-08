package org.fhossyl.packets.protocol

import io.ktor.utils.io.core.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeDecoder.Companion.DECODE_DONE
import kotlinx.serialization.internal.TaggedDecoder
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import org.fhossyl.packets.common.MinecraftInputDecoding
import org.fhossyl.packets.common.annotation
import org.fhossyl.packets.protocol.datatypes.EnumOrdinal
import org.fhossyl.packets.protocol.datatypes.ProtocolEnumDataType
import org.fhossyl.packets.protocol.datatypes.ProtocolNumberDataType

@OptIn(
    InternalSerializationApi::class,
    ExperimentalSerializationApi::class,
    ExperimentalUnsignedTypes::class
)
open class TaggedProtocolDecoder(
    open val input: Input,
    override val serializersModule: SerializersModule = EmptySerializersModule
): TaggedDecoder<ProtocolNumberDescription>() {

    private var index: Int = 0

    final override fun decodeElementIndex(descriptor: SerialDescriptor): Int {
        return if(descriptor.elementsCount == index) DECODE_DONE else index++
    }

    override fun SerialDescriptor.getTag(index: Int) = getTagFor(this, index)

    final override fun beginStructure(descriptor: SerialDescriptor): CompositeDecoder {
        return when(descriptor.kind) {
            is PrimitiveKind -> {
                val description = ProtocolNumberDescription(ProtocolNumberDataType.Signed, 0)
                StaticTaggedProtocolDecoder(input, description, serializersModule)
            }
            else -> super.beginStructure(descriptor)
        }
    }

    final override fun decodeTaggedBoolean(tag: ProtocolNumberDescription) = when(val i = input.readByte()) {
        0x00.toByte() -> false
        0x01.toByte() -> true
        else -> error("Expected boolean value (0 or 1), but $i was provided.")
    }

    final override fun decodeTaggedByte(tag: ProtocolNumberDescription) = when(tag.type) {
        ProtocolNumberDataType.Unsigned -> input.readUByte().toByte()
        else -> input.readByte()
    }

    final override fun decodeTaggedShort(tag: ProtocolNumberDescription) = when(tag.type) {
        ProtocolNumberDataType.Unsigned -> input.readUShort().toShort()
        else -> input.readShort()
    }

    final override fun decodeTaggedInt(tag: ProtocolNumberDescription): Int = when(tag.type) {
        ProtocolNumberDataType.Signed -> input.readInt()
        ProtocolNumberDataType.Unsigned -> input.readUInt().toInt()
        ProtocolNumberDataType.Var -> MinecraftInputDecoding(input).decode().toInt()
    }

    final override fun decodeTaggedLong(tag: ProtocolNumberDescription): Long = when(tag.type) {
        ProtocolNumberDataType.Signed -> input.readLong()
        ProtocolNumberDataType.Unsigned -> input.readULong().toLong()
        ProtocolNumberDataType.Var -> MinecraftInputDecoding(input).decode()
    }

    final override fun decodeTaggedFloat(tag: ProtocolNumberDescription): Float = input.readFloat()

    final override fun decodeTaggedDouble(tag: ProtocolNumberDescription): Double = input.readDouble()

    @ExperimentalStdlibApi
    final override fun decodeTaggedString(tag: ProtocolNumberDescription): String {
        return MinecraftInputDecoding(input).decodeString(tag.maximumStringLength)
    }

    final override fun decodeTaggedEnum(
        tag: ProtocolNumberDescription,
        descriptor: SerialDescriptor
    ): Int {
        val desc = extractEnum(tag, descriptor)

        val ordinal = when(desc.type) {
            ProtocolEnumDataType.Var -> MinecraftInputDecoding(input).decode().toInt()
            ProtocolEnumDataType.String -> descriptor.getElementIndex(
                MinecraftInputDecoding(input).decodeString(desc.maximumStringLength)
            )
            ProtocolEnumDataType.Byte -> input.readByte().toInt()
            ProtocolEnumDataType.UnsignedByte -> input.readUByte().toInt()
            ProtocolEnumDataType.Int -> input.readInt()
        }

        return (0 until descriptor.elementsCount).firstOrNull {
            descriptor.annotation<EnumOrdinal>(index)?.int ?: index == ordinal
        } ?: -1
    }

}

private class StaticTaggedProtocolDecoder(
    override val input: Input,
    private val description: ProtocolNumberDescription,
    override val serializersModule: SerializersModule
): TaggedProtocolDecoder(input, serializersModule) {

    override fun SerialDescriptor.getTag(index: Int): ProtocolNumberDescription {
        return description
    }

}