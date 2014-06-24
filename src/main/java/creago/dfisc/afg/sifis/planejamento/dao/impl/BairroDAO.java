package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IBairroDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Bairro;

/**
 *
 * @author Tiago Borges Pereira
 */
public class BairroDAO extends AbstractJpaDAO<Bairro> implements IBairroDAO {

    public BairroDAO() {
        super();

        setClazz(Bairro.class);
    }
}
