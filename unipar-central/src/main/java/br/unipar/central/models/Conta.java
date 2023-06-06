
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class Conta extends AbstractBaseEntiny{
    
    private String numero;
    private String tipo;
    private int digito;
    private double saldo;
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(String numero, String tipo, int digito, double saldo, Pessoa pessoa) {
        this.numero = numero;
        this.tipo = tipo;
        this.digito = digito;
        this.saldo = saldo;
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Conta{" + "numero=" + numero + ", tipo=" + tipo + ", digito=" + digito + ", saldo=" + saldo + ", pessoa=" + pessoa + '}';
    }

}
