
package controladores.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.entidades.Autor;
import session.beans.AutorFacade;

/**
 *
 * @author Miranda
 */
@ManagedBean (name="autorBean")
@ViewScoped
public class AutorBean implements Serializable{
    
 
    @Inject
    AutorFacade AutorFacade;
    Autor AutorSeleccionado;
    List<Autor> lstAutor;
    List<Autor> lstdatosAutorFiltrada;

  
    private String opcionActualGenero;

    @PostConstruct
    public void init() {
        AutorSeleccionado = new Autor();
        buscarTodos();
    }

    public List<Autor> buscarTodos() {
        lstAutor = AutorFacade.findAll();
        return lstAutor;
    }

    public AutorBean() {
    }

    public String insertarAutor() {
        AutorFacade.create(AutorSeleccionado);
            return "TblAlumnos.xhtml?faces-redirect=true";
    }

    public String elimiinarAutor() {
        AutorFacade.remove(AutorSeleccionado);   
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "TblAlumnos.xhtml?faces-redirect=true";
    }

    public String actualizarAutor() {
        AutorFacade.edit(AutorSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "TblAlumnos.xhtml?faces-redirect=true";
    }

    public AutorFacade getAlumnoFacade() {
        return AutorFacade;
    }

    public void setAlumnoFacade(AutorFacade alumnoFacade) {
        this.AutorFacade = alumnoFacade;
    }

    public Autor getAlumnoSeleccionado() {
        return AutorSeleccionado;
    }

    public void setAlumnoSeleccionado(Autor alumnoSeleccionado) {
        this.AutorSeleccionado = alumnoSeleccionado;
    }

    public List<Autor> getLstAlumno() {
        return lstAutor;
    }

    public void setLstAlumno(List<Autor> lstAlumno) {
        this.lstAutor = lstAlumno;
    }

    public List<Autor> getLstdatosAlumnoFiltrada() {
        return lstdatosAutorFiltrada;
    }

    public void setLstdatosAlumnoFiltrada(List<Autor> lstdatosAlumnoFiltrada) {
        this.lstdatosAutorFiltrada = lstdatosAlumnoFiltrada;
    }
public String getOpcionActualGenero() {
        return opcionActualGenero;
    }

    public void setOpcionActualGenero(String opcionActualGenero) {
        this.opcionActualGenero = opcionActualGenero;
    }

}
