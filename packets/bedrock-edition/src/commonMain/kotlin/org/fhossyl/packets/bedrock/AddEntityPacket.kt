package org.fhossyl.packets.bedrock

import org.fhossyl.packets.Attribute
import org.fhossyl.packets.BedrockEntityLink
import org.fhossyl.packets.BedrockMetadata
import org.fhossyl.packets.BedrockPacket
import org.fhossyl.packets.common.Vector3F

data class AddEntityPacket(
    val attributes: List<Attribute>,
    val metadata: Map<BedrockMetadata, Any>,
    val links: List<BedrockEntityLink>,
    val uniqueEntityId: Long,
    val runtimeEntityId: Long,
    val identifier: String,
    val position: Vector3F,
    val motion: Vector3F,
    val rotation: Vector3F,
    override val packetId: Int,
    override val clientId: Int,
    override val senderId: Int
): BedrockPacket
