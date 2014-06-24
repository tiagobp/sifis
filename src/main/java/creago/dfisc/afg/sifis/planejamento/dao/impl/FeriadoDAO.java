package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFeriadoDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Feriado;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FeriadoDAO extends AbstractJpaDAO<Feriado> implements IFeriadoDAO {

    public FeriadoDAO() {
        super();

        setClazz(Feriado.class);
    }
}
