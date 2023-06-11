
package br.unipar.central.repositories;

import br.unipar.central.models.Transacao;
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
public class TransacaoDAO {
    
    private static final String INSERT =
            "INSERT INTO TRANSACAO " +
            "(ID, DATAHORA, VALOR, TIPO, RA, CONTA_ORIGEM, CONTA_DESTINO) " +
            "VALUES(?, ?, ?, ?, ?)";
    
    private static final String FIND_ALL =
            "SELECT ID, DATAHORA, VALOR, TIPO, RA, CONTA_ORIGEM, CONTA_DESTINO  " +
            "FROM TRANSACAO ";
    
    private static final String FIND_BY_ID =
            "SELECT ID, DATAHORA, VALOR, TIPO, RA, CONTA_ORIGEM, CONTA_DESTINO  " +
            "FROM TRANSACAO " +
            "WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
            "DELETE FROM TRANSACAO WHERE ID = ?";
    
    private static final String UPDATE = 
            "UPDATE TRANSACAO SET ID = ?, DATAHORA = ?, VALOR = ?, " + 
            "TIPO = ?, RA = ?, CONTA_ORIGEM = ?, CONTA_DESTINO = ? " +
            "WHERE ID = ?";
    
    public List<Transacao> findAll() throws SQLException {
        
        ArrayList<Transacao> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                Transacao transacao = new Transacao();
                transacao.setId(rs.getInt("ID"));
                transacao.setTipo(rs.getString("TIPO"));
                transacao.setDataHora(rs.getTimestamp("DATAHORA"));
                transacao.setValor(rs.getDouble("VALOR"));
                transacao.setContaOrigem(new ContaDAO().findById(rs.getInt("CONTA_ORIGEM")));
                transacao.setContaDestino(new ContaDAO().findById(rs.getInt("CONTA_DESTINO")));
                
                retorno.add(transacao);
                
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
    
    public Transacao findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Transacao retorno = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Transacao();
              
               retorno.setId(rs.getInt("ID"));
               retorno.setTipo(rs.getString("TIPO"));
               retorno.setDataHora(rs.getTimestamp("DATAHORA"));
               retorno.setValor(rs.getDouble("VALOR"));
               retorno.setContaOrigem(new ContaDAO().findById(rs.getInt("CONTA_ORIGEM")));
               retorno.setContaDestino(new ContaDAO().findById(rs.getInt("CONTA_DESTINO")));
               
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
    
    public void insert(Transacao transacao) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, transacao.getId());
            pstmt.setString(2, transacao.getTipo());
            pstmt.setTimestamp(3, transacao.getDataHora());
            pstmt.setDouble(4, transacao.getValor());
            pstmt.setInt(5, transacao.getContaOrigem().getId());
            pstmt.setInt(6, transacao.getContaDestino().getId());
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(Transacao transacao) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, transacao.getId());
            pstmt.setString(2, transacao.getTipo());
            pstmt.setTimestamp(3, transacao.getDataHora());
            pstmt.setDouble(4, transacao.getValor());
            pstmt.setInt(5, transacao.getContaOrigem().getId());
            pstmt.setInt(6, transacao.getContaDestino().getId());
            
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
