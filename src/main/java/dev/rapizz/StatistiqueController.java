package dev.rapizz;

import dev.rapizz.model.Command;
import dev.rapizz.model.CommandDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.io.IOException;
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
        chiffreAffaires.setText(getCA());
        bestClient.setText(getBestClient());
        bestLivreur.setText(getBestLivreur());
        worstLivreur.setText(getWorstLivreur());
        bestVehicle.setText(getBestVehicle());
        bestPizza.setText(getBestPizza());
        worstPizza.setText(getWorstPizza());
        favouriteIngredient.setText(getFavIngredient());
    }

    private String getCA() {
        try(ResultSet rs = ConnectionManager.query("SELECT SUM(price) AS chiffre_affaire FROM Command WHERE status = 'finish'")) {
            if (rs.next()) {
                return rs.getString("chiffre_affaire") + " €";
            }
        } catch (SQLException e){
            Utils.Log.error("Error on getCA()", e);
        }
        return null;
    }

    private String getBestClient() {
        try(ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/one/BestClient.sql"))) {
            if (rs.next()) {
                String name = rs.getString("name");
                int total_amount = rs.getInt("total_amount");
                return name + " (" + total_amount + " €)";
            }
        } catch (Exception e){
            Utils.Log.error("Error on getBestClient()", e);
        }
        return null;
    }

    private String getBestLivreur() {
        try(ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/one/BestLivreur.sql"))) {
            if (rs.next()) {
                String name = rs.getString("name");
                int nb_livraison = rs.getInt("nb_livraison");
                return name + " (" + nb_livraison + " livraisons réussies)";
            }
        } catch (Exception e){
            Utils.Log.error("Error on getBestLivreur()", e);
        }
        return null;
    }

    private String getWorstLivreur() {
        try(ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/one/WorstLivreur.sql"))) {
            if (rs.next()) {
                String name = rs.getString("name");
                int nb_retards = rs.getInt("nb_retards");
                return name + " (" + nb_retards + " retards)";
            }
        } catch (Exception e){
            Utils.Log.error("Error on getWorstLivreur()", e);
        }
        return null;
    }

    private String getBestVehicle() {
        try(ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/one/BestVehicle.sql"))) {
            if (rs.next()) {
                String name = rs.getString("name");
                int nb_utilisations = rs.getInt("nb_utilisations");
                return name + " (" + nb_utilisations + " utilisations)";
            }
        } catch (Exception e){
            Utils.Log.error("Error on getBestVehicle()", e);
        }
        return null;
    }

    private String getBestPizza() {
        try(ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/one/BestPizza.sql"))) {
            if (rs.next()) {
                String name = rs.getString("name");
                int nb_commandes = rs.getInt("nb_commandes");
                return name + " (" + nb_commandes + " commandes)";
            }
        } catch (Exception e){
            Utils.Log.error("Error on getBestPizza()", e);
        }
        return null;
    }

    private String getWorstPizza() {
        try(ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/one/WorstPizza.sql"))) {
            if (rs.next()) {
                String name = rs.getString("name");
                int nb_commandes = rs.getInt("nb_commandes");
                return name + " (" + nb_commandes + " commandes)";
            }
        } catch (Exception e){
            Utils.Log.error("Error on getWorstPizza()", e);
        }
        return null;
    }

    private String getFavIngredient() {
        try(ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/one/FavIngredient.sql"))) {
            if (rs.next()) {
                String name = rs.getString("name");
                int nb_occurrences = rs.getInt("nb_occurrences");
                return name + " (utilisé dans " + nb_occurrences + " pizzas)";
            }
        } catch (Exception e){
            Utils.Log.error("Error on getFavIngredient()", e);
        }
        return null;
    }
}
