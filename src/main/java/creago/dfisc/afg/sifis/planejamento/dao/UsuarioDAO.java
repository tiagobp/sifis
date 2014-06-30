package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.dao.common.GenericDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Usuario;

/**
 *
 * @author Tiago Borges Pereira
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public void delete(Usuario usuario) {
        super.delete(usuario.getIdusuario(), Usuario.class);
    }
}
