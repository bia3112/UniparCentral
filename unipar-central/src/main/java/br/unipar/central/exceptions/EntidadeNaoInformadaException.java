
package br.unipar.central.exceptions;

/**
 *
 * @author Beatr
 */
public class EntidadeNaoInformadaException extends Exception{
    
    public EntidadeNaoInformadaException(String entidade){
        super(entidade + " Não foi informada e deve ser preenchida(o). Verifique!");
    }

}
