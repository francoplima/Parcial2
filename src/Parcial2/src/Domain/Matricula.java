package Domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 * @versionDate 24/10 19:21
 */
public class Matricula {
    private int id;
    private List<Disciplina> disciplinas;
    
    public Matricula(int id) {
        this.id = id;
        disciplinas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
