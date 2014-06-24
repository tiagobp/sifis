package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IJurisdicaoDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Jurisdicao;

/**
 *
 * @author Tiago Borges Pereira
 */
public class JurisdicaoDAO extends AbstractJpaDAO<Jurisdicao> implements IJurisdicaoDAO {

    public JurisdicaoDAO() {
        super();

        setClazz(Jurisdicao.class);
    }
}
