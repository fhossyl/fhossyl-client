package org.fhossyl.packets.common

interface Packet {

    /**
     * Returns whether this [Packet] has handling priority. If the result is equals to `true`,
     * the packet will be handled immediately, otherwise it will be added to a queue.
     * */
    val isPriority: Boolean

}