
package br.unipar.central;

import br.unipar.central.models.Pais;
import br.unipar.central.services.PaisService;
import javax.swing.JOptionPane;

/**
 *
 * @author Beatr
 */
public class UniparCentral {

    public static void main(String[] args) {

        try{
            
            PaisService service = new PaisService();
            //List<Pais> resultado = service.findAll(); montra todos os dados da tabela

            Pais resultado = service.findById(10584564);
            System.out.println(resultado.toString());
            
            Pais pais = new Pais();
            pais.setId(234);
            pais.setNome("");
            pais.setRegistroAcademico("17221");
            pais.setSigla("JO");
            
            //service.insert(pais);
            //service.update(pais);
            //service.delete(234);
        
        }catch (Exception ex){
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
            
    }
}
