
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class Banco extends AbstractBaseEntiny{
    
    private  String nome;
    private Agencia agencia;

    public Banco() {
    }

    public Banco(String nome, Agencia agencia) {
        this.nome = nome;
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Banco{" + "nome=" + nome + ", agencia=" + agencia + '}';
    }

}
