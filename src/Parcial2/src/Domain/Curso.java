package Domain.Service;

//import Geral.Disciplina;
import java.util.List;

public class Curso {
    private int codigo;
    private String nome;
    //private List<Disciplina> disciplinas;
    private int numeroPeriodos;
    private String titulacao;
    
    public Curso(int codigo, String nome, int numeroPeriodos, String titulacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroPeriodos = numeroPeriodos;
        this.titulacao = titulacao;
    }
    public Curso(String nome, int numeroPeriodos, String titulacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroPeriodos = numeroPeriodos;
        this.titulacao = titulacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
