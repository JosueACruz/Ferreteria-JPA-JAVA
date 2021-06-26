package Entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T18:53:11")
@StaticMetamodel(Productoscondetalle2.class)
public class Productoscondetalle2_ { 

    public static volatile SingularAttribute<Productoscondetalle2, String> descripcion;
    public static volatile SingularAttribute<Productoscondetalle2, Long> idUnidademedida;
    public static volatile SingularAttribute<Productoscondetalle2, String> medida;
    public static volatile SingularAttribute<Productoscondetalle2, BigDecimal> costo;
    public static volatile SingularAttribute<Productoscondetalle2, String> lote;
    public static volatile SingularAttribute<Productoscondetalle2, String> categoria;
    public static volatile SingularAttribute<Productoscondetalle2, String> nombre;
    public static volatile SingularAttribute<Productoscondetalle2, String> marca;
    public static volatile SingularAttribute<Productoscondetalle2, Long> idLotes;
    public static volatile SingularAttribute<Productoscondetalle2, Date> fechaingreso;
    public static volatile SingularAttribute<Productoscondetalle2, Long> idProducto;
    public static volatile SingularAttribute<Productoscondetalle2, BigDecimal> precioventa;
    public static volatile SingularAttribute<Productoscondetalle2, Long> idMarca;
    public static volatile SingularAttribute<Productoscondetalle2, Long> idCategoria;
    public static volatile SingularAttribute<Productoscondetalle2, BigDecimal> stock;

}