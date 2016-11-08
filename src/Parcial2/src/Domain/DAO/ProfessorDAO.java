/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.DAO;

import Domain.Professor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author guilh
 */
public abstract class ProfessorDAO extends Banco {
    public static Professor findById(int id) {
        conectar();
        final String sql = "select p.id, p.nome, p.cpf, p.nascimento from Professor p "
                         + "where id = " + id;
        
        resultSet = exec(sql);
        Professor professor = null;
        try {
            resultSet.next();
            if (resultSet != null) {
                int idProf = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String cpf = resultSet.getString(3);
                Date data = resultSet.getDate(4);
                professor = new Professor(id, nome, data, cpf);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
        return professor;
    }
    public static ArrayList<Professor> getAll() {
        conectar();
        final String sql = "select p.id, p.nome, p.cpf, p.nascimento from Professor p;";
        resultSet = exec(sql);
        ArrayList<Professor> professores = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String cpf = resultSet.getString(3);
                Date data = resultSet.getDate(4);
                professores.add(new Professor(id, nome, data, cpf));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
        return professores;
    }
    public static boolean addProfessor(String nome, String cpf, String nascimento ) {
        conectar();
        final String sql = "insert into Professor (nome, cpf, nascimento) "
                         + "values(" + nome + ", " + cpf +", " + nascimento + ")";
        desconectar();
        return save(sql);
    }
    //creio que remoção basta o ip como parâmetro
    public static boolean remProfessor (int id) {
        conectar();
        final String sql = "delete from Professor where id = " + id;
        desconectar();
        return delete(sql);
    }
}

