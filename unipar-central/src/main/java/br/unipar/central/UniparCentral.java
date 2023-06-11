
package br.unipar.central;

import br.unipar.central.models.Estado;
import br.unipar.central.models.Pais;
import br.unipar.central.models.Transacao;
import br.unipar.central.repositories.EstadoDAO;
import br.unipar.central.services.PaisService;
import br.unipar.central.services.TransacaoService;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Beatr
 */
public class UniparCentral {

    public static void main(String[] args) {

        try {
            
            //PaisService service = new PaisService();
            //List<Pais> resultado = service.findAll();
            
            //System.out.println(resultado.toString());
            
           // Pais pais = new Pais();
            //pais.setId(525257);
            //pais.setNome("PAIS PROF BOSINGGGGGGPAIS");
            //pais.setRegistroAcademico("17221");
            //pais.setSigla("B8");
            
            //service.insert(pais);
            //service.update(pais);
            //service.delete(525257);
            
            TransacaoService service = new TransacaoService();
            List<Transacao> resultado = service.findAll();
            System.out.println(resultado.toString());
            
            
//            EstadoDAO estadoDAO = new EstadoDAO();
//            List<Estado> listaEstados = estadoDAO.findAll();
//            
//            System.out.println(listaEstados.toString());
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                    ex.getMessage());
        }
            
    }
}
