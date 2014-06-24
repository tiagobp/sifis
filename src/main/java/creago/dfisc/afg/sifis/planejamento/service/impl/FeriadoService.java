package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFeriadoDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Feriado;
import creago.dfisc.afg.sifis.planejamento.service.IFeriadoService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FeriadoService extends AbstractService<Feriado> implements IFeriadoService {

    private IFeriadoDAO dao;

    @Override
    protected IOperations<Feriado> getDao() {
        return dao;
    }

}
