package creago.dfisc.afg.sifis.planejamento.entities;
// Generated 10/06/2014 11:59:13 by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Fiscal generated by hbm2java
 */
@Component
public class Fiscal implements java.io.Serializable {

    private Long idfiscal;
    private Inspetoria inspetoria;
    private String nome;
    private String sobrenome;
    private String sigla;
    private Integer matricula;
    private Boolean isAtivo;
    private Set<Usuario> usuarios = new HashSet(0);
    private Set<Ferias> feriases = new HashSet(0);
    private Set<Viagem> viagems = new HashSet(0);

    public Fiscal() {
    }

    public Fiscal(Inspetoria inspetoria, String nome, String sobrenome, 
            String sigla, Integer matricula, Boolean isAtivo) {
        this.inspetoria = inspetoria;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sigla = sigla;
        this.matricula = matricula;
        this.isAtivo = isAtivo;
    }

    public Fiscal(Inspetoria inspetoria, String nome, String sobrenome,
            String sigla, Integer matricula, Boolean isAtivo, Set<Usuario> usuarios,
            Set<Ferias> feriases, Set<Viagem> viagems) {
        this.inspetoria = inspetoria;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sigla = sigla;
        this.matricula = matricula;
        this.isAtivo = isAtivo;
        this.usuarios = usuarios;
        this.feriases = feriases;
        this.viagems = viagems;
    }

    public Long getIdfiscal() {
        return this.idfiscal;
    }

    public void setIdfiscal(Long idfiscal) {
        this.idfiscal = idfiscal;
    }

    public Inspetoria getInspetoria() {
        return this.inspetoria;
    }

    public void setInspetoria(Inspetoria inspetoria) {
        this.inspetoria = inspetoria;
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

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Boolean getIsAtivo() {
        return this.isAtivo;
    }

    public void setIsAtivo(Boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Ferias> getFeriases() {
        return this.feriases;
    }

    public void setFeriases(Set<Ferias> feriases) {
        this.feriases = feriases;
    }

    public Set<Viagem> getViagems() {
        return this.viagems;
    }

    public void setViagems(Set<Viagem> viagems) {
        this.viagems = viagems;
    }

    public void validate() {
        if (inspetoria == null || nome == null || sobrenome == null || sigla == null
                || matricula == null) {
            throw new IllegalArgumentException("Inspetoria, Nome, Sobrenome, Matrícula and"
                    + " Sigla cannot be null");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idfiscal);
        hash = 29 * hash + Objects.hashCode(this.inspetoria);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.sobrenome);
        hash = 29 * hash + Objects.hashCode(this.sigla);
        hash = 29 * hash + Objects.hashCode(this.matricula);
        hash = 29 * hash + Objects.hashCode(this.isAtivo);
        hash = 29 * hash + Objects.hashCode(this.usuarios);
        hash = 29 * hash + Objects.hashCode(this.feriases);
        hash = 29 * hash + Objects.hashCode(this.viagems);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fiscal other = (Fiscal) obj;
        if (!Objects.equals(this.idfiscal, other.idfiscal)) {
            return false;
        }
        if (!Objects.equals(this.inspetoria, other.inspetoria)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sobrenome, other.sobrenome)) {
            return false;
        }
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.isAtivo, other.isAtivo)) {
            return false;
        }
        if (!Objects.equals(this.usuarios, other.usuarios)) {
            return false;
        }
        if (!Objects.equals(this.feriases, other.feriases)) {
            return false;
        }
        if (!Objects.equals(this.viagems, other.viagems)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fiscal{" + "idfiscal=" + idfiscal + ", inspetoria=" + inspetoria
                + ", nome=" + nome + ", sobrenome=" + sobrenome + ", sigla="
                + sigla + ", matricula=" + matricula + ", isAtivo=" + isAtivo
                + ", usuarios=" + usuarios + ", feriases=" + feriases
                + ", viagems=" + viagems + '}';
    }
}
