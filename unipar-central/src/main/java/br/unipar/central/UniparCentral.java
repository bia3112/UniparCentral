
package br.unipar.central;

import br.unipar.central.enums.TipoTransacaoEnum;
import br.unipar.central.models.Agencia;
import br.unipar.central.models.Banco;
import br.unipar.central.models.Cidade;
import br.unipar.central.models.Conta;
import br.unipar.central.models.Endereco;
import br.unipar.central.models.Estado;
import br.unipar.central.models.Pais;
import br.unipar.central.models.Pessoa;
import br.unipar.central.models.PessoaFisica;
import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.models.Telefone;
import br.unipar.central.models.Transacao;
import br.unipar.central.repositories.AgenciaDAO;
import br.unipar.central.repositories.BancoDAO;
import br.unipar.central.repositories.CidadeDAO;
import br.unipar.central.repositories.ContaDAO;
import br.unipar.central.repositories.EnderecoDAO;
import br.unipar.central.repositories.EstadoDAO;
import br.unipar.central.repositories.PessoaDAO;
import br.unipar.central.repositories.PessoaFisicaDAO;
import br.unipar.central.repositories.PessoaJuridicaDAO;
import br.unipar.central.repositories.TelefoneDAO;
import br.unipar.central.repositories.TransacaoDAO;
import br.unipar.central.services.PaisService;
import br.unipar.central.services.TransacaoService;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Beatr
 */
public class UniparCentral {

    public static void main(String[] args) {

        try {
            
    //      PaisService service = new PaisService();
    //      List<Pais> resultado = service.findAll();
    //      System.out.println(resultado.toString());
            
           // Pais pais = new Pais();
            //pais.setId(525257);
            //pais.setNome("PAIS PROF BOSINGGGGGGPAIS");
            //pais.setRegistroAcademico("17221");
            //pais.setSigla("B8");
            //service.insert(pais);
            //service.update(pais);
            //service.delete(525257);
            
            Transacao transacao = new Transacao();
            transacao.setTipo(TipoTransacaoEnum.TED);
            transacao.setDataHora(new Timestamp(System.currentTimeMillis()));
            transacao.setValor(548);
            transacao.setContaOrigem();
            
            
        //  EstadoDAO estadoDAO = new EstadoDAO();
        //  List<Estado> listaEstados = estadoDAO.findAll();
        //  System.out.println(listaEstados.toString());

        //  CidadeDAO cidadeDAO = new CidadeDAO();
        //  List<Cidade> listaCidade = cidadeDAO.findAll();
        //  System.out.println(listaCidade.toString());

        //  AgenciaDAO agenciaDAO = new AgenciaDAO();
        //  List<Agencia> listaAgencia = agenciaDAO.findAll();
        //  System.out.println(listaAgencia.toString());

//            BancoDAO bancoDAO = new BancoDAO();
//            List<Banco> listaBanco = bancoDAO.findAll();
//            System.out.println(listaBanco.toString());

//           EnderecoDAO enderecoDAO = new EnderecoDAO();
//           List<Endereco> listaEndereco = enderecoDAO.findAll();
//            System.out.println(listaEndereco.toString());

//        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
//        List<PessoaFisica> listaPessoaFisica = pessoaFisicaDAO.findAll();
//        System.out.println(listaPessoaFisica.toString());

//            PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
//            List<PessoaJuridica> listaPessoaJuridica = pessoaJuridicaDAO.findAll();
//            System.out.println(listaPessoaJuridica.toString());

//            TelefoneDAO telefoneDAO = new TelefoneDAO();
//            List<Telefone> listaTelefone = telefoneDAO.findAll();
//            System.out.println(listaTelefone.toString());

//                ContaDAO contaDAO = new ContaDAO();
//                List<Conta> listaConta = contaDAO.findAll();
//                System.out.println(listaConta.toString());

//                PessoaDAO pessoaDAO = new PessoaDAO();
//                List<Pessoa> listaPessoa = pessoaDAO.findAll();
//                System.out.println(listaPessoa.toString());
            
            TransacaoDAO transacaoDAO = new TransacaoDAO();
            List<Transacao> listaTransacao = transacaoDAO.findAll();
            System.out.println(listaTransacao.toString());
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                    ex.getMessage());
        }
            
    }
}
