
package jp.minecraftuser.ecoworldauth.command;

import jp.minecraftuser.ecoframework.PluginFrame;
import jp.minecraftuser.ecoframework.CommandFrame;

import org.bukkit.command.CommandSender;

/**
 * ewa reloadコマンドクラス
 * @author ecolight
 */
public class EwaReloadCommand extends CommandFrame {

    /**
     * コンストラクタ
     * @param plg_ プラグインインスタンス
     * @param name_ コマンド名
     */
    public EwaReloadCommand(PluginFrame plg_, String name_) {
        super(plg_, name_);
        setAuthBlock(true);
        setAuthConsole(true);
    }

    /**
     * コマンド権限文字列設定
     * @return 権限文字列
     */
    @Override
    public String getPermissionString() {
        return "ecoworldauth.reload";
    }

    /**
     * 処理実行部
     * @param sender コマンド送信者
     * @param args パラメタ
     * @return コマンド処理成否
     */
    @Override
    public boolean worker(CommandSender sender, String[] args) {
        // リロード
        conf.reload();
        sender.sendMessage("[" + plg.getName()+"] コンフィグリロード");
        return true;
    }
    
}
