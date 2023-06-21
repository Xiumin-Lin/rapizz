package dev.rapizz.model;

import dev.rapizz.ConnectionManager;
import dev.rapizz.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleDao implements IDao<Vehicle> {
    public Vehicle parseResultSetToVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(
                rs.getInt("id_vehicle"),
                rs.getString("name"),
                rs.getString("type")
        );
    }

    @Override
    public Optional<Vehicle> getById(int id) {
        Connection conn = ConnectionManager.getInstance();
        try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM Vehicle WHERE id_vehicle = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = parseResultSetToVehicle(rs);
                return Optional.of(vehicle);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving Vehicle id: " + id, e);
        }

        return Optional.empty();
    }

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Vehicle");
            while (rs.next()) {
                Vehicle vehicle = parseResultSetToVehicle(rs);
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving all Vehicle of table Vehicle", e);
        }

        return vehicles;
    }

    @Override
    public Vehicle create(Vehicle p) {
        throw new RuntimeException("Not yet implemented for Create Client");
    }

    @Override
    public Vehicle update(Vehicle p) {
        throw new RuntimeException("Not yet implemented for Update Client");
    }

    @Override
    public void delete(Vehicle p) {
        throw new RuntimeException("Not yet implemented for Delete Client");
    }
}
