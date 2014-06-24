package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IUsuarioDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Usuario;
import creago.dfisc.afg.sifis.planejamento.service.IUsuarioService;
import creago.dfisc.afg.sifis.planejamento.service.common.AbstractService;

/**
 *
 * @author Tiago Borges Pereira
 */
public class UsuarioService extends AbstractService<Usuario> implements IUsuarioService {

    private IUsuarioDAO dao;

    @Override
    protected IOperations<Usuario> getDao() {
        return dao;
    }

}
