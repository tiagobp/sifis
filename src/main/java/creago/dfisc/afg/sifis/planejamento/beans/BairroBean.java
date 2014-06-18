package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Bairro;
import creago.dfisc.afg.sifis.planejamento.service.BairroService;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 *
 * @author Tiago Borges Pereira
 */
@Component
@Scope("request")
public class BairroBean {

    private Bairro bairro;

    //@Autowired
    private BairroService bairroService;

    @PostConstruct
    private void init() {
        bairro = new Bairro();
    }

    public String save() {
        try {
            bairroService.save(bairro);
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

    public BairroService getBairroService() {
        return bairroService;
    }

    public void setBairroService(BairroService bairroService) {
        this.bairroService = bairroService;
    }
}
