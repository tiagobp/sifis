package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IViagemDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Viagem;
import creago.dfisc.afg.sifis.planejamento.service.IViagemService;
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
public class ViagemService extends AbstractService<Viagem> implements IViagemService {

    @Autowired
    private IViagemDAO dao;

    @Override
    protected IOperations<Viagem> getDao() {
        return dao;
    }

}
