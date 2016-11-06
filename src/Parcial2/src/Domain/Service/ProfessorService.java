package Domain.Service;

import Domain.DAO.ProfessorDAO;
import Domain.Professor;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public abstract class ProfessorService {
    public static ArrayList<Professor> getAll() {
        return ProfessorDAO.getAll();
    }
}
