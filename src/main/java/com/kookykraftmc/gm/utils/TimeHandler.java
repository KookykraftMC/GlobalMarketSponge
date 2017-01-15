package com.kookykraftmc.gm.utils;

import com.kookykraftmc.gm.GlobalMarket;
import com.kookykraftmc.gm.storage.SQL;
import org.spongepowered.api.plugin.PluginContainer;

/**
 * This class should handle most things related to the expiry time and creation time of new Listings.
 * It will be referenced when parsing times from the SQL database as well.
 */
public class TimeHandler {

    private GlobalMarket plugin;

    public TimeHandler(GlobalMarket plugin) {
        this.plugin = plugin;
    }

    public String parseSQLTime() {
        SQL sql = new SQL(plugin);



        return null;
    }

}
