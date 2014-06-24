package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.ICategoriaDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Categoria;
import creago.dfisc.afg.sifis.planejamento.service.ICategoriaService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CategoriaService extends AbstractService<Categoria> implements ICategoriaService {

    private ICategoriaDAO dao;

    @Override
    protected IOperations<Categoria> getDao() {
        return dao;
    }
}
