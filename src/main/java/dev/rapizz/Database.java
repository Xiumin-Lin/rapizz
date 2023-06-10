package dev.rapizz;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class Database {
    // ----- CONNECTION CONSTANTS -----
    public static final String DB_NAME;
    public static final String HOST;
    public static final String PORT;
    public static final String USER;
    private static final String PASSWORD;
    // ----- Attributs -----
    private static Connection conn;

    static {
        Dotenv dotenv = Dotenv.configure().directory("./src/main/resources").load();
        DB_NAME = dotenv.get("DB_NAME");
        HOST = dotenv.get("DB_HOST");
        USER = dotenv.get("DB_USER");
        PORT = dotenv.get("DB_PORT");
        PASSWORD = dotenv.get("DB_PASSWORD");
    }

    /**
     * Enable a connection with the database
     * @throws SQLException if a database access error occurs
     */
    private static void connect() throws SQLException {
        String dbUrl = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Utils.Log.success("URL : " + dbUrl);

        try {
//            Class.forName("com.mysql.jdbc.Driver"); // no need with JDBC 4.0
//            Utils.Log.success("MySQL JDBC Driver");
            conn = DriverManager.getConnection(dbUrl, USER, PASSWORD);
            Utils.Log.success("Connection Success !");
//        } catch (ClassNotFoundException e) {
//            Utils.Log.error("Can't find the MySQL JDBC Driver !");
//            e.printStackTrace();
//            throw e;
        } catch (SQLException e) {
            Utils.Log.error("Connection Failed", e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Releases the connection with the database
     */
    public static void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
                Utils.Log.success("Disconnection Success !");
            }
        } catch (SQLException e){
            Utils.Log.error("Disconnection Failed !", e);
        }
    }

    /**
     * For SELECT statement
     * @param query the SELECT query to execute
     * @return a ResultSet object that contains the data produced by the given query or null
     * @throws SQLException if a database access error occurs
     */
    public static ResultSet query(String query) throws SQLException {
        ResultSet resultSet;
        try {
            connect();
            Statement statement = conn.createStatement();
            Utils.Log.info("SELECT statement: " + query + "\n");
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            Utils.Log.error("Problem occurred at select query operation", e);
            throw e;
        }
        return resultSet;
    }

    /**
     * For INSERT, UPDATE, or DELETE statement
     * @param query the update query to execute
     * @throws SQLException if a database access error occurs
     */
    public static void update(String query) throws SQLException {
        try {
            connect();
            Statement statement = conn.createStatement();
            Utils.Log.info("Update statement: " + query + "\n");
            // Run executeUpdate operation with given sql statement
            statement.executeUpdate(query);
        } catch (SQLException e) {
            Utils.Log.error("Problem occurred at update query operation : " + e);
            throw e;
        } finally {
            disconnect();
        }
    }
}
