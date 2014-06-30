package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Fiscal;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FiscalDAO extends GenericDAO<Fiscal> {

    public FiscalDAO() {
        super(Fiscal.class);
    }

    public void delete(Fiscal fiscal) {
        super.delete(fiscal.getIdfiscal(), Fiscal.class);
    }
}
