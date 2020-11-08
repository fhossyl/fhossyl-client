# Fhossyl

[![actions_badge][]][actions] [![localized][]][translate]

  ⚠️ **Fhossyl is still a work in progress and is not recommended for production.**

Fhossyl is a bridge that allows you to connect to Minecraft: Java Edition servers using 
Minecraft: Bedrock Edition and vice versa.


# Project structure

As Fhossyl is a modular project, we separate it into subprojects and three different repositories.

⚙️ **Client** The `fhossyl-client` repository separate their function in three subprojects:

* **Bootstrap** is a low level API divided into 3 subprojects (`bukkit`, `common` and `standalone`), that provides
  information about the server to the connector.

* **Connector** is a low level API that connects to the provided server using an incompatible Minecraft Edition by using
  the information provided by the bootstrap.

* **Packets** is a subproject that stores all the packets of each game edition.

# Credits

* [kt-mc-packet][ktmcpacket] by `DevSrSouza`. Some parts of the kt-mc-packet code have been reworked internally for
  adaptation to our uses. You can notice several similarities from the
  `packets` subproject.
* [NukkitX Protocol][nukkitxprotocol] by `CloudburstMC`. Like kt-mc-packet, the NukkitX Protocol has also been reworked
  internally for our uses.
* [Minecraft Protocol Wiki][protocol]. Information about Minecraft: Java Edition servers and clients has been taken from
  the Minecraft Protocol Wiki.
* [Ktor for I/O][ktorio] by `Ktor Team`. The Ktor for I/O dependency is being used on our
  `build.gradle.kts` for Input/Output work.
* [kotlinx.serialization][serialization] by `Kotlin`. The kotlinx.serialization dependency is being used on
  our `build.gradle.kts` to provide an optimized and cleaner binary (de)serialization systems.
* [kotlinx.coroutines][coroutines] by `Kotlin`. The kotlinx.coroutines dependency is being user on
  our `build.gradle.kts` to provide suspendable, readable and more optimized code.

# Related repositories

* [Client][client] `fhossyl-client`
* [Desktop App][app] `fhossyl-app`
* [Mobile App][app] `fhossyl-app`
* [Mappings][mappings] `fhossyl-mappings`

# Frequently-asked questions

These questions are frequently asked or will probably be asked. Please check that what you're asking isn't covered by
this section before creating a issue.

* **What versions does Fhossyl support? Any plans to support newer versions?** Fhossyl starts from 1.16.3 to the latest
  stable version for Minecraft: Java Edition and 1.16.x for Minecraft: Bedrock Edition.

* **Any plans to support older versions like 1.8.9 or 1.15?** No. Fhossyl will only support modern versions such as 1.16
  and newer.

[ktorio]: https://ktor.io/

[nukkitxprotocol]: https://github.com/CloudburstMC/Protocol/tree/develop

[serialization]: https://github.com/Kotlin/kotlinx.serialization

[coroutines]: https://github.com/Kotlin/kotlinx.coroutines

[ktmcpacket]: https://github.com/devsrsouza/kt-mc-packet

[protocol]: https://wiki.vg

[client]: https://github.com/fhossyl/fhossyl-client

[app]: https://github.com/fhossyl/fhossyl-app

[mappings]: https://github.com/fhossyl/fhossyl-mappings

[localized]: https://badges.crowdin.net/fhossyl/localized.svg

[translate]: https://crowdin.com/project/fhossyl

[actions]: https://github.com/fhossyl/fhossyl-client/actions

[actions_badge]: https://github.com/fhossyl/fhossyl-client/workflows/Kotlin%20CI%20with%20Gradle/badge.svg
