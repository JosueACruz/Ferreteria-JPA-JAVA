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
@Table(name = "TIPOCOMPRA")
@NamedQueries({
    @NamedQuery(name = "Tipocompra.findAll", query = "SELECT t FROM Tipocompra t")})
public class Tipocompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPOCOMPRA")
    private Long idTipocompra;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipocompra")
    private List<Compra> compraList;

    public Tipocompra() {
    }

    public Tipocompra(Long idTipocompra) {
        this.idTipocompra = idTipocompra;
    }

    public Tipocompra(Long idTipocompra, String nombre) {
        this.idTipocompra = idTipocompra;
        this.nombre = nombre;
    }

    public Long getIdTipocompra() {
        return idTipocompra;
    }

    public void setIdTipocompra(Long idTipocompra) {
        this.idTipocompra = idTipocompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipocompra != null ? idTipocompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocompra)) {
            return false;
        }
        Tipocompra other = (Tipocompra) object;
        if ((this.idTipocompra == null && other.idTipocompra != null) || (this.idTipocompra != null && !this.idTipocompra.equals(other.idTipocompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Tipocompra[ idTipocompra=" + idTipocompra + " ]";
    }
    
}
