package dev.rapizz.model;

import dev.rapizz.ConnectionManager;
import dev.rapizz.Utils;

import java.sql.*;
import java.util.*;

public class PizzaDao implements IDao<Pizza> {

    private Pizza parseResultSetToPizza(ResultSet rs) throws SQLException {
        return new Pizza(
                rs.getInt("id_pizza"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getString("picture_url")
        );
    }

    @Override
    public Optional<Pizza> getById(int id) {
        Connection conn = ConnectionManager.getInstance();
        try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM Pizza WHERE id_pizza = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Pizza pizza = parseResultSetToPizza(rs);
                pizza.getIngredients().addAll(new IngredientDao().getAllByPizzaId(id));
                return Optional.of(pizza);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving pizza id: " + id, e);
        }

        return Optional.empty();
    }

    @Override
    public List<Pizza> getAll() {
        List<Pizza> pizzas = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance();
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Pizza");

            while (resultSet.next()) {
                Pizza pizza = parseResultSetToPizza(resultSet);
                pizza.getIngredients().addAll(new IngredientDao().getAllByPizzaId(pizza.getId()));
                pizzas.add(pizza);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving all Pizza of table Pizza", e);
        }

        return pizzas;
    }

    @Override
    public Pizza create(Pizza p) {
        throw new RuntimeException("Not yet implemented for Create Pizza");
    }

    @Override
    public Pizza update(Pizza p) {
        throw new RuntimeException("Not yet implemented for Update Pizza");
    }

    @Override
    public void delete(Pizza p) {
        throw new RuntimeException("Not yet implemented for Delete Pizza");
    }
}
