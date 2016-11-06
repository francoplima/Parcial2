package Domain.Service;

import Domain.DAO.TurmaDAO;
import Domain.Professor;
import Domain.Turma;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public abstract class TurmaService {
    public static ArrayList<Turma> findByProfessor(Professor professor) {
        return TurmaDAO.findByProfessor(professor);
    }
}
