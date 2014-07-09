package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.entities.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tiago Borges Pereira
 */
public class UsuarioDAO {

    protected EntityManager entityManager;

    public UsuarioDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("PlanejamentoPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Usuario getById(final Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> findAll() {
        return entityManager.createQuery("FROM " + Usuario.class.getName() + " u ORDER BY u.nome, u.sobrenome")
                .getResultList();
    }

    public void persist(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            Usuario persisted = getById(usuario.getIdusuario());
            persisted.setNome(usuario.getNome());
            persisted.setAuthority(usuario.getAuthority());
            persisted.setAvatar(usuario.getAvatar());
            persisted.setEmail(usuario.getEmail());
            persisted.setFiscal(usuario.getFiscal());
            persisted.setMatricula(usuario.getMatricula());
            persisted.setPassword(usuario.getPassword());
            persisted.setUsername(usuario.getUsername());
            persisted.setSobrenome(usuario.getSobrenome());
            entityManager.merge(persisted);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            usuario = entityManager.find(Usuario.class, usuario.getIdusuario());
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Long id) {
        try {
            Usuario usuario = getById(id);
            remove(usuario);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
