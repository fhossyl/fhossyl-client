package org.fhossyl.packets.protocol

import org.fhossyl.packets.protocol.datatypes.ProtocolDataType
import org.fhossyl.packets.protocol.datatypes.ProtocolEnumDataType
import org.fhossyl.packets.protocol.datatypes.ProtocolNumberDataType

sealed class ProtocolDescription {
    abstract val type: ProtocolDataType
    abstract val maximumStringLength: Int
}

data class ProtocolNumberDescription(
    override val type: ProtocolNumberDataType,
    override val maximumStringLength: Int = 32767
): ProtocolDescription()

data class ProtocolEnumDescription(
    override val type: ProtocolEnumDataType,
    override val maximumStringLength: Int = 32767
): ProtocolDescription()