/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.LotesJpaController;
import Entidad.Lotes;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

/**
 *
 * @author Josue
 */
public class lote {
    private LotesJpaController lot = new LotesJpaController();
    private Lotes lo = new Lotes();
    private String mensaje = "";
    
    EntityManager em = lot.getEntityManager();
    public String insertarLote(String nombre, String descripcion)
    {
        try{
            long idl = idIncrement();
            lo.setIdLotes(idl);
            lo.setNombre(nombre);
            lo.setDescripcion(descripcion);
            lot.create(lo);
            mensaje = "Guardado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
        }
        return mensaje;
    }
    public String actualizarLote(int id,String nombre, String descripcion){
        try{
            long idl = id;
            lo.setIdLotes(idl);
            lo.setNombre(nombre);
            lo.setDescripcion(descripcion);
            lot.edit(lo);
            mensaje = "Actualizado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en actualizar: " + e.getMessage());
            mensaje = "No se pudo actualiza la informacion";
        }
        return mensaje;
    }
    public String eliminarLote(int id){
        try{
            long idl = id;
            lo.setIdLotes(idl);
            lot.destroy(idl);
            
            mensaje = "Eliminado correctamente";
        }
        catch(Exception e)
        {
            System.out.println("Mensaje en eliminar: " + e.getMessage());
            mensaje = "No se pudo eliminar la informacion";
        }
        return mensaje;
    }
    public void listarLote(JTable tabla){
        DefaultTableModel model;
        String [] titulo = {"id", "Nombre", "Descripcion"};
        model = new DefaultTableModel(null, titulo);
        
        List<Lotes> datos = lot.findLotesEntities();
        String[] datosLotes = new String[3];
        for (Lotes l : datos){
            datosLotes[0] = l.getIdLotes()+"";
            datosLotes[1] = l.getNombre()+"";
            datosLotes[2] = l.getDescripcion()+"";
            model.addRow(datosLotes);
        }
        tabla.setModel(model);
    }
    public int idIncrement()
    {
        Query query = em.createQuery("select max(l.idLotes) from Lotes l");
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
    public void ReporteGeneralLote()
    {
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_ReporteLote.jasper";
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
