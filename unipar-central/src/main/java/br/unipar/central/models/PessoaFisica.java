
package br.unipar.central.models;

import br.unipar.central.enums.TipoPessoaEnum;
import java.sql.Date;

/**
 *
 * @author Beatr
 */
public class PessoaFisica extends Pessoa{
    
    private String nome;
    private String cpf;
    private String rg;
    private Date dtNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cpf, String rg, Date dtNascimento, String email, TipoPessoaEnum tipoPessoa) {
        super(email, tipoPessoa);
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dtNascimento = dtNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dtNascimento=" + dtNascimento + '}';
    }

}
