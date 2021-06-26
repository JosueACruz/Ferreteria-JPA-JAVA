/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import static java.awt.PageAttributes.MediaType.C;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Josue
 */
public class backup {
    //Aqui meter sus datos de oracle!!!!!!!!!!!!!!!!!!!!!!!!!!!
    String nombreUsuario = "ferreteria";
    String pass = "qwerty";
    String NombreBD = "Ferreteria";
    public int seleccionar()
    {
        int sel = 0;
        Scanner entrada = null;
        //creamos el objeto JFileChooser
        JFileChooser fileChooser = new JFileChooser(".");
        //creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos DMP (.DMP)", "DMP");
        fileChooser.setCurrentDirectory(new File("C:\\BackuOracle"));
        //Asignamos el filtro
        fileChooser.setFileFilter(filtro);
        //Abrimos el cuadro de dialogo
        int valor = fileChooser.showOpenDialog(fileChooser);
        if(valor == JFileChooser.APPROVE_OPTION){
            //Obtenemos la ruta del fichero seleccionado
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();                                        
            //leemos el nombre
            String nom = fileChooser.getSelectedFile().getName();
            String[] arch = nom.split("\\.");
            String n = arch[0];
            String ext = arch[1];
            System.out.println(ruta);
            System.out.println("Nombre: " + n);
            String ru = "C:\\BackuOracle\\"+n+".DMP";
            if(!ruta.equals(ru))
            {
                JOptionPane.showMessageDialog(null, "Solo puede escoger archivos de la carpeta: C:/BackuOracle");
                sel = 0;
            }
            else{
                try {
                    Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"impdp "+nombreUsuario+"/"+pass+" schemas="+NombreBD+" directory=dpdir dumpfile="+n+".dmp content=data_only && exit");
                    sel = 1;
                } catch (IOException ex) {
                    Logger.getLogger(backup.class.getName()).log(Level.SEVERE, null, ex);
                    sel = 0;
                }
            }
        }
        else{
            System.out.println("No se ha seleccionado ningun archivo de restauracion");
        }
        return sel;
    }
    public int generarbackup(String nombre)
    {
        int rest = 0;
        try {
            String nom = nombre.trim();
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"expdp "+nombreUsuario+"/"+pass+" schemas="+NombreBD+" directory=dpdir dumpfile="+nom+".dmp && exit");
            rest = 1;
        } catch (IOException ex) {
            Logger.getLogger(backup.class.getName()).log(Level.SEVERE, null, ex);
            rest = 0;
        }
        return rest;
    }
}
