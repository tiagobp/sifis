package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IJurisdicaoDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Jurisdicao;
import creago.dfisc.afg.sifis.planejamento.service.IJurisdicaoService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;

/**
 *
 * @author Tiago Borges Pereira
 */
public class JurisdicaoService extends AbstractService<Jurisdicao> implements IJurisdicaoService {

    private IJurisdicaoDAO dao;

    @Override
    protected IOperations<Jurisdicao> getDao() {
        return dao;
    }

}
