package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFeriasDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Ferias;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FeriasDAO extends AbstractJpaDAO<Ferias> implements IFeriasDAO {

    public FeriasDAO() {
        super();

        setClazz(Ferias.class);
    }  
}
