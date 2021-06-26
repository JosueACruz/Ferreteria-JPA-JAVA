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
@Table(name = "DETALLEVENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventa.findAll", query = "SELECT d FROM Detalleventa d")
    , @NamedQuery(name = "Detalleventa.findByIdDetalleventa", query = "SELECT d FROM Detalleventa d WHERE d.idDetalleventa = :idDetalleventa")
    , @NamedQuery(name = "Detalleventa.findByCantidad", query = "SELECT d FROM Detalleventa d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalleventa.findBySubtotal", query = "SELECT d FROM Detalleventa d WHERE d.subtotal = :subtotal")})
public class Detalleventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLEVENTA")
    private Long idDetalleventa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public Detalleventa() {
    }

    public Detalleventa(Long idDetalleventa) {
        this.idDetalleventa = idDetalleventa;
    }

    public Detalleventa(Long idDetalleventa, BigDecimal cantidad, BigDecimal subtotal) {
        this.idDetalleventa = idDetalleventa;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Long getIdDetalleventa() {
        return idDetalleventa;
    }

    public void setIdDetalleventa(Long idDetalleventa) {
        this.idDetalleventa = idDetalleventa;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleventa != null ? idDetalleventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventa)) {
            return false;
        }
        Detalleventa other = (Detalleventa) object;
        if ((this.idDetalleventa == null && other.idDetalleventa != null) || (this.idDetalleventa != null && !this.idDetalleventa.equals(other.idDetalleventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Detalleventa[ idDetalleventa=" + idDetalleventa + " ]";
    }
    
}
