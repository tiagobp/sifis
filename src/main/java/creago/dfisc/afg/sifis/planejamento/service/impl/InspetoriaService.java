package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IInspetoriaDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Inspetoria;
import creago.dfisc.afg.sifis.planejamento.service.IInspetoriaService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;

/**
 *
 * @author Tiago Borges Pereira
 */
public class InspetoriaService extends AbstractService<Inspetoria> implements IInspetoriaService {

    private IInspetoriaDAO dao;

    @Override
    protected IOperations<Inspetoria> getDao() {
        return dao;
    }

}
