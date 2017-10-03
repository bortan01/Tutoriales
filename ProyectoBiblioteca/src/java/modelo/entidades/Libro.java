/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByCodigolibro", query = "SELECT l FROM Libro l WHERE l.codigolibro = :codigolibro"),
    @NamedQuery(name = "Libro.findByTitulolibro", query = "SELECT l FROM Libro l WHERE l.titulolibro = :titulolibro"),
    @NamedQuery(name = "Libro.findByExistencia", query = "SELECT l FROM Libro l WHERE l.existencia = :existencia"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigolibro")
    private String codigolibro;
    @Size(max = 100)
    @Column(name = "titulolibro")
    private String titulolibro;
    @Column(name = "existencia")
    private Integer existencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @OneToMany(mappedBy = "codigoLibro")
    private List<PrestamoAlumno> prestamoAlumnoList;
    @JoinColumn(name = "codigocategoria", referencedColumnName = "codigocategoria")
    @ManyToOne
    private Categorialibro codigocategoria;
    @JoinColumn(name = "codigoautor", referencedColumnName = "codigoautor")
    @ManyToOne
    private Autor codigoautor;

    public Libro() {
    }

    public Libro(String codigolibro) {
        this.codigolibro = codigolibro;
    }

    public String getCodigolibro() {
        return codigolibro;
    }

    public void setCodigolibro(String codigolibro) {
        this.codigolibro = codigolibro;
    }

    public String getTitulolibro() {
        return titulolibro;
    }

    public void setTitulolibro(String titulolibro) {
        this.titulolibro = titulolibro;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<PrestamoAlumno> getPrestamoAlumnoList() {
        return prestamoAlumnoList;
    }

    public void setPrestamoAlumnoList(List<PrestamoAlumno> prestamoAlumnoList) {
        this.prestamoAlumnoList = prestamoAlumnoList;
    }

    public Categorialibro getCodigocategoria() {
        return codigocategoria;
    }

    public void setCodigocategoria(Categorialibro codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public Autor getCodigoautor() {
        return codigoautor;
    }

    public void setCodigoautor(Autor codigoautor) {
        this.codigoautor = codigoautor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigolibro != null ? codigolibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.codigolibro == null && other.codigolibro != null) || (this.codigolibro != null && !this.codigolibro.equals(other.codigolibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.Libro[ codigolibro=" + codigolibro + " ]";
    }
    
}
