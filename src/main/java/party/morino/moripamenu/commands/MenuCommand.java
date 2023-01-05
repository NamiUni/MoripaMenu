package party.morino.moripamenu.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.incendo.interfaces.paper.PlayerViewer;
import org.jetbrains.annotations.NotNull;
import party.morino.moripamenu.gui.MainMenuInterface;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            new MainMenuInterface().buildInterface().open(PlayerViewer.of(player));
            return true;
        }
        return false;
    }
}
