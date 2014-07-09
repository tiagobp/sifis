package creago.dfisc.afg.sifis.planejamento.entities;
// Generated 10/06/2014 11:59:13 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Jurisdicao generated by hbm2java
 */
public class Jurisdicao  implements java.io.Serializable {


     private Long idjurisdicao;
     private Cidade cidade;
     private String nome;
     private Set<Rota> rotas = new HashSet(0);
     private Set<Bairro> bairros = new HashSet(0);

    public Jurisdicao() {
    }

	
    public Jurisdicao(Cidade cidade, String nome) {
        this.cidade = cidade;
        this.nome = nome;
    }
    public Jurisdicao(Cidade cidade, String nome, Set<Rota> rotas, Set<Bairro> bairros) {
       this.cidade = cidade;
       this.nome = nome;
       this.rotas = rotas;
       this.bairros = bairros;
    }
   
    public Long getIdjurisdicao() {
        return this.idjurisdicao;
    }
    
    public void setIdjurisdicao(Long idjurisdicao) {
        this.idjurisdicao = idjurisdicao;
    }
    public Cidade getCidade() {
        return this.cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Rota> getRotas() {
        return this.rotas;
    }
    
    public void setRotas(Set<Rota> rotas) {
        this.rotas = rotas;
    }
    public Set<Bairro> getBairros() {
        return this.bairros;
    }
    
    public void setBairros(Set<Bairro> bairros) {
        this.bairros = bairros;
    }

    public void validate() {
        if(nome == null || cidade == null){
            throw new IllegalArgumentException("Nome and Cidade cannot be null");
        }
    }

    @Override
    public String toString() {
        return "Jurisdicao{" + "idjurisdicao=" + idjurisdicao + ", cidade="
                + cidade + ", nome=" + nome + ", rotas=" + rotas + ", bairros="
                + bairros + '}';
    }
}


