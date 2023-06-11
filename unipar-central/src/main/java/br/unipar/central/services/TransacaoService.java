
package br.unipar.central.services;

import br.unipar.central.exceptions.CampoNaoInformadoException;
import br.unipar.central.exceptions.EntidadeNaoInformadaException;
import br.unipar.central.exceptions.TamanhoCampoInvalidoException;
import br.unipar.central.models.Transacao;
import br.unipar.central.repositories.TransacaoDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

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
    
    public List<Transacao> findAll() throws SQLException{
        
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<Transacao> resultado = transacaoDAO.findAll();
        
        return resultado;
    }
    
    public Transacao findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        
        Transacao retorno = transacaoDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar um pais com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(Transacao transacao)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(transacao);//validar todas as exceções
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.insert(transacao);
        
    }
    
    public void update(Transacao transacao) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(transacao);
        TransacaoDAO transacaoDAO= new TransacaoDAO();
        transacaoDAO.update(transacao);
    
    }
    
    public void delete(int id) throws SQLException{
        
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        transacaoDAO.delete(id);
        
    }
    
}
