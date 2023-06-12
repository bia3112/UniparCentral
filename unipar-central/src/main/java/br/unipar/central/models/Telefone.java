
package br.unipar.central.models;

import br.unipar.central.enums.TipoOperadoraEnum;

/**
 *
 * @author Beatr
 */
public class Telefone extends AbstractBaseEntiny{
    
    private String numero;
    private TipoOperadoraEnum operadora;
    private Agencia agencia;
    private Pessoa pessoa;

    public Telefone() {
    }

    public Telefone(String numero, TipoOperadoraEnum operadora, Agencia agencia, Pessoa pessoa) {
        this.numero = numero;
        this.operadora = operadora;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoOperadoraEnum getOperadora() {
        return operadora;
    }

    public void setOperadora(TipoOperadoraEnum operadora) {
        this.operadora = operadora;
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
