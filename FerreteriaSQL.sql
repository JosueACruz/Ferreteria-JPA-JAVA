--------------------------------------------------------
--  File created - Friday-June-25-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CATEGORIA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."CATEGORIA" 
   (	"ID_CATEGORIA" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."CLIENTE" 
   (	"ID_CLIENTE" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(50 BYTE), 
	"APELIDO" VARCHAR2(50 BYTE), 
	"TELEFONO" VARCHAR2(8 BYTE), 
	"DIRECCION" VARCHAR2(250 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table COMPRA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."COMPRA" 
   (	"ID_COMPRA" NUMBER(10,0), 
	"ID_PROVEEDOR" NUMBER(10,0), 
	"ID_USUARIO" NUMBER(10,0), 
	"ID_TIPOCOMPRA" NUMBER(10,0), 
	"FECHACOMPRA" DATE, 
	"TOTAL" NUMBER(10,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table DETALLECOMPRA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."DETALLECOMPRA" 
   (	"ID_DETALLECOMPRA" NUMBER(10,0), 
	"ID_COMPRA" NUMBER(10,0), 
	"ID_PRODUCTO" NUMBER(10,0), 
	"PRECIOCOMPRA" NUMBER(10,2), 
	"CANTIDAD" NUMBER(10,0), 
	"PRECIOVENTA" NUMBER(10,2), 
	"SUBTOTAL" NUMBER(10,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table DETALLEVENTA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."DETALLEVENTA" 
   (	"ID_DETALLEVENTA" NUMBER(10,0), 
	"ID_VENTA" NUMBER(10,0), 
	"ID_PRODUCTO" NUMBER(10,0), 
	"CANTIDAD" NUMBER(10,2), 
	"SUBTOTAL" NUMBER(10,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table LOTES
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."LOTES" 
   (	"ID_LOTES" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"DESCRIPCION" VARCHAR2(250 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table MARCA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."MARCA" 
   (	"ID_MARCA" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PRODUCTO
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."PRODUCTO" 
   (	"ID_PRODUCTO" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"DESCRIPCION" VARCHAR2(250 BYTE), 
	"ID_MARCA" NUMBER(10,0), 
	"ID_CATEGORIA" NUMBER(10,0), 
	"PRECIOVENTA" NUMBER(10,2), 
	"FECHAINGRESO" DATE, 
	"COSTO" NUMBER(10,2), 
	"STOCK" NUMBER(10,2), 
	"ID_LOTES" NUMBER(10,0), 
	"ID_UNIDADEMEDIDA" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PROVEEDOR
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."PROVEEDOR" 
   (	"ID_PROVEEDOR" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(250 BYTE), 
	"DIRECCION" VARCHAR2(250 BYTE), 
	"TELEFONO" VARCHAR2(8 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPOCOMPRA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."TIPOCOMPRA" 
   (	"ID_TIPOCOMPRA" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPOUSUARIO
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."TIPOUSUARIO" 
   (	"ID_TIPOUSUARIO" NUMBER(10,0), 
	"TIPO" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TIPOVENTA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."TIPOVENTA" 
   (	"ID_TIPOVENTA" NUMBER(10,0), 
	"TIPOVENTA" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table UNIDADDEMEDIDA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."UNIDADDEMEDIDA" 
   (	"ID_UNIDADDEMEDIDA" NUMBER(10,0), 
	"MEDIDA" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."USUARIO" 
   (	"ID_USUARIO" NUMBER(10,0), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"APELLIDO" VARCHAR2(100 BYTE), 
	"TELEFONO" VARCHAR2(8 BYTE), 
	"USERNAME" VARCHAR2(25 BYTE), 
	"CLAVE" VARCHAR2(250 BYTE), 
	"ID_TIPOUSUARIO" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table VENTA
--------------------------------------------------------

  CREATE TABLE "FERRETERIA"."VENTA" 
   (	"ID_VENTA" NUMBER(10,0), 
	"ID_CLIENTE" NUMBER(10,0), 
	"FECHA" DATE, 
	"ID_USUARIO" NUMBER(10,0), 
	"ID_TIPOVENTA" NUMBER(10,0), 
	"TOTAL" NUMBER(10,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for View PRODUCTOSCONDETALLE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "FERRETERIA"."PRODUCTOSCONDETALLE" ("ID_PRODUCTO", "NOMBRE", "DESCRIPCION", "ID_MARCA", "MARCA", "ID_CATEGORIA", "CATEGORIA", "PRECIOVENTA", "FECHAINGRESO", "COSTO", "STOCK", "ID_LOTES", "LOTE", "ID_UNIDADEMEDIDA", "MEDIDA") AS 
  Select pr.id_producto, pr.nombre, pr.descripcion, pr.id_marca, m.nombre as marca, pr.id_categoria,
    cat.nombre as categoria, pr.precioventa, pr.fechaingreso, pr.costo, pr.stock, pr.id_lotes, l.nombre as lote, pr.id_unidademedida, un.medida 
from Producto pr 
join categoria cat on pr.id_categoria = cat.id_categoria 
join marca m on pr.id_marca = m.id_marca 
join lotes l on pr.id_lotes = l.id_lotes 
join unidaddemedida un on pr.id_unidademedida = un.id_unidaddemedida
;
--------------------------------------------------------
--  DDL for View PRODUCTOSCONDETALLE2
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "FERRETERIA"."PRODUCTOSCONDETALLE2" ("ID_PRODUCTO", "NOMBRE", "DESCRIPCION", "ID_MARCA", "MARCA", "ID_CATEGORIA", "CATEGORIA", "PRECIOVENTA", "FECHAINGRESO", "COSTO", "STOCK", "ID_LOTES", "LOTE", "ID_UNIDADEMEDIDA", "MEDIDA") AS 
  Select pr.id_producto, pr.nombre, pr.descripcion, pr.id_marca, m.nombre as marca, pr.id_categoria,
    cat.nombre as categoria, pr.precioventa, pr.fechaingreso, pr.costo, pr.stock, pr.id_lotes, l.nombre as lote, pr.id_unidademedida, un.medida 
from Producto pr 
join categoria cat on pr.id_categoria = cat.id_categoria 
join marca m on pr.id_marca = m.id_marca 
join lotes l on pr.id_lotes = l.id_lotes 
join unidaddemedida un on pr.id_unidademedida = un.id_unidaddemedida
;
--------------------------------------------------------
--  DDL for View USUARIOSCONDETALLE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "FERRETERIA"."USUARIOSCONDETALLE" ("ID_USUARIO", "USUARIO", "APELLIDO", "NOMBRE", "TELEFONO", "USERNAME", "CLAVE", "ID_TIPOUSUARIO", "TIPO") AS 
  select u.id_usuario, u.nombre as usuario, u.apellido,(u.nombre || ' ' || u.apellido) as Nombre, u.telefono, u.username, u.clave, u.id_tipousuario,tp.tipo from usuario u
join tipousuario tp on u.id_tipousuario = tp.id_tipousuario
;
REM INSERTING into FERRETERIA.CATEGORIA
SET DEFINE OFF;
Insert into FERRETERIA.CATEGORIA (ID_CATEGORIA,NOMBRE) values (3,'Categoria 3');
Insert into FERRETERIA.CATEGORIA (ID_CATEGORIA,NOMBRE) values (4,'Herramientas caseras');
Insert into FERRETERIA.CATEGORIA (ID_CATEGORIA,NOMBRE) values (1,'Categoria 1');
Insert into FERRETERIA.CATEGORIA (ID_CATEGORIA,NOMBRE) values (2,'Categoria 2 editado');
REM INSERTING into FERRETERIA.CLIENTE
SET DEFINE OFF;
Insert into FERRETERIA.CLIENTE (ID_CLIENTE,NOMBRE,APELIDO,TELEFONO,DIRECCION) values (2,'Javier','Aguirre','55664365','Ahuchapan');
Insert into FERRETERIA.CLIENTE (ID_CLIENTE,NOMBRE,APELIDO,TELEFONO,DIRECCION) values (3,'Juan','Garcia','66778855','Santa Ana');
REM INSERTING into FERRETERIA.COMPRA
SET DEFINE OFF;
Insert into FERRETERIA.COMPRA (ID_COMPRA,ID_PROVEEDOR,ID_USUARIO,ID_TIPOCOMPRA,FECHACOMPRA,TOTAL) values (3,1,1,1,to_date('01-DEC-20','DD-MON-RR'),1.98);
Insert into FERRETERIA.COMPRA (ID_COMPRA,ID_PROVEEDOR,ID_USUARIO,ID_TIPOCOMPRA,FECHACOMPRA,TOTAL) values (4,3,1,1,to_date('15-JUN-21','DD-MON-RR'),10.79);
Insert into FERRETERIA.COMPRA (ID_COMPRA,ID_PROVEEDOR,ID_USUARIO,ID_TIPOCOMPRA,FECHACOMPRA,TOTAL) values (1,1,1,1,to_date('14-OCT-20','DD-MON-RR'),28.25);
Insert into FERRETERIA.COMPRA (ID_COMPRA,ID_PROVEEDOR,ID_USUARIO,ID_TIPOCOMPRA,FECHACOMPRA,TOTAL) values (2,1,1,1,to_date('15-OCT-20','DD-MON-RR'),18.36);
REM INSERTING into FERRETERIA.DETALLECOMPRA
SET DEFINE OFF;
Insert into FERRETERIA.DETALLECOMPRA (ID_DETALLECOMPRA,ID_COMPRA,ID_PRODUCTO,PRECIOCOMPRA,CANTIDAD,PRECIOVENTA,SUBTOTAL) values (3,2,5,1,10,1.75,11.3);
Insert into FERRETERIA.DETALLECOMPRA (ID_DETALLECOMPRA,ID_COMPRA,ID_PRODUCTO,PRECIOCOMPRA,CANTIDAD,PRECIOVENTA,SUBTOTAL) values (4,2,2,1.25,5,1.85,7.06);
Insert into FERRETERIA.DETALLECOMPRA (ID_DETALLECOMPRA,ID_COMPRA,ID_PRODUCTO,PRECIOCOMPRA,CANTIDAD,PRECIOVENTA,SUBTOTAL) values (5,3,1,0.35,5,0.5,1.98);
Insert into FERRETERIA.DETALLECOMPRA (ID_DETALLECOMPRA,ID_COMPRA,ID_PRODUCTO,PRECIOCOMPRA,CANTIDAD,PRECIOVENTA,SUBTOTAL) values (6,4,2,1.85,3,2.25,6.27);
Insert into FERRETERIA.DETALLECOMPRA (ID_DETALLECOMPRA,ID_COMPRA,ID_PRODUCTO,PRECIOCOMPRA,CANTIDAD,PRECIOVENTA,SUBTOTAL) values (7,4,5,2,2,2.5,4.52);
Insert into FERRETERIA.DETALLECOMPRA (ID_DETALLECOMPRA,ID_COMPRA,ID_PRODUCTO,PRECIOCOMPRA,CANTIDAD,PRECIOVENTA,SUBTOTAL) values (1,1,1,1,5,1.75,5.65);
Insert into FERRETERIA.DETALLECOMPRA (ID_DETALLECOMPRA,ID_COMPRA,ID_PRODUCTO,PRECIOCOMPRA,CANTIDAD,PRECIOVENTA,SUBTOTAL) values (2,1,3,2,10,2.55,22.6);
REM INSERTING into FERRETERIA.DETALLEVENTA
SET DEFINE OFF;
Insert into FERRETERIA.DETALLEVENTA (ID_DETALLEVENTA,ID_VENTA,ID_PRODUCTO,CANTIDAD,SUBTOTAL) values (3,5,2,0.59,0.59);
Insert into FERRETERIA.DETALLEVENTA (ID_DETALLEVENTA,ID_VENTA,ID_PRODUCTO,CANTIDAD,SUBTOTAL) values (4,5,5,0.33,0.33);
Insert into FERRETERIA.DETALLEVENTA (ID_DETALLEVENTA,ID_VENTA,ID_PRODUCTO,CANTIDAD,SUBTOTAL) values (5,6,2,0.29,0.29);
Insert into FERRETERIA.DETALLEVENTA (ID_DETALLEVENTA,ID_VENTA,ID_PRODUCTO,CANTIDAD,SUBTOTAL) values (1,4,3,0.33,0.33);
Insert into FERRETERIA.DETALLEVENTA (ID_DETALLEVENTA,ID_VENTA,ID_PRODUCTO,CANTIDAD,SUBTOTAL) values (2,4,5,0.46,0.46);
REM INSERTING into FERRETERIA.LOTES
SET DEFINE OFF;
Insert into FERRETERIA.LOTES (ID_LOTES,NOMBRE,DESCRIPCION) values (3,'Lote 3','Descripcion de lote 3 editado');
Insert into FERRETERIA.LOTES (ID_LOTES,NOMBRE,DESCRIPCION) values (4,'Lote 4','Ingreso 1 de diciembre');
Insert into FERRETERIA.LOTES (ID_LOTES,NOMBRE,DESCRIPCION) values (1,'Lote 1','Descripcion de lote 1');
Insert into FERRETERIA.LOTES (ID_LOTES,NOMBRE,DESCRIPCION) values (2,'Lote 2','Descripcion de lote 2 editado');
REM INSERTING into FERRETERIA.MARCA
SET DEFINE OFF;
Insert into FERRETERIA.MARCA (ID_MARCA,NOMBRE) values (3,'Imacasa');
Insert into FERRETERIA.MARCA (ID_MARCA,NOMBRE) values (4,'Orobar');
Insert into FERRETERIA.MARCA (ID_MARCA,NOMBRE) values (1,'Trupper');
Insert into FERRETERIA.MARCA (ID_MARCA,NOMBRE) values (2,'Marca editada');
REM INSERTING into FERRETERIA.PRODUCTO
SET DEFINE OFF;
Insert into FERRETERIA.PRODUCTO (ID_PRODUCTO,NOMBRE,DESCRIPCION,ID_MARCA,ID_CATEGORIA,PRECIOVENTA,FECHAINGRESO,COSTO,STOCK,ID_LOTES,ID_UNIDADEMEDIDA) values (4,'Cuchillo','Acerado',2,2,2.55,to_date('20-OCT-20','DD-MON-RR'),2,8,2,1);
Insert into FERRETERIA.PRODUCTO (ID_PRODUCTO,NOMBRE,DESCRIPCION,ID_MARCA,ID_CATEGORIA,PRECIOVENTA,FECHAINGRESO,COSTO,STOCK,ID_LOTES,ID_UNIDADEMEDIDA) values (2,'Desarmador','Plano',1,2,2.25,to_date('14-OCT-20','DD-MON-RR'),1.85,1,1,1);
Insert into FERRETERIA.PRODUCTO (ID_PRODUCTO,NOMBRE,DESCRIPCION,ID_MARCA,ID_CATEGORIA,PRECIOVENTA,FECHAINGRESO,COSTO,STOCK,ID_LOTES,ID_UNIDADEMEDIDA) values (1,'Clavo','Grande',2,2,0.5,to_date('11-NOV-20','DD-MON-RR'),0.35,5,2,1);
Insert into FERRETERIA.PRODUCTO (ID_PRODUCTO,NOMBRE,DESCRIPCION,ID_MARCA,ID_CATEGORIA,PRECIOVENTA,FECHAINGRESO,COSTO,STOCK,ID_LOTES,ID_UNIDADEMEDIDA) values (3,'Foco','Amarillo',2,3,2.55,to_date('11-NOV-20','DD-MON-RR'),2,6,3,1);
Insert into FERRETERIA.PRODUCTO (ID_PRODUCTO,NOMBRE,DESCRIPCION,ID_MARCA,ID_CATEGORIA,PRECIOVENTA,FECHAINGRESO,COSTO,STOCK,ID_LOTES,ID_UNIDADEMEDIDA) values (5,'Desarmador','Philips',1,2,2.5,to_date('11-NOV-20','DD-MON-RR'),2,4,1,1);
REM INSERTING into FERRETERIA.PROVEEDOR
SET DEFINE OFF;
Insert into FERRETERIA.PROVEEDOR (ID_PROVEEDOR,NOMBRE,DIRECCION,TELEFONO) values (3,'Trupper','San Salvador','77864523');
Insert into FERRETERIA.PROVEEDOR (ID_PROVEEDOR,NOMBRE,DIRECCION,TELEFONO) values (1,'Brazil','Santa Ana, El Salvador','77234512');
Insert into FERRETERIA.PROVEEDOR (ID_PROVEEDOR,NOMBRE,DIRECCION,TELEFONO) values (2,'Imacasa','San Miguel, El Salvador','77221123');
REM INSERTING into FERRETERIA.TIPOCOMPRA
SET DEFINE OFF;
Insert into FERRETERIA.TIPOCOMPRA (ID_TIPOCOMPRA,NOMBRE) values (1,'contado');
REM INSERTING into FERRETERIA.TIPOUSUARIO
SET DEFINE OFF;
Insert into FERRETERIA.TIPOUSUARIO (ID_TIPOUSUARIO,TIPO) values (1,'Administrador');
Insert into FERRETERIA.TIPOUSUARIO (ID_TIPOUSUARIO,TIPO) values (2,'Gerente');
Insert into FERRETERIA.TIPOUSUARIO (ID_TIPOUSUARIO,TIPO) values (3,'Vendedor');
REM INSERTING into FERRETERIA.TIPOVENTA
SET DEFINE OFF;
Insert into FERRETERIA.TIPOVENTA (ID_TIPOVENTA,TIPOVENTA) values (1,'contado');
REM INSERTING into FERRETERIA.UNIDADDEMEDIDA
SET DEFINE OFF;
Insert into FERRETERIA.UNIDADDEMEDIDA (ID_UNIDADDEMEDIDA,MEDIDA) values (1,'Unidad');
REM INSERTING into FERRETERIA.USUARIO
SET DEFINE OFF;
Insert into FERRETERIA.USUARIO (ID_USUARIO,NOMBRE,APELLIDO,TELEFONO,USERNAME,CLAVE,ID_TIPOUSUARIO) values (1,'Josue','Cruz','77886677','josue','123',2);
Insert into FERRETERIA.USUARIO (ID_USUARIO,NOMBRE,APELLIDO,TELEFONO,USERNAME,CLAVE,ID_TIPOUSUARIO) values (2,'Erick','Aguilar','77885674','erick','123',3);
REM INSERTING into FERRETERIA.VENTA
SET DEFINE OFF;
Insert into FERRETERIA.VENTA (ID_VENTA,ID_CLIENTE,FECHA,ID_USUARIO,ID_TIPOVENTA,TOTAL) values (3,2,to_date('01-DEC-20','DD-MON-RR'),1,1,5.76);
Insert into FERRETERIA.VENTA (ID_VENTA,ID_CLIENTE,FECHA,ID_USUARIO,ID_TIPOVENTA,TOTAL) values (1,2,to_date('07-NOV-20','DD-MON-RR'),1,1,10.11);
Insert into FERRETERIA.VENTA (ID_VENTA,ID_CLIENTE,FECHA,ID_USUARIO,ID_TIPOVENTA,TOTAL) values (2,3,to_date('07-NOV-20','DD-MON-RR'),1,1,14.8);
Insert into FERRETERIA.VENTA (ID_VENTA,ID_CLIENTE,FECHA,ID_USUARIO,ID_TIPOVENTA,TOTAL) values (5,3,to_date('15-JUN-21','DD-MON-RR'),1,1,7.92);
Insert into FERRETERIA.VENTA (ID_VENTA,ID_CLIENTE,FECHA,ID_USUARIO,ID_TIPOVENTA,TOTAL) values (6,3,to_date('25-JUN-21','DD-MON-RR'),1,1,2.54);
Insert into FERRETERIA.VENTA (ID_VENTA,ID_CLIENTE,FECHA,ID_USUARIO,ID_TIPOVENTA,TOTAL) values (4,2,to_date('01-DEC-20','DD-MON-RR'),1,1,6.84);
--------------------------------------------------------
--  DDL for Procedure REPORTECLIENTE1
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "FERRETERIA"."REPORTECLIENTE1" (tipo NUMBER)
IS
BEGIN
 SELECT * FROM Cliente

/
--------------------------------------------------------
--  Constraints for Table TIPOUSUARIO
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."TIPOUSUARIO" ADD PRIMARY KEY ("ID_TIPOUSUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."TIPOUSUARIO" MODIFY ("TIPO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COMPRA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."COMPRA" ADD PRIMARY KEY ("ID_COMPRA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."COMPRA" MODIFY ("TOTAL" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."COMPRA" MODIFY ("FECHACOMPRA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."COMPRA" MODIFY ("ID_TIPOCOMPRA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."COMPRA" MODIFY ("ID_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."COMPRA" MODIFY ("ID_PROVEEDOR" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."COMPRA" MODIFY ("ID_COMPRA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DETALLEVENTA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."DETALLEVENTA" ADD PRIMARY KEY ("ID_DETALLEVENTA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."DETALLEVENTA" MODIFY ("SUBTOTAL" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLEVENTA" MODIFY ("CANTIDAD" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLEVENTA" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLEVENTA" MODIFY ("ID_VENTA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLEVENTA" MODIFY ("ID_DETALLEVENTA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPOCOMPRA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."TIPOCOMPRA" ADD PRIMARY KEY ("ID_TIPOCOMPRA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."TIPOCOMPRA" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table VENTA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."VENTA" ADD PRIMARY KEY ("ID_VENTA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."VENTA" MODIFY ("TOTAL" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."VENTA" MODIFY ("ID_TIPOVENTA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."VENTA" MODIFY ("ID_USUARIO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."VENTA" MODIFY ("ID_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."VENTA" MODIFY ("ID_VENTA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOTES
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."LOTES" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."LOTES" ADD PRIMARY KEY ("ID_LOTES")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."LOTES" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TIPOVENTA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."TIPOVENTA" ADD PRIMARY KEY ("ID_TIPOVENTA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."TIPOVENTA" MODIFY ("TIPOVENTA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."USUARIO" ADD PRIMARY KEY ("ID_USUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."USUARIO" MODIFY ("ID_TIPOUSUARIO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."USUARIO" MODIFY ("CLAVE" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."USUARIO" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."USUARIO" MODIFY ("TELEFONO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."USUARIO" MODIFY ("APELLIDO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."USUARIO" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."CLIENTE" ADD PRIMARY KEY ("ID_CLIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DETALLECOMPRA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" ADD PRIMARY KEY ("ID_DETALLECOMPRA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" MODIFY ("SUBTOTAL" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" MODIFY ("PRECIOVENTA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" MODIFY ("CANTIDAD" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" MODIFY ("PRECIOCOMPRA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" MODIFY ("ID_COMPRA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" MODIFY ("ID_DETALLECOMPRA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."PRODUCTO" ADD PRIMARY KEY ("ID_PRODUCTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("ID_UNIDADEMEDIDA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("ID_LOTES" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("STOCK" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("COSTO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("FECHAINGRESO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("PRECIOVENTA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("ID_CATEGORIA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("ID_MARCA" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PRODUCTO" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CATEGORIA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."CATEGORIA" ADD PRIMARY KEY ("ID_CATEGORIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."CATEGORIA" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table UNIDADDEMEDIDA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."UNIDADDEMEDIDA" ADD PRIMARY KEY ("ID_UNIDADDEMEDIDA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."UNIDADDEMEDIDA" MODIFY ("MEDIDA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PROVEEDOR
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."PROVEEDOR" ADD PRIMARY KEY ("ID_PROVEEDOR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."PROVEEDOR" MODIFY ("TELEFONO" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PROVEEDOR" MODIFY ("DIRECCION" NOT NULL ENABLE);
  ALTER TABLE "FERRETERIA"."PROVEEDOR" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MARCA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."MARCA" ADD PRIMARY KEY ("ID_MARCA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "FERRETERIA"."MARCA" MODIFY ("NOMBRE" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table COMPRA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."COMPRA" ADD CONSTRAINT "FK_PROVEEDOR" FOREIGN KEY ("ID_PROVEEDOR")
	  REFERENCES "FERRETERIA"."PROVEEDOR" ("ID_PROVEEDOR") ENABLE;
  ALTER TABLE "FERRETERIA"."COMPRA" ADD CONSTRAINT "FK_TIPOCOMPRA" FOREIGN KEY ("ID_TIPOCOMPRA")
	  REFERENCES "FERRETERIA"."TIPOCOMPRA" ("ID_TIPOCOMPRA") ENABLE;
  ALTER TABLE "FERRETERIA"."COMPRA" ADD CONSTRAINT "FK_USUARIO" FOREIGN KEY ("ID_USUARIO")
	  REFERENCES "FERRETERIA"."USUARIO" ("ID_USUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DETALLECOMPRA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" ADD CONSTRAINT "FK_COMPRADET" FOREIGN KEY ("ID_COMPRA")
	  REFERENCES "FERRETERIA"."COMPRA" ("ID_COMPRA") ENABLE;
  ALTER TABLE "FERRETERIA"."DETALLECOMPRA" ADD CONSTRAINT "FK_PRODUCTOCOMPR" FOREIGN KEY ("ID_PRODUCTO")
	  REFERENCES "FERRETERIA"."PRODUCTO" ("ID_PRODUCTO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DETALLEVENTA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."DETALLEVENTA" ADD CONSTRAINT "FK_PRODUCTOVENT" FOREIGN KEY ("ID_PRODUCTO")
	  REFERENCES "FERRETERIA"."PRODUCTO" ("ID_PRODUCTO") ENABLE;
  ALTER TABLE "FERRETERIA"."DETALLEVENTA" ADD CONSTRAINT "FK_VENTADET" FOREIGN KEY ("ID_VENTA")
	  REFERENCES "FERRETERIA"."VENTA" ("ID_VENTA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."PRODUCTO" ADD CONSTRAINT "FK_CATEGORIAPROD" FOREIGN KEY ("ID_CATEGORIA")
	  REFERENCES "FERRETERIA"."CATEGORIA" ("ID_CATEGORIA") ENABLE;
  ALTER TABLE "FERRETERIA"."PRODUCTO" ADD CONSTRAINT "FK_LOTEPROD" FOREIGN KEY ("ID_LOTES")
	  REFERENCES "FERRETERIA"."LOTES" ("ID_LOTES") ENABLE;
  ALTER TABLE "FERRETERIA"."PRODUCTO" ADD CONSTRAINT "FK_MARCAPROD" FOREIGN KEY ("ID_MARCA")
	  REFERENCES "FERRETERIA"."MARCA" ("ID_MARCA") ENABLE;
  ALTER TABLE "FERRETERIA"."PRODUCTO" ADD CONSTRAINT "FK_UNIDADPROD" FOREIGN KEY ("ID_UNIDADEMEDIDA")
	  REFERENCES "FERRETERIA"."UNIDADDEMEDIDA" ("ID_UNIDADDEMEDIDA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIO
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."USUARIO" ADD CONSTRAINT "FK_FORANEA" FOREIGN KEY ("ID_TIPOUSUARIO")
	  REFERENCES "FERRETERIA"."TIPOUSUARIO" ("ID_TIPOUSUARIO") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table VENTA
--------------------------------------------------------

  ALTER TABLE "FERRETERIA"."VENTA" ADD CONSTRAINT "FK_CLIENTE" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "FERRETERIA"."CLIENTE" ("ID_CLIENTE") ENABLE;
  ALTER TABLE "FERRETERIA"."VENTA" ADD CONSTRAINT "FK_TIPOVENTA" FOREIGN KEY ("ID_TIPOVENTA")
	  REFERENCES "FERRETERIA"."TIPOVENTA" ("ID_TIPOVENTA") ENABLE;
  ALTER TABLE "FERRETERIA"."VENTA" ADD CONSTRAINT "FK_USUARIOVENTA" FOREIGN KEY ("ID_USUARIO")
	  REFERENCES "FERRETERIA"."USUARIO" ("ID_USUARIO") ENABLE;