
package br.unipar.central.repositories;

import br.unipar.central.models.PessoaFisica;
import br.unipar.central.utils.DataBaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class PessoaFisicaDAO {
    
    private static final String INSERT =
            "INSERT INTO PESSOAFISICA " +
            "(NOME, CPF, RG, DATANASCIMENTO, PESSOA_ID) " +
            "VALUES(?, ?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT NOME, CPF, RG, DATANASCIMENTO, PESSOA_ID  " +
            "FROM PESSOAFISICA ";
    
    private static final String FIND_BY_ID =
            "SELECT NOME, CPF, RG, DATANASCIMENTO, PESSOA_ID  " +
            "FROM PESSOAFISICA " +
            "WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM PESSOAFISICA WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE PESSOAFISICA SET NOME = ?, CPF = ?, RG = ?, " + 
            "DATANASCIMENTO = ?, PESSOA_ID = ? " +
            "WHERE ID = ?";
    
    public List<PessoaFisica> findAll() throws SQLException {
        
        ArrayList<PessoaFisica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                PessoaFisica pessoaFisica = new PessoaFisica();
                
                pessoaFisica.setNome(rs.getString("NOME"));
                pessoaFisica.setCpf(rs.getString("CPF"));
                pessoaFisica.setRg(rs.getString("RG"));
                pessoaFisica.setDtNascimento(rs.getDate("DATANASCIMENTO"));
                pessoaFisica.setId(rs.getInt("PESSOA_ID"));
                
                retorno.add(pessoaFisica);
                
            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null) 
                conn.close();
        }
        
        return retorno;
        
    }
    
    public PessoaFisica findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica retorno = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                retorno = new PessoaFisica();
                retorno.setNome(rs.getString("NOME"));
                retorno.setCpf(rs.getString("CPF"));
                retorno.setRg(rs.getString("RG"));
                retorno.setDtNascimento(rs.getDate("DATANASCIMENTO"));
                retorno.setId(rs.getInt("PESSOA_ID"));
            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
            
        }
        
        return retorno;
        
    }
    
    public void insert(PessoaFisica pessoaFisica) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT, new String[]{"id"});
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, pessoaFisica.getDtNascimento());
            pstmt.setInt(5, pessoaFisica.getId());     
            
            pstmt.executeUpdate();   
            rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                int idGerado = rs.getInt(1);
                pessoaFisica.setId(idGerado);
            }
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(PessoaFisica pessoaFisica) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setString(2, pessoaFisica.getCpf());
            pstmt.setString(3, pessoaFisica.getRg());
            pstmt.setDate(4, pessoaFisica.getDtNascimento());
            pstmt.setInt(5, pessoaFisica.getId());
            
            pstmt.executeUpdate();
            
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    
    public void delete(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        
    }
    
}
