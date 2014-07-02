package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.entities.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tiago Borges Pereira
 */
public class CategoriaDAO {

    protected EntityManager entityManager;

    public CategoriaDAO() {
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

    public Categoria getById(final Long id) {
        return entityManager.find(Categoria.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Categoria> findAll() {
        return entityManager.createQuery("FROM " + Categoria.class.getName())
                .getResultList();
    }

    public void persist(Categoria categoria) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Categoria categoria) {
        try {
            entityManager.getTransaction().begin();
            Categoria persisted = getById(categoria.getIdcategoria());
            persisted.setNome(categoria.getNome());
            persisted.setCor(categoria.getCor());
            entityManager.merge(persisted);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Categoria categoria) {
        try {
            entityManager.getTransaction().begin();
            categoria = entityManager.find(Categoria.class, categoria.getIdcategoria());
            entityManager.remove(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Long id) {
        try {
            Categoria categoria = getById(id);
            remove(categoria);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
