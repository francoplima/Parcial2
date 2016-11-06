package Domain.DAO;

import Domain.Disciplina;
import Domain.Professor;
import Domain.Turma;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public abstract class TurmaDAO extends Banco {
    public static Turma findById(int id) {
        conectar();
        final String sql = "select t.id, t.idProfessor, t.idDisciplina from Turma t "
                         + "where id = " + id;
        
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
}
