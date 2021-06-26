package Entidad;

import Entidad.Detallecompra;
import Entidad.Proveedor;
import Entidad.Tipocompra;
import Entidad.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T18:53:11")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, BigDecimal> total;
    public static volatile ListAttribute<Compra, Detallecompra> detallecompraList;
    public static volatile SingularAttribute<Compra, Long> idCompra;
    public static volatile SingularAttribute<Compra, Proveedor> idProveedor;
    public static volatile SingularAttribute<Compra, Usuario> idUsuario;
    public static volatile SingularAttribute<Compra, Date> fechacompra;
    public static volatile SingularAttribute<Compra, Tipocompra> idTipocompra;

}