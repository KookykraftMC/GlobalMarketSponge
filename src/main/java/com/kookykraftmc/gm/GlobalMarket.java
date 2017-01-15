package com.kookykraftmc.gm;

import com.google.inject.Inject;
import com.kookykraftmc.gm.command.CommandHandler;
import com.kookykraftmc.gm.config.Configuration;
import com.kookykraftmc.gm.listing.ListingHandler;
import com.kookykraftmc.gm.storage.SQL;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePostInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.service.ChangeServiceProviderEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.service.economy.EconomyService;

import java.io.File;

@Plugin(name = "GlobalMarket", id = "globalmarket", version = "0.0.4,",
        description = "KKMC GlobalMarket Rewrite. Does market things.",
        authors = "SolarShrieking, TimeTheCat")
public class GlobalMarket {

    public static final String NAME = "GlobalMarket";

    @Inject
    private GlobalMarket plugin;

    @Inject
    private Game game;

    @Inject
    private Logger logger;

    public Configuration configuration;

    private EconomyService economyService;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private File defaultConfig;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private ConfigurationLoader<CommentedConfigurationNode> configManager;

    public static ListingHandler listingHandler;

    /**
     * Called when the GamePreInitializationEvent is triggered. Logger access available and configuration file location here
     * is available.
     *
     * @param event GamePreInitializationEvent
     */
    @Listener
    public void preInit(GamePreInitializationEvent event) {
        getLogger().info("GlobalMarket is now loading! Standby for critical failure.");
        //Setup Configuration
        configuration = new Configuration(this);
        configuration.loadConfig(logger);
    }

    /**
     * Called when the GameInitializationEvent is triggered. GlobalMarket should finish any work needed to be
     * functional. Global Event Handlers are registered here.
     *
     * @param event GameInitializationEvent
     */
    @Listener
    public void init(GameInitializationEvent event) {
        //Create & Register Commands.
        CommandHandler commandHandler = new CommandHandler();
        commandHandler.registerCommands(this);

        //Test SQL Connection
        SQL sql = new SQL(this);
        String test = "SELECT 1";
        sql.execute(test, sql.getDataSource());

        //Create Listings Table
        listingHandler = new ListingHandler(this);
        SQL sql2 = new SQL(this);
        sql2.execute(ListingHandler.SQL_LISTING_TABLE_CREATE, sql2.getDataSource());
    }

    /**
     * Called when the GamePostInitializationEvent is triggered. Inter-plugin communication can happen, external API
     * calls are now allowed.
     *
     * @param event GamePostInitializationEvent
     */
    @Listener
    public void postInit(GamePostInitializationEvent event) {

    }

    /**
     * Sets the logger. As expected.
     *
     * @param logger The Logger
     */
    @Inject
    private void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Returns the logger. Use this for all logger calls, ex getLogger().info("Rekt")
     *
     * @return logger - The plugin's instance of logger.
     */
    public Logger getLogger() {
        return logger;
    }

    public GlobalMarket getPlugin() {
        return plugin;
    }

    public Game getGame() {
        return game;
    }

    @Listener
    public void onChangeServiceProvider(ChangeServiceProviderEvent event) {
        if (event.getService().equals(EconomyService.class))
            economyService = (EconomyService) event.getNewProviderRegistration().getProvider();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public ConfigurationLoader<CommentedConfigurationNode> getConfigManager() {
        return configManager;
    }

    public File getDefaultConfig() {
        return defaultConfig;
    }
}
