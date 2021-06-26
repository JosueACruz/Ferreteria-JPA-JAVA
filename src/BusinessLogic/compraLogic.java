/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.CategoriaJpaController;
import Controlador.CompraJpaController;
import Controlador.DetallecompraJpaController;
import Controlador.LotesJpaController;
import Controlador.MarcaJpaController;
import Controlador.ProductoJpaController;
import Controlador.ProveedorJpaController;
import Controlador.TipocompraJpaController;
import Controlador.UnidaddemedidaJpaController;
import Controlador.UsuarioJpaController;
import Controlador.exceptions.NonexistentEntityException;
import Entidad.Categoria;
import Entidad.Compra;
import Entidad.Detallecompra;
import Entidad.Lotes;
import Entidad.Marca;
import Entidad.Producto;
import Entidad.Proveedor;
import Entidad.Tipocompra;
import Entidad.Unidaddemedida;
import Entidad.Usuario;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Josue
 */
public class compraLogic {
    /////Compra
    Compra cmp = new Compra();
    CompraJpaController cmpC = new CompraJpaController();
    ////Proveedor
    Proveedor pr = new Proveedor();
    ProveedorJpaController prC = new ProveedorJpaController();
    ////Tipo Compra
    Tipocompra tc = new Tipocompra();
    TipocompraJpaController tcC = new TipocompraJpaController();
    //Usuario
    Usuario us = new Usuario();
    UsuarioJpaController usC = new UsuarioJpaController();
    //Detalle Compra
    Detallecompra dtc = new Detallecompra();
    DetallecompraJpaController dtcC = new DetallecompraJpaController();
    //Producto
    Producto prod = new Producto();
    ProductoJpaController prodC = new ProductoJpaController();
    //Agregando categorias
    private final Categoria cate = new Categoria();
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
    
    EntityManager em = prodC.getEntityManager();
    public int extraerIdCompra()
    {
        int conteo = cmpC.getCompraCount();
        int tot = conteo + 1;
        System.out.println("id: " + conteo);
        System.out.println("id t: " + tot);
        return tot;
    }
    public int extraerIdDetalle()
    {
        int conteo = dtcC.getDetallecompraCount();
        int tot = conteo + 1;
        return tot;
    }
    public void llenarproveedor(JComboBox cmbProveedor){
//        List<Proveedor> datos = prC.findProveedorEntities();
        cmbProveedor.addItem("Escoja un proveedor");
        Query query = em.createQuery("SELECT p FROM Proveedor p ORDER BY p.idProveedor");
        List<Proveedor> resultado = query.getResultList();
        for (Proveedor p : resultado)
        {
            cmbProveedor.addItem(p.getNombre());
        }
//        for(Proveedor p : datos)
//        {
//            cmbProveedor.addItem(p.getNombre());
//        }
    }
    public void llenarUsuario(JTextField usuario)
    {
        //sesion.Nombre = "Josue";
        //sesion.apellido = "Cruz";
        String nombre = sesion.Nombre;
        String apellido = sesion.apellido;
        String nombreCompleto = nombre + " " +apellido;
        usuario.setText(nombreCompleto);
    }
    public void llenarTabla(int Factura, String producto, String descripcion, int cantidad, double preciocompra, double precioventa, JTable table, JTextField total)
    {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        String [] titulo = {"Factura","idProducto" ,"Poducto", "Descripcion", "Cantidad", "Precio Compra", "IVA", "Subtotal","Precio Venta",};
        double sub = (cantidad * preciocompra);
        double iva;
        double subtot;
        iva = (sub * 0.13);
        String.format("%.3f", iva);
        subtot = sub + iva;
        Object nuevaFila[] = {Factura,sesion.idProductoCompra, producto, descripcion, cantidad, String.format("%.2f", preciocompra), String.format("%.2f", iva), String.format("%.2f", subtot), String.format("%.2f", precioventa)};
        modelo.addRow(nuevaFila);
        //Sumar el total
        double t = 0;
        double p = 0;
        if(modelo.getRowCount() > 0)
        {
            for(int i = 0; i < modelo.getRowCount(); i ++)
            {
                p = Double.parseDouble((modelo.getValueAt(i, 7).toString()));
                t += p;
            }
            total.setText(String.format("%.2f", t)+"");
        }
    }
    public void llenarTipoCompra(JComboBox cmbtipoCompra)
    {
        List<Tipocompra> datos = tcC.findTipocompraEntities();
        cmbtipoCompra.addItem("Escoja el tipo de compra");
        for(Tipocompra t: datos)
        {
            cmbtipoCompra.addItem(t.getNombre());
        }
    }
    public void eliminardetabla(JTable table)
    {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        
        modelo.removeRow(table.getSelectedRow());
    }
        public void limpiarTabla(JTable table)
    {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        int filas = modelo.getRowCount();
        for(int i = 0; filas > i; i++)
        {
            modelo.removeRow(0);
        }    
    }
    public boolean ingresarCompra(int idCompra, int idProveedor, int idTipoCompra, Date fecha, double total)
    {
         boolean valor;
        try {
            //id_compra id_proveedor id_usuario id_tipoCompra FechaCompra Total
            //Pasando a long los id
           
            long idC = idCompra;
            long idProv = idProveedor;
            long idUsu = sesion.getIdUsuario();
            long idTU = idTipoCompra;
            //Conviritneod en objetos segun corresponde los id
            pr.setIdProveedor(idProv);
            us.setIdUsuario(idUsu);
            tc.setIdTipocompra(idTU);
            //insertando en la Compra
            
            BigDecimal ttl = new BigDecimal(total);
            
            cmp.setIdCompra(idC);
            cmp.setIdProveedor(pr);
            cmp.setIdUsuario(us);
            cmp.setIdTipocompra(tc);
            cmp.setFechacompra(fecha);
            cmp.setTotal(ttl);
            cmpC.create(cmp);
            valor = true;
        } catch (Exception ex) {
            Logger.getLogger(compraLogic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Mensaje en guardar: " + ex.getMessage());
            valor = false;
        }
        return valor;
    }
    public boolean ingresarDetalleCompra(JTable tableDetalle)
    {
        boolean valor = false;
        DefaultTableModel modelo = (DefaultTableModel) tableDetalle.getModel();
//        if(modelo.getRowCount() > 0)
//        {
            for(int i = 0; i < modelo.getRowCount(); i++)
            {
                try {
                    //"Factura", 'idp',"Poducto", "Descripcion", "Cantidad", "Precio Compra", "IVA", "Subtotal","Precio Venta"
//               id_detalleCompra id_compra NUMBER id_producto PrecioCompra Cantidad PrecioVenta Subtotal
                    long idDC = extraerIdDetalle();
                    long idCompra = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                    long idP = Integer.parseInt(modelo.getValueAt(i, 1).toString());
                    int cantidad = Integer.parseInt(modelo.getValueAt(i, 4).toString());
                    double PrecioCompra ;
                    PrecioCompra = Double.parseDouble(modelo.getValueAt(i, 5).toString());
                    double PrecioVenta;
                    PrecioVenta = Double.parseDouble(modelo.getValueAt(i, 8).toString());
                    double Subtotal;
                    Subtotal = Double.parseDouble(modelo.getValueAt(i, 7).toString());
                    BigDecimal prcomp = new BigDecimal(PrecioCompra);
                    BigDecimal prvent = new BigDecimal(PrecioVenta);
                    BigDecimal sbtto = new BigDecimal(Subtotal);

                    cmp.setIdCompra(idCompra);
                    prod.setIdProducto(idP);

                    dtc.setIdDetallecompra(idDC);
                    dtc.setIdCompra(cmp);
                    dtc.setIdProducto(prod);
                    dtc.setPreciocompra(prcomp);
                    dtc.setCantidad(cantidad);
                    dtc.setPrecioventa(prvent);
                    dtc.setSubtotal(sbtto);

                    dtcC.create(dtc);
                    boolean R;
                    //Llamamos al metodo de restar producto luego de haber hecho el ingreso
                    restarProducto(idP, PrecioVenta, PrecioCompra,cantidad);
                    
                    valor = true;
                } catch (Exception ex) {
                    Logger.getLogger(compraLogic.class.getName()).log(Level.SEVERE, null, ex);
                    valor = false;
                }
            }
       // }
        return valor;
    }
    public boolean restarProducto(long id,double precioVenta,double costo, int cantid)
    {
        boolean Val;
        try {
            /////Obtenemos los datos del producto
            Producto p = new Producto();
            Query query = em.createQuery("SELECT p FROM Producto p WHERE p.idProducto =:idProducto");
            query.setParameter("idProducto",id);
            p = (Producto) query.getSingleResult();

            long idPr = p.getIdProducto();
            String nombre = p.getNombre().toString();
            String descr = p.getDescripcion().toString();
            long idMar = Integer.parseInt(p.getIdMarca().toString());
            long idCat = Integer.parseInt(p.getIdCategoria().toString());
            double precioV = Double.parseDouble(p.getPrecioventa().toString());
            Date fecha = p.getFechaingreso();
            double cost = Double.parseDouble(p.getCosto().toString());
            int stock = Integer.parseInt(p.getStock().toString());
            long idlot = Integer.parseInt(p.getIdLotes().toString());
            long idUni = Integer.parseInt(p.getIdUnidademedida().toString());

            /////Actualizamos el producto
            int nuevoTotal = stock + cantid;
            double nuevoPrecioVenta = precioVenta;
            ////
            BigDecimal nPV = new BigDecimal(nuevoPrecioVenta);
            BigDecimal nCos = new BigDecimal(costo);
            BigDecimal nStk = new BigDecimal(nuevoTotal);
            //Pasando a objetos los id
            cate.setIdCategoria(idCat);
            marc.setIdMarca(idMar);
            lot.setIdLotes(idlot);
            unid.setIdUnidaddemedida(idUni);
            //Insertando todo en la tabla producto
            //Query query2 = em.createQuery("UPDATE Producto p SET p.stock =:stock WHERE p.idProducto =:idProducto");
            
           // query2.setParameter("stock",nStk);
            //query2.setParameter("idProducto",idPr);
            //query2.executeUpdate();
            prod.setIdProducto(idPr);
            prod.setNombre(nombre);
            prod.setDescripcion(descr);
            prod.setIdMarca(marc);
            prod.setIdCategoria(cate);
            prod.setPrecioventa(nPV);
            prod.setFechaingreso(fecha);
            prod.setCosto(nCos);
            prod.setStock(nStk);
            prod.setIdLotes(lot);
            prod.setIdUnidademedida(unid);
            prodC.edit(prod);
            Val = true;
        } catch (Exception ex) {
            Logger.getLogger(compraLogic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Mensaje en actualizar: " + ex.getMessage());
            Val = false;
        }
        return Val;
    }
        public void listarCompra(JTable tabla){
        DefaultTableModel model;
        String [] titulo = {"id", "Proveedor", "Usuario", "Tipo Compra", "Fecha Compra", "Total"};
        model = new DefaultTableModel(null, titulo);
        
        List<Compra> datos = cmpC.findCompraEntities();
        String[] datosCompra = new String[6];
        for (Compra c : datos){
            datosCompra[0] = c.getIdCompra()+"";
            ///Proveedor
            Proveedor prv = c.getIdProveedor();
            datosCompra[1] = prv.getNombre();
            ///Usuario
            Usuario uss = c.getIdUsuario();
            ///////////////////////////////////////
            datosCompra[2] = uss.getNombre();
            //Tipo Compra
            Tipocompra tcm = c.getIdTipocompra();
            datosCompra[3] = tcm.getNombre();
            datosCompra[4] = c.getFechacompra()+"";
            datosCompra[5] = c.getTotal()+"";
            
            model.addRow(datosCompra);
        }
        tabla.setModel(model);
    }
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
            String path = "src\\Reports\\rpt_Compras.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReportePorID(int id)
    {
        Map parametro = new HashMap();
        parametro.put("id", id);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ComprasPorID.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReportePorFecha(String fecha)
    {
        Map parametro = new HashMap();
        parametro.put("fecha", fecha);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ComprasPorFecha.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReportePorMes(String Mes)
    {
        Map parametro = new HashMap();
        parametro.put("mes", Mes);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ComprasPorMes.jasper";
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
