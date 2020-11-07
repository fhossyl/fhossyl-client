package org.fhossyl.packets

import org.fhossyl.packets.common.MetadataType

private typealias Type = MetadataType

// Credits: https://github.com/CloudburstMC/Protocol/blob/1dc26dca83160f6f8d54e1bca95cda3bdff9d3de/bedrock/bedrock-common/src/main/java/com/nukkitx/protocol/bedrock/data/EntityData.java
enum class BedrockMetadata(val type: Type) {

    Flags(Type.Flags),
    Health(Type.Int),
    Variant(Type.Int),
    Color(Type.Byte),
    NameTag(Type.String),
    OwnerEid(Type.Long),
    TargetEid(Type.Long),
    Air(Type.Short),
    PotionColor(Type.Int),
    PotionAmbient(Type.Byte),
    HurtTime(Type.Int),
    JumpDuration(Type.Byte),
    HurtDirection(Type.Int),
    PaddleTimeLeft(Type.Float)
    // TODO;

}
