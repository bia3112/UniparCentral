
package br.unipar.central.models;

import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
public class Agencia extends AbstractBaseEntiny{
    
    private String codigo;
    private String razaoSocial;
    private String cnpj;
    private ArrayList<Telefone> telefones = new ArrayList<>();
    private ArrayList<Conta> contas = new ArrayList<>();

    public Agencia() {
    }

    public Agencia(String codigo, String razaoSocial, String cnpj) {
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "Agencia{" + "codigo=" + codigo + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", telefones=" + telefones + ", contas=" + contas + '}';
    }

}
