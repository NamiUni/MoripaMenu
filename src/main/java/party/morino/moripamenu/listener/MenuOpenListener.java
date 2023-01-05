package party.morino.moripamenu.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.incendo.interfaces.paper.PlayerViewer;
import party.morino.moripamenu.gui.MainMenuInterface;

public class MenuOpenListener implements Listener {
    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent event) {
        if (event.getPlayer().isSneaking()) {
            new MainMenuInterface().buildInterface().open(PlayerViewer.of(event.getPlayer()));
        }
    }
}
