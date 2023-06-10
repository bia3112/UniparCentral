
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Banco;

/**
 *
 * @author Beatr
 */
public class BancoService {
    
    public void validar(Banco banco) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(banco == null){
            throw new EntidadeNaoInformadaException("Banco");
        }
        if(banco.getNome() == null ||
                banco.getNome().isBlank() ||
                banco.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        } 
    }  
}
