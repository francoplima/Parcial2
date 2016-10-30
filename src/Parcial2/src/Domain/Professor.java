package Domain;

import java.util.Date;

/**
 *
 * @author guilh
 * @versionDate
 */
public class Professor extends Pessoa {
    private Matricula matricula;
    
    /**
     * 
     * Construtor de Professor, para dataNascimento deve-se passar no formato dd-MM-yyy.
     * O cpf possui validação de acordo com as regras de utilização brasileiras.
     * Há uma classe para formatação chamada PadronizadorService, ela trabalhará para padronizar os dados necessários em todo projeto
     */
    public Professor(String nome, Date dataNascimento, String endereco, String cpf) {
        super(nome, dataNascimento, endereco, cpf);
    }
    public Professor(int id, String nome, Date dataNascimento, String endereco, String cpf) {
        super(nome, dataNascimento, endereco, cpf);
        matricula = new Matricula(id);
    }
    
}
