package org.fhossyl.packets

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import org.fhossyl.packets.bedrock.AddEntityPacket

val BedrockPacketParser = Json {
    serializersModule = SerializersModule {
        polymorphic(BedrockPacket::class) {
            subclass(AddEntityPacket::class)
        }
    }
}