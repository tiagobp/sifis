package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IJurisdicaoDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Jurisdicao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tiago Borges Pereira
 */
@Repository
public class JurisdicaoDAO extends AbstractJpaDAO<Jurisdicao> implements IJurisdicaoDAO {

    public JurisdicaoDAO() {
        super();

        setClazz(Jurisdicao.class);
    }
}
