package creago.dfisc.afg.sifis.planejamento.entities;
// Generated 10/06/2014 11:59:13 by Hibernate Tools 3.6.0

import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * Bairro generated by hbm2java
 */
@Component
public class Bairro  implements java.io.Serializable {


     private Long idbairro;
     private Jurisdicao jurisdicao;
     private String nome;

    public Bairro() {
    }

    public Bairro(Jurisdicao jurisdicao, String nome) {
       this.jurisdicao = jurisdicao;
       this.nome = nome;
    }
   
    public Long getIdbairro() {
        return this.idbairro;
    }
    
    public void setIdbairro(Long idbairro) {
        this.idbairro = idbairro;
    }
    public Jurisdicao getJurisdicao() {
        return this.jurisdicao;
    }
    
    public void setJurisdicao(Jurisdicao jurisdicao) {
        this.jurisdicao = jurisdicao;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void validate() {
        if(nome == null || jurisdicao == null){
            throw new IllegalArgumentException("Nome and Jurisdição cannot be null");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idbairro);
        hash = 41 * hash + Objects.hashCode(this.jurisdicao);
        hash = 41 * hash + Objects.hashCode(this.nome);
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
        final Bairro other = (Bairro) obj;
        if (!Objects.equals(this.idbairro, other.idbairro)) {
            return false;
        }
        if (!Objects.equals(this.jurisdicao, other.jurisdicao)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bairro{" + "idbairro=" + idbairro + ", jurisdicao=" + jurisdicao + ", nome=" + nome + '}';
    }
}


