
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Conta;
import br.unipar.central.repositories.ContaDAO;
import java.sql.SQLException;
import java.util.List;

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
                String.valueOf(conta.getTipo()).isBlank() ||
                String.valueOf(conta.getTipo()).isEmpty()){
        throw new CampoNaoInformadoException("Tipo");
        }
        
        if(String.valueOf(conta.getDigito()) == null ||
                String.valueOf(conta.getDigito()).isBlank() ||
                String.valueOf(conta.getDigito()).isEmpty()){
            throw new CampoNaoInformadoException("Digito");
        }
        if(conta.getDigito() > 2){
            throw new TamanhoCampoInvalidoException("Digito", 2);
        }
        
        if(String.valueOf(conta.getSaldo()) == null ||
                String.valueOf(conta.getSaldo()).isBlank() ||
                String.valueOf(conta.getSaldo()).isEmpty()){
            throw new CampoNaoInformadoException("Saldo");
        }
            
    }
    
    public List<Conta> findAll() throws SQLException{
        
        ContaDAO contaDAO = new ContaDAO();
        List<Conta> resultado = contaDAO.findAll();
        
        return resultado;
    }
    
    public Conta findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        ContaDAO agenciaDAO = new ContaDAO();
        
        Conta retorno = agenciaDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar um conta com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(Conta conta)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.insert(conta);
        
    }
    
    public void update(Conta conta) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(conta);
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.update(conta);
    
    }
    
    public void delete(int id) throws SQLException{
        
        ContaDAO contaDAO = new ContaDAO();
        contaDAO.delete(id);
        
    }
    
}
