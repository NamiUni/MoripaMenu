package party.morino.moripamenu.gui;

import broccolai.corn.paper.item.PaperItemBuilder;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.incendo.interfaces.core.click.ClickHandler;
import org.incendo.interfaces.core.transform.Transform;
import org.incendo.interfaces.paper.PlayerViewer;
import org.incendo.interfaces.paper.element.ItemStackElement;
import org.incendo.interfaces.paper.pane.ChestPane;
import org.incendo.interfaces.paper.type.ChestInterface;
import java.util.List;

// TODO: エモートの追加？
public class MainMenuInterface extends AbstractMenuInterface {

    private static final ItemStack info = PaperItemBuilder.ofType(Material.PLAYER_HEAD)
            .name(Component.text()
                    .append(Component.text("あなた"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .build();

    private static final ItemStack announce = PaperItemBuilder.ofType(Material.OAK_SIGN)
            .name(Component.text()
                    .append(Component.text("おしらせ"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .loreList(Component.text("準備中だよ"))
            .build();

    private static final ItemStack guidBook = PaperItemBuilder.ofType(Material.BOOK)
            .name(Component.text()
                    .append(Component.text("はじめに"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .build();

    private static final ItemStack link = PaperItemBuilder.ofType(Material.BEACON)
            .name(Component.text()
                    .append(Component.text("りんく"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .build();

    private static final ItemStack command = PaperItemBuilder.ofType(Material.COMMAND_BLOCK)
            .name(Component.text()
                    .append(Component.text("こまんど"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .build();

    private static final ItemStack convenient = PaperItemBuilder.ofType(Material.CRAFTING_TABLE)
            .name(Component.text()
                    .append(Component.text("べんり"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .loreList(Component.text("準備中だよ"))
            .build();

    private static final ItemStack mail = PaperItemBuilder.ofType(Material.PAPER)
            .name(Component.text()
                    .append(Component.text("めーる"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .build();

    private static final ItemStack help = PaperItemBuilder.ofType(Material.GOAT_HORN)
            .name(Component.text()
                    .append(Component.text("ほうこく"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .build();

    private static final ItemStack close = PaperItemBuilder.ofType(Material.BARRIER)
            .name(Component.text()
                    .append(Component.text("とじる"))
                    .decoration(TextDecoration.BOLD, true)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(TextColor.fromCSSHexString("#03a9f4"))
                    .build())
            .build();

    @Override
    public ChestInterface buildInterface() {
        return ChestInterface.builder()
                .updates(true, 20)
                .clickHandler(ClickHandler.cancel())
                .title(Component.text()
                        .append(Component.text("めにゅー"))
                        .decoration(TextDecoration.BOLD, true)
                        .color(TextColor.fromCSSHexString("#263238"))
                        .build())
                .addTransform(this.emptySlot)
                .addTransform(info())
                .addTransform(chestItem(ItemStackElement.of(announce), 1, 0))
                .addTransform((pane, view) -> pane.element(ItemStackElement.of(guidBook, context -> new GuidBookInterface().replaceActiveScreen(context)), 2, 0))
                .addTransform((pane, view) -> pane.element(ItemStackElement.of(link, context -> new HyperlinkInterface().replaceActiveScreen(context)), 3, 0))
                .addTransform((pane, view) -> pane.element(ItemStackElement.of(command, context -> {
                    context.viewer().close();
                    Player player = context.viewer().player();
                    player.performCommand("clist");
                }), 4, 0))
                .addTransform(chestItem(ItemStackElement.of(convenient), 5, 0))
                .addTransform((pane, view) -> pane.element(ItemStackElement.of(mail, context -> {
                    context.viewer().close();
                    Player player = context.viewer().player();
                    player.performCommand("mail read");
                }), 6, 0))
                .addTransform((pane, view) -> pane.element(ItemStackElement.of(help, context -> {
                    context.viewer().close();
                    Player player = context.viewer().player();
                    String message = """
                            <color:#00ff84>+<st>                                                                              </st></color>
                            <color:#00ff84>| チケット機能:</color>
                            <color:#00ff84>|</color> 荒らし報告や土地保護削除申請にご利用下さい
                            <color:#00ff84>|</color> 詳細なお問い合わせが必要な場合は<u><gold><click:open_url:'https://morino.party/inquiry'>こちら</click></gold></u>
                            <color:#00ff84>|</color>
                            <color:#00ff84>|</color> 実際に荒らし行為が行われた場所や土地保護を削除して欲しい場所に立ち、
                            <color:#00ff84>|</color> 下のボタンをクリックしたら文章をそのまま入力して送信して下さい。
                            <color:#00ff84>|</color>                           <u><click:suggest_command:'/ticket create '><color:#619eff>>>チケットを送信<<</color></click></u>
                            <color:#00ff84>+<st>                                                                              </st></color>""";
                    player.sendRichMessage(message);
                }), 7, 0))
                .addTransform((pane, view) -> pane.element(ItemStackElement.of(close, context -> context.viewer().close()), 8, 0))
                .build();
    }

    public Transform<ChestPane, PlayerViewer> info() {
        return (pane, view) -> {
            var viewerHead = info.clone();
            viewerHead.editMeta(meta -> {
                if (meta instanceof SkullMeta skullMeta) {
                    skullMeta.setOwningPlayer(view.viewer().player());
                }
                meta.lore(List.of(
                        Component.text()
                                .append(Component.text("[所有数]"))
                                .decoration(TextDecoration.ITALIC, false)
                                .color(NamedTextColor.GOLD)
                                .build(),
                        Component.text()
                                .append(Component.text(PlaceholderAPI.setPlaceholders(view.viewer().player(), "お金: %vault_eco_balance_formatted%")))
                                .decoration(TextDecoration.ITALIC, false)
                                .color(NamedTextColor.WHITE)
                                .build(),
                        Component.text()
                                .append(Component.text(PlaceholderAPI.setPlaceholders(view.viewer().player(), "土地: %griefprevention_remainingclaims%\uD83C\uDFD5")))
                                .decoration(TextDecoration.ITALIC, false)
                                .color(NamedTextColor.WHITE)
                                .build(),
                        Component.text()
                                .append(Component.text(PlaceholderAPI.setPlaceholders(view.viewer().player(), "投票: %VotingPlugin_Points%P")))
                                .decoration(TextDecoration.ITALIC, false)
                                .color(NamedTextColor.WHITE)
                                .build(),
                        Component.text(""),
                        Component.text()
                                .append(Component.text("[タスク]"))
                                .decoration(TextDecoration.ITALIC, false)
                                .color(NamedTextColor.GOLD)
                                .build(),
                        Component.text()
                                .append(Component.text(PlaceholderAPI.setPlaceholders(view.viewer().player(), "投票: %VotingPlugin_CanVoteSites% / 2")))
                                .decoration(TextDecoration.ITALIC, false)
                                .color(NamedTextColor.WHITE)
                                .build(),
                        Component.text()
                                .append(Component.text(PlaceholderAPI.setPlaceholders(view.viewer().player(), "クエスト: %odailyquests_achieved% / %odailyquests_total%")))
                                .decoration(TextDecoration.ITALIC, false)
                                .color(NamedTextColor.WHITE)
                                .build()
                ));
            });
            return pane.element(ItemStackElement.of(viewerHead), 0, 0);
        };
    }
}
