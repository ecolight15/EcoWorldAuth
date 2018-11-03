
package jp.minecraftuser.ecoworldauth.listener;

import jp.minecraftuser.ecoframework.PluginFrame;
import jp.minecraftuser.ecoframework.ListenerFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;

/**
 * プレイヤーイベント処理リスナークラス
 * @author ecolight
 */
public class PlayerListener extends ListenerFrame {

    /**
     * コンストラクタ
     * @param plg_ プラグインインスタンス
     * @param name_ 名前
     */
    public PlayerListener(PluginFrame plg_, String name_) {
        super(plg_, name_);
    }

    /**
     * アーマースタンド編集イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void PlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.player.armor_stand_manipulate")) {
            event.setCancelled(true);
        }
    }

    /**
     * バケツ使用イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void PlayerBucketEmptyEvent(PlayerBucketEmptyEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.player.bucket_empty")) {
            event.setCancelled(true);
        }
    }

    /**
     * バケツ汲み取りイベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void PlayerBucketFillEvent(PlayerBucketFillEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.player.bucket_fill")) {
            event.setCancelled(true);
        }
    }

    /**
     * アイテムドロップイベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void PlayerDropItemEvent(PlayerDropItemEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.player.drop_item")) {
            event.setCancelled(true);
        }
    }

    /**
     * エンティティへの操作イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.player.interact_entity")) {
            event.setCancelled(true);
        }
    }

    /**
     * 操作イベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.player.interact")) {
            event.setCancelled(true);
        }
    }

    /**
     * 矢を拾う際のイベント処理
     * @param event イベント情報
     */
    @EventHandler
    public void PlayerPickupArrowEvent(PlayerPickupArrowEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.player.pickup_arrow")) {
            event.setCancelled(true);
        }
    }

}
