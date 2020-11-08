package org.fhossyl.packets.common

import kotlinx.serialization.descriptors.SerialDescriptor

inline fun <reified T> SerialDescriptor.annotation(index: Int? = null): T? {
    if(index == null) {
        return annotations.find { it is T } as T?
    }
    return getElementAnnotations(index).find { it is T } as T?
}