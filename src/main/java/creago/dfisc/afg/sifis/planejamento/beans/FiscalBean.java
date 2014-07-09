package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Fiscal;
import creago.dfisc.afg.sifis.planejamento.entities.Inspetoria;
import creago.dfisc.afg.sifis.planejamento.facade.FiscalFacade;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Tiago Borges Pereira
 */
@SessionScoped
@ManagedBean
public class FiscalBean extends AbstractBean implements Serializable {

    private Fiscal fiscal;
    private List<Fiscal> fiscais;
    private Fiscal selectedFiscal;
    private List<Fiscal> filteredFiscais;

    private FiscalFacade fiscalFacade;

    public FiscalFacade getFiscalFacade() {
        if (fiscalFacade == null) {
            fiscalFacade = new FiscalFacade();
        }
        return fiscalFacade;
    }

    public String create() {
        try {
            getFiscalFacade().create(fiscal);
            displayInfoMessageToUser("Fiscal cadastrado com sucesso!");
            loadFiscais();
            resetFiscal();
            return "fiscais-list";
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao cadastrar o novo fiscal!");
            return "fiscais-new";
        }
    }

    public String newFiscal() {
        return "fiscais-new";
    }

    public List<Fiscal> findAll() {
        loadFiscais();
        return fiscais;
    }

    public String remove() {
        try {
            getFiscalFacade().delete(selectedFiscal);
            displayInfoMessageToUser("Fiscal excluído com sucesso!");
            loadFiscais();
            resetFiscal();
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao excluir fiscal!");
            e.printStackTrace();
        }
        return "fiscais-list";
    }

    public void onRowEdit(RowEditEvent event) {
        Fiscal fiscalAlterado = (Fiscal) event.getObject();
        getFiscalFacade().update(fiscalAlterado);
        displayInfoMessageToUser("Fiscal atualizado com sucesso!");
        loadFiscais();
        resetFiscal();
    }

    public void onCancel(RowEditEvent event) {
        displayInfoMessageToUser("Atualização cancelada com sucesso!");
    }

    // GETTERS AND SETTERS
    public Fiscal getFiscal() {
        if (fiscal == null) {
            fiscal = new Fiscal();
            fiscal.setInspetoria(new Inspetoria());
        }
        return fiscal;
    }

    public void setFiscal(Fiscal fiscal) {
        this.fiscal = fiscal;
    }

    public List<Fiscal> getFiscais() {
        fiscais = findAll();

        return fiscais;
    }

    public void setFiscais(List<Fiscal> fiscais) {
        this.fiscais = fiscais;
    }

    public Fiscal getSelectedFiscal() {
        return selectedFiscal;
    }

    public void setSelectedFiscal(Fiscal selectedFiscal) {
        this.selectedFiscal = selectedFiscal;
    }

    public List<Fiscal> getFilteredFiscais() {
        return filteredFiscais;
    }

    public void setFilteredFiscais(List<Fiscal> filteredFiscais) {
        this.filteredFiscais = filteredFiscais;
    }

    // LOADER AND RESETER
    private void loadFiscais() {
        fiscais = getFiscalFacade().listAll();
    }

    private void resetFiscal() {
        fiscal = new Fiscal();
        fiscal.setInspetoria(new Inspetoria());
    }
}
