
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class Banco extends AbstractBaseEntiny{
    
    private  String nome;

    public Banco() {
    }

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Banco{" + "nome=" + nome + '}';
    }
    
}
