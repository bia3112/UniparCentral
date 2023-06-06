
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Endereco;

/**
 *
 * @author Beatr
 */
public class EnderecoService {
    
    public void validar(Endereco endereco) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(endereco == null){
            throw new EntidadeNaoInformadaException("Endereco");
        }
        
        if(endereco.getLogradouro() == null || 
            endereco.getLogradouro().isBlank() ||
            endereco.getLogradouro().isEmpty()){
            throw new CampoNaoInformadoException("Logradouro");
        }
        
        if(endereco.getLogradouro().length() > 120){
            throw new TamanhoCampoInvalidoException("Logradouro",120);
        }
        
        if(endereco.getBairro() == null || 
            endereco.getBairro().isBlank() ||
            endereco.getBairro().isEmpty()){
            throw new CampoNaoInformadoException("Bairro");
        }
        
        if(endereco.getBairro().length() > 80){
            throw new TamanhoCampoInvalidoException("Bairro",80);
        }
        
        if(endereco.getComplemento() == null ||
                endereco.getComplemento().isBlank() ||
                endereco.getComplemento().isEmpty()){
            throw new CampoNaoInformadoException("Complemento");
        }
        
        if(endereco.getComplemento().length() > 120){
            throw new TamanhoCampoInvalidoException("Complemento", 120);
        }
     
    }
    
}
