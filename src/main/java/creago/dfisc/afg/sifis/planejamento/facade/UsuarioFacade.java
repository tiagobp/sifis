package creago.dfisc.afg.sifis.planejamento.facade;

import creago.dfisc.afg.sifis.planejamento.dao.UsuarioDAO;
import creago.dfisc.afg.sifis.planejamento.entities.Usuario;
import java.util.List;

/**
 *
 * @author Tiago Borges Pereira
 */
public class UsuarioFacade {

    private final UsuarioDAO dao = new UsuarioDAO();

    public void create(Usuario usuario) {
        dao.persist(usuario);
    }

    public void update(Usuario usuario) {
        dao.merge(usuario);
    }

    public Usuario find(Long entityId) {
        Usuario usuario = dao.getById(entityId);
        return usuario;
    }

    public List<Usuario> listAll() {
        List<Usuario> result = dao.findAll();
        return result;
    }

    public void delete(Usuario usuario) {
        dao.removeById(usuario.getIdusuario());
    }
}
