package controladores.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import session.beans.PrestamoAlumnoFacade;
import utils.general.AutoCompleteBeanAlumno;
import utils.general.AutoCompleteBeanLibro;
import modelo.entidades.PrestamoAlumno;

@ManagedBean(name ="prestamoAlumnoBean")
@RequestScoped
public class PrestamoAlumnoBean implements Serializable{

    @Inject
    PrestamoAlumnoFacade prestamoFacade;
    
    @ManagedProperty("#{autoCompleteBeanLibro}")
    AutoCompleteBeanLibro auLibro;

    @ManagedProperty("#{autoCompleteBeanAlumno}")
    AutoCompleteBeanAlumno auAlumno;
    
    PrestamoAlumno PrestamoSelected;
    List<PrestamoAlumno> lstPrestamos;
    List<PrestamoAlumno> lstdatosLibroFiltrada;
    String valorBusqueda;
    
     @PostConstruct
    public void init() {
        buscarTodos();
        PrestamoSelected = new PrestamoAlumno();

    }
      public PrestamoAlumnoBean() {
    }
      public List<PrestamoAlumno> buscarTodos() {
        lstPrestamos = prestamoFacade.findAll();
        return lstPrestamos ;
    }
      
      public String insertarLibro() {
        PrestamoSelected.setCarnetAlumno(auAlumno.getAlumno());
        PrestamoSelected.setCodigoLibro(auLibro.getLibro());
        prestamoFacade.create(PrestamoSelected);
        return "TblPrestamo.xhtml?faces-redirect=true";
    }

    public String eliminarLibro() {
        prestamoFacade.remove(PrestamoSelected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "TblPrestamo.xhtml?faces-redirect=true";
    }

    public String actualizarLibro() {
        PrestamoSelected.setCarnetAlumno(auAlumno.getAlumno());
        PrestamoSelected.setCodigoLibro(auLibro.getLibro());
        prestamoFacade.edit(PrestamoSelected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "TblPrestamo.xhtml?faces-redirect=true";
    }
    
    public String nuevoLibro() {
        PrestamoSelected = null;
        auAlumno.setAlumno(null);
        auLibro.setLibro(null);
        return "FrmPrestamo";
    }

    public PrestamoAlumnoFacade getPrestamoFacade() {
        return prestamoFacade;
    }

    public void setPrestamoFacade(PrestamoAlumnoFacade prestamoFacade) {
        this.prestamoFacade = prestamoFacade;
    }

    public AutoCompleteBeanLibro getAuLibro() {
        return auLibro;
    }

    public void setAuLibro(AutoCompleteBeanLibro auLibro) {
        this.auLibro = auLibro;
    }

    public AutoCompleteBeanAlumno getAuAlumno() {
        return auAlumno;
    }

    public void setAuAlumno(AutoCompleteBeanAlumno auAlumno) {
        this.auAlumno = auAlumno;
    }

    public PrestamoAlumno getPrestamoSelected() {
        return PrestamoSelected;
    }

    public void setPrestamoSelected(PrestamoAlumno PrestamoSelected) {
        this.PrestamoSelected = PrestamoSelected;
    }

    public List<PrestamoAlumno> getLstPrestamos() {
        return lstPrestamos;
    }

    public void setLstPrestamos(List<PrestamoAlumno> lstPrestamos) {
        this.lstPrestamos = lstPrestamos;
    }

    public List<PrestamoAlumno> getLstdatosLibroFiltrada() {
        return lstdatosLibroFiltrada;
    }

    public void setLstdatosLibroFiltrada(List<PrestamoAlumno> lstdatosLibroFiltrada) {
        this.lstdatosLibroFiltrada = lstdatosLibroFiltrada;
    }

    public String getValorBusqueda() {
        return valorBusqueda;
    }

    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }
    
    
    
}
