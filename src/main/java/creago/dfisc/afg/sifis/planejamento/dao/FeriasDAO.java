package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Ferias;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FeriasDAO extends GenericDAO<Ferias> {

    public FeriasDAO() {
        super(Ferias.class);
    }

    public void delete(Ferias ferias) {
        super.delete(ferias.getIdferias(), Ferias.class);
    }
}
