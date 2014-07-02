package creago.dfisc.afg.sifis.planejamento.facade;

import creago.dfisc.afg.sifis.planejamento.dao.FeriadoDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Feriado;
import java.util.List;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FeriadoFacade {

    private final FeriadoDAO dao = new FeriadoDAO();

    public void create(Feriado feriado) {
        dao.persist(feriado);
    }

    public void update(Feriado feriado) {
        dao.merge(feriado);
    }

    public Feriado find(Long entityId) {
        Feriado feriado = dao.getById(entityId);
        return feriado;
    }

    public List<Feriado> listAll() {
        List<Feriado> result = dao.findAll();
        return result;
    }

    public void delete(Feriado feriado) {
        dao.removeById(feriado.getIdferiado());
    }
}
