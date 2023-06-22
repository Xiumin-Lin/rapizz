package dev.rapizz;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        initUnusedVehicleListView();
        initClientListView();
        initRegularClientListView();
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

    @FXML
    private ListView<String> vehicleListView;

    public void initUnusedVehicleListView() {
        try (ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/UnusedVehicle.sql"))) {
            List<String> list = new ArrayList<>();

            while (rs.next()) {
                int idVehicle = rs.getInt("id_vehicle");
                String name = rs.getString("name");
                String type = rs.getString("type");

                String vehicleInfo = String.format("(ID %d) %s, %s", idVehicle, name, type);
                list.add(vehicleInfo);
            }

            vehicleListView.getItems().addAll(list);
        } catch (Exception e) {
            Utils.Log.error("Error on getFavIngredient()", e);
        }
    }

    @FXML
    private ListView<String> clientListView;

    public void initClientListView() {
        try (ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/CommandsByClient.sql"))) {
            List<String> list = new ArrayList<>();

            while (rs.next()) {
                int idClient = rs.getInt("id_client");
                String name = rs.getString("name");
                int nb_command = rs.getInt("nb_command");

                String clientStr = String.format("(ID %d) %s has ordered %d times", idClient, name, nb_command);
                list.add(clientStr);
            }

            clientListView.getItems().addAll(list);
        } catch (Exception e) {
            Utils.Log.error("Error on getFavIngredient()", e);
        }
    }

    @FXML
    private ListView<String> regularClientListView;

    public void initRegularClientListView() {
        try (ResultSet rs = ConnectionManager.executeOneQueryScript(getClass().getResource("sql/query/MostRegularClients.sql"))) {
            List<String> list = new ArrayList<>();

            while (rs.next()) {
                int idClient = rs.getInt("id_client");
                String name = rs.getString("name");
                int nb_command = rs.getInt("nb_command");

                String clientStr = String.format("(ID %d) %s has ordered %d times", idClient, name, nb_command);
                list.add(clientStr);
            }

            regularClientListView.getItems().addAll(list);
        } catch (Exception e) {
            Utils.Log.error("Error on getFavIngredient()", e);
        }
    }
}
