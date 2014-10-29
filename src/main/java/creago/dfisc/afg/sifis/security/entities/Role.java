package creago.dfisc.afg.sifis.security.entities;

import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author creago
 */
class Role implements GrantedAuthority {

    private static final long serialVersionUID = -3968396919486158590L;
    
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return description;
    }
}
