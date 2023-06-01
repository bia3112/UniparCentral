
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class Agencia extends Telefone{
    
    private int id;
    private String codigo;
    private String razaoSocial;
    private String cnpj;
    private Conta conta;

    public Agencia() {
    }

    public Agencia(int id, String codigo, String razaoSocial, String cnpj, Conta conta) {
        this.id = id;
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.conta = conta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Agencia{" + "id=" + id + ", codigo=" + codigo + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", conta=" + conta + '}';
    }
 
}
