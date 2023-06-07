
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Telefone;

/**
 *
 * @author Beatr
 */
public class TelefoneService {
    
    public void validar(Telefone telefone) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(telefone == null){
            throw new EntidadeNaoInformadaException("Endereco");
        }
            
        if(telefone.getNumero() == null || 
            telefone.getNumero().isBlank() ||
            telefone.getNumero().isEmpty()){
            throw new CampoNaoInformadoException("Numero");
        }
        
        if(telefone.getNumero().length() > 11){
            throw new TamanhoCampoInvalidoException("Numero",11);
        }
        
        if(telefone.getOperadora() == null || 
            telefone.getOperadora().isBlank() ||
            telefone.getOperadora().isEmpty()){
            throw new CampoNaoInformadoException("Operadora");
        }
        
        if(telefone.getOperadora().length() > 50){
            throw new TamanhoCampoInvalidoException("Operadora",50);
        }
        
    }
    
}
