package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Cidade;
import creago.dfisc.afg.sifis.planejamento.entities.Feriado;
import creago.dfisc.afg.sifis.planejamento.entities.Jurisdicao;
import creago.dfisc.afg.sifis.planejamento.service.CidadeService;
import creago.dfisc.afg.sifis.planejamento.service.FeriadoService;
import creago.dfisc.afg.sifis.planejamento.service.JurisdicaoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CidadeBean implements Serializable {

    private Cidade cidade;
    private List<Cidade> cidades;
    private Cidade selectedCidade;
    private List<Cidade> filteredCidades;

    private Jurisdicao jurisdicao;
    private List<Jurisdicao> jurisdicoes;
    private Jurisdicao selectedJurisdicao;
    private List<Jurisdicao> filteredJurisdicoes;

    private Feriado feriado;
    private List<Feriado> feriados;
    private Feriado selectedFeriado;
    private List<Feriado> filteredFeriados;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private JurisdicaoService jurisdicaoService;

    @Autowired
    private FeriadoService feriadoService;

//    private final String persistenceUnitName = "Planejamento";
//    private final SimpleEntityManager simpleEntityManager = new SimpleEntityManager(persistenceUnitName);
//    private CidadeService service = new CidadeServiceImpl(simpleEntityManager);
//    private JurisdicaoService jService = new JurisdicaoServiceImpl(simpleEntityManager);
//    private FeriadoService fService = new FeriadoServiceImpl(simpleEntityManager);
    @PostConstruct
    private void init() {
        cidade = new Cidade();
        jurisdicao = new Jurisdicao();
        feriado = new Feriado();
    }

    private void message(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, msg, null));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }

    // CIDADE
    public String save() {
        cidade.setNome(cidade.getNome().toUpperCase());
        cidadeService.save(cidade);
        message("Cidade cadastrada com sucesso!");
        selectedCidade = cidade;

        cidades = null;
        return "cidades-details";
    }

    public String newCidade() {
        cidade = new Cidade();

        return "cidades-new";
    }

    public Iterable<Cidade> findAll() {
        return cidadeService.findAll();
    }

    public String remove() {
        cidadeService.delete(this.selectedCidade);
        message("Cidade excluída com sucesso!");

        cidades = null;

        return "cidades-list";
    }

    public void onRowEdit(RowEditEvent event) {
        Cidade cidadeAlterada = (Cidade) event.getObject();
        cidadeAlterada.setNome(cidadeAlterada.getNome().toUpperCase());
        cidadeService.update(cidadeAlterada);
        message("Cidade Atualizada.");
    }

    public void onCancel(RowEditEvent event) {
        message("Atualização Cancelada.");
    }

    // JURISDICAO
    public String saveJurisdicao() {
        jurisdicao.setCidade(selectedCidade);
        jurisdicao.setNome(jurisdicao.getNome().toUpperCase());
        jurisdicaoService.create(jurisdicao);
        selectedCidade.getJurisdicaos().add(jurisdicao);
        message("Jurisdição cadastrada com sucesso!");

        return "cidades-details";
    }

    public String newJurisdicao() {
        jurisdicao = new Jurisdicao();

        return "cidades-new-jurisdicao";
    }

    public String removeJurisdicao() {

        Jurisdicao jur = jurisdicaoService.findOne(selectedJurisdicao.getIdjurisdicao());
        jurisdicaoService.delete(jur);

        selectedCidade.getJurisdicaos().remove(selectedJurisdicao);
        message("Jurisdição excluída com sucesso!");

        return "cidades-details";
    }

    public void onRowEditJurisdicao(RowEditEvent event) {
        Jurisdicao jurisdicaoAlterada = (Jurisdicao) event.getObject();
        jurisdicaoAlterada.setNome(jurisdicaoAlterada.getNome().toUpperCase());
        jurisdicaoService.update(jurisdicaoAlterada);

        FacesMessage msg = new FacesMessage("Jurisdicão Atualizada", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void onCancelJurisdicao(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Atualização Cancelada", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //GETTERS AND SETTERS
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        cidades = findAll();

        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Cidade getSelectedCidade() {
        return selectedCidade;
    }

    public void setSelectedCidade(Cidade selectedCidade) {
        this.selectedCidade = selectedCidade;
    }

    public List<Cidade> getFilteredCidades() {
        return filteredCidades;
    }

    public void setFilteredCidades(List<Cidade> filteredCidades) {
        this.filteredCidades = filteredCidades;
    }

    public Jurisdicao getJurisdicao() {
        return jurisdicao;
    }

    public void setJurisdicao(Jurisdicao jurisdicao) {
        this.jurisdicao = jurisdicao;
    }

    public List<Jurisdicao> getJurisdicoes() {
        return jurisdicoes;
    }

    public void setJurisdicoes(List<Jurisdicao> jurisdicoes) {
        this.jurisdicoes = jurisdicoes;
    }

    public Jurisdicao getSelectedJurisdicao() {
        return selectedJurisdicao;
    }

    public void setSelectedJurisdicao(Jurisdicao selectedJurisdicao) {
        this.selectedJurisdicao = selectedJurisdicao;
    }

    public List<Jurisdicao> getFilteredJurisdicoes() {
        return filteredJurisdicoes;
    }

    public void setFilteredJurisdicoes(List<Jurisdicao> filteredJurisdicoes) {
        this.filteredJurisdicoes = filteredJurisdicoes;
    }

    public Feriado getFeriado() {
        return feriado;
    }

    public void setFeriado(Feriado feriado) {
        this.feriado = feriado;
    }

    public List<Feriado> getFeriados() {
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
}
