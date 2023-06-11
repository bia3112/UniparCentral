
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class Telefone extends AbstractBaseEntiny{
    
    private String numero;
    private String operadora;
    private Agencia agencia;
    private Pessoa pessoa;

    public Telefone() {
    }

    public Telefone(String numero, String operadora, Agencia agencia, Pessoa pessoa) {
        this.numero = numero;
        this.operadora = operadora;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Telefone{" + "numero=" + numero + ", operadora=" + operadora + ", agencia=" + agencia + ", pessoa=" + pessoa + '}';
    }

}
