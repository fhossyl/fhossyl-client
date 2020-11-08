package org.fhossyl.packets.protocol

import io.ktor.utils.io.core.*
import kotlinx.serialization.BinaryFormat
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule

@OptIn(ExperimentalSerializationApi::class)
class MinecraftProtocol(
    override val serializersModule: SerializersModule = EmptySerializersModule,
): BinaryFormat {

    override fun <T> decodeFromByteArray(
        deserializer: DeserializationStrategy<T>,
        bytes: ByteArray
    ): T {
        val packets = ByteReadPacket(bytes)
        return TaggedProtocolDecoder(packets, serializersModule).decodeSerializableValue(deserializer)
    }

    override fun <T> encodeToByteArray(serializer: SerializationStrategy<T>, value: T): ByteArray {
        val packetBuilder = BytePacketBuilder()
        TaggedProtocolEncoder(packetBuilder).encodeSerializableValue(serializer, value)
        return packetBuilder.build().readBytes()
    }

}