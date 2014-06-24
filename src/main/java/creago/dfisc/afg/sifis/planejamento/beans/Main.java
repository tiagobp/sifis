package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Feriado;
import creago.dfisc.afg.sifis.planejamento.service.FeriadoService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author creago
 */
@Controller
@Scope("request")
public class Main {

    @Autowired
    static FeriadoService feriadoService;

    public static void main(String[] args) {

        Feriado feriado = new Feriado("FeriadoSpring", new Date(), true);

        feriadoService.save(feriado);
    }
}
