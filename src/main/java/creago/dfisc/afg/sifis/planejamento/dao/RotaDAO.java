package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Rota;

/**
 *
 * @author Tiago Borges Pereira
 */
public class RotaDAO extends GenericDAO<Rota> {

    public RotaDAO() {
        super(Rota.class);
    }

    public void delete(Rota rota) {
        super.delete(rota.getIdrota(), Rota.class);
    }
}
