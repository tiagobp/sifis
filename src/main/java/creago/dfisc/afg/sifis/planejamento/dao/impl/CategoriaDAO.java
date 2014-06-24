package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.ICategoriaDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Categoria;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CategoriaDAO extends AbstractJpaDAO<Categoria> implements ICategoriaDAO {

    public CategoriaDAO() {
        super();

        setClazz(Categoria.class);
    }
}
