/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controller.exceptions.IllegalOrphanException;
import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidad.Compra;
import Entidad.Tipocompra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Josue
 */
public class TipocompraJpaController implements Serializable {

    public TipocompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TipocompraJpaController() {
    }

    public void create(Tipocompra tipocompra) throws PreexistingEntityException, Exception {
        if (tipocompra.getCompraList() == null) {
            tipocompra.setCompraList(new ArrayList<Compra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Compra> attachedCompraList = new ArrayList<Compra>();
            for (Compra compraListCompraToAttach : tipocompra.getCompraList()) {
                compraListCompraToAttach = em.getReference(compraListCompraToAttach.getClass(), compraListCompraToAttach.getIdCompra());
                attachedCompraList.add(compraListCompraToAttach);
            }
            tipocompra.setCompraList(attachedCompraList);
            em.persist(tipocompra);
            for (Compra compraListCompra : tipocompra.getCompraList()) {
                Tipocompra oldIdTipocompraOfCompraListCompra = compraListCompra.getIdTipocompra();
                compraListCompra.setIdTipocompra(tipocompra);
                compraListCompra = em.merge(compraListCompra);
                if (oldIdTipocompraOfCompraListCompra != null) {
                    oldIdTipocompraOfCompraListCompra.getCompraList().remove(compraListCompra);
                    oldIdTipocompraOfCompraListCompra = em.merge(oldIdTipocompraOfCompraListCompra);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipocompra(tipocompra.getIdTipocompra()) != null) {
                throw new PreexistingEntityException("Tipocompra " + tipocompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipocompra tipocompra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipocompra persistentTipocompra = em.find(Tipocompra.class, tipocompra.getIdTipocompra());
            List<Compra> compraListOld = persistentTipocompra.getCompraList();
            List<Compra> compraListNew = tipocompra.getCompraList();
            List<String> illegalOrphanMessages = null;
            for (Compra compraListOldCompra : compraListOld) {
                if (!compraListNew.contains(compraListOldCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Compra " + compraListOldCompra + " since its idTipocompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Compra> attachedCompraListNew = new ArrayList<Compra>();
            for (Compra compraListNewCompraToAttach : compraListNew) {
                compraListNewCompraToAttach = em.getReference(compraListNewCompraToAttach.getClass(), compraListNewCompraToAttach.getIdCompra());
                attachedCompraListNew.add(compraListNewCompraToAttach);
            }
            compraListNew = attachedCompraListNew;
            tipocompra.setCompraList(compraListNew);
            tipocompra = em.merge(tipocompra);
            for (Compra compraListNewCompra : compraListNew) {
                if (!compraListOld.contains(compraListNewCompra)) {
                    Tipocompra oldIdTipocompraOfCompraListNewCompra = compraListNewCompra.getIdTipocompra();
                    compraListNewCompra.setIdTipocompra(tipocompra);
                    compraListNewCompra = em.merge(compraListNewCompra);
                    if (oldIdTipocompraOfCompraListNewCompra != null && !oldIdTipocompraOfCompraListNewCompra.equals(tipocompra)) {
                        oldIdTipocompraOfCompraListNewCompra.getCompraList().remove(compraListNewCompra);
                        oldIdTipocompraOfCompraListNewCompra = em.merge(oldIdTipocompraOfCompraListNewCompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tipocompra.getIdTipocompra();
                if (findTipocompra(id) == null) {
                    throw new NonexistentEntityException("The tipocompra with id " + id + " no longer exists.");
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
            Tipocompra tipocompra;
            try {
                tipocompra = em.getReference(Tipocompra.class, id);
                tipocompra.getIdTipocompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipocompra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Compra> compraListOrphanCheck = tipocompra.getCompraList();
            for (Compra compraListOrphanCheckCompra : compraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tipocompra (" + tipocompra + ") cannot be destroyed since the Compra " + compraListOrphanCheckCompra + " in its compraList field has a non-nullable idTipocompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tipocompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipocompra> findTipocompraEntities() {
        return findTipocompraEntities(true, -1, -1);
    }

    public List<Tipocompra> findTipocompraEntities(int maxResults, int firstResult) {
        return findTipocompraEntities(false, maxResults, firstResult);
    }

    private List<Tipocompra> findTipocompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipocompra.class));
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

    public Tipocompra findTipocompra(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipocompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipocompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipocompra> rt = cq.from(Tipocompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
