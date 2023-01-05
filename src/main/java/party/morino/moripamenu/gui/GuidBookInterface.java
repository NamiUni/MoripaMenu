package party.morino.moripamenu.gui;

import net.kyori.adventure.text.Component;
import org.incendo.interfaces.paper.transform.PaperTransform;
import org.incendo.interfaces.paper.type.BookInterface;

public class GuidBookInterface extends AbstractBookInterface {
    private static final Component tableOfContents = miniMessage.deserialize("""
            <dark_green><b>もりのパーティ！</b></dark_green>へようこそ！
            
            サーバーの住人たちは
            あなたが来るのをずっと
            待っていました！
            
            <red><b>[目次]</b></red>
            >> <gold>サーバールール</gold>
            >> <gold>サーバー紹介</gold>
            >> <gold>最初の街紹介</gold>
            >> <gold>資源サーバーへ</gold>
            >> <gold>家を建てよう</gold>
            >> <gold>セーブしよう</gold>
            """);

    private static final Component rule = miniMessage.deserialize("""
            <b><red>▶サーバールール</red></b>
                        
            1. <b><blue>嫌がらせをしない！</blue></b>
            破壊や窃盗、誹謗中傷などは禁止です！
            
            2. <b><blue>ズルをしない！</blue></b>
            通常プレイで再現できないチート行為は禁止です！
            
            3. <blue><b>指示を無視しない！</b></blue>
            すたっふの指示を無視する事は禁止です！
            """);

    private static final Component introduction = miniMessage.deserialize("""
            <b><red>▶サーバー紹介</red></b>
                        
            <dark_aqua>[生活サーバー]</dark_aqua>
            まったりした生活専用
            難易度はイージー
            アイテムロストなし
            <dark_red>※資源採取は禁止です</dark_red>
                        
            <dark_green>[資源サーバー]</dark_green>
            資源採取や冒険専用
            難易度はハード
            アイテムロストあり
            <dark_red>※定期リセットされます</dark_red>
            """);

    private static final Component town = miniMessage.deserialize("""
            <b><red>▶最初の街</red></b>
                        
            最初にスポーンする街は
            新規くらふたー専用です！
                        
            新規くらふたーがサーバーでの生活を始められやすいように作られた街なんです
                        
            周りは君と同じように始めたばかりのくらふたーばかりなので、仲良くしましょう！！
            """);

    private static final Component resource = miniMessage.deserialize("""
            <b><red>▶冒険に出よう！</red></b>
            
            街の紹介が終わったのでさっそく<dark_green>資源サーバー</dark_green>へ遊びに行きましょう！
            
            スポーン地点のそばにポータルがあるのでそこに飛び込むと広がっているのは<color:#0069aa>冒険専用のワールド</color>です！
            
            戦闘や採取を存分に楽しんで下さいね！
            """);

    private static final Component build = miniMessage.deserialize("""
            <b><red>▶家を建てよう！</red></b>
                        
            資源サーバーで家を建てる資材が集まったらさっそく家を建てましょう
                        
            初期スポの整備区画は新規専用でアクセスもいいのでオススメ♪
                        
            窃盗や破壊の被害を防ぐため家の土地は必ず保護してね
            <gold><u><click:open_url:'https://morino.party/protect'>保護の掛け方を確認</click></u></gold>
            """);

    private static final Component setHome = miniMessage.deserialize("""
            <b><red>▶セーブしよう！</red></b>
                        
            家を建てて保護をかけたらホーム拠点としてセーブしよう！
                        
            キーボードの<light_purple>/</light_purple>を押して
            <light_purple>sethome</light_purple>と入力して送信するとセーブされます
            死んだらセーブした場所で復活するので覚えておこう！
            
            <u><gold><click:run_command:'/sethome'>/sethomeを実行してみる</click></gold></u>
            """);
    private static final Component end = miniMessage.deserialize("""
            <b><red>▶最後に</red></b>
                        
            分からない事は<u><click:open_url:'https://morino.party'><gold>公式HP</gold></click></u>を確認するかサーバー内で質問してみよう！
                        
            <u><gold><click:open_url:'https://discord.gg/9HdanPM'>Discord</click></gold></u>で通話やチャットも盛んに行われています
            ぜひ参加してみんなで楽しくお話しましょう♪
                        
            それでは<color:#ff8cc0>まったりした生活</color>を楽しんでくださいね♫
            副管理人Unitarouより    
            """);
    @Override
    protected BookInterface buildInterface() {

        return BookInterface.builder()
                .addTransform(PaperTransform.bookText(
                        tableOfContents,
                        rule,
                        introduction,
                        town,
                        resource,
                        build,
                        setHome,
                        end
                        ))
                .build();
    }
}
