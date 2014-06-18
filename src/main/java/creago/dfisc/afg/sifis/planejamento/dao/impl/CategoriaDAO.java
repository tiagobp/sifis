package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.ICategoriaDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Categoria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tiago Borges Pereira
 */
@Repository
public class CategoriaDAO extends AbstractJpaDAO<Categoria> implements ICategoriaDAO {

    public CategoriaDAO() {
        super();

        setClazz(Categoria.class);
    }
}
