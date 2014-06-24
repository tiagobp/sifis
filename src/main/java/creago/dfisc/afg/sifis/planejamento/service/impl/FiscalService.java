package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFiscalDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Fiscal;
import creago.dfisc.afg.sifis.planejamento.service.IFiscalService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FiscalService extends AbstractService<Fiscal> implements IFiscalService {


    private IFiscalDAO dao;

    @Override
    protected IOperations<Fiscal> getDao() {
        return dao;
    }
}
