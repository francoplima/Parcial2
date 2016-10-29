package Domain;

import java.util.List;

/**
 *
 * @author guilh
 * @versionDate 
 */
public class Disciplina {
    private int id;
    private String nome;
    private Professor professor;
    private List<Turma> turmas;
    
    public Disciplina(int id, String nome, Professor professor) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    
}
