# Fhossyl

[![actions_badge][]][actions] [![localized][]][translate]

  ⚠️ **Fhossyl is still a work in progress and is not recommended for production.**

Fhossyl is a bridge that allows you to connect to Minecraft: Java Edition servers using 
Minecraft: Bedrock Edition and vice versa.


# Project structure

As Fhossyl is a modular project, we separate it into subprojects and three different repositories.

⚙️ **Client** The `fhossyl-client` repository separate their function in three subprojects:
    
  * **Bootstrap** is a low level API divided into 3 subprojects (`bukkit`, `common` and `standalone`),
  that provides information about the server to the connector.
  
  * **Connector** is a low level API that connects to the provided server using an incompatible
  Minecraft Edition by using the information provided by the bootstrap.
  
  * **Packets** is a subproject that stores all the packets of each game edition.

# Related repositories

  * [Client][client]
  * [Desktop App][app]
  * [Mobile App][app]
  * [Mappings][mappings]

# Frequently-asked questions

These questions are frequently asked or will probably be asked. Please check that what 
you're asking isn't covered by this section before creating a issue.

  * **What versions does Fhossyl support? Any plans to support newer versions?** Fhossyl starts from 
  1.16.3 to the latest stable version for Minecraft: Java Edition and 1.16.x for Minecraft: Bedrock 
  Edition.
    
  * **Any plans to support older versions like 1.8.9 or 1.15?** No. Fhossyl will only support
  modern versions such as 1.16 and newer.


[client]: https://github.com/fhossyl/fhossyl-client
[app]: https://github.com/fhossyl/fhossyl-app
[mappings]: https://github.com/fhossyl/fhossyl-mappings
[localized]: https://badges.crowdin.net/fhossyl/localized.svg
[translate]: https://crowdin.com/project/fhossyl
[actions]: https://github.com/fhossyl/fhossyl-client/actions
[actions_badge]: https://github.com/fhossyl/fhossyl-client/workflows/Kotlin%20CI%20with%20Gradle/badge.svg
