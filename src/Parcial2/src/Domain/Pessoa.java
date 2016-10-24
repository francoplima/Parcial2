/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author 
 * @versionDate
 */
public abstract class Pessoa {
    protected String nome;
    protected Date dataNascimento;
    protected String endereco;
    protected String cpf;
    
    public Pessoa(String nome, Date dataNascimento, String endereco, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cpf = cpf;
    }
    
}
