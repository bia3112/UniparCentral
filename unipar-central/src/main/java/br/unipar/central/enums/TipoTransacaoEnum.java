
package br.unipar.central.enums;

/**
 *
 * @author Beatr
 */
public enum TipoTransacaoEnum {
    
    DOC(1), 
    TED(2), 
    TEF(3);
    
    private final int numero;

    private TipoTransacaoEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

}
