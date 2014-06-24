package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Bairro;
import creago.dfisc.afg.sifis.planejamento.service.IBairroService;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Tiago Borges Pereira
 */
public class BairroBean {

    private Bairro bairro;

    //@Autowired
    private IBairroService bairroService;

    @PostConstruct
    private void init() {
        bairro = new Bairro();
    }

    public String save() {
        try {
            bairroService.create(bairro);
            message("Bairro cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            message(e.getMessage());
        }
        return "";
    }

    private void message(String msg) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(msg, ""));
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public IBairroService getBairroService() {
        return bairroService;
    }

    public void setBairroService(IBairroService bairroService) {
        this.bairroService = bairroService;
    }
}
