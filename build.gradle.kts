plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("xyz.jpenilla.run-paper") version "2.0.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

group = "party.morino"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")

    // Paper
    maven("https://repo.papermc.io/repository/maven-public/")

    // Corn
    maven("https://repo.broccol.ai")

    // Papi
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    // Paper
    compileOnly("io.papermc.paper", "paper-api", "1.19.3-R0.1-SNAPSHOT")

    // Config
    implementation("org.spongepowered", "configurate-hocon", "4.1.2")
    implementation("net.kyori", "adventure-serializer-configurate4", "4.12.0")

    // Corn
    implementation("broccolai.corn", "corn-minecraft-paper", "3.2.0")

    // inventory gui
    implementation("org.incendo.interfaces", "interfaces-paper", "1.0.0-SNAPSHOT")

    // PlaceholderAPI
    compileOnly("me.clip", "placeholderapi", "2.11.2")

    // Utils
    implementation("com.google.inject", "guice", "5.1.0")
}

bukkit {
    name = rootProject.name
    version = project.version as String
    main = "party.morino.moripamenu.MoripaMenu"
    apiVersion = "1.19"
    description = "もりぱ専用メニュープラグイン"
    author = "Unitarou"
    website = "https://morino.party"
    depend = listOf("PlaceholderAPI")
    commands {
        register("menu") {
            description = "メニューコマンド"
            usage = "/menu"
        }
    }
}

tasks {
    shadowJar {
        this.archiveClassifier.set(null as String?)

    }
    runServer {
        minecraftVersion("1.19.3")
    }
}