package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFeriasDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Ferias;
import creago.dfisc.afg.sifis.planejamento.service.IFeriasService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FeriasService extends AbstractService<Ferias> implements IFeriasService {

    private IFeriasDAO dao;

    @Override
    protected IOperations<Ferias> getDao() {
        return dao;
    }

}
