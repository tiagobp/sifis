package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IBairroDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Bairro;
import creago.dfisc.afg.sifis.planejamento.service.IBairroService;
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
public class BairroService extends AbstractService<Bairro> implements IBairroService {

    @Autowired
    private IBairroDAO dao;

    @Override
    protected IOperations<Bairro> getDao() {
        return dao;
    }
}
