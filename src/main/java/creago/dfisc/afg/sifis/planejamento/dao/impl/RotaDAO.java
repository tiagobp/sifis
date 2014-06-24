package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IRotaDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Rota;

/**
 *
 * @author Tiago Borges Pereira
 */
public class RotaDAO extends AbstractJpaDAO<Rota> implements IRotaDAO {

    public RotaDAO() {
        super();

        setClazz(Rota.class);
    }
}
