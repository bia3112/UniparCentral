
package br.unipar.central.repositories;

import br.unipar.central.models.Banco;
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
public class BancoDAO {
    
    private static final String INSERT =
            "INSERT INTO BANCO " +
            "(ID, NOME, RA) " +
            "VALUES(?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT ID, NOME, RA " +
            "FROM BANCO ";
    
    private static final String FIND_BY_ID =
            "SELECT ID, NOME, RA " +
            "FROM BANCO " +
            "WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM BANCO WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE BANCO SET NOME = ?, RA = ?, " + 
            "WHERE ID = ?";
    
    public List<Banco> findAll() throws SQLException {
        
        ArrayList<Banco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                Banco banco = new Banco();
                banco.setId(rs.getInt("ID"));
                banco.setNome(rs.getString("NOME"));
                banco.setRegistroAcademico(
                        rs.getString("RA"));
                
                retorno.add(banco);
                
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
    
    public Banco findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Banco retorno = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Banco();
               retorno.setId(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setRegistroAcademico(
                       rs.getString("RA"));
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
    
    public void insert(Banco banco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, banco.getId());
            pstmt.setString(2, banco.getNome());
            pstmt.setString(3, banco.getRegistroAcademico());
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(Banco banco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, banco.getId());
            pstmt.setString(2, banco.getNome());
            pstmt.setString(3, banco.getRegistroAcademico());
            
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
