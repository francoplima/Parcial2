package Domain.DAO;

import Domain.Aluno;
import Domain.Curso;
import static Domain.DAO.Banco.resultSet;
import Domain.Disciplina;
import Domain.Turma;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public abstract class DisciplinaDAO extends Banco {
    
    public static Disciplina findById(int idDisciplina) {
        final String sql = "select d.id, d.nome, d.idCurso from Disciplina d where d.id = " + idDisciplina;
        
        resultSet = exec(sql);
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                Curso curso = CursoDAO.findById(resultSet.getInt(3));
                return new Disciplina(id, nome, curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Turma> findAllTurmaByDisciplina(int idDisciplina) {
        final String sql = "select t.id, t.idDisciplina from Turma t join DisciplinaTurma dt on t.id = dt.idTurma "
                         + "where t.id = " + idDisciplina;
        Disciplina disciplina = findById(idDisciplina);
        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        resultSet = exec(sql);
        
        try {
            while (resultSet.next()) {
                int idTurma = Integer.parseInt(resultSet.getObject(1).toString());
                final String sql2 =  "select ";
            
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;
    }
    
    public static boolean addTurma(int idDisciplina, int idTurma) {
        final String sql = "insert into DisciplinaTurma(idDisciplina, idTurma) "
                         + "values(" + idDisciplina + ", " + idTurma + ")";
        return save(sql);
    }
    
    public static boolean remTurma(int idDisciplina, int idTurma) {
        final String sql = "delete from DisciplinaTurma where idDisciplina = " + idDisciplina + " idTurma = " + idTurma;
        return delete(sql);
    }
}
