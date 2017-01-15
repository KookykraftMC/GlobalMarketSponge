package com.kookykraftmc.gm.listing;

import com.kookykraftmc.gm.GlobalMarket;
import com.kookykraftmc.gm.config.Configuration;
import com.kookykraftmc.gm.storage.SQL;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private GlobalMarket plugin;

    public ListingHandler(GlobalMarket plugin) {
        this.plugin = plugin;
    }

    public Listing create(Player player, ItemStack item, BigDecimal price, DataContainer cItem,
                          String creationTime, String expiryTime) {
        //Add to Storage
        createSQLListing(player, cItem, price, creationTime, expiryTime);


        return new Listing(player, item, price, "", ""); //TODO: Put shit here.
    }

    public boolean createSQLListing(Player player, DataContainer item, BigDecimal price,
                                    String creationTime, String expiryTime) {
        SQL sql = new SQL(plugin);
        String createListing = "INSERT INTO listings VALUES (" +
                "'1'," +
                "'" + player.getUniqueId() + "'," +
                "'" + item + "'," +
                "'" + price + "'," +
                "'" + getTime() + "'," +
                "'" + "" + "'" +
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

    private String getTime()  {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    }

    private String initExpiry() {
        return new SimpleDateFormat("yyy-MM-dd HH:mm").format(new Date());
    }
}
