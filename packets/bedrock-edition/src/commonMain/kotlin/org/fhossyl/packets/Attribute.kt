package org.fhossyl.packets

data class Attribute(
    val name: String,
    val minimum: Float,
    val maximum: Float,
    val value: Float,
    val default: Float
)
