package com.kookykraftmc.gm.storage;

import com.kookykraftmc.gm.config.Configuration;
import ninja.leaping.configurate.ConfigurationNode;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.sql.SqlService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQL {

    /**
     * To get a SQL Connection:
     * Create a jdbcURL
     * Create a DataSource
     * Create a Command to be executed
     * Execute the command - This opens the connection, executes, then closes
     *
     * Example:
     * SQL sql        = new SQL(config, true, logger);
     * String command = "SQL COMMAND";
     * sql.execute(commmand, sql.getDataSource();
     */

    private String jdbcURL;
    private SqlService sql;
    private DataSource dataSource;
    private Logger logger;


    /**
     *
     * @param config        The Existing Configuration Object
     * @param defaultURL    Use config-defined database. Usually, if not always, true.
     * @param logger        Logger instance.
     */
    public SQL(ConfigurationNode config, boolean defaultURL, Logger logger) {
        this.logger = logger;

        if (defaultURL) {
            jdbcURL = createURL(config);

            try {
                dataSource = getDataSource(jdbcURL);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Creates the jdbc URL and returns it.
     *
     * @return jdbcURL.
     */
    private String createURL(ConfigurationNode config) {

        String hostname = config.getNode("Database", "Host").getValue().toString();
        String port     = config.getNode("Database", "Port").getValue().toString();
        String database = config.getNode("Database", "Database").getValue().toString();
        String username = config.getNode("Database", "Username").getValue().toString();
        String password = config.getNode("Database", "Password").getValue().toString();

        return "jdbc:mysql://" + hostname + ":" +
                port + "/" + database + "?user=" +
                username + "&password=" + password;
    }

    /**
     * Gets the DataSource.
     *
     * @param jdbcURL       The jdbcURL.
     * @return              DataSource.
     * @throws SQLException One would hope not.
     */
    public DataSource getDataSource(String jdbcURL) throws SQLException {
        if (sql == null) {
            sql = Sponge.getServiceManager().provide(SqlService.class).get();
        }
        return sql.getDataSource(jdbcURL);
    }

    //Shorthand method. Only use if using the shortcut SQL Constructor.
    public DataSource getDataSource() {
        return this.dataSource;
    }

    /**
     * Creates the connection, Executes the command, Closes the connection.
     *
     * @param command       Command to be executed in the SQL Database
     * @param dataSource    Datasource.
     */
    public boolean execute(String command, DataSource dataSource) {
        try {
            Connection conn = dataSource.getConnection();
            Statement statement = conn.createStatement();
            statement.execute(command);
            statement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public String initTable() {
        return "CREATE TABLE IF NOT EXISTS GlobalMarket " + "(UUID VARCHAR(256) PRIMARY KEY NOT NULL)";
    }

}
