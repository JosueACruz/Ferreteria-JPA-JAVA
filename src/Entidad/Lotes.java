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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josue
 */
@Entity
@Table(name = "LOTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lotes.findAll", query = "SELECT l FROM Lotes l")
    , @NamedQuery(name = "Lotes.findByIdLotes", query = "SELECT l FROM Lotes l WHERE l.idLotes = :idLotes")
    , @NamedQuery(name = "Lotes.findByNombre", query = "SELECT l FROM Lotes l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Lotes.findByDescripcion", query = "SELECT l FROM Lotes l WHERE l.descripcion = :descripcion")})
public class Lotes implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLotes")
    private List<Producto> productoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LOTES")
    private Long idLotes;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Lotes() {
    }

    public Lotes(Long idLotes) {
        this.idLotes = idLotes;
    }

    public Lotes(Long idLotes, String nombre, String descripcion) {
        this.idLotes = idLotes;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getIdLotes() {
        return idLotes;
    }

    public void setIdLotes(Long idLotes) {
        this.idLotes = idLotes;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLotes != null ? idLotes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lotes)) {
            return false;
        }
        Lotes other = (Lotes) object;
        if ((this.idLotes == null && other.idLotes != null) || (this.idLotes != null && !this.idLotes.equals(other.idLotes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idLotes + "";
    }
    
    //copia del toString
//    public String toString() {
//        return "Entidad.Lotes[ idLotes=" + idLotes + " ]";
//    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

}
