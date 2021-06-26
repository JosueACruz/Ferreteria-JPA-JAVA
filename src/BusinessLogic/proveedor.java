/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.ProveedorJpaController;
import Entidad.Proveedor;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTable;
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
public class proveedor {
    private Proveedor prove = new Proveedor();
    private ProveedorJpaController prov = new ProveedorJpaController();
    private String mensaje = "";
    
    EntityManager em = prov.getEntityManager();
    public String insertarDatos(String nombre, String direccion, String telefono)
    {
        try
        {
            long idl = idIncrement();
            prove.setIdProveedor(idl);
            prove.setNombre(nombre);
            prove.setDireccion(direccion);
            prove.setTelefono(telefono);
            prov.create(prove);
            mensaje = "Guardado correctamente";
        }
        catch (Exception e)
        {
            System.out.println("Mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
        }
        return mensaje;
    }
    public String actualizarDatos(int id, String nombre, String direccion, String telefono)
    {
        try
        {
            long idl = id;
            prove.setIdProveedor(idl);
            prove.setNombre(nombre);
            prove.setDireccion(direccion);
            prove.setTelefono(telefono);
            prov.edit(prove);
            mensaje = "Editado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en actualizar: " + e.getMessage());
            mensaje = "No se pudo actualiza la informacion";
        }
        return mensaje;
    }
    public String eliminarDato(int id)
    {
        try{
            long idl = id;
            prov.destroy(idl);
            mensaje = "Eliminado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en eliminar: " + e.getMessage());
            mensaje = "No se pudo eliminar la informacion";
        }
        return mensaje;
    }
    public void listarProveedores(JTable tabla)
    {
        DefaultTableModel model;
        String [] titulo = {"id", "Nombre", "Direccion", "Telefono"};
        model = new DefaultTableModel(null, titulo);
        
        List<Proveedor> datos = prov.findProveedorEntities();
        String[] datosProveedores = new String[4];
        for(Proveedor p : datos)
        {
            datosProveedores[0] = p.getIdProveedor().toString();
            datosProveedores[1] = p.getNombre().toString();
            datosProveedores[2] = p.getDireccion().toString();
            datosProveedores[3] = p.getTelefono().toString();
            model.addRow(datosProveedores);
        }
        tabla.setModel(model);
    }
    public int idIncrement()
    {
        Query query = em.createQuery("select max(p.idProveedor) from Proveedor p");
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
    private Connection con()
    {
        //Obtengo la variable conexion de JPA
        em.getTransaction().begin();
        java.sql.Connection connection = em.unwrap(java.sql.Connection.class); // unwraps the Connection class.    
        em.getTransaction().commit();
        return connection;
    }
    public void ReporteGeneralProveedor()
    {
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_Proveedor.jasper";
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null,  con());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
