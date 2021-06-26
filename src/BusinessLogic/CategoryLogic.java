/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Controlador.CategoriaJpaController;
import Entidad.Categoria;
import entityMain.entityMain;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CategoryLogic {

    private Categoria category = new Categoria();
    private String msg = "";
    private CategoriaJpaController Catjpa = new CategoriaJpaController(entityMain.getInstance());
    EntityManager em = Catjpa.getEntityManager();

    public void ListaCategoria(JTable tabla){
        DefaultTableModel model;
        String[] titulo={"Id", "Categoria"};
        model=new DefaultTableModel(null, titulo);
        List<Categoria> datos=Catjpa.findCategoriaEntities();
        String[] datosCategoria=new String[2];
        for(Categoria Cat:datos){
            datosCategoria[0]=Cat.getIdCategoria()+"";
            datosCategoria[1]=Cat.getNombre()+"";
            model.addRow(datosCategoria);
        }
        tabla.setModel(model);
    }
    
    public String insertarCategoria(String categoria) {
        try {
            long id = idIncrement();
            category.setIdCategoria(id);
            category.setNombre(categoria);
            Catjpa.create(category);
            msg="Guardado correctamente";
        } catch (Exception e) {
            System.out.print("Mensaje en guardar: " + e.getMessage());
            msg="No se pudo guardar la informacion";
        }
        return msg;
    }
    public String actualizarCategoria(int id, String nombre) {
        try{
            long idl=id;
            category.setIdCategoria(idl);
            category.setNombre(nombre);
            Catjpa.edit(category);
            msg="Guardado correctamente";
        }catch(Exception e){
            System.out.print("Mensaje en editar: " + e.getMessage());
            msg="No se pudo actualizar la informacion";
        }
        return msg;
    }
    
    public String eliminarCategoria(int id){
        try{
            long idl = id;
            category.setIdCategoria(idl);
            Catjpa.destroy(idl);
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
        Query query = em.createQuery("select max(c.idCategoria) from Categoria c");
        List id = query.getResultList();
        String idAuto = id.toString();
        String idA = idAuto.replace("[", "").replace("]", "");
        int Nid = Integer.parseInt(idA) + 1;
        return Nid;           
    }
}