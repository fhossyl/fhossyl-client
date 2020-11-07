package org.fhossyl.packets

import kotlinx.serialization.Polymorphic
import org.fhossyl.packets.common.Packet

@Polymorphic
interface BedrockPacket: Packet {

    val packetId: Int

    val clientId: Int

    val senderId: Int

}