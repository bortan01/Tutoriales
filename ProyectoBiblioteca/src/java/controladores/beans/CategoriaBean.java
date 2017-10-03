package controladores.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import modelo.entidades.Categorialibro;
import session.beans.CategorialibroFacade;

@ManagedBean (name ="categoriaBean")
@ViewScoped
public class CategoriaBean  implements Serializable{
    
    @Inject
    CategorialibroFacade CategoriaFacade;
    Categorialibro CategoriaSeleccionada;
    List<Categorialibro> listaCategoria;
    List<Categorialibro> listaFiltrada;

    @PostConstruct
    public void init() {
        CategoriaSeleccionada = new Categorialibro();
        buscarTodos();
    }
    
    public CategoriaBean(){
    }

    public CategorialibroFacade getCategoriaFacade() {
        return CategoriaFacade;
    }

    public void setCategoriaFacade(CategorialibroFacade CategoriaFacade) {
        this.CategoriaFacade = CategoriaFacade;
    }

    public Categorialibro getCategoriaSeleccionada() {
        return CategoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(Categorialibro CategoriaSeleccionada) {
        this.CategoriaSeleccionada = CategoriaSeleccionada;
    }

    public List<Categorialibro> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categorialibro> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public List<Categorialibro> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Categorialibro> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }
    
        
    public List<Categorialibro> buscarTodos() {
        listaCategoria = CategoriaFacade.findAll();
        return listaCategoria;
    }
    public String eliminarCategoria() {
        CategoriaFacade.remove(CategoriaSeleccionada);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Eliminados"));
        return "TblAutor.xhtml?faces-redirect=true";
    }
    
    public String actualizaCategoria() {
        CategoriaFacade.edit(CategoriaSeleccionada);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos Modificados"));
        return "TblAutor.xhtml?faces-redirect=true";
    }
  public String insertaCategoria() {
        CategoriaFacade.create(CategoriaSeleccionada);
            return "TblAutor.xhtml?faces-redirect=true";
    }
    
    
}
