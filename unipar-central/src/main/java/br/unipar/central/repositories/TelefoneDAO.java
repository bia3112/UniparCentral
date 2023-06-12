
package br.unipar.central.repositories;

import br.unipar.central.enums.TipoOperadoraEnum;
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
            "(ID, RA, NUMERO, OPERADORA, AGENCIA_ID, PESSOA_ID) " +
            "VALUES(?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT ID, RA, NUMERO, OPERADORA, AGENCIA_ID, PESSOA_ID " +
            "FROM TELEFONE ";
    
    private static final String FIND_BY_ID =
            "SELECT ID, RA, NUMERO, OPERADORA, AGENCIA_ID, PESSOA_ID  " +
            "FROM TELEFONE " +
            "WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM TELEFONE WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE TELEFONE SET RA = ?, " + 
            " NUMERO = ?, OPERADORA = ? , AGENCIA_ID = ?, PESSOA_ID = ?" +
            "WHERE ID = ?";
    
    public List<Telefone> findAll() throws SQLException{
        
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
                telefone.setOperadora(TipoOperadoraEnum.valueOf(rs.getString("OPERADORA")));
                telefone.setAgencia(new AgenciaDAO().findById(rs.getInt("AGENCIA_ID")));
                telefone.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));

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
               retorno.setOperadora(TipoOperadoraEnum.valueOf(rs.getString("OPERADORA")));
               retorno.setAgencia(new AgenciaDAO().findById(rs.getInt("AGENCIA_ID")));
               retorno.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
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
            pstmt.setString(4, telefone.getOperadora().name());
            pstmt.setInt(5, telefone.getAgencia().getId());
            pstmt.setInt(6, telefone.getPessoa().getId());
            
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
            pstmt.setString(4, telefone.getOperadora().name());
            pstmt.setInt(5, telefone.getAgencia().getId());
            pstmt.setInt(6, telefone.getPessoa().getId());

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
