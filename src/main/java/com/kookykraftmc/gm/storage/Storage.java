package com.kookykraftmc.gm.storage;

import com.kookykraftmc.gm.config.Configuration;
import ninja.leaping.configurate.ConfigurationNode;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.sql.SqlService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class will manage all handling of storage of items. Interfacing with the SQL database or otherwise.
 */
public class Storage {
    private SqlService sql;
    Connection database;


    public DataSource getDataSource(String jdbcURL) throws SQLException {
        if (sql == null) {
            sql = Sponge.getServiceManager().provide(SqlService.class).get();
        }
        return sql.getDataSource(jdbcURL);
    }

    public void addListing() throws SQLException {
        Connection conn = getDataSource("").getConnection();

        try {
//            conn.prepareStatement("SELECT * FROM test_tbl").execute();
        } finally {
            conn.close();
        }
    }

    public String createURL(Configuration configuration) {
        ConfigurationNode config = configuration.getConfig();

        //A jdbc connection url is expected to be of the form:
        // jdbc:<engine>://[<username>[:<password>]@]<host>/<database>
        // or an alias (available aliases are known only by the service provider)
        String jdbcURL = "jdbc:sql://" + "sql" + "://" +
                config.getNode("Database", "Username") + ":" +
                config.getNode("Database", "Password") + "@" +
                config.getNode("Database", "Host") +
                config.getNode("Database", "Port");




        return null;
    }

}
