package dev.rapizz.model;

import dev.rapizz.ConnectionManager;
import dev.rapizz.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivreurDao implements IDao<Livreur> {
    public Livreur parseResultSetToLivreur(ResultSet rs) throws SQLException {
        return new Livreur(
                rs.getInt("id_livreur"),
                rs.getString("name")
        );
    }

    @Override
    public Livreur getById(int id) {
        Connection conn = ConnectionManager.getInstance();
        try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM Livreur WHERE id_livreur = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return parseResultSetToLivreur(rs);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving Livreur id: " + id, e);
        }

        return null;
    }

    @Override
    public List<Livreur> getAll() {
        List<Livreur> livreurs = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Livreur");
            while (rs.next()) {
                Livreur livreur = parseResultSetToLivreur(rs);
                livreurs.add(livreur);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving all Livreur of table Livreur", e);
        }

        return livreurs;
    }

    @Override
    public Livreur create(Livreur p) {
        throw new RuntimeException("Not yet implemented for Create Livreur");
    }

    @Override
    public Livreur update(Livreur p) {
        throw new RuntimeException("Not yet implemented for Update Livreur");
    }

    @Override
    public void delete(Livreur p) {
        throw new RuntimeException("Not yet implemented for Delete Livreur");
    }
}
