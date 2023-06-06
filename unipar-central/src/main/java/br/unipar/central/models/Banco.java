
package br.unipar.central.models;

import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
public class Banco extends AbstractBaseEntiny{
    
    private  String nome;
    private ArrayList<Agencia> agencias = new ArrayList<>();

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

    public ArrayList<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(ArrayList<Agencia> agencias) {
        this.agencias = agencias;
    }

    @Override
    public String toString() {
        return "Banco{" + "nome=" + nome + ", agencias=" + agencias + '}';
    }

}
