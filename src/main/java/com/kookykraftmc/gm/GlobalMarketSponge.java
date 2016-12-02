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
import org.spongepowered.api.event.game.state.*;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.plugin.Plugin;

import java.io.File;
import java.io.IOException;

@Plugin(name = "GlobalMarket", id = "globalmarket.kkmc", version = "0.0.1")
public class GlobalMarketSponge {

    @Inject
    private Logger logger;

    Game game = Sponge.getGame();


    /**
     * Called when the GameConstructionEvent is triggered. @Plugin is called here.
     * @param event GameConstructionEvent
     */
    @Listener
    public void prePreInit(GameConstructionEvent event) {
        //Probably nothing here.
    }

    /**
     * Called when the GamePreInitializationEvent is triggered. Logger access available and config file location here
     *      is available.
     * @param event GamePreInitializationEvent
     */
    @Listener
    public void preInit(GamePreInitializationEvent event) {
        getLogger().info("GlobalMarket is now loading! Standby for critical failure.");
    }

    /**
     * Called when the GameInitializationEvent is triggered. GlobalMarket should finish any work needed to be
     *      functional. Global Event Handlers are registered here.
     * @param event GameInitializationEvent
     */
    @Listener
    public void init(GameInitializationEvent event) {

    }

    /**
     * Called when the GamePostInitializationEvent is triggered. Inter-plugin communication can happen, external API
     *      calls are now allowed.
     * @param event GamePostInitializationEvent
     */
    @Listener
    public void postInit(GamePostInitializationEvent event) {

    }

    /**
     * Called when the GameLoadCompleteEvent is triggered. All plugins should now be done loading.
     * @param event GameLoadCompleteEvent
     */
    @Listener
    public void loadComplete(GameLoadCompleteEvent event) {
        //Probably nothing here.
    }


    /**
     * Sets the logger. As expected.
     * @param logger    The Logger
     */
    @Inject
    private void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Returns the logger. Use this for all logger calls, ex getLogger().info("Rekt")
     * @return logger - The plugin's instance of logger.
     */
    public Logger getLogger() {
        return logger;
    }

}
