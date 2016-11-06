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
    
    public static ArrayList<Curso> getAll() {
        return CursoDAO.getAll();
    }
    
    public static Curso findCursoById(int idCurso) {
        return CursoDAO.findById(idCurso);
    }
    
    public static Curso findCursoByName(String nome) {
        return CursoDAO.findByName(nome);
    }
    
    public static ArrayList<Disciplina> getDisciplinas(Curso curso) {
        if (curso == null || curso.getId() < 0) {
            JOptionPane.showMessageDialog(null, "Curso inválido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, curso.getId(), "Curso", JOptionPane.INFORMATION_MESSAGE);
        return CursoDAO.getAllDisciplinasByCurso(curso);
    }
    
    public static boolean addDisciplina(Curso curso, Disciplina disciplina) {
        if (disciplina == null || disciplina.getId() < 0 || curso == null || curso.getId() < 0) {
            return false;
        }
        
        return CursoDAO.addDisciplina(curso, disciplina);
    }
    
    public static boolean remDisciplina(Curso curso, Disciplina disciplina) {
        if (disciplina == null || disciplina.getId() < 0 || curso == null || curso.getId() < 0) {
            return false;
        }
        return CursoDAO.remDisciplina(curso, disciplina);
    }
    
    public static boolean save(Curso curso) {
        if (curso != null) {
            CursoDAO.save(curso);
        }
        return false;
    }
    
    public static boolean ExistCurso() {
        return false;
    }
    
    public static boolean ExistDisciplinaInCurso() {
        return false;
    }
}
