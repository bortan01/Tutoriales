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
@Table(name = "autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findByCodigoautor", query = "SELECT a FROM Autor a WHERE a.codigoautor = :codigoautor"),
    @NamedQuery(name = "Autor.findByNombreautor", query = "SELECT a FROM Autor a WHERE a.nombreautor = :nombreautor")})
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigoautor")
    private String codigoautor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombreautor")
    private String nombreautor;
    @OneToMany(mappedBy = "codigoautor")
    private List<Libro> libroList;

    public Autor() {
    }

    public Autor(String codigoautor) {
        this.codigoautor = codigoautor;
    }

    public Autor(String codigoautor, String nombreautor) {
        this.codigoautor = codigoautor;
        this.nombreautor = nombreautor;
    }

    public String getCodigoautor() {
        return codigoautor;
    }

    public void setCodigoautor(String codigoautor) {
        this.codigoautor = codigoautor;
    }

    public String getNombreautor() {
        return nombreautor;
    }

    public void setNombreautor(String nombreautor) {
        this.nombreautor = nombreautor;
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
        hash += (codigoautor != null ? codigoautor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.codigoautor == null && other.codigoautor != null) || (this.codigoautor != null && !this.codigoautor.equals(other.codigoautor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Autor[ codigoautor=" + codigoautor + " ]";
    }
    
}
