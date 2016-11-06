package Domain.Service;

import Domain.DAO.DisciplinaDAO;
import Domain.Disciplina;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public abstract class DisciplinaService {
    public static ArrayList<Disciplina> getAll() {
        return DisciplinaDAO.getAll();
    }
    
}
