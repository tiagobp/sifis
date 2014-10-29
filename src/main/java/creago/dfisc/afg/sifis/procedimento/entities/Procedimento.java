package creago.dfisc.afg.sifis.procedimento.entities;

import java.util.Date;
import javax.persistence.Transient;

/**
 *
 * @author Tiago Borges Pereira
 */
public class Procedimento implements java.io.Serializable {

    private Long idprocedimento;
    private String identificador;
    private String tipo;
    private String assunto;
    private String descricao;
    private String evidencia;
    private Date inicio;
    private Date fim;

    public Procedimento() {
    }

    public Procedimento(String identificador, String tipo, String assunto, String descricao, String evidencia, Date inicio, Date fim) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.assunto = assunto;
        this.descricao = descricao;
        this.evidencia = evidencia;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getIdprocedimento() {
        return idprocedimento;
    }

    public void setIdprocedimento(Long idprocedimento) {
        this.idprocedimento = idprocedimento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
    
    @Transient
    public boolean isVigente() {
        Date dataAtual = new Date();
        if (fim == null) {
            return inicio.before(dataAtual);
        } else {
            return inicio.before(dataAtual) && fim.after(dataAtual);
        }
    }

    @Override
    public String toString() {
        return "Procedimento{" + "idprocedimento=" + idprocedimento
                + ", identificador=" + identificador + ", tipo=" + tipo
                + ", assunto=" + assunto + ", descricao=" + descricao
                + ", evidencia=" + evidencia + ", inicio=" + inicio
                + ", fim=" + fim + '}';
    }
}
