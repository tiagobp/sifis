package creago.dfisc.afg.sifis.planejamento.dao;

import creago.dfisc.afg.sifis.planejamento.entities.Viagem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tiago Borges Pereira
 */
public class ViagemDAO {

    protected EntityManager entityManager;

    public ViagemDAO() {
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

    public Viagem getById(final Long id) {
        return entityManager.find(Viagem.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Viagem> findAll() {
        return entityManager.createQuery("FROM " + Viagem.class.getName())
                .getResultList();
    }

    public void persist(Viagem viagem) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(viagem);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Viagem viagem) {
        try {
            entityManager.getTransaction().begin();
            Viagem persisted = getById(viagem.getIdviagem());
            persisted.setInicio(viagem.getInicio());
            persisted.setFim(viagem.getFim());
            persisted.setFiscal(viagem.getFiscal());
            persisted.setCategoria(viagem.getCategoria());
            persisted.setRota(viagem.getRota());
            entityManager.merge(persisted);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Viagem viagem) {
        try {
            entityManager.getTransaction().begin();
            viagem = entityManager.find(Viagem.class, viagem.getIdviagem());
            entityManager.remove(viagem);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Long id) {
        try {
            Viagem viagem = getById(id);
            remove(viagem);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
