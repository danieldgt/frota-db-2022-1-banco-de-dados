package br.com.frota.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDB {
    //TODO: criar variáveis de ambiente para os dados de acesso ao banco.
    private static final String dbName = "professor_frota";
    private static final String dbURL = "jdbc:postgresql://200.17.32.221:5432/";
    private static final String username = "postgres";
    private static final String password = "postgres";

    public static Connection conexaoDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conexaoDB = DriverManager.getConnection(dbURL.concat(dbName), username, password);

        if (conexaoDB != null) {
            System.out.println("Conexão com o banco de dados gerada com sucesso! ");
            return conexaoDB;
        } else {
            throw new RuntimeException("Ops! Erro ao conectar com o banco de dados. :(");
        }
    }

    public static PreparedStatement prapararSQL(String sql) throws SQLException, ClassNotFoundException {
        return conexaoDB().prepareStatement(sql);
    }

    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("Estado do SQL: " + ((SQLException) e).getSQLState());
                System.err.println("Codigo do ERRO: " + ((SQLException) e).getErrorCode());
                System.err.println("Messagem: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Causa: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
