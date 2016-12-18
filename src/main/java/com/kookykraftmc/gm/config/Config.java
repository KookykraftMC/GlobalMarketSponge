package com.kookykraftmc.gm.config;

import com.kookykraftmc.gm.GlobalMarket;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.plugin.PluginContainer;

import java.io.File;
import java.io.IOException;

public class Config {
//    PluginContainer gm = GlobalMarket.plugin;
//    File defaultConfig = GlobalMarket.getDefaultConfig();
//    ConfigurationLoader<CommentedConfigurationNode> configManager = GlobalMarket.getConfigManager();
//    ConfigurationNode config = GlobalMarket.config;
//
//
//    public void loadConfig() {
//        try {
//
//            if(!defaultConfig.exists()) {
//                defaultConfig.createNewFile();
//                config = configManager.load();
//
//                config.getNode("ConfigVersion").setValue(1);
//
//                config.getNode("Database", "Host").setValue("127.0.0.1");
//                config.getNode("Database", "Port").setValue(3306);
//                config.getNode("Database", "Username").setValue("username");
//                config.getNode("Database", "Password").setValue("password");
//                config.getNode("Database", "Configured").setValue(false);
//                configManager.save(this.config);
//                gm.getLogger().info("Created default config!");
//
//            }
//
//            this.config = configManager.load();
//        } catch (IOException e) {
//            gm.getLogger().error("Couldn't create default configuration file!");
//            gm.getLogger().error(e.getStackTrace().toString());
//        }
//    }
}
