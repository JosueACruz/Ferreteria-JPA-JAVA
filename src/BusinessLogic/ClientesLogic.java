/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.ClienteJpaController;
import Entidad.Cliente;
import entityMain.entityMain;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.eclipse.persistence.sessions.Session;
/**
 *
 * @author Erick Siguache
 */
public class ClientesLogic {
    private Cliente ClieEnti = new Cliente();
    private String msg = "";
    private ClienteJpaController Cliejpa = new ClienteJpaController(entityMain.getInstance());
    EntityManager em = Cliejpa.getEntityManager();

    public void ListaClientes(JTable tabla){
        DefaultTableModel model;
        String[] titulo={"Id", "Nombre", "Apellido", "Telefono", "Direccion"};
        model=new DefaultTableModel(null, titulo);
        List<Cliente> datos=Cliejpa.findClienteEntities();
        String[] datosCliente=new String[5];
        for(Cliente Clie:datos){
            datosCliente[0]=Clie.getIdCliente().toString();
            datosCliente[1]=Clie.getNombre();
            datosCliente[2]=Clie.getApelido();
            datosCliente[3]=Clie.getTelefono();
            datosCliente[4]=Clie.getDireccion();
            model.addRow(datosCliente);
        }
        tabla.setModel(model);
    }
    public String insertarCliente(String nombre, String apellido, String telefono, String Direccion) {
        try {
            long id = idIncrement();
            ClieEnti.setIdCliente(id);
            ClieEnti.setNombre(nombre);
            ClieEnti.setApelido(apellido);
            ClieEnti.setTelefono(telefono);
            ClieEnti.setDireccion(Direccion);
            Cliejpa.create(ClieEnti);
            msg="Guardado correctamente";
        } catch (Exception e) {
            System.out.print("Mensaje en guardar: " + e.getMessage());
            msg="No se pudo guardar la informacion";
        }
        return msg;
    }
    public String actualizarCliente(int id, String nombre,String apellido, String telefono, String Direccion) {
        try{
            long idl=id;
            ClieEnti.setIdCliente(idl);
            ClieEnti.setNombre(nombre);
            ClieEnti.setApelido(apellido);
            ClieEnti.setTelefono(telefono);
            ClieEnti.setDireccion(Direccion);
            Cliejpa.edit(ClieEnti);
            msg="Guardado correctamente";
        }catch(Exception e){
            System.out.print("Mensaje en editar: " + e.getMessage());
            msg="No se pudo actualizar la informacion";
        }
        return msg;
    }
    public String eliminarCliente(int id){
        try{
            long idl = id;
            ClieEnti.setIdCliente(idl);
            Cliejpa.destroy(idl);
            msg = "Eliminado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en eliminar: " + e.getMessage());
            msg = "No se pudo eliminar la informacion";
        }
        return msg;
    }
        public int idIncrement()
    {
        Query query = em.createQuery("select max(c.idCliente) from Cliente c");
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
    public void buscarPorNombre(String param,JTable tabla)
    {
        Cliente c = new Cliente();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre");
        query.setParameter("nombre",param +"%");
        DefaultTableModel model;
        String[] titulo={"Id", "Nombre", "Apellido", "Telefono", "Direccion"};
        model=new DefaultTableModel(null, titulo);
        List<Cliente> datos= query.getResultList();
        String[] datosCliente=new String[5];
        for(Cliente Clie:datos){
            datosCliente[0]=Clie.getIdCliente().toString();
            datosCliente[1]=Clie.getNombre();
            datosCliente[2]=Clie.getApelido();
            datosCliente[3]=Clie.getTelefono();
            datosCliente[4]=Clie.getDireccion();
            model.addRow(datosCliente);
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
            String path = "src\\Reports\\rpt_Clientes.jasper";
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
        parametro.put("nombre", nombre);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ClientesNombre.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReporteVentasPorCLiente(int id)
    {
        Map parametro = new HashMap();
        parametro.put("id", id);
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ClientesVenta.jasper";
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
