package Domain.DAO;

import Domain.Aluno;
import static Domain.DAO.Banco.resultSet;
import Domain.Disciplina;
import Domain.Professor;
import Domain.Turma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author guilh
 */
public abstract class DisciplinaDAO extends Banco {
    
    public static Disciplina findById(int idDisciplina) {
        final String sql = "select d.id, d.nome d.idProfessor fom Disciplina d "+
                           "where d.id = " + idDisciplina;
        
        resultSet = exec(sql);
        try {
            while(resultSet.next()) {
                int id = Integer.parseInt(resultSet.getObject(1).toString());
                String nome = resultSet.getObject(2).toString();
                String sql2 = "select p.id, p. nome, p.dataNascimento, p.cpf "
                            + "from DisciplinaProfessor df join Professor p on p.id=df.idProfessor  "
                            + "where df.idDisciplina = " + resultSet.getString(1);
                ResultSet resultSetP = exec(sql);
                int idP = Integer.parseInt(resultSetP.getString(1));
                String nomeP = resultSetP.getString(2);
                Date dataP = new Date(resultSetP.getString(3));
                String cpf = resultSetP.getString(4);
                Professor professor =  new Professor(id, nomeP, dataP, cpf);
                return new Disciplina(id, nome, professor);
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
