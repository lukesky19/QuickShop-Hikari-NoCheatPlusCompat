plugins {
    java
}

group = "com.github.lukesky19"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
    maven("https://repo.codemc.io/repository/maven-public/") {
        name = "QuickShop Repo"
    }
    maven("https://repo.md-5.net/content/repositories/snapshots/") {
        name = "NoCheatPlus Snapshots"
    }
    maven("https://repo.md-5.net/content/repositories/releases/") {
        name = "NoCheatPlus Releases"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
    //compileOnly("com.ghostchu:quickshop-bukkit:6.2.0.6")
    compileOnly("com.ghostchu:quickshop-api:6.2.0.6")
    compileOnly("fr.neatmonster:nocheatplus:3.16.1-SNAPSHOT")
    //implementation("org.spongepowered:configurate-yaml:4.1.2")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks.jar {
    manifest {
        attributes["paperweight-mappings-namespace"] = "mojang"
    }
    archiveClassifier.set("")
}
