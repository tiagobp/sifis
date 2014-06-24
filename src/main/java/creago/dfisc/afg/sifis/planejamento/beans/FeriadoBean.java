package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Feriado;
import creago.dfisc.afg.sifis.planejamento.service.FeriadoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.collections.IteratorUtils;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Tiago Borges Pereira
 */
@Controller
@Scope("request")
public class FeriadoBean implements Serializable {

    private Feriado feriado;
    private List<Feriado> feriados;
    private Feriado selectedFeriado;
    private List<Feriado> filteredFeriados;

    @Autowired
    private FeriadoService feriadoService;

//    private final String persistenceUnitName = "Planejamento";
//    private final SimpleEntityManager simpleEntityManager = new SimpleEntityManager(persistenceUnitName);
//    private FeriadoService service = new FeriadoServiceImpl(simpleEntityManager);
    @PostConstruct
    private void init() {
        feriado = new Feriado();
    }

    public String save() {
        feriadoService.save(feriado);
        message("Feriado cadastrado com sucesso!");

        feriados.add(feriado);
        return "feriados-list";
    }

    private void message(String msg) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(msg, ""));
    }

    public String newFeriado() {
        feriado = new Feriado();

        return "feriados-new";
    }

    public Iterable<Feriado> findAll() {
        return feriadoService.findAll();
    }

    public String remove() {
        feriadoService.delete(this.selectedFeriado);
        feriados.remove(this.selectedFeriado);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Feriado excluído com sucesso!", null));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        return "feriados-list";
    }

    public void onRowEdit(RowEditEvent event) {
        Feriado feriadoAlterado = (Feriado) event.getObject();
        feriadoService.save(feriadoAlterado);

        FacesMessage msg = new FacesMessage("Feriado Atualizado", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Atualização Cancelada", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Feriado getFeriado() {
        return feriado;
    }

    public void setFeriado(Feriado feriado) {
        this.feriado = feriado;
    }

    public List<Feriado> getFeriados() {
        feriados = IteratorUtils.toList(findAll().iterator());

        return feriados;
    }

    public void setFeriados(List<Feriado> feriados) {
        this.feriados = feriados;
    }

    public Feriado getSelectedFeriado() {
        return selectedFeriado;
    }

    public void setSelectedFeriado(Feriado selectedFeriado) {
        this.selectedFeriado = selectedFeriado;
    }

    public List<Feriado> getFilteredFeriados() {
        return filteredFeriados;
    }

    public void setFilteredFeriados(List<Feriado> filteredFeriados) {
        this.filteredFeriados = filteredFeriados;
    }

    public FeriadoService getFeriadoService() {
        return feriadoService;
    }

    public void setFeriadoService(FeriadoService feriadoService) {
        this.feriadoService = feriadoService;
    }
}
