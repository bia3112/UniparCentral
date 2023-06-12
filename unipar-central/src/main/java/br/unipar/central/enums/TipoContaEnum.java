
package br.unipar.central.enums;

/**
 *
 * @author Beatr
 */
public enum TipoContaEnum {
    
    CORRENTE(1), 
    POUPANCA(2),
    SALARIO(3);
    
    private final int numero;
    
    private TipoContaEnum(int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    } 
    
}
