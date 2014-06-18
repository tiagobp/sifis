package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFiscalDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Fiscal;
import creago.dfisc.afg.sifis.planejamento.service.IFiscalService;
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
public class FiscalService extends AbstractService<Fiscal> implements IFiscalService {

    @Autowired
    private IFiscalDAO dao;

    @Override
    protected IOperations<Fiscal> getDao() {
        return dao;
    }
}
