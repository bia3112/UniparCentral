
package br.unipar.central.models;

import br.unipar.central.enums.TipoContaEnum;

/**
 *
 * @author Beatr
 */
public class Conta extends AbstractBaseEntiny{
    
    private String numero;
    private TipoContaEnum tipo;
    private int digito;
    private double saldo;
    private Pessoa pessoa;
    private Agencia agencia;

    public Conta() {
    }

    public Conta(String numero, TipoContaEnum tipo, int digito, double saldo, Pessoa pessoa, Agencia agencia) {
        this.numero = numero;
        this.tipo = tipo;
        this.digito = digito;
        this.saldo = saldo;
        this.pessoa = pessoa;
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoContaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoContaEnum tipo) {
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

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Conta{" + "numero=" + numero + ", tipo=" + tipo + ", digito=" + digito + ", saldo=" + saldo + ", pessoa=" + pessoa + ", agencia=" + agencia + '}';
    }

}
