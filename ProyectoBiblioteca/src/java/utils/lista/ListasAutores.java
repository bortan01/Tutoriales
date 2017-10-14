package utils.lista;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.Autor;
import session.beans.AutorFacade;

@ManagedBean(name="listasAutores")
@SessionScoped
public class ListasAutores implements Serializable {
    @Inject
    AutorFacade autorFacade;
    public List<Autor> lstAutor;
    
    @PostConstruct
    public void init(){
        lstAutor=llenarLista();
    }
    public List<Autor> llenarLista(){
       return autorFacade.findAll();        
    }
  
    public AutorFacade getAutorFacade() {
        return autorFacade;
    }

    public void setAutorFacade(AutorFacade autorFacade) {
        this.autorFacade = autorFacade;
    }

    public List<Autor> getLstAutor() {
        return lstAutor;
    }

    public void setLstAutor(List<Autor> lstAutor) {
        this.lstAutor = lstAutor;
    }
 }
