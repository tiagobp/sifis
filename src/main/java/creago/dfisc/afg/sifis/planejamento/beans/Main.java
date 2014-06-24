package creago.dfisc.afg.sifis.planejamento.beans;

import creago.dfisc.afg.sifis.planejamento.entities.Feriado;
import creago.dfisc.afg.sifis.planejamento.service.IFeriadoService;
import creago.dfisc.afg.sifis.planejamento.service.impl.FeriadoService;
import java.util.Date;

/**
 *
 * @author creago
 */
public class Main {

    static IFeriadoService feriadoService;

    public static void main(String[] args) {

        Feriado feriado = new Feriado("FeriadoSpring", new Date(), true);

        feriadoService.create(feriado);
    }
}
