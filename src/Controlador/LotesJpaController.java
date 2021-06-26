/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Entidad.Lotes;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Josue
 */
public class LotesJpaController implements Serializable {

    public LotesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public LotesJpaController() {
    }
    

    public void create(Lotes lotes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lotes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLotes(lotes.getIdLotes()) != null) {
                throw new PreexistingEntityException("Lotes " + lotes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lotes lotes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lotes = em.merge(lotes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = lotes.getIdLotes();
                if (findLotes(id) == null) {
                    throw new NonexistentEntityException("The lotes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lotes lotes;
            try {
                lotes = em.getReference(Lotes.class, id);
                lotes.getIdLotes();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lotes with id " + id + " no longer exists.", enfe);
            }
            em.remove(lotes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lotes> findLotesEntities() {
        return findLotesEntities(true, -1, -1);
    }

    public List<Lotes> findLotesEntities(int maxResults, int firstResult) {
        return findLotesEntities(false, maxResults, firstResult);
    }

    private List<Lotes> findLotesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lotes.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Lotes findLotes(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lotes.class, id);
        } finally {
            em.close();
        }
    }

    public int getLotesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lotes> rt = cq.from(Lotes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
