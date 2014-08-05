package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Cidade;
import creago.dfisc.afg.sifis.planejamento.entities.Inspetoria;
import creago.dfisc.afg.sifis.planejamento.entities.Rota;
import creago.dfisc.afg.sifis.planejamento.facade.CidadeFacade;
import creago.dfisc.afg.sifis.planejamento.facade.RotaFacade;
import java.io.Serializable;
import java.util.ArrayList;
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

    //CIDADE
    private List<Cidade> cidadesSource;
    private List<Cidade> cidadesTarget;
    private DualListModel<Cidade> cidades;

    //FACADE
    private RotaFacade rotaFacade;
    private CidadeFacade cidadeFacade;

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

    public String create() {
        try {
            rota.setNome(rota.getNome().toUpperCase());
            getRotaFacade().create(rota);
            displayInfoMessageToUser("Rota cadastrada com sucesso!");
            loadRotas();
            resetRota();
            return "rotas-list";
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao cadastrar a nova rota!");
            return "rotas-new";
        }
    }

    public String newRota() {
        cidadesSource = getCidadeFacade().listAll();
        cidadesTarget = new ArrayList<>();
        cidades = new DualListModel<>(cidadesSource, cidadesTarget);
        return "rotas-new";
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
    
    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for (Object item : event.getItems()) {
            builder.append(((Cidade) item).getNome()).append("<br />");
        }

        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Cidade(s) selecionada(s):");
        msg.setDetail(builder.toString());

        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    //CIDADE
    public DualListModel<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(DualListModel<Cidade> cidades) {
        this.cidades = cidades;
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

}
