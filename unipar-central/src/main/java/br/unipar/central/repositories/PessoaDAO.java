
package br.unipar.central.repositories;

import br.unipar.central.models.Endereco;
import br.unipar.central.models.Pessoa;
import br.unipar.central.models.Telefone;
import br.unipar.central.utils.DataBaseUtils;
import java.sql.Array;
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
public class PessoaDAO {
    
    private static final String INSERT = "INSERT INTO PESSOA" 
            + "(ID, RA, EMAIL, ENDERECO_ID, TELEFONE_ID) "
            + "VALUES(?, ?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT ID, RA, EMAIL, ENDERECO_ID, TELEFONE_ID " +
            "FROM PESSOA";
    
    private static final String FIND_BY_ID =
            "SELECT ID, RA, EMAIL, ENDERECO_ID, TELEFONE_ID " +
            "FROM PESSOA " +
            "WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM PESSOA WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE PESSOA SET RA = ?, EMAIL = ?, ENDERECO_ID = ?, " + 
            " TELEFONE_ID = ? " +
            "WHERE ID = ?";
    
    public List<Pessoa> findall() throws SQLException{
        ArrayList<Pessoa> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{          
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){                
                Pessoa pessoa = new Pessoa();
                
                pessoa.setId(rs.getInt("ID"));
                pessoa.setRegistroAcademico(rs.getString("RA"));
                pessoa.setEmail(rs.getString("EMAIL"));
                ArrayList<Endereco> enderecos = new ArrayList<>();
                    enderecos.add(new EnderecoDAO().findById(rs.getInt("ENDERECO_ID")));
                    pessoa.setEnderecos(enderecos);          
                ArrayList<Telefone> telefones = new ArrayList<>();
                    telefones.add(new TelefoneDAO().findById(rs.getInt("TELEFONE_ID")));
                    pessoa.setTelefones(telefones);
               
                retorno.add(pessoa);   
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
    
    public Pessoa findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pessoa retorno = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Pessoa(); 
               
               retorno.setId(rs.getInt("ID"));
               retorno.setRegistroAcademico(rs.getString("RA"));
               retorno.setEmail(rs.getString("EMAIL"));
                ArrayList<Endereco> enderecos = new ArrayList<>();
                    enderecos.add(new EnderecoDAO().findById(rs.getInt("ENDERECO_ID")));
                    retorno.setEnderecos(enderecos);          
                ArrayList<Telefone> telefones = new ArrayList<>();
                    telefones.add(new TelefoneDAO().findById(rs.getInt("TELEFONE_ID")));
                    retorno.setTelefones(telefones);
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
    
    public void insert(Pessoa pessoa) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, pessoa.getRegistroAcademico());
            pstmt.setString(3, pessoa.getEmail());
            Array enderecoIdsArray = conn.createArrayOf("INTEGER", pessoa.getEnderecos().stream().map(Endereco::getId).toArray());
            pstmt.setArray(4, enderecoIdsArray);
            Array telefoneIdsArray = conn.createArrayOf("INTEGER", pessoa.getTelefones().stream().map(Telefone::getId).toArray());
            pstmt.setArray(5, telefoneIdsArray);

            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
        
        public void update(Pessoa pessoa) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, pessoa.getRegistroAcademico());
            pstmt.setString(3, pessoa.getEmail());
            Array enderecoIdsArray = conn.createArrayOf("INTEGER", pessoa.getEnderecos().stream().map(Endereco::getId).toArray());
            pstmt.setArray(4, enderecoIdsArray);
            Array telefoneIdsArray = conn.createArrayOf("INTEGER", pessoa.getTelefones().stream().map(Telefone::getId).toArray());
            pstmt.setArray(5, telefoneIdsArray);
            
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
