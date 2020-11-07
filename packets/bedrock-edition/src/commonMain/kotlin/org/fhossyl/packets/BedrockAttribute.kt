package org.fhossyl.packets

data class BedrockAttribute(
    val name: String,
    val minimum: Float,
    val maximum: Float,
    val value: Float,
    val default: Float
)
