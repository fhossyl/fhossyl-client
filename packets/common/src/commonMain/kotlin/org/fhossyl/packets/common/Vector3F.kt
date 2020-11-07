package org.fhossyl.packets.common

data class Vector3F(val x: Float, val y: Float, val z: Float)

inline operator fun Vector3F.plus(vector: Vector3F) = Vector3F(x + vector.x, y + vector.y, z + vector.z)

inline operator fun Vector3F.minus(vector: Vector3F) = Vector3F(x - vector.x, y - vector.y, z - vector.z)