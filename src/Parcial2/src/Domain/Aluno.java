package Domain;

import java.util.Date;

/**
 *
 * @author guilh
 * @versionDate
 */
public class Aluno extends Pessoa{
    private Matricula matricula;
    private Curso curso;
    
    /*
    protected String nome;
    protected Date dataNascimento;
    protected String endereco;
    protected String telefone;
    */
    
    /**
     * Construtor de Aluno, para dataNascimento deve-se passar no formato dd-MM-yyy.
     * O cpf possui validação de acordo com as regras de utilização brasileiras.
     * Há uma classe para formatação chamada PadronizadorService, ela trabalhará para padronizar os dados necessários em todo projeto
     */
    public Aluno(int codigo, String nome, Date dataNascimento, String cpf, Curso curso) {
        super(nome, dataNascimento, cpf);
        matricula.setId(codigo);
        this.curso = curso;
    }
    public Aluno(String nome, Date dataNascimento, String cpf, Curso curso) {
        super(nome, dataNascimento, cpf);
        this.curso = curso;
    }
    
    public int getId() {
        return matricula.getId();
    }
}
