/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Josue
 */
@Entity
@Table(name = "TIPOVENTA")
@NamedQueries({
    @NamedQuery(name = "Tipoventa.findAll", query = "SELECT t FROM Tipoventa t")})
public class Tipoventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPOVENTA")
    private Long idTipoventa;
    @Basic(optional = false)
    @Column(name = "TIPOVENTA")
    private String tipoventa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoventa")
    private List<Venta> ventaList;

    public Tipoventa() {
    }

    public Tipoventa(Long idTipoventa) {
        this.idTipoventa = idTipoventa;
    }

    public Tipoventa(Long idTipoventa, String tipoventa) {
        this.idTipoventa = idTipoventa;
        this.tipoventa = tipoventa;
    }

    public Long getIdTipoventa() {
        return idTipoventa;
    }

    public void setIdTipoventa(Long idTipoventa) {
        this.idTipoventa = idTipoventa;
    }

    public String getTipoventa() {
        return tipoventa;
    }

    public void setTipoventa(String tipoventa) {
        this.tipoventa = tipoventa;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoventa != null ? idTipoventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoventa)) {
            return false;
        }
        Tipoventa other = (Tipoventa) object;
        if ((this.idTipoventa == null && other.idTipoventa != null) || (this.idTipoventa != null && !this.idTipoventa.equals(other.idTipoventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Tipoventa[ idTipoventa=" + idTipoventa + " ]";
    }
    
}
