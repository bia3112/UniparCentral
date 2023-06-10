
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Transacao;
import java.text.SimpleDateFormat;

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
 
        if(String.valueOf(transacao.getValor()) == null || 
                String.valueOf(transacao.getValor()).isBlank() ||
                String.valueOf(transacao.getValor()).isEmpty()){
            throw new CampoNaoInformadoException("Valor");
        }
        
        if(transacao.getDataHora() == null ||
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(transacao.getDataHora()).isBlank() ||
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(transacao.getDataHora()).isEmpty()){
            throw new CampoNaoInformadoException("DataHora");
        }

    }
}
