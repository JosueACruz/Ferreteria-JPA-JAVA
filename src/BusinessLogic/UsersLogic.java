/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.UsuarioJpaController;
import Controlador.TipousuarioJpaController;
import Controlador.UsuarioscondetalleJpaController;
import Entidad.Usuario;
import Entidad.Tipousuario;
import Entidad.Usuarioscondetalle;
import entityMain.entityMain;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JComboBox;
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
public class UsersLogic {

    private Usuario usEnti = new Usuario();
    private UsuarioJpaController usJp = new UsuarioJpaController();
    //Tipo de usuario
    private Tipousuario TipoEnti = new Tipousuario();
    //////////////////////////////////////////////
    private String msg = "";
    private TipousuarioJpaController Tipojpa = new TipousuarioJpaController(entityMain.getInstance());
    //Tipo de usuario
    private UsuarioJpaController Userjpa = new UsuarioJpaController(entityMain.getInstance());
    /////////////////////////////////
    //Llamando la vista para mostrar en la tabla
    private Usuarioscondetalle usVis = new Usuarioscondetalle();
    private UsuarioscondetalleJpaController usVisC = new UsuarioscondetalleJpaController();
    EntityManager em = Userjpa.getEntityManager();

    public void ListaUsuarios2(JTable tabla) {
        DefaultTableModel model;
        String[] titulo = {"Id", "Nombre", "Apellido","Nombre Completo" , "Telefono", "Nombre de Usuario", "Contraseña","IdTipo", "Tipo"};
        model = new DefaultTableModel(null, titulo);
        List<Usuario> datos = usJp.findUsuarioEntities();
        tabla.setModel(model);
        String[] datosUsuarios = new String[9];
        for(Usuario u : datos)
        {
            datosUsuarios[0] = u.getIdUsuario().toString();
            datosUsuarios[1] = u.getNombre().toString();
            datosUsuarios[2] = u.getApellido().toString();
            String nombrr = u.getNombre();
            String apelll = u.getApellido();
            datosUsuarios[3] = nombrr + " " + apelll;
            datosUsuarios[4] = u.getTelefono().toString();
            datosUsuarios[5] = u.getUsername().toString();
            datosUsuarios[6] = u.getClave().toString();
            datosUsuarios[7] = u.getIdTipousuario().toString();
            Tipousuario tus = u.getIdTipousuario();
            datosUsuarios[8] = tus.getTipo();
            model.addRow(datosUsuarios);
        }
        tabla.setModel(model);
    }
    public String insertarUsuarios(String nombre, String apellido, String telefono, int tipo, String username, String pass) {
        try{
            //pasando los id a long
            long idU = idIncrement();
            long idT = tipo;
            //pasando a objetos los id
            TipoEnti.setIdTipousuario(idT);
            //Insertando en la tabla usuario
            usEnti.setIdUsuario(idU);
            usEnti.setNombre(nombre);
            usEnti.setApellido(apellido);
            usEnti.setTelefono(telefono);
            usEnti.setIdTipousuario(TipoEnti);
            usEnti.setUsername(username);
            usEnti.setClave(pass);
            Userjpa.create(usEnti);
            msg = "Guardado correctamente";
            
        }catch(Exception e)
        {
            System.out.println("Mensaje en guardar: " + e.getMessage());
            msg = "No se pudo guardar la informacion";
        }
        return msg;
    }
    public void listarTipos(JComboBox cmbtipo){
        List<Tipousuario> datos = Tipojpa.findTipousuarioEntities();
        cmbtipo.addItem("Escoja un tipo de usuario");
        for(Tipousuario t: datos)
        {
            cmbtipo.addItem(t.getTipo().toString());
        }
    }
    public String actualizarUsuario(int idUsu,String nombre, String apellido, String telefono, int tipo, String username, String pass)
    {
        try{
            long idU = idUsu;
            long idT = tipo;
             //pasando a objetos los id
            TipoEnti.setIdTipousuario(idT);
            //Insertando en la tabla usuario
            usEnti.setIdUsuario(idU);
            usEnti.setNombre(nombre);
            usEnti.setApellido(apellido);
            usEnti.setTelefono(telefono);
            usEnti.setIdTipousuario(TipoEnti);
            usEnti.setUsername(username);
            usEnti.setClave(pass);
            Userjpa.edit(usEnti);
            msg = "Actualizado correctamente";
            
        }catch(Exception e)
        {
            System.out.println("Mensaje en actualizar: " + e.getMessage());
            msg = "No se pudo actualiza la informacion";
        }
        return msg;
    }
    public String eliminarUsuario(int id)
    {
        try{
            long idU = id;
            Userjpa.destroy(idU);
            msg = "Eliminado correctamente";
        }catch(Exception e)
        {
            System.out.println("Mensaje en eliminar: " + e.getMessage());
            msg = "No se pudo eliminar la informacion";
        }
        return msg;
    }
    public void contarusuarios()
    {
        int conteo;
        conteo = Userjpa.getUsuarioCount();
        System.out.println("son: " + conteo);
    }
    public int idIncrement()
    {
        Query query = em.createQuery("select max(u.idUsuario) from Usuario u");
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
    public void ReporteGeneralUsuario()
    {
        try {            
            JasperReport reporte = null;
            String path = "src\\Reports\\rpt_Usuarios.jasper";
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
