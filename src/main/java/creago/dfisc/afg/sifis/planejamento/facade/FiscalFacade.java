package creago.dfisc.afg.sifis.planejamento.facade;

import creago.dfisc.afg.sifis.planejamento.dao.FiscalDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Fiscal;
import java.util.List;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FiscalFacade {

    private final FiscalDAO dao = new FiscalDAO();

    public void create(Fiscal fiscal) {
        dao.persist(fiscal);
    }

    public void update(Fiscal fiscal) {
        dao.merge(fiscal);
    }

    public Fiscal find(Long entityId) {
        Fiscal fiscal = dao.getById(entityId);
        return fiscal;
    }

    public List<Fiscal> listAll() {
        List<Fiscal> result = dao.findAll();
        return result;
    }

    public void delete(Fiscal fiscal) {
        dao.removeById(fiscal.getIdfiscal());
    }
}
