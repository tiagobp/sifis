package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Bairro;

/**
 *
 * @author Tiago Borges Pereira
 */
public class BairroDAO extends GenericDAO<Bairro> {

    public BairroDAO() {
        super(Bairro.class);
    }

    public void delete(Bairro bairro) {
        super.delete(bairro.getIdbairro(), Bairro.class);
    }
}
