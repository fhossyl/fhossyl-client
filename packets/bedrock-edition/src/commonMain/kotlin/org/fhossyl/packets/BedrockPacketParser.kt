package org.fhossyl.packets

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

val BedrockPacketParser = Json {
    serializersModule = SerializersModule {

    }
}