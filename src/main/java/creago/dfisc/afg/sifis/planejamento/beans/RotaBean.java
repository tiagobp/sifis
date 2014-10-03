package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Cidade;
import creago.dfisc.afg.sifis.planejamento.entities.Inspetoria;
import creago.dfisc.afg.sifis.planejamento.entities.Jurisdicao;
import creago.dfisc.afg.sifis.planejamento.entities.Rota;
import creago.dfisc.afg.sifis.planejamento.entities.Viagem;
import creago.dfisc.afg.sifis.planejamento.facade.CidadeFacade;
import creago.dfisc.afg.sifis.planejamento.facade.InspetoriaFacade;
import creago.dfisc.afg.sifis.planejamento.facade.JurisdicaoFacade;
import creago.dfisc.afg.sifis.planejamento.facade.RotaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Tiago Borges Pereira
 */
@SessionScoped
@ManagedBean
public class RotaBean extends AbstractBean implements Serializable {

    //ROTA
    private Rota rota;
    private List<Rota> rotas;
    private Rota selectedRota;
    private List<Rota> filteredRotas;

    //JURISDICAO
    private List<Jurisdicao> jurisdicaoSource = new ArrayList<>();
    private List<Jurisdicao> jurisdicaoTarget = new ArrayList<>();
    private DualListModel<Jurisdicao> jurisdicoes;
    
    //VIAGEM
    private Viagem selectedViagem;

    //INSPETORIA
    private List<Inspetoria> inspetorias;
    private Inspetoria selectedInspetoria;

    //FACADE
    private RotaFacade rotaFacade;
    private CidadeFacade cidadeFacade;
    private JurisdicaoFacade jurisdicaoFacade;
    private InspetoriaFacade inspetoriaFacade;

    public InspetoriaFacade getInspetoriaFacade() {
        if (inspetoriaFacade == null) {
            inspetoriaFacade = new InspetoriaFacade();
        }
        return inspetoriaFacade;
    }

    public JurisdicaoFacade getJurisdicaoFacade() {
        if (jurisdicaoFacade == null) {
            jurisdicaoFacade = new JurisdicaoFacade();
        }
        return jurisdicaoFacade;
    }

    public RotaFacade getRotaFacade() {
        if (rotaFacade == null) {
            rotaFacade = new RotaFacade();
        }
        return rotaFacade;
    }

    public CidadeFacade getCidadeFacade() {
        if (cidadeFacade == null) {
            cidadeFacade = new CidadeFacade();
        }
        return cidadeFacade;
    }

    public String processaInspetoria() {
        try {
            resetJurisdicao();
            selectedInspetoria = getInspetoriaFacade().find(rota.getInspetoria().getIdinspetoria());
            Iterator it = selectedInspetoria.getCidades().iterator();
            while (it.hasNext()) {
                Cidade c = (Cidade) it.next();
                Iterator itJ = c.getJurisdicaos().iterator();
                while (itJ.hasNext()) {
                    jurisdicaoSource.add((Jurisdicao) itJ.next());
                }
            }
            this.jurisdicoes = new DualListModel<>(jurisdicaoSource, jurisdicaoTarget);
            return "rotas-new";
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao selecionar a inspetoria!");
            return "rotas-inspetoria-selection";
        }
    }

    public String create() {
        try {
            Iterator it = jurisdicoes.getTarget().iterator();
            while(it.hasNext()){
                rota.getJurisdicaos().add((Jurisdicao) it.next());
            }
            rota.setNome(rota.getNome().toUpperCase());
            getRotaFacade().create(rota);
            displayInfoMessageToUser("Rota cadastrada com sucesso!");
            loadRotas();
            resetRota();
            return "rotas-list";
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao cadastrar a nova rota!");
            return "rotas-inspetoria-selection";
        }
    }

    public String newRota() {
        this.inspetorias = getInspetoriaFacade().listAll();
        return "rotas-inspetoria-selection";
    }

    public List<Rota> findAll() {
        loadRotas();
        return rotas;
    }

    public String remove() {
        try {
            getRotaFacade().delete(this.selectedRota);
            displayInfoMessageToUser("Rota excluída com sucesso!");
            loadRotas();
            resetRota();
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao excluir rota!");
            e.printStackTrace();
        }
        return "rotas-list";
    }

    public void onRowEdit(RowEditEvent event) {
        Rota rotaAlterada = (Rota) event.getObject();
        rotaAlterada.setNome(rotaAlterada.getNome().toUpperCase());
        getRotaFacade().update(rotaAlterada);
        displayInfoMessageToUser("Rota Atualizada.");
    }

    public void onCancel(RowEditEvent event) {
        displayInfoMessageToUser("Atualização Cancelada.");
    }

    //GETTERS AND SETTERS
    //ROTA
    public Rota getRota() {
        if (rota == null) {
            rota = new Rota();
            rota.setInspetoria(new Inspetoria());
        }
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public List<Rota> getRotas() {
        rotas = findAll();
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }

    public Rota getSelectedRota() {
        return selectedRota;
    }

    public void setSelectedRota(Rota selectedRota) {
        this.selectedRota = selectedRota;
    }

    public List<Rota> getFilteredRotas() {
        return filteredRotas;
    }

    public void setFilteredRotas(List<Rota> filteredRotas) {
        this.filteredRotas = filteredRotas;
    }

    //INSPETORIA
    public List<Inspetoria> getInspetorias() {
        return inspetorias;
    }

    public void setInspetorias(List<Inspetoria> inspetorias) {
        this.inspetorias = inspetorias;
    }

    public Inspetoria getSelectedInspetoria() {
        return selectedInspetoria;
    }

    public void setSelectedInspetoria(Inspetoria selectedInspetoria) {
        this.selectedInspetoria = selectedInspetoria;
    }
    
    //VIAGENS
    public Viagem getSelectedViagem() {
        return selectedViagem;
    }

    public void setSelectedViagem(Viagem selectedViagem) {    
        this.selectedViagem = selectedViagem;
    }

    //JURISDICOES
    public DualListModel<Jurisdicao> getJurisdicoes() {
        return jurisdicoes;
    }

    public void setJurisdicoes(DualListModel<Jurisdicao> jurisdicoes) {
        this.jurisdicoes = jurisdicoes;
    }

    public List<Jurisdicao> getJurisdicaoSource() {
        return jurisdicaoSource;
    }

    public void setJurisdicaoSource(List<Jurisdicao> jurisdicaoSource) {
        this.jurisdicaoSource = jurisdicaoSource;
    }

    public List<Jurisdicao> getJurisdicaoTarget() {
        return jurisdicaoTarget;
    }

    public void setJurisdicaoTarget(List<Jurisdicao> jurisdicaoTarget) {
        this.jurisdicaoTarget = jurisdicaoTarget;
    }

    //LOADDERS AND RESETTERS
    //ROTA
    private void loadRotas() {
        rotas = getRotaFacade().listAll();
    }

    private void resetRota() {
        rota = new Rota();
        rota.setInspetoria(new Inspetoria());
    }

    private void resetJurisdicao() {
        jurisdicaoSource = new ArrayList<>();
        jurisdicaoTarget = new ArrayList<>();
    }

    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Jurisdicao) item).getCidade().getNome())
                    .append(" - ")
                    .append(((Jurisdicao) item).getNome()).append("<br />");
        }

        System.out.println(">>>>>>>>>>>>>"+jurisdicaoTarget.size());
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Cidade(s) selecionada(s):");
        msg.setDetail(builder.toString());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
