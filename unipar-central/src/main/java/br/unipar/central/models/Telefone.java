
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class Telefone extends AbstractBaseEntiny{
    
    private String numero;
    private String operadora;

    public Telefone() {
    }

    public Telefone(String numero, String operadora) {
        this.numero = numero;
        this.operadora = operadora;
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

    @Override
    public String toString() {
        return "Telefone{" + "numero=" + numero + ", operadora=" + operadora + '}';
    }

}
