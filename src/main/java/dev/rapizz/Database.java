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
        Dotenv dotenv = Dotenv.configure().load();
        DB_NAME = dotenv.get("DB_PORT");
        HOST = dotenv.get("DB_HOST");
        USER = dotenv.get("DB_USER");
        PORT = dotenv.get("DB_PORT");
        PASSWORD = dotenv.get("DB_PASSWORD");
    }

    /**
     * Enable a connection with the database
     * @throws SQLException if a database access error occurs
     * @throws ClassNotFoundException if the class cannot be located
     */
    private static void connection() throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Utils.Log.success("MySQL JDBC Driver");

            conn = DriverManager.getConnection(dbUrl, USER, PASSWORD);
            Utils.Log.success("✅ Connection Success !");
        } catch (ClassNotFoundException e) {
            Utils.Log.error("❌ Can't find the MySQL JDBC Driver !");
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            Utils.Log.error("❌ Connection Failed : " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Releases the connection with the database
     * @throws SQLException if a database access error occurs
     */
    private static void disconnection() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
                Utils.Log.success("✅ Disconnection Success !");
            }
        } catch (Exception e){
            Utils.Log.error("❌ Disconnection Failed !");
            throw e;
        }
    }

    /**
     * For SELECT statement
     * @param query the SELECT query to execute
     * @return a ResultSet object that contains the data produced by the given query or null
     * @throws SQLException if a database access error occurs
     * @throws ClassNotFoundException if the class cannot be located
     */
    public static ResultSet query(String query) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        try(Statement statement = conn.createStatement()) {
            connection();
            Utils.Log.info("SELECT statement: " + query + "\n");
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            Utils.Log.error("Problem occurred at select query operation : " + e);
            throw e;
        } finally {
            disconnection();
        }
        return resultSet;
    }

    /**
     * For INSERT, UPDATE, or DELETE statement
     * @param query the update query to execute
     * @throws SQLException if a database access error occurs
     * @throws ClassNotFoundException if the class cannot be located
     */
    public static void update(String query) throws SQLException, ClassNotFoundException {
        try(Statement statement = conn.createStatement()) {
            connection();
            Utils.Log.info("Update statement: " + query + "\n");
            //Run executeUpdate operation with given sql statement
            statement.executeUpdate(query);
        } catch (SQLException e) {
            Utils.Log.error("Problem occurred at update query operation : " + e);
            throw e;
        } finally {
            //Close connection
            disconnection();
        }
    }
}
