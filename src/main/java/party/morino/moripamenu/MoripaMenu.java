package party.morino.moripamenu;

import org.bukkit.plugin.java.JavaPlugin;
import org.incendo.interfaces.paper.PaperInterfaceListeners;
import party.morino.moripamenu.listener.MenuOpenListener;

public class MoripaMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MenuOpenListener(), this);
        PaperInterfaceListeners.install(this);
    }
}
