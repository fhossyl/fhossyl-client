package org.fhossyl.packets

data class BedrockEntityLink(
    val from: Long,
    val to: Long,
    val type: Type,
    val immediate: Boolean,
    val riderInitiated: Boolean
) {

    enum class Type {
        Remove,
        Rider,
        Passenger;
    }

}
