
package jp.minecraftuser.ecoworldauth.listener;

import jp.minecraftuser.ecoframework.PluginFrame;
import jp.minecraftuser.ecoframework.ListenerFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * ブロック系イベント処理リスナークラス
 * @author ecolight
 */
public class BlockListener extends ListenerFrame {

    /**
     * コンストラクタ
     * @param plg_ プラグインインスタンス
     * @param name_ 名前
     */
    public BlockListener(PluginFrame plg_, String name_) {
        super(plg_, name_);
    }

    /**
     * ブロック破壊イベント処理
     * @param event イベント情報
     */
    @EventHandler(ignoreCancelled = true)
    public void BlockBreakEvent(BlockBreakEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.block.break." + event.getBlock().getType().name())) {
            event.setCancelled(true);
        }
    }

    /**
     * ブロック破壊イベント処理
     * @param event イベント情報
     */
    @EventHandler(ignoreCancelled = true)
    public void BlockPlaceEvent(BlockPlaceEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.block.place." + event.getBlock().getType().name())) {
            event.setCancelled(true);
        }
    }

    /**
     * ブロックが殴られた際のイベント処理
     * BlockBreakと役割は被るが、ダメージ表現ごと無効化する場合にはこちらでガードする
     * @param event イベント情報
     */
    @EventHandler(ignoreCancelled = true)
    public void BlockDamageEvent(BlockDamageEvent event)
    {
        if (conf.getBoolean("event-logging")) {
            log.info(event.toString());
        }
        if (!event.getPlayer().isPermissionSet("ewa.block.blockdamage." + event.getBlock().getType().name())) {
            event.setCancelled(true);
        }
    }
    
    /**
     * ブロック着火イベント処理
     * @param event イベント情報
     */
    @EventHandler(ignoreCancelled = true)
    public void BlockIgniteEvent(BlockIgniteEvent event)
    {
        if (event.getCause().equals(IgniteCause.FLINT_AND_STEEL)) {
            if (conf.getBoolean("event-logging")) {
                log.info(event.toString());
            }
            if (!event.getPlayer().isPermissionSet("ewa.block.blockignite." + event.getBlock().getType().name())) {
                event.setCancelled(true);
            }
        }
    }

}
