package org.fhossyl.packets

import kotlinx.serialization.Polymorphic

@Polymorphic
interface BedrockPacket {

    val packetId: Int

    val clientId: Int

    val senderId: Int

}