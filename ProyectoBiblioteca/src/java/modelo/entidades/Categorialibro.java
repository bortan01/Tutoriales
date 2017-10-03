/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miranda
 */
@Entity
@Table(name = "categorialibro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorialibro.findAll", query = "SELECT c FROM Categorialibro c"),
    @NamedQuery(name = "Categorialibro.findByCodigocategoria", query = "SELECT c FROM Categorialibro c WHERE c.codigocategoria = :codigocategoria"),
    @NamedQuery(name = "Categorialibro.findByNombrecategoria", query = "SELECT c FROM Categorialibro c WHERE c.nombrecategoria = :nombrecategoria")})
public class Categorialibro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigocategoria")
    private String codigocategoria;
    @Size(max = 50)
    @Column(name = "nombrecategoria")
    private String nombrecategoria;
    @OneToMany(mappedBy = "codigocategoria")
    private List<Libro> libroList;

    public Categorialibro() {
    }

    public Categorialibro(String codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public String getCodigocategoria() {
        return codigocategoria;
    }

    public void setCodigocategoria(String codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocategoria != null ? codigocategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorialibro)) {
            return false;
        }
        Categorialibro other = (Categorialibro) object;
        if ((this.codigocategoria == null && other.codigocategoria != null) || (this.codigocategoria != null && !this.codigocategoria.equals(other.codigocategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Categorialibro[ codigocategoria=" + codigocategoria + " ]";
    }
    
}
