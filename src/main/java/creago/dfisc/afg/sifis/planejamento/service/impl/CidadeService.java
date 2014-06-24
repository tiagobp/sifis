package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.ICidadeDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Cidade;
import creago.dfisc.afg.sifis.planejamento.service.ICidadeService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CidadeService extends AbstractService<Cidade> implements ICidadeService {

    private ICidadeDAO dao;

    @Override
    protected IOperations<Cidade> getDao() {
        return dao;
    }

}
