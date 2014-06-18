package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.ICidadeDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Cidade;
import creago.dfisc.afg.sifis.planejamento.service.ICidadeService;
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
public class CidadeService extends AbstractService<Cidade> implements ICidadeService {

    @Autowired
    private ICidadeDAO dao;

    @Override
    protected IOperations<Cidade> getDao() {
        return dao;
    }

}
