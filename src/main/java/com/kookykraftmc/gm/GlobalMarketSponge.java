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

@Plugin(name = "GlobalMarket", id = "globalmarket.kkmc", version = "0.0.1")
public class GlobalMarketSponge {

    @Inject
    private Logger logger;

    Game game = Sponge.getGame();

    @Listener
    public void preInit(GamePreInitializationEvent event) {

    }

}