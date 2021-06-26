/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controller.exceptions.IllegalOrphanException;
import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.PreexistingEntityException;
import Entidad.Tipoventa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidad.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Josue
 */
public class TipoventaJpaController implements Serializable {

    public TipoventaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TipoventaJpaController() {
    }

    public void create(Tipoventa tipoventa) throws PreexistingEntityException, Exception {
        if (tipoventa.getVentaList() == null) {
            tipoventa.setVentaList(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : tipoventa.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdVenta());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            tipoventa.setVentaList(attachedVentaList);
            em.persist(tipoventa);
            for (Venta ventaListVenta : tipoventa.getVentaList()) {
                Tipoventa oldIdTipoventaOfVentaListVenta = ventaListVenta.getIdTipoventa();
                ventaListVenta.setIdTipoventa(tipoventa);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdTipoventaOfVentaListVenta != null) {
                    oldIdTipoventaOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdTipoventaOfVentaListVenta = em.merge(oldIdTipoventaOfVentaListVenta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoventa(tipoventa.getIdTipoventa()) != null) {
                throw new PreexistingEntityException("Tipoventa " + tipoventa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoventa tipoventa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoventa persistentTipoventa = em.find(Tipoventa.class, tipoventa.getIdTipoventa());
            List<Venta> ventaListOld = persistentTipoventa.getVentaList();
            List<Venta> ventaListNew = tipoventa.getVentaList();
            List<String> illegalOrphanMessages = null;
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaListOldVenta + " since its idTipoventa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdVenta());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            tipoventa.setVentaList(ventaListNew);
            tipoventa = em.merge(tipoventa);
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Tipoventa oldIdTipoventaOfVentaListNewVenta = ventaListNewVenta.getIdTipoventa();
                    ventaListNewVenta.setIdTipoventa(tipoventa);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdTipoventaOfVentaListNewVenta != null && !oldIdTipoventaOfVentaListNewVenta.equals(tipoventa)) {
                        oldIdTipoventaOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdTipoventaOfVentaListNewVenta = em.merge(oldIdTipoventaOfVentaListNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tipoventa.getIdTipoventa();
                if (findTipoventa(id) == null) {
                    throw new NonexistentEntityException("The tipoventa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoventa tipoventa;
            try {
                tipoventa = em.getReference(Tipoventa.class, id);
                tipoventa.getIdTipoventa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoventa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Venta> ventaListOrphanCheck = tipoventa.getVentaList();
            for (Venta ventaListOrphanCheckVenta : ventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tipoventa (" + tipoventa + ") cannot be destroyed since the Venta " + ventaListOrphanCheckVenta + " in its ventaList field has a non-nullable idTipoventa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipoventa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoventa> findTipoventaEntities() {
        return findTipoventaEntities(true, -1, -1);
    }

    public List<Tipoventa> findTipoventaEntities(int maxResults, int firstResult) {
        return findTipoventaEntities(false, maxResults, firstResult);
    }

    private List<Tipoventa> findTipoventaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoventa.class));
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

    public Tipoventa findTipoventa(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoventa.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoventaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoventa> rt = cq.from(Tipoventa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
