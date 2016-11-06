package com.kookykraftmc.gm;

import com.google.inject.Inject;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * Created by TimeTheCat on 11/6/2016.
 */
@Plugin(name = "GlobalMarket", id = "globalmarket", version = "0.0.1")
public class GlobalMarket {

    @Inject
    private Logger logger;

    @Inject
    @ConfigDir(sharedRoot = false)
    private File cfgDir;

    @Inject
    @ConfigDir(sharedRoot = false)
    private File defaultCfg;

    @Inject
    @ConfigDir(sharedRoot = false)
    private ConfigurationLoader<CommentedConfigurationNode> loader;

    @Inject
    @ConfigDir(sharedRoot = false)
    private File dataCfgDir;

    @Inject
    @ConfigDir(sharedRoot = false)
    private File dataDefaultCfg;

    private ConfigurationNode cfg;
    private ConfigurationNode cfgData;

    Game game = Sponge.getGame();

    @Listener
    public void preInit(GamePreInitializationEvent event) {
        makeConfig();
    }

    public void addItemToData(ItemStack stack, Integer price) {
        try {
            cfgData = loader.load();
            int id = cfgData.getNode("data", "last-id").getInt();
            if (id == 0) {
                cfg.getNode("data", "last-id").setValue(1);
            }
            if (!dataDefaultCfg.exists()) {
                cfgData.getNode("data").setValue(18);
                loader.save(cfgData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void makeConfig() {
        try {
            cfg = loader.load();
            if (!defaultCfg.exists()) {
                cfg.getNode("stack-slots").setValue(18);
                cfg.getNode("stack-slots-max").setValue("320");
                cfg.getNode("tax").setValue(0.05);
                cfg.getNode("command-name").setValue("market");
                cfg.getNode("enable-server-listings").setValue("true");
                loader.save(cfg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
