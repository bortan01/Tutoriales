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
@ManagedBean(name = "autorBean")
@ViewScoped
public class AutorBean implements Serializable {

    @Inject
    AutorFacade AutorFacade;
    Autor AutorSeleccionado;
    List<Autor> lstAutor;
    List<Autor> lstdatosAutorFiltrada;

    @PostConstruct
    public void init() {
        AutorSeleccionado = new Autor();
        buscarTodos();
    }

    public AutorBean() {
    }

    public AutorFacade getAutorFacade() {
        return AutorFacade;
    }

    public void setAutorFacade(AutorFacade AutorFacade) {
        this.AutorFacade = AutorFacade;
    }

    public Autor getAutorSeleccionado() {
        return AutorSeleccionado;
    }

    public void setAutorSeleccionado(Autor AutorSeleccionado) {
        this.AutorSeleccionado = AutorSeleccionado;
    }

    public List<Autor> getLstAutor() {
        return lstAutor;
    }

    public void setLstAutor(List<Autor> lstAutor) {
        this.lstAutor = lstAutor;
    }

    public List<Autor> getLstdatosAutorFiltrada() {
        return lstdatosAutorFiltrada;
    }

    public void setLstdatosAutorFiltrada(List<Autor> lstdatosAutorFiltrada) {
        this.lstdatosAutorFiltrada = lstdatosAutorFiltrada;
    }

    
    public List<Autor> buscarTodos() {
        lstAutor = AutorFacade.findAll();
        return lstAutor;
    }
    public String eliminarAutor() {
        AutorFacade.remove(AutorSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "TblAutor.xhtml?faces-redirect=true";
    }
    
    public String actualizarAutor() {
        AutorFacade.edit(AutorSeleccionado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "TblAutor.xhtml?faces-redirect=true";
    }
  public String insertarAutor() {
        AutorFacade.create(AutorSeleccionado);
            return "TblAutor.xhtml?faces-redirect=true";
    }
}
