package controladores.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import modelo.entidades.Alumno;
import session.beans.AlumnoFacade;

/**
 *
 * @author Emily
 */
@ManagedBean(name="alumnoBean")
@ViewScoped
public class AlumnoBean implements Serializable{

 
    @Inject
    AlumnoFacade alumnoFacade;
    Alumno alumnoSeleccionado;
    List<Alumno> lstAlumno;
    List<Alumno> lstdatosAlumnoFiltrada;

    private SelectItem[] opcionesGenero = new SelectItem[]{new SelectItem("MASCULINO"),
        new SelectItem("FEMENINO")};
    private String opcionActualGenero;

    @PostConstruct
    public void init() {
        alumnoSeleccionado = new Alumno();
        buscarTodos();
    }

    public List<Alumno> buscarTodos() {
        lstAlumno = alumnoFacade.findAll();
        return lstAlumno;
    }

    public AlumnoBean() {
    }

    public String insertarAlumno() {
        alumnoFacade.create(alumnoSeleccionado);
            return "TblAlumnos.xhtml?faces-redirect=true";
    }

    public String eliminarAlumno() {
        alumnoFacade.remove(alumnoSeleccionado);   
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "TblAlumnos.xhtml?faces-redirect=true";
    }

    public String actualizarAlumno() {
        alumnoFacade.edit(alumnoSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "TblAlumnos.xhtml?faces-redirect=true";
    }

    public AlumnoFacade getAlumnoFacade() {
        return alumnoFacade;
    }

    public void setAlumnoFacade(AlumnoFacade alumnoFacade) {
        this.alumnoFacade = alumnoFacade;
    }

    public Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
        this.alumnoSeleccionado = alumnoSeleccionado;
    }

    public List<Alumno> getLstAlumno() {
        return lstAlumno;
    }

    public void setLstAlumno(List<Alumno> lstAlumno) {
        this.lstAlumno = lstAlumno;
    }

    public List<Alumno> getLstdatosAlumnoFiltrada() {
        return lstdatosAlumnoFiltrada;
    }

    public void setLstdatosAlumnoFiltrada(List<Alumno> lstdatosAlumnoFiltrada) {
        this.lstdatosAlumnoFiltrada = lstdatosAlumnoFiltrada;
    }

    public SelectItem[] getOpcionesGenero() {
        return opcionesGenero;
    }

    public void setOpcionesGenero(SelectItem[] opcionesGenero) {
        this.opcionesGenero = opcionesGenero;
    }

    public String getOpcionActualGenero() {
        return opcionActualGenero;
    }

    public void setOpcionActualGenero(String opcionActualGenero) {
        this.opcionActualGenero = opcionActualGenero;
    }

}
