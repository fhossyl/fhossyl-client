package org.fhossyl.packets.protocol

import kotlinx.serialization.descriptors.SerialDescriptor
import org.fhossyl.packets.common.annotation
import org.fhossyl.packets.protocol.datatypes.*

internal inline fun getTagFor(descriptor: SerialDescriptor, index: Int): ProtocolNumberDescription {
    val numberType = descriptor.annotation<ProtocolNumber>(index)?.type ?: ProtocolNumberDataType.Signed
    val stringMaximumLength = descriptor.annotation<ProtocolString>(index)?.maximumLength ?: 0
    return ProtocolNumberDescription(numberType, stringMaximumLength)
}

internal inline fun extractEnum(
    tag: ProtocolNumberDescription,
    descriptor: SerialDescriptor
): ProtocolEnumDescription {
    val type = descriptor.annotation<ProtocolEnum>()?.dataType ?: ProtocolEnumDataType.Var
    val length = descriptor.annotation<ProtocolString>()?.maximumLength ?: tag.maximumStringLength
    return ProtocolEnumDescription(type, length)
}
