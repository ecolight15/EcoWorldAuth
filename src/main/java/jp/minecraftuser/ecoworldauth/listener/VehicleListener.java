
package jp.minecraftuser.ecoworldauth.listener;

import jp.minecraftuser.ecoframework.PluginFrame;
import jp.minecraftuser.ecoframework.ListenerFrame;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

/**
 * 乗り物系処理リスナークラス
 * @author ecolight
 */
public class VehicleListener extends ListenerFrame {

    /**
     * コンストラクタ
     * @param plg_ プラグインインスタンス
     * @param name_ 名前
     */
    public VehicleListener(PluginFrame plg_, String name_) {
        super(plg_, name_);
    }

    /**
     * 乗り物ダメージイベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void VehicleDamageEvent(VehicleDamageEvent event)
    {
        Entity e = event.getAttacker();
        if (e instanceof Player) {
            if (conf.getBoolean("event-logging")) {
                log.info(event.toString());
            }
            if (!((Player)e).isPermissionSet("ewa.vehicle.damage")) {
                event.setCancelled(true);
            }
        } else if (e instanceof Projectile) {
            if (((Projectile) e).getShooter() instanceof Player) {
                if (conf.getBoolean("event-logging")) {
                    log.info(event.toString());
                }
                if (!((Player)((Projectile) e).getShooter()).isPermissionSet("ewa.vehicle.damage")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    /**
     * 乗り物破壊イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void VehicleDestroyEvent(VehicleDestroyEvent event)
    {
        Entity e = event.getAttacker();
        if (e instanceof Player) {
            if (conf.getBoolean("event-logging")) {
                log.info(event.toString());
            }
            if (!((Player)e).isPermissionSet("ewa.vehicle.destroy")) {
                event.setCancelled(true);
            }
        } else if (e instanceof Projectile) {
            if (((Projectile) e).getShooter() instanceof Player) {
                if (conf.getBoolean("event-logging")) {
                    log.info(event.toString());
                }
                if (!((Player)((Projectile) e).getShooter()).isPermissionSet("ewa.vehicle.destroy")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    /**
     * 乗り物乗車イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void VehicleEnterEvent(VehicleEnterEvent event)
    {
        Entity e = event.getEntered();
        if (e instanceof Player) {
            if (conf.getBoolean("event-logging")) {
                log.info(event.toString());
            }
            if (!e.isPermissionSet("ewa.vehicle.enter")) {
                event.setCancelled(true);
            }
        }
    }

    /**
     * 乗り物接触イベント処理
     * このメソッドでは、自分が車両に対してぶつかった際の権限を判定する（乗っている側ではない）
     * @param event イベント情報
     */
    @EventHandler
    public void VehicleEntityCollisionEvent(VehicleEntityCollisionEvent event)
    {
        Entity e = event.getEntity();
        if (e instanceof Player) {
            if (conf.getBoolean("event-logging")) {
                log.info(event.toString());
            }
            if (!e.isPermissionSet("ewa.vehicle.collision")) {
                event.setCancelled(true);
            }
        }
    }

}
