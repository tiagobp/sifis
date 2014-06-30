package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Cidade;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CidadeDAO extends GenericDAO<Cidade> {

    public CidadeDAO() {
        super(Cidade.class);
    }

    public void delete(Cidade cidade) {
        super.delete(cidade.getIdcidade(), Cidade.class);
    }
}
