# TryTP — Fabric 1.21.11

TryTP adds a client-side command:

    /trytp <player>

It sends the server's ordinary command:

    /tpa <player>

The server still decides whether the command is permitted and whether the target can receive requests. This mod does not detect other players' private settings or predict when they will change them, and it does not bypass server rules.

## Build

Requirements:
- Java 21 JDK
- Internet access for Gradle to download Minecraft/Fabric dependencies

From this folder, run:

- Windows: `gradlew.bat build` (if you add a Gradle wrapper), or `gradle build`
- macOS/Linux: `gradle build`

The built JAR will be in `build/libs/`. Put that JAR in your Minecraft `mods` folder along with Fabric API.

## Notes

This is the source project, not a precompiled JAR. The dependency versions in `gradle.properties` may need updating if Fabric has published newer or differently numbered artifacts for Minecraft 1.21.11.
