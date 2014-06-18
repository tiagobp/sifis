package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IBairroDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Bairro;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tiago Borges Pereira
 */
@Repository
public class BairroDAO extends AbstractJpaDAO<Bairro> implements IBairroDAO {

    public BairroDAO() {
        super();

        setClazz(Bairro.class);
    }
}
