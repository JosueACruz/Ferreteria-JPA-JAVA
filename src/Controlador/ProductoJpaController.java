/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidad.Categoria;
import Entidad.Lotes;
import Entidad.Marca;
import Entidad.Producto;
import Entidad.Unidaddemedida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Josue
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJerusalenPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ProductoJpaController() {
    }

    public void create(Producto producto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria idCategoria = producto.getIdCategoria();
            if (idCategoria != null) {
                idCategoria = em.getReference(idCategoria.getClass(), idCategoria.getIdCategoria());
                producto.setIdCategoria(idCategoria);
            }
            Lotes idLotes = producto.getIdLotes();
            if (idLotes != null) {
                idLotes = em.getReference(idLotes.getClass(), idLotes.getIdLotes());
                producto.setIdLotes(idLotes);
            }
            Marca idMarca = producto.getIdMarca();
            if (idMarca != null) {
                idMarca = em.getReference(idMarca.getClass(), idMarca.getIdMarca());
                producto.setIdMarca(idMarca);
            }
            Unidaddemedida idUnidademedida = producto.getIdUnidademedida();
            if (idUnidademedida != null) {
                idUnidademedida = em.getReference(idUnidademedida.getClass(), idUnidademedida.getIdUnidaddemedida());
                producto.setIdUnidademedida(idUnidademedida);
            }
            em.persist(producto);
            if (idCategoria != null) {
                idCategoria.getProductoList().add(producto);
                idCategoria = em.merge(idCategoria);
            }
            if (idLotes != null) {
                idLotes.getProductoList().add(producto);
                idLotes = em.merge(idLotes);
            }
            if (idMarca != null) {
                idMarca.getProductoList().add(producto);
                idMarca = em.merge(idMarca);
            }
            if (idUnidademedida != null) {
                idUnidademedida.getProductoList().add(producto);
                idUnidademedida = em.merge(idUnidademedida);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducto(producto.getIdProducto()) != null) {
                throw new PreexistingEntityException("Producto " + producto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edita(Producto producto) throws NonexistentEntityException, Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            producto = em.merge(producto);
            
            em.getTransaction().commit();
        }catch(Exception ex)
        {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
//            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
//            Categoria idCategoriaOld = persistentProducto.getIdCategoria();
//            Categoria idCategoriaNew = producto.getIdCategoria();
//            Lotes idLotesOld = persistentProducto.getIdLotes();
//            Lotes idLotesNew = producto.getIdLotes();
//            Marca idMarcaOld = persistentProducto.getIdMarca();
//            Marca idMarcaNew = producto.getIdMarca();
//            Unidaddemedida idUnidademedidaOld = persistentProducto.getIdUnidademedida();
//            Unidaddemedida idUnidademedidaNew = producto.getIdUnidademedida();
//            if (idCategoriaNew != null) {
//                idCategoriaNew = em.getReference(idCategoriaNew.getClass(), idCategoriaNew.getIdCategoria());
//                producto.setIdCategoria(idCategoriaNew);
//            }
//            if (idLotesNew != null) {
//                idLotesNew = em.getReference(idLotesNew.getClass(), idLotesNew.getIdLotes());
//                producto.setIdLotes(idLotesNew);
//            }
//            if (idMarcaNew != null) {
//                idMarcaNew = em.getReference(idMarcaNew.getClass(), idMarcaNew.getIdMarca());
//                producto.setIdMarca(idMarcaNew);
//            }
//            if (idUnidademedidaNew != null) {
//                idUnidademedidaNew = em.getReference(idUnidademedidaNew.getClass(), idUnidademedidaNew.getIdUnidaddemedida());
//                producto.setIdUnidademedida(idUnidademedidaNew);
//            }
            producto = em.merge(producto);
//            if (idCategoriaOld != null && !idCategoriaOld.equals(idCategoriaNew)) {
//                idCategoriaOld.getProductoList().remove(producto);
//                idCategoriaOld = em.merge(idCategoriaOld);
//            }
//            if (idCategoriaNew != null && !idCategoriaNew.equals(idCategoriaOld)) {
//                idCategoriaNew.getProductoList().add(producto);
//                idCategoriaNew = em.merge(idCategoriaNew);
//            }
//            if (idLotesOld != null && !idLotesOld.equals(idLotesNew)) {
//                idLotesOld.getProductoList().remove(producto);
//                idLotesOld = em.merge(idLotesOld);
//            }
//            if (idLotesNew != null && !idLotesNew.equals(idLotesOld)) {
//                idLotesNew.getProductoList().add(producto);
//                idLotesNew = em.merge(idLotesNew);
//            }
//            if (idMarcaOld != null && !idMarcaOld.equals(idMarcaNew)) {
//                idMarcaOld.getProductoList().remove(producto);
//                idMarcaOld = em.merge(idMarcaOld);
//            }
//            if (idMarcaNew != null && !idMarcaNew.equals(idMarcaOld)) {
//                idMarcaNew.getProductoList().add(producto);
//                idMarcaNew = em.merge(idMarcaNew);
//            }
//            if (idUnidademedidaOld != null && !idUnidademedidaOld.equals(idUnidademedidaNew)) {
//                idUnidademedidaOld.getProductoList().remove(producto);
//                idUnidademedidaOld = em.merge(idUnidademedidaOld);
//            }
//            if (idUnidademedidaNew != null && !idUnidademedidaNew.equals(idUnidademedidaOld)) {
//                idUnidademedidaNew.getProductoList().add(producto);
//                idUnidademedidaNew = em.merge(idUnidademedidaNew);
//            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
//            Categoria idCategoria = producto.getIdCategoria();
//            if (idCategoria != null) {
//                idCategoria.getProductoList().remove(producto);
//                idCategoria = em.merge(idCategoria);
//            }
//            Lotes idLotes = producto.getIdLotes();
//            if (idLotes != null) {
//                idLotes.getProductoList().remove(producto);
//                idLotes = em.merge(idLotes);
//            }
//            Marca idMarca = producto.getIdMarca();
//            if (idMarca != null) {
//                idMarca.getProductoList().remove(producto);
//                idMarca = em.merge(idMarca);
//            }
//            Unidaddemedida idUnidademedida = producto.getIdUnidademedida();
//            if (idUnidademedida != null) {
//                idUnidademedida.getProductoList().remove(producto);
//                idUnidademedida = em.merge(idUnidademedida);
//            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
