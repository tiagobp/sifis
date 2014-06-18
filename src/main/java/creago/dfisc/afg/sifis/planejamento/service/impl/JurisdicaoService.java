package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IJurisdicaoDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Jurisdicao;
import creago.dfisc.afg.sifis.planejamento.service.IJurisdicaoService;
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
public class JurisdicaoService extends AbstractService<Jurisdicao> implements IJurisdicaoService {

    @Autowired
    private IJurisdicaoDAO dao;

    @Override
    protected IOperations<Jurisdicao> getDao() {
        return dao;
    }

}
