
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Estado;

/**
 *
 * @author Beatr
 */
public class EstadoService {
    
    public void validar(Estado estado) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(estado == null){
            throw new EntidadeNaoInformadaException("Estado");
        }
        
        if(estado.getNome() == null || 
            estado.getNome().isBlank() ||
            estado.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(estado.getNome().length() > 58){
            throw new TamanhoCampoInvalidoException("Nome",58);
        }
        
    }
    
}
