package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IFeriadoDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Feriado;
import creago.dfisc.afg.sifis.planejamento.service.IFeriadoService;
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
public class FeriadoService extends AbstractService<Feriado> implements IFeriadoService {

    @Autowired
    private IFeriadoDAO dao;

    @Override
    protected IOperations<Feriado> getDao() {
        return dao;
    }

}
