
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.PessoaFisica;
import java.text.SimpleDateFormat;

/**
 *
 * @author Beatr
 */
public class PessoaFisicaService {
    
    public void validar(PessoaFisica pessoaFisica) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(pessoaFisica == null){
            throw new EntidadeNaoInformadaException("PessoaFisica");
        }
            
        if(pessoaFisica.getNome() == null || 
            pessoaFisica.getNome().isBlank() ||
            pessoaFisica.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        }       
        if(pessoaFisica.getNome().length() > 80){
            throw new TamanhoCampoInvalidoException("Nome",80);
        }
        
        if(pessoaFisica.getCpf() == null || 
            pessoaFisica.getCpf().isBlank() ||
            pessoaFisica.getCpf().isEmpty()){
            throw new CampoNaoInformadoException("Cpf");
        }        
        if(pessoaFisica.getCpf().length() > 11){
            throw new TamanhoCampoInvalidoException("Cpf",11);
        }
        
        if(pessoaFisica.getRg() == null || 
            pessoaFisica.getRg().isBlank() ||
            pessoaFisica.getRg().isEmpty()){
            throw new CampoNaoInformadoException("Rg");
        }        
        if(pessoaFisica.getRg().length() > 8){
            throw new TamanhoCampoInvalidoException("Rg",8);
        }
        
        if(pessoaFisica.getDtNascimento() == null ||
           new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pessoaFisica.getDtNascimento()).isBlank() ||
           new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pessoaFisica.getDtNascimento()).isEmpty()){
            throw new CampoNaoInformadoException("DtNascimento");
        } 
        
    }
    
}
