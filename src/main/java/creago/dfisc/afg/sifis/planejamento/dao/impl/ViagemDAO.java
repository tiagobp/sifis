package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IViagemDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Viagem;

/**
 *
 * @author Tiago Borges Pereira
 */
public class ViagemDAO extends AbstractJpaDAO<Viagem> implements IViagemDAO {

    public ViagemDAO() {
        super();

        setClazz(Viagem.class);
    }
}
