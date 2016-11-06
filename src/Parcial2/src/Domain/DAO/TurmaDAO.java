package Domain.DAO;

import Domain.Disciplina;
import Domain.Professor;
import Domain.Turma;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public abstract class TurmaDAO extends Banco {
    public static Turma findById(int id) {
        conectar();
        final String sql = "select t.id, t.idProfessor, t.idDisciplina from Turma t "
                         + "where t.id = " + id;
        
        resultSet = exec(sql);
        Turma turma = null;
        try {
            if (resultSet != null) {
                int idTurma = resultSet.getInt(1);
                Professor prof = ProfessorDAO.findById(resultSet.getInt(2));
                Disciplina disc = DisciplinaDAO.findById(resultSet.getInt(3));
                turma = new Turma(idTurma, disc, prof);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        desconectar();
        return turma;
    }
    public static ArrayList<Turma> findByProfessor(Professor professor) {
        conectar();
        final String sql = "select t.id, t.idDisciplina from Turma t "
                         + "where t.idProfessor = " + professor.getId();
        resultSet = exec(sql);
        ArrayList<Turma> turmas = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                Disciplina disciplina = DisciplinaDAO.findById(resultSet.getInt(2));
                turmas.add(new Turma(id, disciplina, professor));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        desconectar();
        return turmas;
    }
    
    public static void main (String[] args) {
        System.out.println("Tetando findById, buscando por professor 1");
        Turma turma = findById(1);
        
        System.out.println("Exibindo disciplina relacionada: " + turma.getDisciplina().getNome());
        
    }
}
