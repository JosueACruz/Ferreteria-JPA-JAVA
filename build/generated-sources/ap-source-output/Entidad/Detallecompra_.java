package Entidad;

import Entidad.Compra;
import Entidad.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T18:53:11")
@StaticMetamodel(Detallecompra.class)
public class Detallecompra_ { 

    public static volatile SingularAttribute<Detallecompra, Long> idDetallecompra;
    public static volatile SingularAttribute<Detallecompra, BigDecimal> subtotal;
    public static volatile SingularAttribute<Detallecompra, Compra> idCompra;
    public static volatile SingularAttribute<Detallecompra, BigDecimal> preciocompra;
    public static volatile SingularAttribute<Detallecompra, Long> cantidad;
    public static volatile SingularAttribute<Detallecompra, BigDecimal> precioventa;
    public static volatile SingularAttribute<Detallecompra, Producto> idProducto;

}