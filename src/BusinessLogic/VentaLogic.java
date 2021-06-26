/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.CategoriaJpaController;
import Controlador.ClienteJpaController;
import Controlador.DetalleventaJpaController;
import Controlador.LotesJpaController;
import Controlador.MarcaJpaController;
import Controlador.ProductoJpaController;
import Controlador.TipoventaJpaController;
import Controlador.UnidaddemedidaJpaController;
import Controlador.UsuarioJpaController;
import Controlador.VentaJpaController;
import Entidad.Categoria;
import Entidad.Cliente;
import Entidad.Detalleventa;
import Entidad.Lotes;
import Entidad.Marca;
import Entidad.Producto;
import Entidad.Proveedor;
import Entidad.Tipocompra;
import Entidad.Tipoventa;
import Entidad.Unidaddemedida;
import Entidad.Usuario;
import Entidad.Venta;
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
public class VentaLogic {
    ///Venta 
    Venta ven = new Venta();
    VentaJpaController venC = new VentaJpaController();
    //Detalle de venta
    Detalleventa detven = new Detalleventa();
    DetalleventaJpaController detvenC = new DetalleventaJpaController();
    //Usuario
    Usuario us = new Usuario();
    UsuarioJpaController usC = new UsuarioJpaController();
    //Tipo de venta
    Tipoventa tv = new Tipoventa();
    TipoventaJpaController tvC = new TipoventaJpaController();
    //Cliente
    Cliente cl = new Cliente();
    ClienteJpaController clC = new ClienteJpaController();
    //Producto
    Producto pr = new Producto();
    ProductoJpaController prC = new ProductoJpaController();
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
    
    EntityManager em = prC.getEntityManager();
    public int extraerIdVenta()
    {
        int conteo = venC.getVentaCount();
        int tot = conteo + 1;
        System.out.println("ultimo id de venta: " + conteo);
        System.out.println("nuevo id de venta: " + tot);
        return tot;
    }
    public int extraerIdDetalle()
    {
        int conteo = detvenC.getDetalleventaCount();
        int tot = conteo + 1;
        return tot;
    }
    public void llenarTipoVent(JComboBox cmbTipo)
    {
        List<Tipoventa> datos = tvC.findTipoventaEntities();
        cmbTipo.addItem("Escoja un tipo de venta");
        for(Tipoventa t: datos)
        {
            cmbTipo.addItem(t.getTipoventa());
        }
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
    public void llenarTabla(int factura, String producto, double precio, int cantidad, JTable tabla, JTextField total)
    {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        String [] titulo = {"Factura", "Producto", "Nombre", "Precio", "Cantidad", "IVA", "Subtotal"};
        double sub = (cantidad * precio);
        double iva;
        double subtot;
        iva = (sub * 0.13);
        subtot = sub + iva;
        //String.format("%.2f", preciocompra)
        Object nuevaFila[] = {factura, sesion.idProductoVenta, producto, String.format("%.2f", precio), cantidad, String.format("%.2f", iva), String.format("%.2f", subtot)};
        modelo.addRow(nuevaFila);
        //Sacando el total
        double t = 0;
        double p = 0;
        if(modelo.getRowCount()>0)
        {
            for(int i =0; i < modelo.getRowCount(); i++)
            {
                p = Double.parseDouble(modelo.getValueAt(i, 6).toString());
                t += p;
            }
            total.setText(String.format("%.2f", t)+"");
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
    public boolean ingresarVenta(int idVenta, int idCliente, Date fecha, int idTipoVenta, double total)
    {
        boolean valor;
        try{
            long idV = idVenta;
            long idC = idCliente;
            long idU = sesion.getIdUsuario();
            long idT = idTipoVenta;
            //Convirtiendo en objetos segun corresponda
            cl.setIdCliente(idC);
            us.setIdUsuario(idU);
            tv.setIdTipoventa(idT);
            BigDecimal ttl = new BigDecimal(total);
            
            //insertando en la venta
            ven.setIdVenta(idV);
            ven.setIdCliente(cl);
            ven.setIdUsuario(us);
            ven.setIdTipoventa(tv);
            ven.setFecha(fecha);
            ven.setTotal(ttl);
            venC.create(ven);
            valor = true;
            
        } catch(Exception ex){
            Logger.getLogger(compraLogic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Mensaje en guardar: " + ex.getMessage());
            valor = false;
        }
        return valor;
    }
    public boolean ingresarDetalleVenta(JTable tableDetalle)
    {
        boolean valor = false;
        DefaultTableModel modelo = (DefaultTableModel) tableDetalle.getModel();
        for(int i = 0; i < modelo.getRowCount(); i++)
        {
            try{
                long idDV = extraerIdDetalle();
                long idVenta = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                long idProd = Integer.parseInt(modelo.getValueAt(i, 1).toString());
                int cantidad = Integer.parseInt(modelo.getValueAt(i, 4).toString());
                double subtot; 
                subtot = Double.parseDouble(modelo.getValueAt(i, 5).toString());
                
                BigDecimal sbtot = new BigDecimal(subtot);
                
                ven.setIdVenta(idVenta);
                pr.setIdProducto(idProd);
                
                detven.setIdDetalleventa(idDV);
                detven.setIdVenta(ven);
                detven.setIdProducto(pr);
                detven.setCantidad(sbtot);
                detven.setSubtotal(sbtot);
                
                detvenC.create(detven);
                ///
                restarProducto(idProd, cantidad);
                valor = true;  
            }
            catch(Exception ex)
            {
                Logger.getLogger(compraLogic.class.getName()).log(Level.SEVERE, null, ex);
                valor = false;
            }
        }
        return valor;
    }
    public boolean restarProducto(long id, int cantid)
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
            int nuevoTotal = stock - cantid;
            ////
            BigDecimal nStk = new BigDecimal(nuevoTotal);
            BigDecimal prV = new BigDecimal(precioV);
            BigDecimal csT = new BigDecimal(cost);
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
            pr.setIdProducto(idPr);
            pr.setNombre(nombre);
            pr.setDescripcion(descr);
            pr.setIdMarca(marc);
            pr.setIdCategoria(cate);
            pr.setPrecioventa(prV);
            pr.setFechaingreso(fecha);
            pr.setCosto(csT);
            pr.setStock(nStk);
            pr.setIdLotes(lot);
            pr.setIdUnidademedida(unid);
            prC.edit(pr);
            Val = true;
        } catch (Exception ex) {
            Logger.getLogger(compraLogic.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Mensaje en actualizar: " + ex.getMessage());
            Val = false;
        }
        return Val;
    }
    public void factura(int id)
    {
        Map parametro = new HashMap();
        parametro.put("id", id);
        
        //Obtengo la variable conexion de JPA
        em.getTransaction().begin();
        java.sql.Connection connection = em.unwrap(java.sql.Connection.class); // unwraps the Connection class.    
        em.getTransaction().commit();
        
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\factura.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  connection);
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Para reportes
    public void listarVentas(JTable tabla){
        DefaultTableModel model;
        String [] titulo = {"id", "Cliente", "Fecha", "Usuario", "TipoVenta", "Total"};
        model = new DefaultTableModel(null, titulo);
        
        List<Venta> datos = venC.findVentaEntities();
        String[] datosVenta = new String[6];
        for (Venta c : datos){
            datosVenta[0] = c.getIdVenta()+"";
            ///Proveedor
            Cliente prv = c.getIdCliente();
            datosVenta[1] = prv.getNombre();
            //Fecha
            datosVenta[2] = c.getFecha()+"";
            ///Usuario
            Usuario uss = c.getIdUsuario();
            ///////////////////////////////////////
            datosVenta[3] = uss.getNombre();
            //Tipo Compra
            Tipoventa tcm = c.getIdTipoventa();
            datosVenta[4] = tcm.getTipoventa();
            
            datosVenta[5] = c.getTotal()+"";
            
            model.addRow(datosVenta);
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
            String path = "src\\Reports\\rpt_Ventas.jasper";
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
        parametro.put("venta", id);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_VentaPorID.jasper";
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
            String path = "src\\Reports\\rpt_VentaPorFecha.jasper";
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
        parametro.put("valor", Mes);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_VentasPorMes.jasper";
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
