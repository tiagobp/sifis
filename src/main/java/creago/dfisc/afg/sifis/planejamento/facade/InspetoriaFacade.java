package creago.dfisc.afg.sifis.planejamento.facade;

import creago.dfisc.afg.sifis.planejamento.dao.InspetoriaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Inspetoria;
import java.util.List;

/**
 *
 * @author Tiago Borges Pereira
 */
public class InspetoriaFacade{

    private final InspetoriaDAO dao = new InspetoriaDAO();
    
    public void create(Inspetoria inspetoria) {
        dao.beginTransaction();
        dao.save(inspetoria);
        dao.commitAndCloseTransaction();
    }
 
    public void update(Inspetoria inspetoria) {
        dao.beginTransaction();
//        Inspetoria persisted = dao.find(inspetoria.getIdinspetoria());
//        persisted.setNome(inspetoria.getNome());
        dao.update(inspetoria);
        dao.commitAndCloseTransaction();
    }
 
    public Inspetoria find(Long entityId) {
        dao.beginTransaction();
        Inspetoria inspetoria = dao.find(entityId);
        dao.closeTransaction();
        return inspetoria;
    }
 
    public List<Inspetoria> listAll() {
        dao.beginTransaction();
        List<Inspetoria> result = dao.findAll();
        dao.closeTransaction();
        return result;
    }
 
    public void delete(Inspetoria inspetoria) {
        dao.beginTransaction();
        Inspetoria persisted = dao.findReferenceOnly(inspetoria.getIdinspetoria());
        dao.delete(persisted);
        dao.commitAndCloseTransaction();
    }
}
