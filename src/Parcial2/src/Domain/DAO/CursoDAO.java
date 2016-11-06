package Domain.DAO;

import Domain.Curso;

import Domain.Disciplina;
import Domain.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CursoDAO extends Banco {
    
    public static Curso get(Curso curso) {
        // nome, disciplina, numeroPeriodo, titulacao
        final String sql = "select c.id, c.nome, c.periodos, c.titulacao from curso c " +
                           "where c.nome = " + curso.getNome() + "c.periodos = " + curso.getNumeroPeriodos() + "c.titulacao = " 
                          +curso.getTitulacao();
        
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                curso.setId(id);
                return curso;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    /**
     * Este método retorna um ArrayList<'Disciplina>' as colunas id, nome das disciplinas e professor.
     */
    public static ArrayList<Disciplina> getAllDisciplinasByCurso(Curso curso) {
        final String sql = "select d.id, d.nome fom Disciplina d where d.idCurso = " + curso.getId();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        resultSet = exec(sql);
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String nome = resultSet.getObject(2).toString();
                
                System.out.println(id + " " + nome );
                disciplinas.add(new Disciplina(id, nome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplinas;
    }
    
    public static boolean addDisciplina(Curso curso, Disciplina disciplina) {
        final String sql = "insert into CursoDisciplina(idCurso, idDisciplina) "
                         + "values(" + curso.getId() + "" + disciplina.getId() + ");";
        return save(sql);
    }
    
    public static boolean remDisciplina(Curso curso, Disciplina disciplina) {
        final String sql = "delete from CursoDisciplina where idCurso = " + curso.getId() + " and idDisciplina = " + disciplina.getId();
        disciplina = null;
        return delete(sql);
    }
    
    
    public static ArrayList<Curso> getAll() {
        conectar();
        // id, nome, disciplinas, numeroPeriodos, titulacao
        final String sql = "select c.id, c.nome, c.periodos, c.titulacao from curso c";
        ArrayList<Curso> cursos = new ArrayList<>();
        
        resultSet = exec(sql);
        
        try {
            while(resultSet.next()) {
                int codigo = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                int numeroPeriodos = resultSet.getInt(3);
                String titulacao = resultSet.getString(4);
                cursos.add(new Curso(codigo, nome, numeroPeriodos, titulacao));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return cursos;
    }
    public static Curso findById(int id) {
        conectar();
        // id, nome, periodos, titulacao
        final String sql = "select c.id, c.nome, c.periodos, c.titulacao from curso c where c.id = " + id;
        System.out.println(id);
        Curso curso = null;
        
        resultSet = exec(sql);
        
        if (resultSet != null) {
            try {
                int idCurso = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                int periodos = resultSet.getInt(3);
                String titulacao = resultSet.getString(4);
                curso = new Curso (idCurso, nome, periodos, titulacao);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        desconectar();
        return curso;
    }
    public static Curso findByName(String name) {
        conectar();
        final String sql = "select c.id, c.nome, c.periodos, c.titulacao from curso c where c.nome = '" + name + "';";
        Curso curso = null;
        
        resultSet = exec(sql);
        
        try {
            if (resultSet != null) {
                int idCurso = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                int periodos = resultSet.getInt(3);
                String titulacao = resultSet.getString(4);
                curso = new Curso(idCurso, nome, periodos, titulacao);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        return curso;
    }
    public static boolean delete(Curso curso) {
        if(curso != null) {
            final String sql = "delete from Curso where id = " + curso.getId();
            curso = null;
            return delete(sql);
        }
        return false;
    }
    
    /**
     * Deve-se atualizar o objeto logo após salvá-lo.<br>
     * Esta atualização utiliza o método get, pois assim será atualizada a informação de id do objeto.
     */
    public static boolean save(Curso curso) {
        conectar();
        boolean result = false;
        if(curso != null) {
            final String sql = "insert into Curso(nome, periodos, titulacao) " +
                               " values('" + curso.getNome()+"',"+curso.getNumeroPeriodos()+",'"+curso.getTitulacao()+"')";
            result = save(sql);
        }
        desconectar();
        return result;
    }
}
