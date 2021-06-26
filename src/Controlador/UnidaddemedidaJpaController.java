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
import Entidad.Producto;
import Entidad.Unidaddemedida;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Josue
 */
public class UnidaddemedidaJpaController implements Serializable {

    public UnidaddemedidaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public UnidaddemedidaJpaController() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Unidaddemedida unidaddemedida) throws PreexistingEntityException, Exception {
        if (unidaddemedida.getProductoList() == null) {
            unidaddemedida.setProductoList(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedProductoList = new ArrayList<Producto>();
            for (Producto productoListProductoToAttach : unidaddemedida.getProductoList()) {
                productoListProductoToAttach = em.getReference(productoListProductoToAttach.getClass(), productoListProductoToAttach.getIdProducto());
                attachedProductoList.add(productoListProductoToAttach);
            }
            unidaddemedida.setProductoList(attachedProductoList);
            em.persist(unidaddemedida);
            for (Producto productoListProducto : unidaddemedida.getProductoList()) {
                Unidaddemedida oldIdUnidademedidaOfProductoListProducto = productoListProducto.getIdUnidademedida();
                productoListProducto.setIdUnidademedida(unidaddemedida);
                productoListProducto = em.merge(productoListProducto);
                if (oldIdUnidademedidaOfProductoListProducto != null) {
                    oldIdUnidademedidaOfProductoListProducto.getProductoList().remove(productoListProducto);
                    oldIdUnidademedidaOfProductoListProducto = em.merge(oldIdUnidademedidaOfProductoListProducto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUnidaddemedida(unidaddemedida.getIdUnidaddemedida()) != null) {
                throw new PreexistingEntityException("Unidaddemedida " + unidaddemedida + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Unidaddemedida unidaddemedida) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Unidaddemedida persistentUnidaddemedida = em.find(Unidaddemedida.class, unidaddemedida.getIdUnidaddemedida());
            List<Producto> productoListOld = persistentUnidaddemedida.getProductoList();
            List<Producto> productoListNew = unidaddemedida.getProductoList();
            List<String> illegalOrphanMessages = null;
            for (Producto productoListOldProducto : productoListOld) {
                if (!productoListNew.contains(productoListOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + productoListOldProducto + " since its idUnidademedida field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Producto> attachedProductoListNew = new ArrayList<Producto>();
            for (Producto productoListNewProductoToAttach : productoListNew) {
                productoListNewProductoToAttach = em.getReference(productoListNewProductoToAttach.getClass(), productoListNewProductoToAttach.getIdProducto());
                attachedProductoListNew.add(productoListNewProductoToAttach);
            }
            productoListNew = attachedProductoListNew;
            unidaddemedida.setProductoList(productoListNew);
            unidaddemedida = em.merge(unidaddemedida);
            for (Producto productoListNewProducto : productoListNew) {
                if (!productoListOld.contains(productoListNewProducto)) {
                    Unidaddemedida oldIdUnidademedidaOfProductoListNewProducto = productoListNewProducto.getIdUnidademedida();
                    productoListNewProducto.setIdUnidademedida(unidaddemedida);
                    productoListNewProducto = em.merge(productoListNewProducto);
                    if (oldIdUnidademedidaOfProductoListNewProducto != null && !oldIdUnidademedidaOfProductoListNewProducto.equals(unidaddemedida)) {
                        oldIdUnidademedidaOfProductoListNewProducto.getProductoList().remove(productoListNewProducto);
                        oldIdUnidademedidaOfProductoListNewProducto = em.merge(oldIdUnidademedidaOfProductoListNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = unidaddemedida.getIdUnidaddemedida();
                if (findUnidaddemedida(id) == null) {
                    throw new NonexistentEntityException("The unidaddemedida with id " + id + " no longer exists.");
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
            Unidaddemedida unidaddemedida;
            try {
                unidaddemedida = em.getReference(Unidaddemedida.class, id);
                unidaddemedida.getIdUnidaddemedida();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidaddemedida with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Producto> productoListOrphanCheck = unidaddemedida.getProductoList();
            for (Producto productoListOrphanCheckProducto : productoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Unidaddemedida (" + unidaddemedida + ") cannot be destroyed since the Producto " + productoListOrphanCheckProducto + " in its productoList field has a non-nullable idUnidademedida field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(unidaddemedida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Unidaddemedida> findUnidaddemedidaEntities() {
        return findUnidaddemedidaEntities(true, -1, -1);
    }

    public List<Unidaddemedida> findUnidaddemedidaEntities(int maxResults, int firstResult) {
        return findUnidaddemedidaEntities(false, maxResults, firstResult);
    }

    private List<Unidaddemedida> findUnidaddemedidaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Unidaddemedida.class));
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

    public Unidaddemedida findUnidaddemedida(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Unidaddemedida.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidaddemedidaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Unidaddemedida> rt = cq.from(Unidaddemedida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
