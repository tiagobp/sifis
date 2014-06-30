package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Feriado;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FeriadoDAO extends GenericDAO<Feriado> {

    public FeriadoDAO() {
        super(Feriado.class);
    }

    public void delete(Feriado feriado) {
        super.delete(feriado.getIdferiado(), Feriado.class);
    }
}
