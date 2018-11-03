
package jp.minecraftuser.ecoworldauth.listener;

import jp.minecraftuser.ecoframework.PluginFrame;
import jp.minecraftuser.ecoframework.ListenerFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryOpenEvent;

/**
 * インベントリ系処理リスナークラス
 * @author ecolight
 */
public class InventoryListener extends ListenerFrame {

    /**
     * コンストラクタ
     * @param plg_ プラグインインスタンス
     * @param name_ 名前
     */
    public InventoryListener(PluginFrame plg_, String name_) {
        super(plg_, name_);
    }

    /**
     * インベントリを開くイベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void InventoryOpenEvent(InventoryOpenEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.inventory.open")) {
            event.setCancelled(true);
        }
    }

}
