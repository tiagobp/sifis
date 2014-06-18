package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFeriasDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Ferias;
import creago.dfisc.afg.sifis.planejamento.service.IFeriasService;
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
public class FeriasService extends AbstractService<Ferias> implements IFeriasService {

    @Autowired
    private IFeriasDAO dao;

    @Override
    protected IOperations<Ferias> getDao() {
        return dao;
    }

}
