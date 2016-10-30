package Domain.DAO;

import Domain.Curso;

import Domain.Disciplina;
import Domain.Professor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CursoDAO extends Banco {
    
    public static Curso get(Curso curso) {
        // nome, disciplina, numeroPeriodo, titulacao
        final String sql = "select c.id, c.nome, c.numeroDePeriodos, c.titulacao from curso c " +
                           "where c.nome = " + curso.getNome() + "c.numeroDePeriodos = " + curso.getNumeroPeriodos() + "c.titulacao = " 
                          +curso.getTitulacao();
        resultSet = exec(sql);
        
        try {
            while(resultSet.next()) {
                int codigo = Integer.parseInt(resultSet.getObject(1).toString());
                String nome = resultSet.getObject(2).toString();
                int numeroPeriodos = Integer.parseInt(resultSet.getObject(3).toString());
                String titulacao = resultSet.getObject(4).toString();
                return new Curso(codigo, nome, numeroPeriodos, titulacao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Este método retorna um ArrayList<'Disciplina>' as colunas id, nome das disciplinas e professor.
     */
    public static ArrayList<Disciplina> getAllDisciplinasByCurso(int idCurso) {
        final String sql = "select d.id, d.nome d.idProfessor fom Disciplina d join CursoDisciplina cd on d.id=cd.idDisciplina "+
                           "where cd.idCurso = " + idCurso;
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        resultSet = exec(sql);
        try {
            while(resultSet.next()) {
                int id = Integer.parseInt(resultSet.getObject(1).toString());
                String nome = resultSet.getObject(2).toString();
                String sql2 = "select p.id, p. nome, p.dataNascimento, p.endereco, p.cpf "
                            + "from DisciplinaProfessor df join Professor p on p.id=df.idProfessor  "
                            + "where df.idDisciplina = " + resultSet.getString(1);
                ResultSet resultSetP = exec(sql);
                int idP = Integer.parseInt(resultSetP.getString(1).toString());
                String nomeP = resultSetP.getString(2).toString();
                Date dataP = new Date(resultSetP.getObject(3).toString());
                String enderecoP = resultSetP.getObject(4).toString();
                String cpf = resultSetP.getObject(5).toString();
                Professor professor =  new Professor(id, nomeP, dataP, enderecoP, cpf);
                disciplinas.add(new Disciplina(id, nome, professor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplinas;
    }
    
    public static boolean addDisciplina(int idCurso, Disciplina disciplina) {
        final String sql = "insert into CursoDisciplina(idCurso, idDisciplina) "
                         + "values(" + idCurso + "" + disciplina.getId() + ");";
        return save(sql);
    }
    
    public static boolean remDisciplina(int idCurso, Disciplina disciplina) {
        final String sql = "delete from CursoDisciplina where idCurso = " + idCurso + " and idDisciplina = " + disciplina.getId();
        return delete(sql);
    }
    
    
    public static ArrayList<Curso> getAll() {
        conectar();
        // id, nome, disciplinas, numeroPeriodos, titulacao
        final String sql = "select c.id, c.nome, c.numeroDePeriodos, c.titulacao from curso c";
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
        final String sql = "select c.codCurso, c.nome, c.numeroDePeriodos, c.titulacao from curso c where c.id = " + id;
        Curso curso = null;
        
        resultSet = exec(sql);
        
        if (resultSet != null) {
            try {
                curso = new Curso(
                    Integer.parseInt(resultSet.getObject(1).toString()),
                    resultSet.getObject(2).toString(),
                    Integer.parseInt(resultSet.getObject(3).toString()),
                    resultSet.getObject(4).toString());
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        desconectar();
        return curso;
    }
    public static ArrayList<Curso> findByName(String name) {
        conectar();
        final String sql = "select c.codCurso, c.nome, c.numeroDePeriodos, c.titulacao "
                         + "from curso c where c.nome = " + name;
        ArrayList<Curso> cursos = new ArrayList<>();
        
        resultSet = exec(sql);
        
        try {
            while(resultSet.next()) {
                int codigo = Integer.parseInt(resultSet.getObject(1).toString());
                String nome = resultSet.getObject(2).toString();
                int numeroPeriodos = Integer.parseInt(resultSet.getObject(3).toString());
                String titulacao = resultSet.getObject(4).toString();
                cursos.add(new Curso(codigo, nome, numeroPeriodos, titulacao));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        return cursos;
    }
    public static boolean delete(Curso curso) {
        if(curso != null) {
            final String sql = "delete from Curso where id = " + curso.getId();
            return delete(sql);
        }
        return false;
    }
    
    public static boolean save(Curso curso) {
        if(curso != null) {
            final String sql = "insert into Curso(nome, numeroPeriodos, titulacao) " +
                           " values(" + curso.getNome()+","+curso.getNumeroPeriodos()+","+curso.getTitulacao()+")";
            return save(sql);
        }
        return false;
    }
}
