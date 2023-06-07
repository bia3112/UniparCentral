
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.PessoaJuridica;

/**
 *
 * @author Beatr
 */
public class PessoaJuridicaService {
    
    public void validar(PessoaJuridica pessoaJuridica) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(pessoaJuridica == null){
            throw new EntidadeNaoInformadaException("PessoaJuridica");
        }
            
        if(pessoaJuridica.getCnpj() == null || 
            pessoaJuridica.getCnpj().isBlank() ||
            pessoaJuridica.getCnpj().isEmpty()){
            throw new CampoNaoInformadoException("Cnpj");
        }
        
        if(pessoaJuridica.getCnpj().length() > 14){
            throw new TamanhoCampoInvalidoException("Cnpj",14);
        }
        
        if(pessoaJuridica.getCnpj() == null || 
            pessoaJuridica.getCnpj().isBlank() ||
            pessoaJuridica.getCnpj().isEmpty()){
            throw new CampoNaoInformadoException("Cnpj");
        }
        
        if(pessoaJuridica.getCnpj().length() > 14){
            throw new TamanhoCampoInvalidoException("Cnpj",14);
        }
        
        if(pessoaJuridica.getRazaoSocial() == null || 
            pessoaJuridica.getRazaoSocial().isBlank() ||
            pessoaJuridica.getRazaoSocial().isEmpty()){
            throw new CampoNaoInformadoException("RazaoSocial");
        }
        
        if(pessoaJuridica.getRazaoSocial().length() > 80){
            throw new TamanhoCampoInvalidoException("RazaoSocial",80);
        }
        
        if(pessoaJuridica.getCnaePrincipal() == null || 
            pessoaJuridica.getCnaePrincipal().isBlank() ||
            pessoaJuridica.getCnaePrincipal().isEmpty()){
            throw new CampoNaoInformadoException("CnaePrincipal");
        }
        
        if(pessoaJuridica.getCnaePrincipal().length() > 7){
            throw new TamanhoCampoInvalidoException("CnaePrincipal",7);
        }
        
        if(pessoaJuridica.getFantasia() == null || 
            pessoaJuridica.getFantasia().isBlank() ||
            pessoaJuridica.getFantasia().isEmpty()){
            throw new CampoNaoInformadoException("Fantasia");
        }
        
        if(pessoaJuridica.getFantasia().length() > 80){
            throw new TamanhoCampoInvalidoException("Fantasia",80);
        }
        
    }
    
}
