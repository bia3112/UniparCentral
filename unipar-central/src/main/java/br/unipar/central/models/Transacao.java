
package br.unipar.central.models;

import java.sql.Timestamp;

/**
 *
 * @author Beatr
 */
public class Transacao extends AbstractBaseEntiny{

    private String tipo;
    private Timestamp dataHora;
    private double valor;

    public Transacao() {
    }

    public Transacao(String tipo, Timestamp dataHora, double valor) {
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Transacao{" + "tipo=" + tipo + ", dataHora=" + dataHora + ", valor=" + valor + '}';
    }

}
