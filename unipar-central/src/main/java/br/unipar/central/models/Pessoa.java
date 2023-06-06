
package br.unipar.central.models;

import br.unipar.central.enums.TipoPessoaEnum;
import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
public class Pessoa extends AbstractBaseEntiny{
    
    private String email;
    private TipoPessoaEnum tipoPessoa;
    private ArrayList<Endereco> enderecos = new ArrayList<>();
    private ArrayList<Telefone> telefones = new ArrayList<>();;

    public Pessoa() {
    }

    public Pessoa(String email, TipoPessoaEnum tipoPessoa) {
        this.email = email;
        this.tipoPessoa = tipoPessoa;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPessoaEnum getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "email=" + email + ", tipoPessoa=" + tipoPessoa + ", enderecos=" + enderecos + ", telefones=" + telefones + '}';
    }

}
