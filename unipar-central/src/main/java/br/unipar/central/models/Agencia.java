
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class Agencia extends AbstractBaseEntiny{
    
    private String codigo;
    private String razaoSocial;
    private String cnpj;
    private Banco banco;

    public Agencia() {
    }

    public Agencia(String codigo, String razaoSocial, String cnpj, Banco banco) {
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.banco = banco;
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

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Agencia{" + "codigo=" + codigo + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", banco=" + banco + '}';
    }

}
