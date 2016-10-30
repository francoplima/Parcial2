package Domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Banco {
    protected static Connection conexao;
    protected static Statement statement;
    protected static PreparedStatement prepStatement;
    protected static ResultSet resultSet;
    
    protected static boolean conectar() {
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
    protected static boolean desconectar() {
        try {
            conexao.close();
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    protected static boolean delete(String sql) {
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
    protected static ResultSet exec(String sql) {
        try {
            conexao.setAutoCommit(true);
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected static boolean save(String sql) {
        conectar();
        boolean result = false;
        try {
            result = statement.execute(sql);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
            return result;
        }
        
    }
}
