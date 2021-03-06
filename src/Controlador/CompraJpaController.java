/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.IllegalOrphanException;
import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import Entidad.Compra;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidad.Proveedor;
import Entidad.Tipocompra;
import Entidad.Usuario;
import Entidad.Detallecompra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Josue
 */
public class CompraJpaController implements Serializable {

    public CompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf =  Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CompraJpaController() {
    }

    public void create(Compra compra) throws PreexistingEntityException, Exception {
        if (compra.getDetallecompraList() == null) {
            compra.setDetallecompraList(new ArrayList<Detallecompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor idProveedor = compra.getIdProveedor();
            if (idProveedor != null) {
                idProveedor = em.getReference(idProveedor.getClass(), idProveedor.getIdProveedor());
                compra.setIdProveedor(idProveedor);
            }
            Tipocompra idTipocompra = compra.getIdTipocompra();
            if (idTipocompra != null) {
                idTipocompra = em.getReference(idTipocompra.getClass(), idTipocompra.getIdTipocompra());
                compra.setIdTipocompra(idTipocompra);
            }
            Usuario idUsuario = compra.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                compra.setIdUsuario(idUsuario);
            }
            List<Detallecompra> attachedDetallecompraList = new ArrayList<Detallecompra>();
            for (Detallecompra detallecompraListDetallecompraToAttach : compra.getDetallecompraList()) {
                detallecompraListDetallecompraToAttach = em.getReference(detallecompraListDetallecompraToAttach.getClass(), detallecompraListDetallecompraToAttach.getIdDetallecompra());
                attachedDetallecompraList.add(detallecompraListDetallecompraToAttach);
            }
            compra.setDetallecompraList(attachedDetallecompraList);
            em.persist(compra);
            if (idProveedor != null) {
                idProveedor.getCompraList().add(compra);
                idProveedor = em.merge(idProveedor);
            }
            if (idTipocompra != null) {
                idTipocompra.getCompraList().add(compra);
                idTipocompra = em.merge(idTipocompra);
            }
            if (idUsuario != null) {
                idUsuario.getCompraList().add(compra);
                idUsuario = em.merge(idUsuario);
            }
            for (Detallecompra detallecompraListDetallecompra : compra.getDetallecompraList()) {
                Compra oldIdCompraOfDetallecompraListDetallecompra = detallecompraListDetallecompra.getIdCompra();
                detallecompraListDetallecompra.setIdCompra(compra);
                detallecompraListDetallecompra = em.merge(detallecompraListDetallecompra);
                if (oldIdCompraOfDetallecompraListDetallecompra != null) {
                    oldIdCompraOfDetallecompraListDetallecompra.getDetallecompraList().remove(detallecompraListDetallecompra);
                    oldIdCompraOfDetallecompraListDetallecompra = em.merge(oldIdCompraOfDetallecompraListDetallecompra);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCompra(compra.getIdCompra()) != null) {
                throw new PreexistingEntityException("Compra " + compra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compra compra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getIdCompra());
            Proveedor idProveedorOld = persistentCompra.getIdProveedor();
            Proveedor idProveedorNew = compra.getIdProveedor();
            Tipocompra idTipocompraOld = persistentCompra.getIdTipocompra();
            Tipocompra idTipocompraNew = compra.getIdTipocompra();
            Usuario idUsuarioOld = persistentCompra.getIdUsuario();
            Usuario idUsuarioNew = compra.getIdUsuario();
            List<Detallecompra> detallecompraListOld = persistentCompra.getDetallecompraList();
            List<Detallecompra> detallecompraListNew = compra.getDetallecompraList();
            List<String> illegalOrphanMessages = null;
            for (Detallecompra detallecompraListOldDetallecompra : detallecompraListOld) {
                if (!detallecompraListNew.contains(detallecompraListOldDetallecompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallecompra " + detallecompraListOldDetallecompra + " since its idCompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idProveedorNew != null) {
                idProveedorNew = em.getReference(idProveedorNew.getClass(), idProveedorNew.getIdProveedor());
                compra.setIdProveedor(idProveedorNew);
            }
            if (idTipocompraNew != null) {
                idTipocompraNew = em.getReference(idTipocompraNew.getClass(), idTipocompraNew.getIdTipocompra());
                compra.setIdTipocompra(idTipocompraNew);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                compra.setIdUsuario(idUsuarioNew);
            }
            List<Detallecompra> attachedDetallecompraListNew = new ArrayList<Detallecompra>();
            for (Detallecompra detallecompraListNewDetallecompraToAttach : detallecompraListNew) {
                detallecompraListNewDetallecompraToAttach = em.getReference(detallecompraListNewDetallecompraToAttach.getClass(), detallecompraListNewDetallecompraToAttach.getIdDetallecompra());
                attachedDetallecompraListNew.add(detallecompraListNewDetallecompraToAttach);
            }
            detallecompraListNew = attachedDetallecompraListNew;
            compra.setDetallecompraList(detallecompraListNew);
            compra = em.merge(compra);
            if (idProveedorOld != null && !idProveedorOld.equals(idProveedorNew)) {
                idProveedorOld.getCompraList().remove(compra);
                idProveedorOld = em.merge(idProveedorOld);
            }
            if (idProveedorNew != null && !idProveedorNew.equals(idProveedorOld)) {
                idProveedorNew.getCompraList().add(compra);
                idProveedorNew = em.merge(idProveedorNew);
            }
            if (idTipocompraOld != null && !idTipocompraOld.equals(idTipocompraNew)) {
                idTipocompraOld.getCompraList().remove(compra);
                idTipocompraOld = em.merge(idTipocompraOld);
            }
            if (idTipocompraNew != null && !idTipocompraNew.equals(idTipocompraOld)) {
                idTipocompraNew.getCompraList().add(compra);
                idTipocompraNew = em.merge(idTipocompraNew);
            }
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getCompraList().remove(compra);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getCompraList().add(compra);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            for (Detallecompra detallecompraListNewDetallecompra : detallecompraListNew) {
                if (!detallecompraListOld.contains(detallecompraListNewDetallecompra)) {
                    Compra oldIdCompraOfDetallecompraListNewDetallecompra = detallecompraListNewDetallecompra.getIdCompra();
                    detallecompraListNewDetallecompra.setIdCompra(compra);
                    detallecompraListNewDetallecompra = em.merge(detallecompraListNewDetallecompra);
                    if (oldIdCompraOfDetallecompraListNewDetallecompra != null && !oldIdCompraOfDetallecompraListNewDetallecompra.equals(compra)) {
                        oldIdCompraOfDetallecompraListNewDetallecompra.getDetallecompraList().remove(detallecompraListNewDetallecompra);
                        oldIdCompraOfDetallecompraListNewDetallecompra = em.merge(oldIdCompraOfDetallecompraListNewDetallecompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = compra.getIdCompra();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
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
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Detallecompra> detallecompraListOrphanCheck = compra.getDetallecompraList();
            for (Detallecompra detallecompraListOrphanCheckDetallecompra : detallecompraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compra (" + compra + ") cannot be destroyed since the Detallecompra " + detallecompraListOrphanCheckDetallecompra + " in its detallecompraList field has a non-nullable idCompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proveedor idProveedor = compra.getIdProveedor();
            if (idProveedor != null) {
                idProveedor.getCompraList().remove(compra);
                idProveedor = em.merge(idProveedor);
            }
            Tipocompra idTipocompra = compra.getIdTipocompra();
            if (idTipocompra != null) {
                idTipocompra.getCompraList().remove(compra);
                idTipocompra = em.merge(idTipocompra);
            }
            Usuario idUsuario = compra.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getCompraList().remove(compra);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
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

    public Compra findCompra(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
