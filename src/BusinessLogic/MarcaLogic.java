/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.MarcaJpaController;
import Entidad.Marca;
import entityMain.entityMain;
import java.sql.Connection;
import java.util.List;
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
 * @author Erick Siguache
 */
public class MarcaLogic {
    private Marca marcaC = new Marca();
    private String msg = "";
    private MarcaJpaController Marjpa = new MarcaJpaController(entityMain.getInstance());
    EntityManager em = Marjpa.getEntityManager();

    
    public void ListaMarca(JTable tabla){
        DefaultTableModel model;
        String[] titulo={"Id", "Marca"};
        model=new DefaultTableModel(null, titulo);
        List<Marca> datos=Marjpa.findMarcaEntities();
        String[] datosMarca=new String[2];
        for(Marca Cat:datos){
            datosMarca[0]=Cat.getIdMarca().toString();
            datosMarca[1]=Cat.getNombre();
            model.addRow(datosMarca);
        }
        tabla.setModel(model);
    }
    public String insertarMarca(String categoria) {
        
        try {
            long id = idIncrement();
            marcaC.setIdMarca(id);
            marcaC.setNombre(categoria);
            Marjpa.create(marcaC);
            msg="Guardado correctamente";
        } catch (Exception e) {
            System.out.print("Mensaje en guardar: " + e.getMessage());
            msg="No se pudo guardar la informacion";
        }
        return msg;
    }
    public String actualizarMarca(int id, String nombre) {
        try{
            long idl=id;
            marcaC.setIdMarca(idl);
            marcaC.setNombre(nombre);
            Marjpa.edit(marcaC);
            msg="Guardado correctamente";
        }catch(Exception e){
            System.out.print("Mensaje en editar: " + e.getMessage());
            msg="No se pudo actualizar la informacion";
        }
        return msg;
    }
    public String eliminarMarca(int id){
        try{
            long idl = id;
            marcaC.setIdMarca(idl);
            Marjpa.destroy(idl);
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
        Query query = em.createQuery("select max(m.idMarca) from Marca m");
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
    public void ReporteGeneralMarca()
    {
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_Marca.jasper";
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
