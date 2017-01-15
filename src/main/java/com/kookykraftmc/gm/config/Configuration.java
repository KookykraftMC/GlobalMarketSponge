package com.kookykraftmc.gm.config;

import com.kookykraftmc.gm.GlobalMarket;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

public class Configuration {

    private File defaultConfig;

    private ConfigurationLoader<CommentedConfigurationNode> configManager;

    private ConfigurationNode config;

    private GlobalMarket plugin;

    public Configuration(GlobalMarket plugin) {
        this.plugin = plugin;
        this.defaultConfig = plugin.getDefaultConfig();
        this.configManager = plugin.getConfigManager();
    }

    public void loadConfig(Logger logger) {

        try {

            if(!defaultConfig.exists()) {
                logger.info("No configuration file. Generating now.");
                defaultConfig.createNewFile();
                config = configManager.load();

                config.getNode("ConfigVersion").setValue(1);

                config.getNode("Database", "Host").setValue("127.0.0.1");
                config.getNode("Database", "Port").setValue(3306);
                config.getNode("Database", "Database").setValue("globalmarket");
                config.getNode("Database", "Username").setValue("username");
                config.getNode("Database", "Password").setValue("password");
                config.getNode("Database", "Configured").setValue(false);
                configManager.save(config);
                plugin.getLogger().info("Created default config!");

            }

            config = configManager.load();
        } catch (IOException e) {
            plugin.getLogger().error("Couldn't create default configuration file!");
            plugin.getLogger().error(e.getStackTrace().toString());
        }
    }

    public File getDefaultConfig() {
        return defaultConfig;
    }

    public ConfigurationLoader<CommentedConfigurationNode> getConfigManager() {
        return configManager;
    }

    public ConfigurationNode getConfig() {
        return config;
    }

    /**
     * Fetches information from the config. Requires an instantiated ConfigurationNode
     * in the SQL class.
     *
     * @param key   Main Key.
     * @param val   SubKey/Value.
     * @return Value under SubKey.
     */
    public String getDetail(String key, String val) {
        return config.getNode(key, val).getString();
    }
}
