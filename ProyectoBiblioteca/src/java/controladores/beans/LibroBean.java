package controladores.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.entidades.Libro;
import session.beans.LibroFacade;
import utils.general.AutoCompleteBeanAutor;
import utils.general.AutoCompleteBeanCatLib;

@ManagedBean(name = "libroBean")
@ViewScoped
public class LibroBean implements Serializable {

    @Inject
    LibroFacade libroFacade;

    @ManagedProperty("#{autoCompleteBeanAutor}")
    AutoCompleteBeanAutor bm;

    @ManagedProperty("#{autoCompleteBeanCategLibro}")
    AutoCompleteBeanCatLib bmcatlib;

    Libro libroSelected;
    List<Libro> lstLibro;
    List<Libro> lstdatosLibroFiltrada;
    String valorBusqueda;

    @PostConstruct
    public void init() {
        buscarTodos();
        libroSelected = new Libro();

    }

    public LibroBean() {
    }

    public String insertarLibro() {
        libroSelected.setCodigoautor(bm.getAutor());
        libroSelected.setCodigocategoria(bmcatlib.getCategorialibro());
        libroFacade.create(libroSelected);
        return "TblLibro.xhtml?faces-redirect=true";
    }

    public String eliminarLibro() {
        libroFacade.remove(libroSelected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "TblLibro.xhtml?faces-redirect=true";
    }

    public String actualizarLibro() {
        libroSelected.setCodigoautor(bm.getAutor());
        libroSelected.setCodigocategoria(bmcatlib.getCategorialibro());
        libroFacade.edit(libroSelected);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "TblLibro.xhtml?faces-redirect=true";
    }

    public List<Libro> buscarTodos() {
        lstLibro = libroFacade.findAll();
        return lstLibro;
    }

    public String nuevoLibro() {
        libroSelected = null;
        bm.setAutor(null);
        bmcatlib.setCategorialibro(null);
        return "FrmLibro";
    }

    /////////////////// metodos setter y getter
    public LibroFacade getLibroFacade() {
        return libroFacade;
    }

    public void setLibroFacade(LibroFacade libroFacade) {
        this.libroFacade = libroFacade;
    }

    public AutoCompleteBeanAutor getBm() {
        return bm;
    }

    public void setBm(AutoCompleteBeanAutor bm) {
        this.bm = bm;
    }

    public AutoCompleteBeanCatLib getBmcatlib() {
        return bmcatlib;
    }

    public void setBmcatlib(AutoCompleteBeanCatLib bmcatlib) {
        this.bmcatlib = bmcatlib;
    }

    public Libro getLibroSelected() {
        return libroSelected;
    }

    public void setLibroSelected(Libro libroSelected) {
        this.libroSelected = libroSelected;
    }

    public List<Libro> getLstLibro() {
        return lstLibro;
    }

    public void setLstLibro(List<Libro> lstLibro) {
        this.lstLibro = lstLibro;
    }

    public List<Libro> getLstdatosLibroFiltrada() {
        return lstdatosLibroFiltrada;
    }

    public void setLstdatosLibroFiltrada(List<Libro> lstdatosLibroFiltrada) {
        this.lstdatosLibroFiltrada = lstdatosLibroFiltrada;
    }

    public String getValorBusqueda() {
        return valorBusqueda;
    }

    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }

}
