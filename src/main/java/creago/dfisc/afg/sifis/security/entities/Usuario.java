package creago.dfisc.afg.sifis.security.entities;
// Generated 10/06/2014 11:59:13 by Hibernate Tools 3.6.0

import creago.dfisc.afg.sifis.planejamento.entities.Fiscal;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements UserDetails {

    private static final long serialVersionUID = -7590317347612436291L;

    private Long idusuario;
    private Fiscal fiscal;
    private String username;
    private String password;
    private String authority;
    private String nome;
    private String sobrenome;
    private Integer matricula;
    private String email;
    private String avatar;
    private boolean enable;
    private List<Role> roles;

    public Usuario() {
    }

    public Long getIdusuario() {
        return this.idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public Fiscal getFiscal() {
        return this.fiscal;
    }

    public void setFiscal(Fiscal fiscal) {
        this.fiscal = fiscal;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void validate() {
        if (nome == null || username == null || password == null || authority == null
                || sobrenome == null || email == null || matricula == null) {
            throw new IllegalArgumentException("Nome, Username, Password, Authority,"
                    + " Sobrenome, Matrícula and Email cannot be null");
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", fiscal=" + fiscal
                + ", username=" + username + ", password=" + password
                + ", authority=" + authority + ", nome=" + nome + ", sobrenome="
                + sobrenome + ", matricula=" + matricula + ", email=" + email
                + ", avatar=" + avatar + '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}