package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IRotaDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Rota;
import creago.dfisc.afg.sifis.planejamento.service.IRotaService;
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
public class RotaService extends AbstractService<Rota> implements IRotaService {

    @Autowired
    private IRotaDAO dao;

    @Override
    protected IOperations<Rota> getDao() {
        return dao;
    }

}
