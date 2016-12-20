package com.kookykraftmc.gm.config;

import com.google.inject.Inject;
import com.kookykraftmc.gm.GlobalMarket;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.plugin.PluginContainer;

import java.io.File;
import java.io.IOException;

public class Config {

    private File defaultConfig;

    private ConfigurationLoader<CommentedConfigurationNode> configManager;

    private ConfigurationNode config = null;

    private PluginContainer plugin;

    public Config(PluginContainer plugin, File defaultConfig, ConfigurationLoader<CommentedConfigurationNode> configManager) {
        this.plugin = plugin;
        this.defaultConfig = defaultConfig;
        this.configManager = configManager;

        loadConfig();
    }

    private void loadConfig() {

        try {

            if(!defaultConfig.exists()) {
                defaultConfig.createNewFile();
                config = configManager.load();

                config.getNode("ConfigVersion").setValue(1);

                config.getNode("Database", "Host").setValue("127.0.0.1");
                config.getNode("Database", "Port").setValue(3306);
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
}
