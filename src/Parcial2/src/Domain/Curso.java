package Domain;

//import Geral.Disciplina;
import Domain.Disciplina;
import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private List<Disciplina> disciplinas;
    private int numeroPeriodos;
    private String titulacao;
    
    public Curso(int id, String nome, int numeroPeriodos, String titulacao) {
        this.id = id;
        this.nome = nome;
        this.numeroPeriodos = numeroPeriodos;
        this.titulacao = titulacao;
    }
    public Curso(String nome, int numeroPeriodos, String titulacao) {
        this.id = id;
        this.nome = nome;
        this.numeroPeriodos = numeroPeriodos;
        this.titulacao = titulacao;
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

    /*public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }*/

    public int getNumeroPeriodos() {
        return numeroPeriodos;
    }

    public void setNumeroPeriodos(int numeroPeriodos) {
        this.numeroPeriodos = numeroPeriodos;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    
}
