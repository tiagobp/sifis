package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFiscalDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Fiscal;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tiago Borges Pereira
 */
@Repository
public class FiscalDAO extends AbstractJpaDAO<Fiscal> implements IFiscalDAO {

    public FiscalDAO() {
        super();

        setClazz(Fiscal.class);
    }
}
