
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Pessoa;

/**
 *
 * @author Beatr
 */
public class PessoaService {
    
    public void validar(Pessoa pessoa) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(pessoa == null){
            throw new EntidadeNaoInformadaException("Pessoa");
        }
            
        if(pessoa.getEmail() == null || 
            pessoa.getEmail().isBlank() ||
            pessoa.getEmail().isEmpty()){
            throw new CampoNaoInformadoException("Email");
        }
        
        if(pessoa.getEmail().length() > 40){
            throw new TamanhoCampoInvalidoException("Email",40);
        }
        
    } 
    
}
