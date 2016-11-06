package Domain;

import java.util.ArrayList;

/**
 *
 * @author guilh
 * @versionDate 
 */
public class Turma {
    private int id;
    private Disciplina disciplina;
    private ArrayList<Aluno> alunos;
    private Professor professor;
    
    public Turma(Disciplina disciplina, Professor professor) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }
    
    public Turma(int id, Disciplina disciplina, Professor professor) {
        this.id = id;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.disciplina.getNome();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
}
