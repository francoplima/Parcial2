package Domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Banco {
    protected Connection conexao;
    protected Statement statement;
    protected PreparedStatement prepStatement;
    protected ResultSet resultSet;
    
    protected boolean conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            // Deve ser alterado quando o banco versão final estiver pronto
            conexao = DriverManager.getConnection("jdbc:sqlite:sqLite_test.db");
            statement = conexao.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            // criar um log em txt futuramente
            e.printStackTrace();
        }
        return false;
    }
    protected boolean desconectar() {
        try {
            conexao.close();
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    protected boolean delete(String sql) {
        conectar();
        boolean result = false;
        try {
            result = statement.execute(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        desconectar();
        return result;
    }
    protected ResultSet exec(String sql) {
        try {
            conexao.setAutoCommit(true);
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
