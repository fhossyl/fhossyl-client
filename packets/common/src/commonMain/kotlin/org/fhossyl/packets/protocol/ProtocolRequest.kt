package org.fhossyl.packets.protocol

import org.fhossyl.packets.protocol.datatypes.ProtocolDataType
import org.fhossyl.packets.protocol.datatypes.ProtocolEnumDataType
import org.fhossyl.packets.protocol.datatypes.ProtocolNumberDataType

interface ProtocolDescription {
    val dataType: ProtocolDataType
    val maximumStringLength: Int
}

data class ProtocolNumberDescription(
    override val dataType: ProtocolNumberDataType,
    override val maximumStringLength: Int = 0
): ProtocolDescription

data class ProtocolEnumDescription(
    override val dataType: ProtocolEnumDataType,
    override val maximumStringLength: Int = 0
): ProtocolDescription