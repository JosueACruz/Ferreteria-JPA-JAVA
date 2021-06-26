package Entidad;

import Entidad.Categoria;
import Entidad.Detalleventa;
import Entidad.Lotes;
import Entidad.Marca;
import Entidad.Unidaddemedida;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T18:53:11")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Unidaddemedida> idUnidademedida;
    public static volatile SingularAttribute<Producto, Lotes> idLotes;
    public static volatile SingularAttribute<Producto, BigDecimal> costo;
    public static volatile SingularAttribute<Producto, Date> fechaingreso;
    public static volatile CollectionAttribute<Producto, Detalleventa> detalleventaCollection;
    public static volatile SingularAttribute<Producto, Long> idProducto;
    public static volatile SingularAttribute<Producto, BigDecimal> precioventa;
    public static volatile SingularAttribute<Producto, BigDecimal> stock;
    public static volatile SingularAttribute<Producto, Categoria> idCategoria;
    public static volatile SingularAttribute<Producto, Marca> idMarca;
    public static volatile SingularAttribute<Producto, String> nombre;

}