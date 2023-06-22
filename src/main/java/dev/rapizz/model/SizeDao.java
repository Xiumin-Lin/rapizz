package dev.rapizz.model;

import dev.rapizz.ConnectionManager;
import dev.rapizz.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SizeDao implements IDao<Size> {
    public Size parseResultSetToSize(ResultSet rs) throws SQLException {
        return new Size(
                rs.getInt("id_size"),
                rs.getString("name"),
                rs.getDouble("price_modifier")
        );
    }

    @Override
    public Size getById(int id) {
        Connection conn = ConnectionManager.getInstance();
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM Size WHERE id_size = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return parseResultSetToSize(rs);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving Size id: " + id, e);
        }

        return null;
    }

    @Override
    public List<Size> getAll() {
        List<Size> sizes = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Size");
            while (rs.next()) {
                Size size = parseResultSetToSize(rs);
                sizes.add(size);
            }
        } catch (SQLException e) {
            Utils.Log.error("Error when retrieving all Size of table Size", e);
        }

        return sizes;
    }

    @Override
    public Size create(Size p) {
        throw new RuntimeException("Not yet implemented for Create Size");
    }

    @Override
    public Size update(Size p) {
        throw new RuntimeException("Not yet implemented for Update Size");
    }

    @Override
    public void delete(Size p) {
        throw new RuntimeException("Not yet implemented for Delete Size");
    }
}