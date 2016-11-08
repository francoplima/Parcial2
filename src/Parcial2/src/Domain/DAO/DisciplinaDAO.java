package Domain.DAO;

import Domain.Curso;
import static Domain.DAO.Banco.resultSet;
import Domain.Disciplina;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public abstract class DisciplinaDAO extends Banco {
    public static Disciplina findById(int idDisciplina) {
        conectar();
        final String sql = "select d.id, d.nome, d.idCurso, d.cargaHoraria from Disciplina d where d.id = " + idDisciplina;
        
        resultSet = exec(sql);
        
        Disciplina disciplina = null;
        try {
            if(resultSet != null) {
                int id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                Curso curso = CursoDAO.findById(resultSet.getInt(3));
                int cargaHoraria = resultSet.getInt(4);
                disciplina = new Disciplina(id, nome, curso, cargaHoraria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        desconectar();
        return disciplina;
    }
    
    public static Disciplina findByName(String name) {
        conectar();
        final String sql = "select d.id, d.nome, d.idCurso, d.cargaHoraria from Disciplina d where d.nome = '" + name + "';";
        Disciplina  disciplina = null;
        
        resultSet = exec(sql);
        
        try {
            if (resultSet != null) {
                int idDisciplina = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                Curso curso = CursoDAO.findById(resultSet.getInt(3));
                int cargaHoraria = resultSet.getInt(4);
                disciplina = new Disciplina(idDisciplina, nome, curso, cargaHoraria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
        return disciplina;
    }
   
    public static boolean addTurma(int idDisciplina, int idTurma) {
        conectar();
        final String sql = "insert into DisciplinaTurma(idDisciplina, idTurma) "
                         + "values(" + idDisciplina + ", " + idTurma + ")";
        desconectar();
        return save(sql);
    }
    
    public static boolean remTurma(int idDisciplina, int idTurma) {
        conectar();
        final String sql = "delete from DisciplinaTurma where idDisciplina = " + idDisciplina + " idTurma = " + idTurma;
        desconectar();
        return delete(sql);
    }
    
    
    public static boolean save(Disciplina disciplina) {
        conectar();
        boolean result = false;
        if(disciplina != null) {
        final String sql = "insert into Disciplina(nome, cargaHoraria, idCurso)"
                        + "value("+disciplina.getNome()+","+disciplina.getCargaHoraria()+","+disciplina.getCurso() +")";
        result = save(sql);
        }
        desconectar();
        return result;
    }
    public static boolean delete(Disciplina disciplina) {
        conectar();
        boolean result = false;
        if(disciplina != null) {
            final String sql = "delete from Disciplina where id = " + disciplina.getId();
            disciplina = null;
            result = delete(sql);
        }
        desconectar();
        return result;
    }
    public static ArrayList<Disciplina> getAll() {
        conectar();
        // id, nome, disciplinas, numeroPeriodos, titulacao
        final String sql = "select d.id, d.nome, c.nome, d.cargaHoraria from Disciplina d join Curso c "
                         + "on c.id = d.idCurso";
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        
        resultSet = exec(sql);
        
        try {
            while(resultSet.next()) {
                int codigo = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                Curso curso = CursoDAO.findById(resultSet.getInt(3));
                int cargaHoraria = resultSet.getInt(4);
                disciplinas.add(new Disciplina(codigo, nome, curso, cargaHoraria));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconectar();
        return disciplinas;
    }
}
