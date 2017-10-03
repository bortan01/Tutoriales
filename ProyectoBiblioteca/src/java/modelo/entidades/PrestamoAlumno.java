/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miranda
 */
@Entity
@Table(name = "prestamo_alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestamoAlumno.findAll", query = "SELECT p FROM PrestamoAlumno p"),
    @NamedQuery(name = "PrestamoAlumno.findByFechaPrestamo", query = "SELECT p FROM PrestamoAlumno p WHERE p.fechaPrestamo = :fechaPrestamo"),
    @NamedQuery(name = "PrestamoAlumno.findByFechaDevolucion", query = "SELECT p FROM PrestamoAlumno p WHERE p.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "PrestamoAlumno.findByCodigoPrestamo", query = "SELECT p FROM PrestamoAlumno p WHERE p.codigoPrestamo = :codigoPrestamo"),
    @NamedQuery(name = "PrestamoAlumno.findByCantidadprestamo", query = "SELECT p FROM PrestamoAlumno p WHERE p.cantidadprestamo = :cantidadprestamo")})
public class PrestamoAlumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_prestamo")
    private String codigoPrestamo;
    @Column(name = "cantidadprestamo")
    private Integer cantidadprestamo;
    @JoinColumn(name = "codigo_libro", referencedColumnName = "codigolibro")
    @ManyToOne
    private Libro codigoLibro;
    @JoinColumn(name = "carnet_alumno", referencedColumnName = "carnet")
    @ManyToOne
    private Alumno carnetAlumno;

    public PrestamoAlumno() {
    }

    public PrestamoAlumno(String codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(String codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public Integer getCantidadprestamo() {
        return cantidadprestamo;
    }

    public void setCantidadprestamo(Integer cantidadprestamo) {
        this.cantidadprestamo = cantidadprestamo;
    }

    public Libro getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Libro codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public Alumno getCarnetAlumno() {
        return carnetAlumno;
    }

    public void setCarnetAlumno(Alumno carnetAlumno) {
        this.carnetAlumno = carnetAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPrestamo != null ? codigoPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoAlumno)) {
            return false;
        }
        PrestamoAlumno other = (PrestamoAlumno) object;
        if ((this.codigoPrestamo == null && other.codigoPrestamo != null) || (this.codigoPrestamo != null && !this.codigoPrestamo.equals(other.codigoPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidades.PrestamoAlumno[ codigoPrestamo=" + codigoPrestamo + " ]";
    }
    
}
