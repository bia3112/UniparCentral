
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Conta;

/**
 *
 * @author Beatr
 */
public class ContaService {
    
    public void validar(Conta conta) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(conta == null){
            throw new EntidadeNaoInformadaException("Conta");
        }
        
        if(conta.getNumero() == null || 
            conta.getNumero().isBlank() ||
            conta.getNumero().isEmpty()){
            throw new CampoNaoInformadoException("Numero");
        } 
        if(conta.getNumero().length() > 10){
            throw new TamanhoCampoInvalidoException("Numero",10);
        }
        
        if(conta.getTipo() == null || 
            conta.getTipo().isBlank() ||
            conta.getTipo().isEmpty()){
            throw new CampoNaoInformadoException("Tipo");
        } 
        if(conta.getTipo().length() > 20){
            throw new TamanhoCampoInvalidoException("Tipo",20);
        }
        
        if(String.valueOf(conta.getDigito()) == null ||
                String.valueOf(conta.getDigito()).isBlank() ||
                String.valueOf(conta.getDigito()).isEmpty()){
            throw new CampoNaoInformadoException("Digito");
        }
        
        if(String.valueOf(conta.getSaldo()) == null ||
                String.valueOf(conta.getSaldo()).isBlank() ||
                String.valueOf(conta.getSaldo()).isEmpty()){
            throw new CampoNaoInformadoException("Saldo");
        }
            
    }
    
}
