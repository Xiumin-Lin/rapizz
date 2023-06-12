package dev.rapizz;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Utils {
    public static class Log {
        private static final PrintStream out = System.out;
        private static final PrintStream err = System.err;
        public static void info(String msg) {
            out.println("[Info] " + msg);
        }

        public static void success(String msg) {
            out.println("[OK] " + msg);
        }

        public static void error(String msg) {
            err.println("[KO] " + msg);
        }

        public static void error(String msg, Exception e) {
            error(msg);
            if(e == null) return;
            e.printStackTrace(err);
            err.println("Message: " + e.getMessage());
        }

        public static void error(String msg, SQLException e) {
            error(msg);
            if(e == null) return;
            e.printStackTrace(err);
            err.println("SQLState: " + e.getSQLState());
            err.println("Error Code: " + e.getErrorCode());
            err.println("Message: " + e.getMessage());
        }
    }

    public static void populateTableView(TableView<String> tableView, ResultSet rs) throws SQLException {
        // Clear existing columns
        tableView.getColumns().clear();

        // Create a column for each column of the ResultSet
        ResultSetMetaData metaData = rs.getMetaData();
        int numColumns = metaData.getColumnCount();
        for (int i = 1; i <= numColumns; i++) {
            final int columnIndex = i;
            TableColumn<String, String> column = new TableColumn<>(metaData.getColumnName(i));
            column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().split(",")[columnIndex - 1]));
            tableView.getColumns().add(column);
        }

        // Add values of ResultSet to TableView
        ObservableList<String> data = FXCollections.observableArrayList();
        while (rs.next()) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int i = 1; i <= numColumns; i++) {
                rowBuilder.append(rs.getString(i));
                if (i != numColumns) {
                    rowBuilder.append(",");
                }
            }
            data.add(rowBuilder.toString());
        }
        tableView.setItems(data);
    }
}
