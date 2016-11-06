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
    private Curso curso;
    private int cargaHoraria;
    private ArrayList<Turma> turmas;
    
    public static final int COLUNAS = 3;
    public static final String[] NOME_COLUNA = {"id", "nome", "Carga Horária"};
    
    public Disciplina(int id, String nome, Curso curso, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.cargaHoraria = cargaHoraria;
        turmas = new ArrayList<>();
    }
    
    public Disciplina(String nome, Curso curso, int cargaHoraria) {
        this.nome = nome;
        this.curso = curso;
        this.cargaHoraria = cargaHoraria;
        turmas = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return this.nome;
    }

    public void addTurma(Turma turma) {
        if (turma == null) {
            return;
        }
        turmas.add(turma);
    }
    public void remTurma(Turma turma) {
        if (turma == null) {
            return;
        }
        turmas.remove(turma);
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

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas.addAll(turmas);
    }
    
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }
    
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public Curso getCurso() {
        return this.curso;
    }
}
