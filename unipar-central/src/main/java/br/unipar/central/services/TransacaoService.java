
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Transacao;

/**
 *
 * @author Beatr
 */
public class TransacaoService {
    
    public void validar(Transacao transacao) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(transacao == null){
            throw new EntidadeNaoInformadaException("Transacao");
        }
            
        if(transacao.getTipo() == null || 
            transacao.getTipo().isBlank() ||
            transacao.getTipo().isEmpty()){
            throw new CampoNaoInformadoException("Tipo");
        }
        
        if(transacao.getTipo().length() > 30){
            throw new TamanhoCampoInvalidoException("Tipo",30);
        }

        if(transacao.getValor(String.valueOf(this.getValor())) == null || 
            transacao.getValor(String.valueOf(getValor)).isBlank() ||
            transacao.getValor(String.valueOf(getValor)).isEmpty()){
            throw new CampoNaoInformadoException("Tipo");
        }
        
        if(transacao.getValor().length() > 30){
            throw new TamanhoCampoInvalidoException("Tipo",30);
        }
        
    }
