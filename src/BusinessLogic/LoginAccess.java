package BusinessLogic;

import Controlador.UsuarioJpaController;
import Entidad.Tipousuario;
import Entidad.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class LoginAccess {
    //Agregando la Entidad Usuario
    private Usuario usr = new Usuario();
    //Agregando el controlador JPA (En ese se hicieron cambios, constructor y EntityManagerFactory)
    private UsuarioJpaController usjpa = new UsuarioJpaController();
    //PAra lograr la conexion de la base de datos, agregamosla unidad de persistencia
    EntityManager em = usjpa.getEntityManager();
    public int login(String usuario, String pasword){
        int valor = 0;
        try{
            //// Con esta se consulta el id y el tipo de usuario
            ////SELECT  u.username, u.clave, u.idUsuario, u.idTipousuario FROM Usuario u WHERE u.username = 'josue' AND U.clave = '123'
            Usuario us = new Usuario();
            Query query = em.createQuery("SELECT  u FROM Usuario u WHERE u.username =:username AND U.clave =:clave");
            query.setParameter("username", usuario);
            query.setParameter("clave", pasword);
            List resultado = query.getResultList();
            us = (Usuario) query.getSingleResult();
            Tipousuario t = us.getIdTipousuario();
//            Tipousuario t = new Tipousuario();
//            Tipousuario u = query.getIdTipousuario();
//            System.out.println("id t: "+ u.getIdTipousuario());
            
            //int tipo = Integer.parseInt(us.getIdTipousuario().toString());
            if(!resultado.isEmpty()){
                if(t.getIdTipousuario() == 1)
                {/////Administrador
                   valor = 1;
                   System.out.println("id t: "+ t.getIdTipousuario());
                }
                else if(t.getIdTipousuario() == 2)
                {////Gerente
                    valor = 2;
                }
                else if(t.getIdTipousuario() == 3)
                {////Vendedor
                    valor = 2;
                }
            }
            else{
                valor = 0;
            }
        }
        catch(Exception e){
            valor = 0;
        }
        return valor;
    }
    public Usuario parasesion(String usuario, String pasword)
    {
        Usuario us = new Usuario();
        Query query = em.createQuery("SELECT  u FROM Usuario u WHERE u.username =:username AND U.clave =:clave");
        query.setParameter("username",usuario);
        query.setParameter("clave",pasword);
        us = (Usuario) query.getSingleResult();
        
        long u = us.getIdUsuario();
        String nombre = us.getNombre();
        String apellido = us.getApellido();
        String username = us.getUsername();
        //Mandando a sesion
        sesion.idUsuario = (int)u;
        sesion.Nombre = nombre;
        sesion.apellido = apellido;
        sesion.username = username;
        System.out.println("id de sesion: " + sesion.idUsuario);
        return us;
    }
}
