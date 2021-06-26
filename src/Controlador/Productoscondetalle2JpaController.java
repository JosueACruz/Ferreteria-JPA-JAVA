/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Entidad.Productoscondetalle2;
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
public class Productoscondetalle2JpaController implements Serializable {

    public Productoscondetalle2JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public Productoscondetalle2JpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productoscondetalle2 productoscondetalle2) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoscondetalle2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductoscondetalle2(productoscondetalle2.getIdProducto()) != null) {
                throw new PreexistingEntityException("Productoscondetalle2 " + productoscondetalle2 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productoscondetalle2 productoscondetalle2) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoscondetalle2 = em.merge(productoscondetalle2);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = productoscondetalle2.getIdProducto();
                if (findProductoscondetalle2(id) == null) {
                    throw new NonexistentEntityException("The productoscondetalle2 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productoscondetalle2 productoscondetalle2;
            try {
                productoscondetalle2 = em.getReference(Productoscondetalle2.class, id);
                productoscondetalle2.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoscondetalle2 with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoscondetalle2);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productoscondetalle2> findProductoscondetalle2Entities() {
        return findProductoscondetalle2Entities(true, -1, -1);
    }

    public List<Productoscondetalle2> findProductoscondetalle2Entities(int maxResults, int firstResult) {
        return findProductoscondetalle2Entities(false, maxResults, firstResult);
    }

    private List<Productoscondetalle2> findProductoscondetalle2Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productoscondetalle2.class));
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

    public Productoscondetalle2 findProductoscondetalle2(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productoscondetalle2.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoscondetalle2Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productoscondetalle2> rt = cq.from(Productoscondetalle2.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
