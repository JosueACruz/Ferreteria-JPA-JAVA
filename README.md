# Ferreteria-JPA-JAVA

_Aplicación de compra venta, e inventario para una ferretería, con distintos módulos como usuarios, productos, categorías, proveedores, lotes, reportes, backup de base de datos, proyecto realizado con JPA, Java, base de datos en Oracle._

## Comenzando 🚀

_Es un proyecto realizado en el lenguaje JAVA, con base de datos en Oracle, se ha hecho uso de "JPA" (Java Persistense API) con el cual hacemos el manejo de datos entre la base de datos y la aplicacion_

Puedes descargarlo clonando el repositorio o descargando el codigo.


### Pre-requisitos 📋

_Para poder ejecutar de manera correcta esta aplicacion, es necesario tener instalado NetBeans (En mi caso 8.2),
tener instalada la base de datos de Oracle, con el administrador "SQL Developer", OracleJDBC_

### Instalación 🔧

_Importar la base de datos FerreteriaSQL a "SQL Developer"_

_Luego de tener la base de datos importada, crear un nuevo usuario para probar el funcionamiento de la base de datos correctamente_

_Crear una nueva conexion entre netbeans y la base de datos que hemos importado:_

```
Barra de herramientas superior de Netbeans buscar "Window" luego services
en Databases crear una nueva conexion con la base de datos.
escoger el Driver de conexion, y crear la conexion
```

En el proyecto modificar el archivo de persistencia.

```
Dentro de Source Packages -> META-INF -> persitence.xml
escoger el JDBC Connection la conexion que hemos creado antes a la base de datos en Oracle
El "Persistence Unit Name: ProjectJerusalenPU"
```

_luego de esto ya podremos ejecutar el proyecto_

## Ejecutando ⚙️

_Iniciamos sesion con el usuario que creamos desde la base de datos_

### Modulos 🔩

_En esta aplicacion tenemos distintos modulos con los cuales interactuar_

```
**Compra
**Venta
**Productos
**Administracion
  ****Categoria
  ****Lotes
  ****Proveedor
  ****Marca
  ****Cliente
  ****Usuarios
**Reportes
  ****Clientes
  ****Usuarios
  ****Productos
  ****Compra
  ****Proveedor
  ****Marca
  ****Venta
  ****Lote
**Backup y Restauracion de Base de datos
```

## Construido con 🛠️

* JAVA
* JPA
* Oracle
* SQL Developer
* OracleJDBC
* MVC
* Git/GitHub
* JassperReports

## Puedes ver los reportes en Youtube:
* https://youtu.be/3uKgGlvHf1s
