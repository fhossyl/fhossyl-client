package org.fhossyl.packets.protocol

import kotlinx.serialization.descriptors.SerialDescriptor
import org.fhossyl.packets.common.annotation
import org.fhossyl.packets.protocol.datatypes.ProtocolNumber
import org.fhossyl.packets.protocol.datatypes.ProtocolNumberDataType
import org.fhossyl.packets.protocol.datatypes.ProtocolString

internal inline fun getTagFor(descriptor: SerialDescriptor, index: Int): ProtocolNumberDescription {
    val numberType = descriptor.annotation<ProtocolNumber>(index)?.type ?: ProtocolNumberDataType.Signed
    val stringMaximumLength = descriptor.annotation<ProtocolString>(index)?.maximumLength ?: 0
    return ProtocolNumberDescription(numberType, stringMaximumLength)
}
