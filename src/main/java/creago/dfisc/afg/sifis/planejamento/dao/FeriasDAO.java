package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.entities.Ferias;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tiago Borges Pereira
 */
public class FeriasDAO {

    protected EntityManager entityManager;

    public FeriasDAO() {
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

    public Ferias getById(final Long id) {
        return entityManager.find(Ferias.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Ferias> findAll() {
        return entityManager.createQuery("FROM " + Ferias.class.getName())
                .getResultList();
    }

    public void persist(Ferias ferias) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(ferias);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Ferias ferias) {
        try {
            entityManager.getTransaction().begin();
            Ferias persisted = getById(ferias.getIdferias());
            persisted.setInicio(ferias.getInicio());
            persisted.setFim(ferias.getFim());
            persisted.setFiscal(ferias.getFiscal());
            entityManager.merge(persisted);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Ferias ferias) {
        try {
            entityManager.getTransaction().begin();
            ferias = entityManager.find(Ferias.class, ferias.getIdferias());
            entityManager.remove(ferias);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Long id) {
        try {
            Ferias ferias = getById(id);
            remove(ferias);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
