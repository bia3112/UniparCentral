
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class PessoaJuridica extends Pessoa{
    
    private String cnpj;
    private String razaoSocial;
    private String cnaePrincipal;
    private String fantasia;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String razaoSocial, String cnaePrincipal, String fantasia) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.cnaePrincipal = cnaePrincipal;
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", cnaePrincipal=" + cnaePrincipal + ", fantasia=" + fantasia + '}';
    }
    
}
