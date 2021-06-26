/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Entidad.Usuarioscondetalle;
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
public class UsuarioscondetalleJpaController implements Serializable {

    public UsuarioscondetalleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public UsuarioscondetalleJpaController() {
    }

    public List<Usuarioscondetalle> findUsuarioscondetalleEntities() {
        return findUsuarioscondetalleEntities(true, -1, -1);
    }

    public List<Usuarioscondetalle> findUsuarioscondetalleEntities(int maxResults, int firstResult) {
        return findUsuarioscondetalleEntities(false, maxResults, firstResult);
    }

    private List<Usuarioscondetalle> findUsuarioscondetalleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarioscondetalle.class));
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

    public Usuarioscondetalle findUsuarioscondetalle(long id) {
        EntityManager em = getEntityManager();
//        em.flush();
//        em.clear();
        try {
                        em.flush();
        em.clear();
            return em.find(Usuarioscondetalle.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioscondetalleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarioscondetalle> rt = cq.from(Usuarioscondetalle.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
