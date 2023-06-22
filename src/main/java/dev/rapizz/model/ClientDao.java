package dev.rapizz.model;

import dev.rapizz.ConnectionManager;
import dev.rapizz.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IDao<Client> {
    public Client parseResultSetToClient(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("id_client"),
                rs.getString("name"),
                rs.getDouble("wallet"),
                rs.getString("address"),
                rs.getBoolean("is_subscribe")
        );
    }

    @Override
    public Client getById(int id) {
        Connection conn = ConnectionManager.getInstance();
        try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM Client WHERE id_client = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return parseResultSetToClient(rs);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving client id: " + id, e);
        }

        return null;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Client");
            while (rs.next()) {
                Client client = parseResultSetToClient(rs);
                clients.add(client);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving all Client of table Client", e);
        }

        return clients;
    }

    @Override
    public Client create(Client p) {
        throw new RuntimeException("Not yet implemented for Create Client");
    }

    @Override
    public Client update(Client p) {
        throw new RuntimeException("Not yet implemented for Update Client");
    }

    @Override
    public void delete(Client p) {
        throw new RuntimeException("Not yet implemented for Delete Client");
    }
}
