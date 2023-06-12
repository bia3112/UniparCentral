
package br.unipar.central.models;

import br.unipar.central.enums.TipoTransacaoEnum;
import java.sql.Timestamp;

/**
 *
 * @author Beatr
 */
public class Transacao extends AbstractBaseEntiny{

    private TipoTransacaoEnum tipo;
    private Timestamp dataHora;
    private double valor;
    private Conta contaOrigem;
    private Conta contaDestino;

    public Transacao() {
    }

    public Transacao(TipoTransacaoEnum tipo, Timestamp dataHora, double valor, Conta contaOrigem, Conta contaDestino) {
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
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

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return "Transacao{" + "tipo=" + tipo + ", dataHora=" + dataHora + ", valor=" + valor + ", contaOrigem=" + contaOrigem + ", contaDestino=" + contaDestino + '}';
    }

}
