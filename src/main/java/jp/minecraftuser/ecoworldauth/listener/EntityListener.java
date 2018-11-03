
package jp.minecraftuser.ecoworldauth.listener;

import jp.minecraftuser.ecoframework.PluginFrame;
import jp.minecraftuser.ecoframework.ListenerFrame;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;

/**
 * エンティティ系イベント処理リスナークラス
 * @author ecolight
 */
public class EntityListener extends ListenerFrame {

    /**
     * コンストラクタ
     * @param plg_ プラグインインスタンス
     * @param name_ 名前
     */
    public EntityListener(PluginFrame plg_, String name_) {
        super(plg_, name_);
    }

    /**
     * 壁掛け破壊イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void EntityPickupItemEvent(EntityPickupItemEvent event)
    {
        Entity e = event.getEntity();
        if (e instanceof Player) {
            if (conf.getBoolean("event-logging")) {
                log.info(event.toString());
            }
            if (!((Player)e).isPermissionSet("ewa.player.pickup_item")) {
                event.setCancelled(true);
            }
        }
    }

}
