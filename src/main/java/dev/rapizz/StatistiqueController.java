package dev.rapizz;

import dev.rapizz.model.Command;
import dev.rapizz.model.CommandDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatistiqueController {
    @FXML
    private Text chiffreAffaires;
    @FXML
    private Text bestClient;
    @FXML
    private Text bestLivreur;
    @FXML
    private Text worstLivreur;
    @FXML
    private Text bestVehicle;
    @FXML
    private Text bestPizza;
    @FXML
    private Text worstPizza;
    @FXML
    private Text favouriteIngredient;

    @FXML
    public void initialize() {
        initGlobalStats();
    }

    private void initGlobalStats() {
        chiffreAffaires.setText(getCA() + " €");
    }

    private String getCA() {
        try(ResultSet rs = ConnectionManager.query("SELECT SUM(price) AS chiffre_affaire FROM Command WHERE status = 'finish'")) {
            if (rs.next()) {
                return rs.getString("chiffre_affaire");
            }
        } catch (SQLException e){
            Utils.Log.error("get", e);
        }
        return null;
    }


}
