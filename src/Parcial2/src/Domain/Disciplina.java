package Domain;


import java.util.ArrayList;
/**
 *
 * @author guilh
 * @versionDate 
 */
public class Disciplina {
    private int id;
    private String nome;
    private Professor professor;
    private ArrayList<Turma> turmas;
    
    public static final int COLUNAS = 3;
    public static final String[] NOME_COLUNA = {"id", "nome", "professor"};
    
    public Disciplina(int id, String nome, Professor professor) {
        this.id = id;
        this.nome = nome;
        turmas = new ArrayList<>();
    }

    public void addTurma(Turma turma) {
        if (turma == null) {
            return;
        }
        turmas.add(turma);
    }
    public void remTurma(Turma turma) {
        
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

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas.addAll(turmas);
    }
    
}
