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
@Table(name = "UNIDADDEMEDIDA")
@NamedQueries({
    @NamedQuery(name = "Unidaddemedida.findAll", query = "SELECT u FROM Unidaddemedida u")})
public class Unidaddemedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_UNIDADDEMEDIDA")
    private Long idUnidaddemedida;
    @Basic(optional = false)
    @Column(name = "MEDIDA")
    private String medida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidademedida")
    private List<Producto> productoList;

    public Unidaddemedida() {
    }

    public Unidaddemedida(Long idUnidaddemedida) {
        this.idUnidaddemedida = idUnidaddemedida;
    }

    public Unidaddemedida(Long idUnidaddemedida, String medida) {
        this.idUnidaddemedida = idUnidaddemedida;
        this.medida = medida;
    }

    public Long getIdUnidaddemedida() {
        return idUnidaddemedida;
    }

    public void setIdUnidaddemedida(Long idUnidaddemedida) {
        this.idUnidaddemedida = idUnidaddemedida;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidaddemedida != null ? idUnidaddemedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidaddemedida)) {
            return false;
        }
        Unidaddemedida other = (Unidaddemedida) object;
        if ((this.idUnidaddemedida == null && other.idUnidaddemedida != null) || (this.idUnidaddemedida != null && !this.idUnidaddemedida.equals(other.idUnidaddemedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idUnidaddemedida + "";
    }
    
}
