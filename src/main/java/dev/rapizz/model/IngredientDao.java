package dev.rapizz.model;

import dev.rapizz.ConnectionManager;
import dev.rapizz.Utils;

import java.sql.*;
import java.util.*;

public class IngredientDao implements IDao<Ingredient> {
    public Ingredient parseResultSetToIngredient(ResultSet rs) throws SQLException {
        return new Ingredient(rs.getInt("id_ingredient"), rs.getString("name"));
    }

    @Override
    public Ingredient getById(int id) {
        Connection conn = ConnectionManager.getInstance();
        try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM ingredient WHERE id_ingredient = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return parseResultSetToIngredient(rs);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving pizza id: " + id, e);
        }

        return null;
    }

    @Override
    public List<Ingredient> getAll() {
        List<Ingredient> ingredients = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Ingredient");

            while (rs.next()) {
                Ingredient ing = parseResultSetToIngredient(rs);
                ingredients.add(ing);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving all Ingredient of table Ingredient", e);
        }

        return ingredients;
    }

    public HashSet<Ingredient> getAllByPizzaId(int id) {
        HashSet<Ingredient> list = new HashSet<>();
        Connection conn = ConnectionManager.getInstance();
        try(PreparedStatement statement = conn.prepareStatement(
                "SELECT i.id_ingredient, i.name FROM Compose c, Ingredient i WHERE c.id_pizza = ? AND c.id_ingredient = i.id_ingredient"
        )) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ingredient ing = parseResultSetToIngredient(rs);
                list.add(ing);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving all ingredient of pizza id: " + id, e);
        }

        return list;
    }

    @Override
    public Ingredient create(Ingredient p) {
        throw new RuntimeException("Not yet implemented for Create Ingredient");
    }

    @Override
    public Ingredient update(Ingredient p) {
        throw new RuntimeException("Not yet implemented for Update Ingredient");
    }

    @Override
    public void delete(Ingredient p) {
        throw new RuntimeException("Not yet implemented for Delete Ingredient");
    }
}
