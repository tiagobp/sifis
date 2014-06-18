package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.ICategoriaDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Categoria;
import creago.dfisc.afg.sifis.planejamento.service.ICategoriaService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tiago Borges Pereira
 */
@Service
@Transactional
public class CategoriaService extends AbstractService<Categoria> implements ICategoriaService {

    @Autowired
    private ICategoriaDAO dao;

    @Override
    protected IOperations<Categoria> getDao() {
        return dao;
    }
}
