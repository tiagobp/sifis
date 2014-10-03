package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Categoria;
import creago.dfisc.afg.sifis.planejamento.entities.Ferias;
import creago.dfisc.afg.sifis.planejamento.entities.Fiscal;
import creago.dfisc.afg.sifis.planejamento.entities.Inspetoria;
import creago.dfisc.afg.sifis.planejamento.entities.Rota;
import creago.dfisc.afg.sifis.planejamento.entities.Viagem;
import creago.dfisc.afg.sifis.planejamento.facade.FiscalFacade;
import creago.dfisc.afg.sifis.planejamento.facade.InspetoriaFacade;
import creago.dfisc.afg.sifis.planejamento.facade.RotaFacade;
import creago.dfisc.afg.sifis.planejamento.facade.ViagemFacade;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Tiago Borges Pereira
 */
@SessionScoped
@ManagedBean
public class ViagemBean extends AbstractBean implements Serializable {

    //VIAGEM
    private Viagem viagem;
    private List<Viagem> viagens;
    private Viagem selectedViagem;
    private List<Viagem> filteredViagem;

    //INSPETORIA
    private Inspetoria selectedInspetoria;

    //ROTAS E FISCAIS
    private List<Rota> rotas;
    private List<Fiscal> fiscais;

    //FACADE
    private ViagemFacade viagemFacade;
    private InspetoriaFacade inspetoriaFacade;
    private RotaFacade rotaFacade;
    private FiscalFacade fiscalFacade;

    //PAINEL CONTROLE DE VISIBILIDADE
    private boolean painelRota = false;

    public InspetoriaFacade getInspetoriaFacade() {
        if (inspetoriaFacade == null) {
            inspetoriaFacade = new InspetoriaFacade();
        }
        return inspetoriaFacade;
    }

    public ViagemFacade getViagemFacade() {
        if (viagemFacade == null) {
            viagemFacade = new ViagemFacade();
        }
        return viagemFacade;
    }

    public RotaFacade getRotaFacade() {
        if (rotaFacade == null) {
            rotaFacade = new RotaFacade();
        }
        return rotaFacade;
    }

    public FiscalFacade getFiscalFacade() {
        if (fiscalFacade == null) {
            fiscalFacade = new FiscalFacade();
        }
        return fiscalFacade;
    }

    // CRUD
    public String create() {
        try {
            getViagemFacade().create(viagem);
            displayInfoMessageToUser("Viagem cadastrada com sucesso!");
            loadViagens();
            resetViagem();
            return "viagens-list";
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao cadastrar a nova viagem!");
            return "viagens-inspetoria-selection";
        }
    }

    public String newViagem() {
        selectedInspetoria = new Inspetoria();
        rotas = new ArrayList<>();
        fiscais = new ArrayList<>();
        resetViagem();
        painelRota = false;
        return "viagens-new";
    }

    public List<Viagem> findAll() {
        loadViagens();
        return viagens;
    }

    public String remove() {
        try {
            getViagemFacade().delete(selectedViagem);
            displayInfoMessageToUser("Viagem excluída com sucesso!");
            loadViagens();
            resetViagem();
        } catch (Exception e) {
            displayErrorMessageToUser("Erro ao excluir viagem!");
            e.printStackTrace();
        }
        return "viagens-list";
    }

    public void onRowEdit(RowEditEvent event) {
        Viagem viagemAlterada = (Viagem) event.getObject();
        getViagemFacade().update(viagemAlterada);
        displayInfoMessageToUser("Viagem atualizada com sucesso!");
        loadViagens();
        resetViagem();
    }

    public void onCancel(RowEditEvent event) {
        displayInfoMessageToUser("Atualização cancelada com sucesso!");
    }

    // GETTERS AND SETTERS
    // VIAGEM
    public Viagem getViagem() {
        if (viagem == null) {
            viagem = new Viagem();
            viagem.setCategoria(new Categoria());
            viagem.setFiscal(new Fiscal());
            viagem.setRota(new Rota());
        }
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public List<Viagem> getViagens() {
        viagens = findAll();
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public Viagem getSelectedViagem() {
        return selectedViagem;
    }

    public void setSelectedViagem(Viagem selectedViagem) {
        this.selectedViagem = selectedViagem;
    }

    public List<Viagem> getFilteredViagem() {
        return filteredViagem;
    }

    public void setFilteredViagem(List<Viagem> filteredViagem) {
        this.filteredViagem = filteredViagem;
    }

    // INSPETORIA
    public Inspetoria getSelectedInspetoria() {
        if (selectedInspetoria == null) {
            selectedInspetoria = new Inspetoria();
        }
        return selectedInspetoria;
    }

    public void setSelectedInspetoria(Inspetoria selectedInspetoria) {
        this.selectedInspetoria = selectedInspetoria;
    }

    // ROTA E FISCAL
    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }

    public List<Fiscal> getFiscais() {
        return fiscais;
    }

    public void setFiscais(List<Fiscal> fiscais) {
        this.fiscais = fiscais;
    }

    //PAINEL CONTROLE VISIBILIDADE
    public boolean isPainelRota() {
        return painelRota;
    }

    public void setPainelRota(boolean painelRota) {
        this.painelRota = painelRota;
    }

    // LOADERS AND RESETERS
    private void loadViagens() {
        viagens = getViagemFacade().listAll();
    }

    private void resetViagem() {
        viagem = new Viagem();
        viagem.setCategoria(new Categoria());
        viagem.setFiscal(new Fiscal());
        viagem.setRota(new Rota());
    }

    /**
     * PROCESSADORES
     */
    /**
     * Método que processa alterações relativas à mudança da rota selecionada
     * para determinada viagem.
     */
    public void onRotaChange() {
        fiscais = new ArrayList<>();
        painelRota = true;
        viagem.setRota(getRotaFacade().find(viagem.getRota().getIdrota()));
        viagem.setInicio(null);
        viagem.setFim(null);
    }

    /**
     * Método que processa alterações relativas à mudança da inspetoria
     * selecionada para determinada viagem.
     */
    public void onInspetoriaChange() {
        painelRota = false;
        viagem.setInicio(null);
        viagem.setFim(null);
        fiscais = new ArrayList<>();
        resetRotas();
    }

    /**
     * Realimenta a lista de rotas cadastradas para a inspetoria selecionada.
     */
    public void resetRotas() {
        rotas = new ArrayList<>();
        Iterator itR = getInspetoriaFacade().find(
                selectedInspetoria.getIdinspetoria()).getRotas().iterator();
        while (itR.hasNext()) {
            rotas.add((Rota) itR.next());
        }
    }

    /**
     * Realimenta a lista de fiscais alocados na inspetoria selecionada.
     */
    public void resetFiscais() {
        fiscais = new ArrayList<>();
        Iterator itF = getInspetoriaFacade().find(
                selectedInspetoria.getIdinspetoria()).getFiscals().iterator();
        while (itF.hasNext()) {
            fiscais.add((Fiscal) itF.next());
        }
    }

    /**
     * Método que processa alterações relativas à mudança da data de início de
     * uma determinada viagem.
     */
    public void onDateSelect() {
        resetFiscais();
        viagem.setFim(viagem.getInicio());

        Calendar cal = Calendar.getInstance();
        cal.setTime(viagem.getFim());

        int dias = viagem.getRota().getAlmoco() + viagem.getRota().getDiaria();
        cal.add(Calendar.DATE, dias - 1);
        viagem.setFim(cal.getTime());

        /**
         * Verifica se o período selecionado contém fim de semana.
         */
        if (isWeekend()) {
            FacesContext f = FacesContext.getCurrentInstance();
            f.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Data inválida!", 
                    "A viagem deve ser realizada somente em dias úteis."));
        }

        /**
         * Verifica se algum fiscal está de férias e retira da lista de fiscais.
         */
        List<Fiscal> listaSecundaria = new ArrayList<>();
        for (Fiscal fiscal : fiscais) {
            if (!isVacationing(fiscal)) {
                listaSecundaria.add(fiscal);
            }
        }
        fiscais = listaSecundaria;
    }

    /**
     * Verifica se o período selecionado para a viagem contém sábado ou domingo.
     *
     * @return true caso seja fim de semana
     */
    public boolean isWeekend() {
        int inicio = viagem.getInicio().getDay();
        int dias = viagem.getRota().getAlmoco() + viagem.getRota().getDiaria();
        int limite = inicio + dias;

        for (int i = inicio; i < limite; i++) {
            if (i == 6 || i == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se o fiscal está de férias no período selecionado para a viagem
     *
     * @param fiscal Fiscal que poderá realizar a viagem caso não esteja de
     * férias
     * @return true caso o fiscal esteja de férias
     */
    public boolean isVacationing(Fiscal fiscal) {
        Ferias ferias;
        Iterator it = fiscal.getFeriases().iterator();
        while (it.hasNext()) {
            ferias = (Ferias) it.next();
            boolean inicio = viagem.getInicio().after(ferias.getInicio())
                    && viagem.getInicio().before(ferias.getFim());
            boolean fim = viagem.getFim().after(ferias.getInicio())
                    && viagem.getFim().before(ferias.getFim());
            boolean igualInicio = viagem.getInicio().equals(ferias.getInicio())
                    || viagem.getInicio().equals(ferias.getFim());
            boolean igualFim = viagem.getFim().equals(ferias.getInicio())
                    || viagem.getFim().equals(ferias.getFim());
            return inicio || fim || igualInicio || igualFim;
        }
        return false;
    }
}
