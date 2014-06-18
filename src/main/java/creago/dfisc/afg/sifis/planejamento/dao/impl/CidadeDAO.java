package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.ICidadeDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Cidade;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tiago Borges Pereira
 */
@Repository
public class CidadeDAO extends AbstractJpaDAO<Cidade> implements ICidadeDAO {

    public CidadeDAO() {
        super();

        setClazz(Cidade.class);
    }
}
