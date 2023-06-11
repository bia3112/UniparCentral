
package br.unipar.central.repositories;

import br.unipar.central.models.Endereco;
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
public class EnderecoDAO {
    
    private static final String INSERT = "INSERT INTO ENDERECO" 
            + "(ID, RA, LOGRADOURO, NUMERO, BAIRRO, CEP, COMPLEMENTO, PESSOA_ID, CIDADE_ID) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT ID, RA, LOGRADOURO, NUMERO, BAIRRO, CEP, COMPLEMENTO, PESSOA_ID, CIDADE_ID " +
            "FROM ENDERECO";
    
    private static final String FIND_BY_ID =
            "SELECT ID, RA, LOGRADOURO, NUMERO, BAIRRO, CEP, COMPLEMENTO, PESSOA_ID, CIDADE_ID " +
            "FROM ENDERECO " +
            "WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM ENDERECO WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE ENDERECO SET RA = ?, LOGRADOURO = ?, NUMERO = ?, " + 
            "BAIRRO = ? , CEP = ?, COMPLEMENTO = ?, PESSOA_ID = ?, CIDADE_ID = ? " +
            "WHERE ID = ?";
    
    public List<Endereco> findall() throws SQLException{
        ArrayList<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{          
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){                
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("ID"));
                endereco.setRegistroAcademico(rs.getString("RA"));
                endereco.setLogradouro(rs.getString("LOGRADOURO"));
                endereco.setNumero(rs.getInt("NUMERO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setCep(rs.getInt("CEP"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));              
                endereco.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
                endereco.setCidade(new CidadeDAO().findById(rs.getInt("CIDADE_ID")));
               
                retorno.add(endereco);   
            }          
        }finally{            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null) 
                conn.close();       
        }   
        return retorno;
    }
    
    public Endereco findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Endereco(); 
               
               retorno.setId(rs.getInt("ID"));
               retorno.setRegistroAcademico(rs.getString("RA"));
               retorno.setLogradouro(rs.getString("LOGRAOUDRO"));
               retorno.setNumero(rs.getInt("NUMERO"));
               retorno.setBairro(rs.getString("BAIRRO"));
               retorno.setCep(rs.getInt("CEP"));
               retorno.setComplemento(rs.getString("COMPLEMENTO"));
               retorno.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
               retorno.setCidade(new CidadeDAO().findById(rs.getInt("CIDADE_ID")));
               
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
    
    public void insert(Endereco endereco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getRegistroAcademico());
            pstmt.setString(3, endereco.getLogradouro());
            pstmt.setInt(4, endereco.getNumero());
            pstmt.setString(5, endereco.getBairro());
            pstmt.setInt(6, endereco.getCep());
            pstmt.setString(7, endereco.getComplemento());
            pstmt.setInt(8, endereco.getPessoa().getId());
            pstmt.setInt(9, endereco.getCidade().getId());

            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
        
        public void update(Endereco endereco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getRegistroAcademico());
            pstmt.setString(3, endereco.getLogradouro());
            pstmt.setInt(4, endereco.getNumero());
            pstmt.setString(5, endereco.getBairro());
            pstmt.setInt(6, endereco.getCep());
            pstmt.setString(7, endereco.getComplemento());
            pstmt.setInt(8, endereco.getPessoa().getId());
            pstmt.setInt(9, endereco.getCidade().getId());
            
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
