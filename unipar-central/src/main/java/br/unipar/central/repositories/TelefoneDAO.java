
package br.unipar.central.repositories;

import br.unipar.central.models.Telefone;
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
public class TelefoneDAO {
    
    private static final String INSERT =
            "INSERT INTO TELEFONE " +
            "(ID, RA, NUMERO, OPERADORA) " +
            "VALUES(?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT ID, RA, NUMERO, OPERADORA  " +
            "FROM TELEFONE ";
    
    private static final String FIND_BY_ID =
            "SELECT ID, RA, NUMERO, OPERADORA  " +
            "FROM TELEFONE " +
            "WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM TELEFONE WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE TELEFONE SET RA = ?, " + 
            " NUMERO = ?, OPERADORA = ? " +
            "WHERE ID = ?";
    
    public List<Telefone> findall() throws SQLException{
        
        ArrayList<Telefone> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{  
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("ID"));
                telefone.setRegistroAcademico(rs.getString("RA"));
                telefone.setNumero(rs.getString("NUMERO"));
                telefone.setOperadora(rs.getString("OPERADORA"));

                retorno.add(telefone);
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
    
    public Telefone findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Telefone retorno = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Telefone();
               retorno.setId(rs.getInt("ID"));
               retorno.setRegistroAcademico(
                       rs.getString("RA"));
               retorno.setNumero(rs.getString("NUMERO"));
               retorno.setOperadora(rs.getString("OPERADORA"));
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
    
    public void insert(Telefone telefone) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, telefone.getId());
            pstmt.setString(2, telefone.getRegistroAcademico());
            pstmt.setString(3, telefone.getNumero());
            pstmt.setString(4, telefone.getOperadora());  
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
    
    public void update(Telefone telefone) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {         
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, telefone.getId());
            pstmt.setString(2, telefone.getRegistroAcademico());
            pstmt.setString(3, telefone.getNumero());
            pstmt.setString(4, telefone.getOperadora());

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
