package Domain.Service;

import Domain.Curso;
import Domain.DAO.CursoDAO;
import Domain.Disciplina;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public abstract class CursoService {
    
    public static ArrayList<Disciplina> getDisciplinas(Curso curso) {
        if (curso == null || curso.getId() < 0) {
            JOptionPane.showMessageDialog(null, "Curso inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return CursoDAO.getAllDisciplinasByCurso(curso.getId());
    }
    
    public static boolean addDisciplina(Disciplina disciplina) {
        if (disciplina == null || disciplina.getId() < 0) {
            return false;
        }
        return false;
    }
}
