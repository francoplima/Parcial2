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
    private Curso curso;
    private Professor professor;
    
    public Turma(Disciplina disciplina, Curso curso, Professor professor) {
        this.disciplina = disciplina;
        this.curso = curso;
        this.professor = professor;
        this.alunos = new ArrayList<>();
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
}
