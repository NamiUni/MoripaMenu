package party.morino.moripamenu.gui;

import broccolai.corn.paper.item.PaperItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.incendo.interfaces.core.click.ClickHandler;
import org.incendo.interfaces.paper.element.ItemStackElement;
import org.incendo.interfaces.paper.type.ChestInterface;

public class MainMenuInterface extends AbstractMenuInterface {

    private static final ItemStack info = PaperItemBuilder.ofType(Material.PLAYER_HEAD)
            .name(Component.text()
                    .append(Component.text("情報"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .build();

    private static final ItemStack announce = PaperItemBuilder.ofType(Material.OAK_SIGN)
            .name(Component.text()
                    .append(Component.text("お知らせ"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .loreList(Component.text()
                    .append(Component.text("カミングスーン"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .build();

    private static final ItemStack link = PaperItemBuilder.ofType(Material.BEACON)
            .name(Component.text()
                    .append(Component.text("各種リンク"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .build();

    private static final ItemStack vote = PaperItemBuilder.ofType(Material.PAPER)
            .name(Component.text()
                    .append(Component.text("投票"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .customModelData(1)
            .build();

    private static final ItemStack command = PaperItemBuilder.ofType(Material.COMMAND_BLOCK)
            .name(Component.text()
                    .append(Component.text("コマンド集"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .build();

    private static final ItemStack convenient = PaperItemBuilder.ofType(Material.CRAFTING_TABLE)
            .name(Component.text()
                    .append(Component.text("便利機能"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .build();

    private static final ItemStack tutorial = PaperItemBuilder.ofType(Material.WRITABLE_BOOK)
            .name(Component.text()
                    .append(Component.text("チュートリアル"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .build();

    private static final ItemStack help = PaperItemBuilder.ofType(Material.CRAFTING_TABLE)
            .name(Component.text()
                    .append(Component.text("便利機能"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .build();

    private static final ItemStack close = PaperItemBuilder.ofType(Material.BARRIER)
            .name(Component.text()
                    .append(Component.text("閉じる"))
                    .decoration(TextDecoration.ITALIC, false)
                    .color(NamedTextColor.WHITE)
                    .build())
            .build();

    @Override
    public ChestInterface buildInterface() {
        return ChestInterface.builder()
                .updates(true, 20)
                .clickHandler(ClickHandler.cancel())
                .addTransform(this.emptySlot)

                // info
                .addTransform((pane, view) -> {
                    info.editMeta(meta -> {
                        if (meta instanceof SkullMeta skullMeta) {
                            skullMeta.setOwningPlayer(view.viewer().player());
                        }
                    });
                    return pane.element(ItemStackElement.of(info), 0, 0);
                })

                // announce
                .addTransform(chestItem(ItemStackElement.of(announce), 1, 0))

                // link
                .addTransform(chestItem(ItemStackElement.of(link), 2, 0))

                // vote
                .addTransform(chestItem(ItemStackElement.of(vote), 3, 0))

                // command
                .addTransform(chestItem(ItemStackElement.of(command), 4, 0))

                // convenient
                .addTransform(chestItem(ItemStackElement.of(convenient), 5, 0))

                // tutorial
                .addTransform(chestItem(ItemStackElement.of(tutorial), 6, 0))

                // help
                .addTransform(chestItem(ItemStackElement.of(help), 7, 0))

                // close
                .addTransform(chestItem(ItemStackElement.of(close), 8, 0))

                .build();
    }
}
