
package jp.minecraftuser.ecoworldauth.listener;

import jp.minecraftuser.ecoframework.PluginFrame;
import jp.minecraftuser.ecoframework.ListenerFrame;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;

/**
 * 壁掛け系イベント処理リスナークラス
 * @author ecolight
 */
public class HangingListener extends ListenerFrame {

    /**
     * コンストラクタ
     * @param plg_ プラグインインスタンス
     * @param name_ 名前
     */
    public HangingListener(PluginFrame plg_, String name_) {
        super(plg_, name_);
    }

    /**
     * 壁掛け破壊イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void HangingBreakByEntityEvent(HangingBreakByEntityEvent event)
    {
        Entity e = event.getRemover();
        if (e instanceof Player) {
            if (conf.getBoolean("event-logging")) {
                log.info(event.toString());
            }
            if (!((Player)e).isPermissionSet("ewa.hanging.break")) {
                event.setCancelled(true);
            }
        } else if (e instanceof Projectile) {
            if (((Projectile) e).getShooter() instanceof Player) {
                if (conf.getBoolean("event-logging")) {
                    log.info(event.toString());
                }
                if (!((Player)((Projectile) e).getShooter()).isPermissionSet("ewa.hanging.break")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    /**
     * 壁掛け設置イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void HangingPlaceEvent(HangingPlaceEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.hanging.place")) {
            event.setCancelled(true);
        }
    }
}
