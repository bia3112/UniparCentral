
package br.unipar.central.models;

import java.sql.Date;

/**
 *
 * @author Beatr
 */
public class PessoaFisica extends AbstractBaseEntiny{
    
    private String nome;
    private String cpj;
    private String rg;
    private Date dtNascimento;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String cpj, String rg, Date dtNascimento) {
        this.nome = nome;
        this.cpj = cpj;
        this.rg = rg;
        this.dtNascimento = dtNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpj() {
        return cpj;
    }

    public void setCpj(String cpj) {
        this.cpj = cpj;
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
        return "PessoaFisica{" + "nome=" + nome + ", cpj=" + cpj + ", rg=" + rg + ", dtNascimento=" + dtNascimento + '}';
    }

}
