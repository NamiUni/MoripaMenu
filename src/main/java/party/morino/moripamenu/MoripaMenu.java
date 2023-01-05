package party.morino.moripamenu;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.interfaces.paper.PaperInterfaceListeners;
import party.morino.moripamenu.commands.MenuCommand;
import party.morino.moripamenu.listener.MenuOpenListener;

public class MoripaMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!papiLoaded()) {
            ComponentLogger.logger().error(Component.text("MoripaMenuにはPAPIが必須です"));
            this.getServer().getPluginManager().disablePlugin(this);
        }

        PaperInterfaceListeners.install(this);
        getServer().getPluginManager().registerEvents(new MenuOpenListener(), this);

        this.getCommand("menu").setExecutor(new MenuCommand());

    }

    private boolean papiLoaded() {
        return this.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");
    }
}
