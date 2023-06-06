
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Agencia;

/**
 *
 * @author Beatr
 */
public class AgenciaService {
    
    public void validar(Agencia agencia) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(agencia == null){
            throw new EntidadeNaoInformadaException("Agencia");
        }
        
        if(agencia.getCodigo() == null ||
                agencia.getCodigo().isBlank() ||
                agencia.getCodigo().isEmpty()){
            throw new CampoNaoInformadoException("Código");
        }
        
        if(agencia.getCodigo().length() > 3){
            throw new TamanhoCampoInvalidoException("Código",3);
        }
        
        if(agencia.getRazaoSocial() == null ||
                agencia.getRazaoSocial().isBlank() ||
                agencia.getRazaoSocial().isEmpty()){
            throw new CampoNaoInformadoException("Razao Social");
        }
        
        if(agencia.getRazaoSocial().length() > 80){
            throw new TamanhoCampoInvalidoException("Razao Social",80);
        }
        
        if(agencia.getCnpj() == null ||
                agencia.getCnpj().isBlank() ||
                agencia.getCnpj().isEmpty()){
            throw new CampoNaoInformadoException("Cnpj");
        }
        
        if(agencia.getCnpj().length() > 14){
            throw new TamanhoCampoInvalidoException("Cnpj",14);
        }

    }
    
}
