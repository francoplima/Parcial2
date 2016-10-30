package Domain;

import java.util.Date;

/**
 *
 * @author guilh
 * @versionDate
 */
public class Aluno extends Pessoa{
    private Matricula matricula;
    
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
    public Aluno(int codigo, String nome, Date dataNascimento, String endereco, String cpf) {
        super(nome, dataNascimento, endereco, cpf);
        matricula.setId(codigo);
    }
    
    public int getId() {
        return matricula.getId();
    }
}
