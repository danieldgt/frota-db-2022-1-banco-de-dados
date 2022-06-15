package br.com.frota.DAO;

import br.com.frota.model.Marca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO extends ConexaoDB {

    private static final String INSERT_MARCA_SQL = "INSERT INTO marca (descricao) VALUES (?);";
    private static final String SELECT_MARCA_BY_ID = "SELECT id, descricao FROM marca WHERE id =?";
    private static final String SELECT_ALL_MARCA = "SELECT * FROM marca;";
    private static final String DELETE_MARCA_SQL = "DELETE FROM marca WHERE id = ?;";
    private static final String UPDATE_MARCA_SQL = "UPDATE marca SET descricao= ? WHERE id = ?;";

    public void insertMarca(Marca marca) {
        try (PreparedStatement preparedStatement = preparedStatement(INSERT_MARCA_SQL)) {
            preparedStatement.setString(1, marca.getDescricao());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Marca selectMarca(int id) {
        Marca marca = null;
        try (PreparedStatement preparedStatement = preparedStatement(SELECT_MARCA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                marca = new Marca(id, descricao);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return marca;
    }

    public List<Marca> selectAllMarcas() {
        List<Marca> marcas = new ArrayList<>();
        try (PreparedStatement preparedStatement = preparedStatement(SELECT_ALL_MARCA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                marcas.add(new Marca(id, descricao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return marcas;
    }

    public boolean deleteMarca(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = preparedStatement(DELETE_MARCA_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    public boolean updateMarca(Marca marca) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = preparedStatement(UPDATE_MARCA_SQL)) {
            statement.setString(1, marca.getDescricao());
            statement.setInt(2, marca.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }
}
