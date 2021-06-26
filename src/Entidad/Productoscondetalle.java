/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Josue
 */
@Entity
@Table(name = "PRODUCTOSCONDETALLE")
@NamedQueries({
    @NamedQuery(name = "Productoscondetalle.findAll", query = "SELECT p FROM Productoscondetalle p")})
public class Productoscondetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private Long idProducto;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ID_MARCA")
    private Long idMarca;
    @Basic(optional = false)
    @Column(name = "MARCA")
    private String marca;
    @Basic(optional = false)
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;
    @Basic(optional = false)
    @Column(name = "CATEGORIA")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIOVENTA")
    private BigDecimal precioventa;
    @Basic(optional = false)
    @Column(name = "FECHAINGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingreso;
    @Basic(optional = false)
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Basic(optional = false)
    @Column(name = "STOCK")
    private BigDecimal stock;
    @Basic(optional = false)
    @Column(name = "ID_LOTES")
    private Long idLotes;
    @Basic(optional = false)
    @Column(name = "LOTE")
    private String lote;
    @Basic(optional = false)
    @Column(name = "ID_UNIDADEMEDIDA")
    private Long idUnidademedida;
    @Basic(optional = false)
    @Column(name = "MEDIDA")
    private String medida;

    public Productoscondetalle() {
    }

    public Long getIdProducto() {
        return idProducto;
    }
    public Productoscondetalle(Long idProducto, String nombre, String descripcion, Long idMarca, String marca, Long idCategoria, String categoria, BigDecimal precioventa, Date fechaingreso, BigDecimal costo, BigDecimal stock, Long idLotes, String lote, Long idUnidademedida, String medida)
    {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idMarca = idMarca;
        this.marca = marca;
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.precioventa = precioventa;
        this.fechaingreso = fechaingreso;
        this.costo = costo;
        this.stock = stock;
        this.idLotes = idLotes;
        this.lote = lote;
        this.idUnidademedida = idUnidademedida;
        this.medida = medida;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(long idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public Long getIdLotes() {
        return idLotes;
    }

    public void setIdLotes(long idLotes) {
        this.idLotes = idLotes;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Long getIdUnidademedida() {
        return idUnidademedida;
    }

    public void setIdUnidademedida(long idUnidademedida) {
        this.idUnidademedida = idUnidademedida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
}
