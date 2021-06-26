/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josue
 */
@Entity
@Table(name = "DETALLECOMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecompra.findAll", query = "SELECT d FROM Detallecompra d")
    , @NamedQuery(name = "Detallecompra.findByIdDetallecompra", query = "SELECT d FROM Detallecompra d WHERE d.idDetallecompra = :idDetallecompra")
    , @NamedQuery(name = "Detallecompra.findByPreciocompra", query = "SELECT d FROM Detallecompra d WHERE d.preciocompra = :preciocompra")
    , @NamedQuery(name = "Detallecompra.findByCantidad", query = "SELECT d FROM Detallecompra d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallecompra.findByPrecioventa", query = "SELECT d FROM Detallecompra d WHERE d.precioventa = :precioventa")
    , @NamedQuery(name = "Detallecompra.findBySubtotal", query = "SELECT d FROM Detallecompra d WHERE d.subtotal = :subtotal")})
public class Detallecompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLECOMPRA")
    private Long idDetallecompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIOCOMPRA")
    private BigDecimal preciocompra;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private long cantidad;
    @Basic(optional = false)
    @Column(name = "PRECIOVENTA")
    private BigDecimal precioventa;
    @Basic(optional = false)
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;
    @JoinColumn(name = "ID_COMPRA", referencedColumnName = "ID_COMPRA")
    @ManyToOne(optional = false)
    private Compra idCompra;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public Detallecompra() {
    }

    public Detallecompra(Long idDetallecompra) {
        this.idDetallecompra = idDetallecompra;
    }

    public Detallecompra(Long idDetallecompra, BigDecimal preciocompra, long cantidad, BigDecimal precioventa, BigDecimal subtotal) {
        this.idDetallecompra = idDetallecompra;
        this.preciocompra = preciocompra;
        this.cantidad = cantidad;
        this.precioventa = precioventa;
        this.subtotal = subtotal;
    }

    public Long getIdDetallecompra() {
        return idDetallecompra;
    }

    public void setIdDetallecompra(Long idDetallecompra) {
        this.idDetallecompra = idDetallecompra;
    }

    public BigDecimal getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(BigDecimal preciocompra) {
        this.preciocompra = preciocompra;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallecompra != null ? idDetallecompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecompra)) {
            return false;
        }
        Detallecompra other = (Detallecompra) object;
        if ((this.idDetallecompra == null && other.idDetallecompra != null) || (this.idDetallecompra != null && !this.idDetallecompra.equals(other.idDetallecompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Detallecompra[ idDetallecompra=" + idDetallecompra + " ]";
    }
    
}
