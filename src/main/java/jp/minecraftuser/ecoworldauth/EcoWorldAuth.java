package jp.minecraftuser.ecoworldauth;

import jp.minecraftuser.ecoframework.PluginFrame;
import jp.minecraftuser.ecoframework.CommandFrame;
import jp.minecraftuser.ecoworldauth.command.EwaCommand;
import jp.minecraftuser.ecoworldauth.command.EwaReloadCommand;
import jp.minecraftuser.ecoworldauth.listener.BlockListener;
import jp.minecraftuser.ecoworldauth.listener.EntityListener;
import jp.minecraftuser.ecoworldauth.listener.HangingListener;
import jp.minecraftuser.ecoworldauth.listener.InventoryListener;
import jp.minecraftuser.ecoworldauth.listener.PlayerListener;
import jp.minecraftuser.ecoworldauth.listener.VehicleListener;

/**
 * EcoUserManagerメインクラス
 * @author ecolight
 */
public class EcoWorldAuth extends PluginFrame {
    
    /**
     * プラグイン起動
     */
    @Override
    public void onEnable() {
        initialize();
    }

    /**
     * プラグイン停止
     */
    @Override
    public void onDisable()
    {
        disable();
    }

    /**
     * 設定初期化
     */
    @Override
    public void initializeConfig() {
        EcoWorldAuthConfig conf = new EcoWorldAuthConfig(this);
        conf.registerBoolean("event-logging");
        registerPluginConfig(conf);
    }

    /**
     * コマンド初期化
     */
    @Override
    public void initializeCommand() {
        CommandFrame cmd = new EwaCommand(this, "ewa");
        cmd.addCommand(new EwaReloadCommand(this, "reload"));
        registerPluginCommand(cmd);
    }

    /**
     * リスナ初期化
     */
    @Override
    public void initializeListener() {
        registerPluginListener(new BlockListener(this, "block"));
        registerPluginListener(new EntityListener(this, "entity"));
        registerPluginListener(new HangingListener(this, "hanging"));
        registerPluginListener(new InventoryListener(this, "inventory"));
        registerPluginListener(new PlayerListener(this, "player"));
        registerPluginListener(new VehicleListener(this, "vehicle"));
    }

}