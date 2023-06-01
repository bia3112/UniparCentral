
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Cidade;

/**
 *
 * @author Beatr
 */
public class CidadeService {
    
    public void validar(Cidade cidade) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(cidade == null){
            throw new EntidadeNaoInformadaException("Cidade");
        }
        
        if(cidade.getNome() == null || 
            cidade.getNome().isBlank() ||
            cidade.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        }
        
        if(cidade.getNome().length() > 58){
            throw new TamanhoCampoInvalidoException("Nome",58);
        }

    }
    
}
