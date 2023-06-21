package dev.rapizz.model;

import dev.rapizz.ConnectionManager;
import dev.rapizz.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandDao implements IDao<Command> {
    public Command parseResultSetToCommand(ResultSet rs) throws SQLException {
        return new Command(
                rs.getInt("id_command"),
                rs.getDouble("price"),
                rs.getString("status"),
                rs.getDate("date_start"),
                rs.getDate("date_end"),
                new PizzaDao().getById(rs.getInt("id_pizza")),
                new SizeDao().getById(rs.getInt("id_size")),
                new ClientDao().getById(rs.getInt("id_client")),
                new LivreurDao().getById(rs.getInt("id_livreur")),
                new VehicleDao().getById(rs.getInt("id_vehicle"))
        );
    }

    @Override
    public Command getById(int id) {
        Connection conn = ConnectionManager.getInstance();
        try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM Command WHERE id_command = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return parseResultSetToCommand(rs);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving Command id: " + id, e);
        }

        return null;
    }

    @Override
    public List<Command> getAll() {
        List<Command> commands = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Command");
            while (rs.next()) {
                Command command = parseResultSetToCommand(rs);
                commands.add(command);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving all Command of table Command", e);
        }

        return commands;
    }

    @Override
    public Command create(Command p) {
        throw new RuntimeException("Not yet implemented for Create Command");
    }

    @Override
    public Command update(Command p) {
        throw new RuntimeException("Not yet implemented for Update Command");
    }

    @Override
    public void delete(Command p) {
        throw new RuntimeException("Not yet implemented for Delete Command");
    }
}
