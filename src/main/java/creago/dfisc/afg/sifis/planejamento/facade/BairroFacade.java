package creago.dfisc.afg.sifis.planejamento.facade;

import creago.dfisc.afg.sifis.planejamento.dao.BairroDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Bairro;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Tiago Borges Pereira
 */
public class BairroFacade implements Serializable {
    
    private final BairroDAO dao = new BairroDAO();
    
    public void create(Bairro bairro) {
        dao.beginTransaction();
        dao.save(bairro);
        dao.commitAndCloseTransaction();
    }
 
    public void update(Bairro bairro) {
        dao.beginTransaction();
        Bairro persisted = dao.find(bairro.getIdbairro());
        persisted.setNome(bairro.getNome());
        persisted.setJurisdicao(bairro.getJurisdicao());
        dao.update(persisted);
        dao.commitAndCloseTransaction();
    }
 
    public Bairro find(Long entityId) {
        dao.beginTransaction();
        Bairro bairro = dao.find(entityId);
        dao.closeTransaction();
        return bairro;
    }
 
    public List<Bairro> listAll() {
        dao.beginTransaction();
        List<Bairro> result = dao.findAll();
        dao.closeTransaction();
        return result;
    }
 
    public void delete(Bairro bairro) {
        dao.beginTransaction();
        Bairro persisted = dao.findReferenceOnly(bairro.getIdbairro());
        dao.delete(persisted);
        dao.commitAndCloseTransaction();
    }
}
