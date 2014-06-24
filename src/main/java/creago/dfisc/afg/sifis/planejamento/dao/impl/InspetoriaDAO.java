package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IInspetoriaDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Inspetoria;

/**
 *
 * @author Tiago Borges Pereira
 */
public class InspetoriaDAO extends AbstractJpaDAO<Inspetoria> implements IInspetoriaDAO {

    public InspetoriaDAO() {
        super();

        setClazz(Inspetoria.class);
    }
}
