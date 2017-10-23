package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Libro;
import utils.lista.ListasLibros;

@ManagedBean(name = "autoCompleteBeanLibro")
@SessionScoped
public class AutoCompleteBeanLibro implements Serializable {

    ///a que hace referenca listas libros
    @ManagedProperty("#{listasLibros}")
    ListasLibros libroData;
    Libro libro;

    public List<Libro> completeLibroDespacho(String query) {
        List<Libro> allLibro = getLibroData().getLstLibro();
        List<Libro> filterLibro = new ArrayList<Libro>();
        for (Libro libroSelected : allLibro) {
            if (libroSelected.getCodigolibro().toLowerCase().startsWith(query) || libroSelected.getTitulolibro().toLowerCase().startsWith(query) || libroSelected.getExistencia().toString().startsWith(query)) {
                filterLibro.add(libroSelected);
            }
        }
        return filterLibro;
    }

    public ListasLibros getLibroData() {
        return libroData;
    }

    public void setLibroData(ListasLibros libroData) {
        this.libroData = libroData;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }


}
