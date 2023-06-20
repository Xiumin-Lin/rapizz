package dev.rapizz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionController {
    public enum ActionType {SHOW_DB, CREATE_DB, ADD_DATA_BD, DROP_DB}
    private final Label connStateLabel;
    private final ActionType actionType;
    @FXML
    private TableView<String> mainTableView;

    public ConnectionController(Label label, ActionType type) {
        this.connStateLabel = label;
        this.actionType = type;
    }

    @FXML
    public void initialize() {
        try {
            switch (actionType) {
                case ADD_DATA_BD -> addDataScript();
                case DROP_DB -> dropTablesScript();
                case CREATE_DB -> createTablesScript();
            }

            String query = Connection.readSQLFile(getClass().getResource("sql/ShowDatabase.sql"));
            ResultSet rs = Connection.query(query);

            if(rs == null) {
                connStateLabel.setText("No results !");
                connStateLabel.setTextFill(Color.ORANGE);
                mainTableView.setPlaceholder(new Label("No rows to display"));
                return;
            }
            connStateLabel.setText("Success !");
            connStateLabel.setTextFill(Color.GREEN);

            Utils.populateTableView(mainTableView, rs);
        } catch (SQLException | IOException e) {
            connStateLabel.setText("Failed !");
            connStateLabel.setTextFill(Color.RED);
            Utils.Log.error("Error when initialize ConnectionController.", e);
        } finally {
            Connection.disconnect();
        }
    }

    public void createTablesScript() throws SQLException, IOException {
        Connection.executeSQLScript(getClass().getResource("sql/CreationTablesScript.sql"));

        Connection.executeSQLScript(getClass().getResource("sql/AddProcedureAndTriggersScript.sql"), "::");
    }

    public void addDataScript() throws SQLException, IOException {
        Connection.executeSQLScript(getClass().getResource("sql/AddDataScript.sql"));
    }

    public void dropTablesScript() throws SQLException, IOException {
        Connection.executeSQLScript(getClass().getResource("sql/DropTablesScript.sql"));
    }
}
