package party.morino.moripamenu.gui;

import broccolai.corn.paper.item.PaperItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.incendo.interfaces.core.transform.Transform;
import org.incendo.interfaces.paper.PlayerViewer;
import org.incendo.interfaces.paper.element.ItemStackElement;
import org.incendo.interfaces.paper.pane.ChestPane;
import org.incendo.interfaces.paper.transform.PaperTransform;
import org.incendo.interfaces.paper.type.ChestInterface;

abstract class AbstractMenuInterface {
    protected final Transform<ChestPane, PlayerViewer> emptySlot = PaperTransform.chestFill(
            ItemStackElement.of(PaperItemBuilder.ofType(Material.BLACK_STAINED_GLASS_PANE)
                    .name(Component.text(""))
                    .customModelData(1)
                    .build()));

    protected abstract ChestInterface buildInterface();

    protected static Transform<ChestPane, PlayerViewer> chestItem(
            final ItemStackElement<ChestPane> element,
            final int x,
            final int y
    ) {
        return PaperTransform.chestItem(() -> element, x, y);
    }
}
