package Domain;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Guilherme
 * @versionDate 24/10 19:21
 */
public class Matricula {
    private int id;
    private List<Disciplina> disciplinas;
    private Date dataMatricula;
    
    public Matricula() {
        
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

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
}
