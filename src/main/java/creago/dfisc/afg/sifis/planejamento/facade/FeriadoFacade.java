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
        dao.beginTransaction();
        dao.save(feriado);
        dao.commitAndCloseTransaction();
    }
 
    public void update(Feriado feriado) {
        dao.beginTransaction();
//        Feriado persisted = dao.find(feriado.getIdferiado());
//        persisted.setNome(feriado.getNome());
//        persisted.setData(feriado.getData());
//        persisted.setIsFixo(feriado.getIsFixo());
//        persisted.setCidades(feriado.getCidades());
        dao.update(feriado);
        dao.commitAndCloseTransaction();
    }
 
    public Feriado find(Long entityId) {
        dao.beginTransaction();
        Feriado feriado = dao.find(entityId);
        dao.closeTransaction();
        return feriado;
    }
 
    public List<Feriado> listAll() {
        dao.beginTransaction();
        List<Feriado> result = dao.findAll();
        dao.closeTransaction();
        return result;
    }
 
    public void delete(Feriado feriado) {
        dao.beginTransaction();
        Feriado persisted = dao.findReferenceOnly(feriado.getIdferiado());
        dao.delete(persisted);
        dao.commitAndCloseTransaction();
    }
}
