package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Libro;
import session.beans.LibroFacade;

@ManagedBean(name = "listasLibros")
@SessionScoped
public class ListasLibros implements Serializable {

    @Inject
    LibroFacade libroFacade;
    public List<Libro> lstLibro;

    @PostConstruct
    public void init() {
        lstLibro = llenarLista();
    }

    public List<Libro> llenarLista() {
        return libroFacade.findAll();
    }

    public LibroFacade getLibroFacade() {
        return libroFacade;
    }

    public void setLibroFacade(LibroFacade libroFacade) {
        this.libroFacade = libroFacade;
    }

    public List<Libro> getLstLibro() {
        return lstLibro;
    }

    public void setLstLibro(List<Libro> lstLibro) {
        this.lstLibro = lstLibro;
    }
    
}
