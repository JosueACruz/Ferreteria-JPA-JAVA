/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import static java.lang.reflect.Array.set;

/**
 *
 * @author Josue
 */
public class sesion {
    
    /////// Variables de sesion
    public static int idUsuario;
    public static String Nombre;
    public static String apellido;
    public static String username;
    public static int idTipo;
    
    ////// Variables usadas en la compra
    public static String CProducto; 
    public static int idProductoCompra;

        ///// Variables usadas en la venta
    public static String ventaProducto;
    public static int idProductoVenta;
    
    public static String ventaCliente;
    public static int idClienteVenta;
    
    //////****************************** Get and Set ************************************

    public static String getCProducto() {
        return CProducto;
    }

    public static void setCProducto(String CProducto) {
        sesion.CProducto = CProducto;
    }

    public static String getVentaProducto() {
        return ventaProducto;
    }

    public static void setVentaProducto(String ventaProducto) {
        sesion.ventaProducto = ventaProducto;
    }

    public static int getIdProductoVenta() {
        return idProductoVenta;
    }

    public static void setIdProductoVenta(int idProductoVenta) {
        sesion.idProductoVenta = idProductoVenta;
    }

    public static String getVentaCliente() {
        return ventaCliente;
    }

    public static void setVentaCliente(String ventaCliente) {
        sesion.ventaCliente = ventaCliente;
    }

    public static int getIdClienteVenta() {
        return idClienteVenta;
    }

    public static void setIdClienteVenta(int idClienteVenta) {
        sesion.idClienteVenta = idClienteVenta;
    }
    
    public static int getIdProductoCompra() {
        return idProductoCompra;
    }

    public static void setIdProductoCompra(int idProductoCompra) {
        sesion.idProductoCompra = idProductoCompra;
    }

    
    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        sesion.Nombre = Nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        sesion.apellido = apellido;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        sesion.username = username;
    }

    public static int getIdTipo() {
        return idTipo;
    }

    public static void setIdTipo(int idTipo) {
        sesion.idTipo = idTipo;
    }


    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        sesion.idUsuario = idUsuario;
    }
}
