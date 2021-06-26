/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Entidad.Productoscondetalle;
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
public class ProductoscondetalleJpaController implements Serializable {

    public ProductoscondetalleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ProductoscondetalleJpaController() {
    }

    public void create(Productoscondetalle productoscondetalle) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoscondetalle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductoscondetalle(productoscondetalle.getIdProducto()) != null) {
                throw new PreexistingEntityException("Productoscondetalle " + productoscondetalle + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productoscondetalle productoscondetalle) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoscondetalle = em.merge(productoscondetalle);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = productoscondetalle.getIdProducto();
                if (findProductoscondetalle(id) == null) {
                    throw new NonexistentEntityException("The productoscondetalle with id " + id + " no longer exists.");
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
            Productoscondetalle productoscondetalle;
            try {
                productoscondetalle = em.getReference(Productoscondetalle.class, id);
                productoscondetalle.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoscondetalle with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoscondetalle);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productoscondetalle> findProductoscondetalleEntities() {
        return findProductoscondetalleEntities(true, -1, -1);
    }

    public List<Productoscondetalle> findProductoscondetalleEntities(int maxResults, int firstResult) {
        return findProductoscondetalleEntities(false, maxResults, firstResult);
    }

    private List<Productoscondetalle> findProductoscondetalleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productoscondetalle.class));
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

    public Productoscondetalle findProductoscondetalle(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productoscondetalle.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoscondetalleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productoscondetalle> rt = cq.from(Productoscondetalle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
