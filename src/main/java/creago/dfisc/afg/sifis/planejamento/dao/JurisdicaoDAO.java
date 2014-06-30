package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Jurisdicao;

/**
 *
 * @author Tiago Borges Pereira
 */
public class JurisdicaoDAO extends GenericDAO<Jurisdicao> {

    public JurisdicaoDAO() {
        super(Jurisdicao.class);
    }

    public void delete(Jurisdicao jurisdicao) {
        super.delete(jurisdicao.getIdjurisdicao(), Jurisdicao.class);
    }
}
