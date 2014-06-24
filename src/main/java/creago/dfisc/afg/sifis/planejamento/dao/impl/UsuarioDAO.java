package creago.dfisc.afg.sifis.planejamento.dao.impl;

import creago.dfisc.afg.sifis.planejamento.dao.IUsuarioDAO;
import creago.dfisc.afg.sifis.planejamento.dao.common.AbstractJpaDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Usuario;

/**
 *
 * @author Tiago Borges Pereira
 */
public class UsuarioDAO extends AbstractJpaDAO<Usuario> implements IUsuarioDAO {

    public UsuarioDAO() {
        super();

        setClazz(Usuario.class);
    }
}
