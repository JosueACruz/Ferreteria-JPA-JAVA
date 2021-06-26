package Entidad;

import Entidad.Cliente;
import Entidad.Detalleventa;
import Entidad.Tipoventa;
import Entidad.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T18:53:11")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, BigDecimal> total;
    public static volatile SingularAttribute<Venta, Tipoventa> idTipoventa;
    public static volatile SingularAttribute<Venta, Cliente> idCliente;
    public static volatile SingularAttribute<Venta, Usuario> idUsuario;
    public static volatile CollectionAttribute<Venta, Detalleventa> detalleventaCollection;
    public static volatile SingularAttribute<Venta, Long> idVenta;

}