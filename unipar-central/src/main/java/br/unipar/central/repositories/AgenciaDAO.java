
package br.unipar.central.repositories;

import br.unipar.central.models.Agencia;
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
public class AgenciaDAO {
    
    private static final String INSERT = "INSERT INTO AGENCIA" 
            + "(ID, RA, CODIGO, RAZAOSOCIAL, CNPJ, BANCO_ID) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT ID, RA, CODIGO, RAZAOSOCIAL, CNPJ, BANCO_ID " +
            "FROM AGENCIA";
    
    private static final String FIND_BY_ID =
            "SELECT ID, RA, CODIGO, RAZAOSOCIAL, CNPJ, BANCO_ID " +
            "FROM AGENCIA " +
            "WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM AGENCIA WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE AGENCIA SET RA = ?, CODIGO = ?, RAZAOSOCIAL = ?, " + 
            "CNPJ = ?, BANCO_ID = ? " +
            "WHERE ID = ?";
    
    public List<Agencia> findAll() throws SQLException{
        ArrayList<Agencia> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{          
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){                
                Agencia agencia = new Agencia();
                
                agencia.setId(rs.getInt("ID"));
                agencia.setRegistroAcademico(rs.getString("RA"));
                agencia.setCodigo(rs.getString("CODIGO"));
                agencia.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                agencia.setCnpj(rs.getString("CNPJ"));
                agencia.setBanco(new BancoDAO().findById(rs.getInt("BANCO_ID")));
                
                retorno.add(agencia);   
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
    
    public Agencia findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Agencia retorno = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Agencia(); 
               
               retorno.setId(rs.getInt("ID"));
               retorno.setRegistroAcademico(rs.getString("RA"));
               retorno.setCodigo(rs.getString("CODIGO"));
               retorno.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
               retorno.setCnpj(rs.getString("CNPJ"));
               retorno.setBanco(new BancoDAO().findById(rs.getInt("BANCO_ID")));
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
    
    public void insert(Agencia agencia) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getRegistroAcademico());
            pstmt.setString(3, agencia.getCodigo());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getCnpj());
            pstmt.setInt(6, agencia.getBanco().getId());

            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
        
        public void update(Agencia agencia) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getRegistroAcademico());
            pstmt.setString(3, agencia.getCodigo());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getCnpj());
            pstmt.setInt(6, agencia.getBanco().getId());
            
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
