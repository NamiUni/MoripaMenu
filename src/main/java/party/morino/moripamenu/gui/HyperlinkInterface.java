package party.morino.moripamenu.gui;

import net.kyori.adventure.text.Component;
import org.incendo.interfaces.paper.transform.PaperTransform;
import org.incendo.interfaces.paper.type.BookInterface;

public class HyperlinkInterface extends AbstractBookInterface {
    private static final Component link = miniMessage.deserialize("""
                <dark_green><b>【各種リンク】</b></dark_green>
                クリックするとブラウザで開くことが出来ます。
                
                <red><b>[公式]</b></red>
                <gold>>> <click:open_url:'https://morino.party'><u>HP</u></click>
                >> <click:open_url:'https://wiki.morino.party'><u>Wiki</u></click>
                >> <click:open_url:'https://discord.gg/9HdanPM'><u>Discord</u></click>
                >> <click:open_url:'https://twitter.com/morinoparty'><u>Twitter</u></click>
                >> <click:open_url:'https://www.youtube.com/@user-fl7xf4ic9k'><u>YouTube</u></click></gold>
                
                <red><b>[投票]</b></red>
                <gold>>> <click:open_url:'https://minecraft.jp/servers/visit.morino.party'><u>JMS</u></click>
                >> <click:open_url:'https://monocraft.net/servers/Rkwtn3jRSVCgHnlT0mG9'><u>monocraft</u></click></gold>
                """);
    @Override
    protected BookInterface buildInterface() {

        return BookInterface.builder()
                .addTransform(PaperTransform.bookText(link))
                .build();
    }
}
