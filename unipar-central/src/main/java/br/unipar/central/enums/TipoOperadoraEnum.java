
package br.unipar.central.enums;

/**
 *
 * @author Beatr
 */
public enum TipoOperadoraEnum {
    
    VIVO(1), 
    CLARO(2), 
    TIM(3), 
    OI(4);
    
    private final int numero;

    private TipoOperadoraEnum(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }  
}
