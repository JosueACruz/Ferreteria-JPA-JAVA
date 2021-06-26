package Entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T18:53:11")
@StaticMetamodel(Productoscondetalle.class)
public class Productoscondetalle_ { 

    public static volatile SingularAttribute<Productoscondetalle, String> descripcion;
    public static volatile SingularAttribute<Productoscondetalle, Long> idUnidademedida;
    public static volatile SingularAttribute<Productoscondetalle, String> medida;
    public static volatile SingularAttribute<Productoscondetalle, BigDecimal> costo;
    public static volatile SingularAttribute<Productoscondetalle, String> lote;
    public static volatile SingularAttribute<Productoscondetalle, String> categoria;
    public static volatile SingularAttribute<Productoscondetalle, String> nombre;
    public static volatile SingularAttribute<Productoscondetalle, String> marca;
    public static volatile SingularAttribute<Productoscondetalle, Long> idLotes;
    public static volatile SingularAttribute<Productoscondetalle, Date> fechaingreso;
    public static volatile SingularAttribute<Productoscondetalle, Long> idProducto;
    public static volatile SingularAttribute<Productoscondetalle, BigDecimal> precioventa;
    public static volatile SingularAttribute<Productoscondetalle, Long> idMarca;
    public static volatile SingularAttribute<Productoscondetalle, Long> idCategoria;
    public static volatile SingularAttribute<Productoscondetalle, BigDecimal> stock;

}