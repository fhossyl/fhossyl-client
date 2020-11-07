rootProject.name = "fhossyl-client"

val packets = listOf("common", "bedrock-edition", "java-edition")
val bootstrap = listOf("common", "bukkit", "standalone")

packets.forEach { include(":packets:$it") }
bootstrap.forEach { include(":bootstrap:$it") }
include(":connector", ":common")