
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public abstract class AbstractBaseEntiny {
    
    private int id;
    private String registroAcademico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }
    
    
    
}
