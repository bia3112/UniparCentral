
package br.unipar.central.models;

/**
 *
 * @author Beatr
 */
public class Pessoa extends AbstractBaseEntiny{
    
    private String email;

    public Pessoa() {
    }

    public Pessoa(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "email=" + email + '}';
    }

}
