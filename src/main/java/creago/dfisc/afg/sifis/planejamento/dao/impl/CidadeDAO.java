package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.ICidadeDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Cidade;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CidadeDAO extends AbstractJpaDAO<Cidade> implements ICidadeDAO {

    public CidadeDAO() {
        super();

        setClazz(Cidade.class);
    }
}
