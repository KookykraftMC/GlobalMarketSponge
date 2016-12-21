package com.kookykraftmc.gm.listing;

import com.kookykraftmc.gm.GlobalMarket;
import com.kookykraftmc.gm.config.Configuration;
import com.kookykraftmc.gm.storage.SQL;
import org.slf4j.Logger;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.math.BigDecimal;

//Handles listings. Amazing.
public class ListingHandler {

    public static final String SQL_LISTING_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "listings ( " +
            "ID int, " +
            "UUID varchar(256), " +
            "ItemStack varchar(256), " +
            "Price REAL, " +
            "CreateTime int, " +
            "ExpiryTime int " +
            ");";

    private PluginContainer plugin;
    private Configuration config;
    private Logger logger;

    public ListingHandler(PluginContainer plugin, Configuration config, Logger logger) {
        this.plugin = plugin;
        this.config = config;
        this.logger = logger;
    }

    public Listing create(Player player, ItemStack item, BigDecimal price) {
        //Add to Storage
//        createSQLListing(player, item, price);

        return new Listing(player, item, price);
    }

    public boolean createSQLListing(Player player, ItemStack item, BigDecimal price) {
        SQL sql = new SQL(config.getConfig(), logger);
        String createListing = "INSERT INTO listings VALUES (" +
                "'1'," +
                "'" + player.getUniqueId() + "'," +
                "'" + item + "'," +
                "'" + price + "'," +
                "'" + "1230" + "'," +
                "'" + "1232" + "'" +
                ");";
        sql.execute(createListing, sql.getDataSource());

        return true;
    }

    boolean remove() {
        //na
        return false;
    }

    boolean expire() {
        //meh
        return false;
    }

    boolean list() {
        //ok
        return false;
    }

    boolean mail() {
        //wat
        return false;
    }
}
