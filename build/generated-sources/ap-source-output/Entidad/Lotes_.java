package Entidad;

import Entidad.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-25T18:53:11")
@StaticMetamodel(Lotes.class)
public class Lotes_ { 

    public static volatile SingularAttribute<Lotes, String> descripcion;
    public static volatile SingularAttribute<Lotes, Long> idLotes;
    public static volatile ListAttribute<Lotes, Producto> productoList;
    public static volatile SingularAttribute<Lotes, String> nombre;

}