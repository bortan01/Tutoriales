package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Categorialibro;
import session.beans.CategorialibroFacade;

@ManagedBean(name = "listasCategoriaLibros")
@SessionScoped
public class ListasCategoriaLibros implements Serializable {

    @Inject
    CategorialibroFacade categorialibroFacade;
    public List<Categorialibro> lstCategorialibro;

    @PostConstruct
    public void init() {
        lstCategorialibro = llenarLista();
    }

    public List<Categorialibro> llenarLista() {
        return categorialibroFacade.findAll();
    }

    public CategorialibroFacade getCategorialibroFacade() {
        return categorialibroFacade;
    }

    public void setCategorialibroFacade(CategorialibroFacade categorialibroFacade) {
        this.categorialibroFacade = categorialibroFacade;
    }

    public List<Categorialibro> getLstCategorialibro() {
        return lstCategorialibro;
    }

    public void setLstCategorialibro(List<Categorialibro> lstCategorialibro) {
        this.lstCategorialibro = lstCategorialibro;
    }
}