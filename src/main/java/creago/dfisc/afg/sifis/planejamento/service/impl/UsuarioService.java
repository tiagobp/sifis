package creago.dfisc.afg.sifis.planejamento.service.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IUsuarioDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.IOperations;
import creago.dfisc.afg.sifis.planejamento.entities.Usuario;
import creago.dfisc.afg.sifis.planejamento.service.IUsuarioService;
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
public class UsuarioService extends AbstractService<Usuario> implements IUsuarioService {

    @Autowired
    private IUsuarioDAO dao;

    @Override
    protected IOperations<Usuario> getDao() {
        return dao;
    }

}
