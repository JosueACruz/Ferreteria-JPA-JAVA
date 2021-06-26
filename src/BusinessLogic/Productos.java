/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.CategoriaJpaController;
import Controlador.LotesJpaController;
import Controlador.MarcaJpaController;
import Controlador.ProductoJpaController;
import Controlador.Productoscondetalle2JpaController;
import Controlador.ProductoscondetalleJpaController;
import Controlador.UnidaddemedidaJpaController;
import Entidad.Categoria;
import Entidad.Lotes;
import Entidad.Marca;
import Entidad.Producto;
import Entidad.Productoscondetalle;
import Entidad.Productoscondetalle2;
import Entidad.Unidaddemedida;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static org.eclipse.persistence.config.ExclusiveConnectionMode.Transactional;

/**
 *
 * @author Josue
 */
public class Productos {
    private final ProductoJpaController prod = new ProductoJpaController();
    Producto pro = new Producto();
    private String mensaje = "";   
    //Agregando categorias
    private Categoria cat = new Categoria();
    private final CategoriaJpaController catJpa = new CategoriaJpaController();
    //agregando marca
    private final Marca marc = new Marca();
    private final MarcaJpaController marcJpa = new MarcaJpaController();
    //Agregando lote
    private final Lotes lot = new Lotes();
    private final LotesJpaController lotJpa = new LotesJpaController();
    //Agregando unidad de medida
    private final Unidaddemedida unid = new Unidaddemedida();
    private final UnidaddemedidaJpaController unidJpa = new UnidaddemedidaJpaController();
    
    private final ProductoscondetalleJpaController det = new ProductoscondetalleJpaController();
    private final Productoscondetalle detEn = new Productoscondetalle();
    
    private final Productoscondetalle2JpaController det2 = new Productoscondetalle2JpaController();
    private final Productoscondetalle2 detEn2 = new Productoscondetalle2();
    
    EntityManager em = det.getEntityManager();
    EntityManager emo = prod.getEntityManager();
    
    public String insertarProducto(String nombre, String descripcion,Double precioVenta,Date fecha, Double costo, Double stock, int categoria, int marca, int lote, int unidad)
    {
        try{
            
            BigDecimal prvent = new BigDecimal(precioVenta);
            BigDecimal cost = new BigDecimal(costo);
            BigDecimal st = new BigDecimal(stock);
            //Convirtiendo primero los id a Long
            long idP = idIncrement();
            long idC = categoria;
            long idM = marca;
            long idL = lote;
            long idU = unidad;
            //Pasando a objetos los id
            cat.setIdCategoria(idC);
            marc.setIdMarca(idM);
            lot.setIdLotes(idL);
            unid.setIdUnidaddemedida(idU);
            //Insertando todo en la tabla producto
            pro.setIdProducto(idP);
            pro.setNombre(nombre);
            pro.setDescripcion(descripcion);
            pro.setIdMarca(marc);
            pro.setIdCategoria(cat);
            pro.setPrecioventa(prvent);
            pro.setFechaingreso(fecha);
            pro.setCosto(cost);
            pro.setStock(st);
            pro.setIdLotes(lot);
            pro.setIdUnidademedida(unid);
            prod.create(pro);
            mensaje = "Guardado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
        }
        return mensaje;
    }
    public String actualizarProducto(int id,String nombre, String descripcion,Double precioVenta,Date fecha, Double costo, Double stock, int categoria, int marca, int lote, int unidad){
        try{
            emo.getTransaction().begin();
            long idP = id;
            BigDecimal prvent = new BigDecimal(precioVenta);
            BigDecimal cost = new BigDecimal(costo);
            BigDecimal st = new BigDecimal(stock);
            //Convirtiendo primero los id a Long
            long idC = categoria;
            long idM = marca;
            long idL = lote;
            long idU = unidad;
            //Pasando a objetos los id
            cat.setIdCategoria(idC);
            marc.setIdMarca(idM);
            lot.setIdLotes(idL);
            unid.setIdUnidaddemedida(idU);

            Producto pr = emo.find(Producto.class, idP);
//            JOptionPane.showMessageDialog(null, pr);
//            pro = emo.find(Producto.class, prod.findProducto(l));
            
            //Insertando todo en la tabla producto
            pr.setIdProducto(idP);
            pr.setNombre(nombre);
            pr.setDescripcion(descripcion);
            pr.setIdMarca(marc);
            pr.setIdCategoria(cat);
            pr.setPrecioventa(prvent);
            pr.setFechaingreso(fecha);
            pr.setCosto(cost);
            pr.setStock(st);
            pr.setIdLotes(lot);
            pr.setIdUnidademedida(unid);
//            prod.edit(pro);
            
            
            emo.merge(pr);
            emo.getTransaction().commit();
            mensaje = "Actualizado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en actualizar: " + e.getMessage());
            mensaje = "No se pudo actualiza la informacion";
        }
        return mensaje;
    }
    public void limpiarModelo(JTable tabla) {
        DefaultTableModel tblModel = (DefaultTableModel) tabla.getModel();
        for (int i = tblModel.getRowCount(); i > 0; i--) {
            tblModel.removeRow(0);
        }
    }
    public String eliminarProducto(int id){
        try{
            long idl = id;
            pro.setIdProducto(idl);
            prod.destroy(idl);
            mensaje = "Eliminado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en eliminar: " + e.getMessage());
            mensaje = "No se pudo eliminar la informacion";
        }
        return mensaje;
    }
    public void listarProducto2(JTable tabla){
        //Para la fecha ************************************************************
        Locale loc = new Locale("es", "SV");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        ////************************************************************************
        DefaultTableModel tblModel = (DefaultTableModel) tabla.getModel();
        for (int i = tblModel.getRowCount(); i > 0; i--) {
            tblModel.removeRow(0);
        }
        DefaultTableModel model;
        String[] titulo = {"id_producto", "nombre", "descripcion", "id_marca", "marca", "id_categoria", "categoria", "precioventa", "fechaingreso", "costo", "stock", "id_lotes", "Lote", "id_unidademedida", "medida"};
        model = new DefaultTableModel(null, titulo){
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        
        List<Producto> datos = prod.findProductoEntities();
        String[] datosProductos = new String[16];
        for (Producto p : datos){
            
            String date = dateFormat.format(p.getFechaingreso());
            //Aqui se hace el llamado a una vista en lugar de la tabla Producto, 
            //Se modifico la entidad con un id para poder crear el controlador de la vista
                datosProductos[0] = p.getIdProducto().toString();
                datosProductos[1] = p.getNombre();
                datosProductos[2] = p.getDescripcion();
                datosProductos[3] = p.getIdMarca().toString();
                Marca mrc = p.getIdMarca();
                datosProductos[4] = mrc.getNombre();
                datosProductos[5] = p.getIdCategoria().toString();
                Categoria ctg = p.getIdCategoria();
                datosProductos[6] = ctg.getNombre();
                datosProductos[7] = p.getPrecioventa().toString();
                datosProductos[8] = date;
                datosProductos[9] = p.getCosto().toString();
                datosProductos[10] = p.getStock().toString();
                datosProductos[11] = p.getIdLotes().toString();
                Lotes lts = p.getIdLotes();
                datosProductos[12] = lts.getNombre();
                datosProductos[13] = p.getIdUnidademedida().toString();
                Unidaddemedida undm = p.getIdUnidademedida();
                datosProductos[14] = undm.getMedida();
                      
                model.addRow(datosProductos);   
            }
        tabla.setModel(model);
    }
    public void listarCategoriacmb(JComboBox cmbCategoria){
        Query query = em.createQuery("SELECT c FROM Categoria c ORDER BY c.idCategoria");
//        cat = (Categoria) query.getSingleResult();
        cmbCategoria.addItem("Escoja una categoria");
        List<Categoria> resultado = query.getResultList();
        for (Categoria c : resultado)
        {
            cmbCategoria.addItem(c.getNombre());
        }
    }
    public void listarLotecmb(JComboBox cmbLotes){ 
//        List<Lotes> datos = lotJpa.findLotesEntities();
        cmbLotes.addItem("Escoja un lote");
        Query query = em.createQuery("SELECT l FROM Lotes l ORDER BY l.idLotes");
//        cat = (Categoria) query.getSingleResult();
        List<Lotes> resultado = query.getResultList();
        for (Lotes l : resultado)
        {
            cmbLotes.addItem(l.getNombre());
        }

    }
    public void listarMarcacmb(JComboBox cmbMarca)
    {
 //       List<Marca> datos = marcJpa.findMarcaEntities();
        cmbMarca.addItem("Escoja una marca");
        Query query = em.createQuery("SELECT m FROM Marca m ORDER BY m.idMarca");
        List<Marca> resultado = query.getResultList();
        for (Marca m : resultado)
        {
            cmbMarca.addItem(m.getNombre());
        }

    }
    public void listarUnidadcmb(JComboBox cmbUnidad)
    {
//        List<Unidaddemedida> datos = unidJpa.findUnidaddemedidaEntities();
        cmbUnidad.addItem("Escoja unidad de medida");
        Query query = em.createQuery("SELECT u FROM Unidaddemedida u ORDER BY u.idUnidaddemedida");
        List<Unidaddemedida> resultado = query.getResultList();
        for (Unidaddemedida m : resultado)
        {
            cmbUnidad.addItem(m.getMedida());
        }
    }
    public int idIncrement()
    {
        Query query = em.createQuery("select max(p.idProducto) from Producto p");
        List id = query.getResultList();
        String idAuto = id.toString();
        String idA = idAuto.replace("[", "").replace("]", "");
        int Nid = 0;
        if(idA.equals("Null") || idA.equals("null"))
        {
            Nid = 1;          
        }
        else
        {
            Nid = Integer.parseInt(idA) + 1;
        } 
        return Nid;           
    }
    public void listarProductoSinVista(JTable tabla){
        //Para la fecha ************************************************************
        Locale loc = new Locale("es", "SV");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        ////************************************************************************
        DefaultTableModel model;
        String[] titulo = {"id_producto", "nombre", "descripcion", "id_marca"};
        model = new DefaultTableModel(null, titulo){
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        
        List<Producto> datos = prod.findProductoEntities();
        String[] datosProductos = new String[16];
        for (Producto p : datos){
            
            //String date = dateFormat.format(p.getFechaingreso());
            //Aqui se hace el llamado a una vista en lugar de la tabla Producto, 
            //Se modifico la entidad con un id para poder crear el controlador de la vista
                datosProductos[0] = p.getIdProducto().toString();
                datosProductos[1] = p.getNombre();
                datosProductos[2] = p.getDescripcion();
                datosProductos[3] = p.getIdMarca().toString();
                //datosProductos[4] = p.getMarca();
                //datosProductos[5] = p.getIdCategoria().toString();
                //datosProductos[6] = p.getCategoria();
                //datosProductos[7] = p.getPrecioventa().toString();
                //datosProductos[8] = date;
                //datosProductos[9] = p.getCosto().toString();
                //datosProductos[10] = p.getStock().toString();
                //datosProductos[11] = p.getIdLotes().toString();
                //datosProductos[12] = p.getLote();
                //datosProductos[13] = p.getIdUnidademedida().toString();
                //datosProductos[14] = p.getMedida();
                      
                model.addRow(datosProductos);   
            }
        tabla.setModel(model);
    }
    public void listarProductoDeNuevo(JTable tabla){
        //Para la fecha ************************************************************
        Locale loc = new Locale("es", "SV");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        ////************************************************************************
        DefaultTableModel model;
        String[] titulo = {"id_producto", "nombre", "descripcion", "id_marca", "marca", "id_categoria", "categoria", "precioventa", "fechaingreso", "costo", "stock", "id_lotes", "Lote", "id_unidademedida", "medida"};
        model = new DefaultTableModel(null, titulo){
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        
        List<Productoscondetalle2> datos = det2.findProductoscondetalle2Entities();
        String[] datosProductos = new String[16];
        for (Productoscondetalle2 p : datos){
            
            String date = dateFormat.format(p.getFechaingreso());
            //Aqui se hace el llamado a una vista en lugar de la tabla Producto, 
            //Se modifico la entidad con un id para poder crear el controlador de la vista
                datosProductos[0] = p.getIdProducto().toString();
                datosProductos[1] = p.getNombre();
                datosProductos[2] = p.getDescripcion();
                datosProductos[3] = p.getIdMarca().toString();
                datosProductos[4] = p.getMarca();
                datosProductos[5] = p.getIdCategoria().toString();
                datosProductos[6] = p.getCategoria();
                datosProductos[7] = p.getPrecioventa().toString();
                datosProductos[8] = date;
                datosProductos[9] = p.getCosto().toString();
                datosProductos[10] = p.getStock().toString();
                datosProductos[11] = p.getIdLotes().toString();
                datosProductos[12] = p.getLote();
                datosProductos[13] = p.getIdUnidademedida().toString();
                datosProductos[14] = p.getMedida();
                      
                model.addRow(datosProductos);   
            }
        tabla.setModel(model);
    }
    ///Reportes
    private Connection con()
    {
        //Obtengo la variable conexion de JPA
        em.getTransaction().begin();
        java.sql.Connection connection = em.unwrap(java.sql.Connection.class); // unwraps the Connection class.    
        em.getTransaction().commit();
        return connection;
    }
    public void ReporteGeneral()
    {
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_Productos.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReportePorNombre(String nombre)
    {
        Map parametro = new HashMap();
        parametro.put("Valor", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ProductoNombre.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReporteLote(String nombre)
    {
        Map parametro = new HashMap();
        parametro.put("Valor", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ReporteLote.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ProductoProveedor(String nombre)
    {
        Map parametro = new HashMap();
        parametro.put("variable", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ProductoProveedor.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ProductoPreVenta(String nombre)
    {
        Map parametro = new HashMap();
        parametro.put("Valor", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ProductoPreVenta.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ProductoPreCompra(String nombre)
    {
        Map parametro = new HashMap();
        parametro.put("Precompra", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ProductoPreCompra.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ProductoMasVendido()
    {
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ProductoMasVendido.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ProductoFechaIngre(String nombre)
    {
        Map parametro = new HashMap();
        parametro.put("fechaIng", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ProductoFechaIngre.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ProductoCategoria(String nombre)
    {
        Map parametro = new HashMap();
        parametro.put("Cat", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ProductoCategoria.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ProductoCantidad(String nombre)
    {
        Map parametro = new HashMap();
        parametro.put("valor", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ProductoCantidad.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
