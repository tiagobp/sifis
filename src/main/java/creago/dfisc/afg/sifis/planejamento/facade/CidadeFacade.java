package creago.dfisc.afg.sifis.planejamento.facade;

import creago.dfisc.afg.sifis.planejamento.dao.CidadeDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Cidade;
import java.util.List;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CidadeFacade {

    private final CidadeDAO dao = new CidadeDAO();

    public void create(Cidade cidade) {
        dao.beginTransaction();
        dao.save(cidade);
        dao.commitAndCloseTransaction();
    }

    public void update(Cidade cidade) {
        dao.beginTransaction();
//        Cidade persisted = dao.find(cidade.getIdcidade());
//        persisted.setNome(cidade.getNome());
        dao.update(cidade);
        dao.commitAndCloseTransaction();
    }

    public void delete(Cidade cidade) {
        dao.beginTransaction();
        Cidade persisted = dao.findReferenceOnly(cidade.getIdcidade());
        dao.delete(persisted);
        dao.commitAndCloseTransaction();
    }

    public List<Cidade> listAll() {
        dao.beginTransaction();
        List<Cidade> result = dao.findAll();
        dao.closeTransaction();
        return result;
    }
}
