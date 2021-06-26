package Entidad;

import Entidad.Producto;
import Entidad.Venta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T18:53:11")
@StaticMetamodel(Detalleventa.class)
public class Detalleventa_ { 

    public static volatile SingularAttribute<Detalleventa, BigDecimal> subtotal;
    public static volatile SingularAttribute<Detalleventa, BigDecimal> cantidad;
    public static volatile SingularAttribute<Detalleventa, Producto> idProducto;
    public static volatile SingularAttribute<Detalleventa, Long> idDetalleventa;
    public static volatile SingularAttribute<Detalleventa, Venta> idVenta;

}