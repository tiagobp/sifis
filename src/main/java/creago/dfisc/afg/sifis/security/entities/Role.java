package creago.dfisc.afg.sifis.security.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author creago
 */
public class Role implements Serializable {

    private Long idrole;
    private String description;
    private Set<Usuario> usuarios = new HashSet(0);

    public Role() {
    }
    
    public Long getIdrole() {
        return idrole;
    }

    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
