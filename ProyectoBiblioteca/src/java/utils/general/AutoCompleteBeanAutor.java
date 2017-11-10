package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Autor;
import utils.lista.ListasAutores;


@ManagedBean(name="autoCompleteBeanAutor")
@SessionScoped
public class AutoCompleteBeanAutor implements Serializable{
    @ManagedProperty ("#{listasAutores}")
    ListasAutores autorData; 
    Autor autor;
    
    public List<Autor> completeAutorDespacho(String query){
        List<Autor> allAutor = getAutorData().getLstAutor();
        List<Autor> filterAutor = new ArrayList<Autor>();
        for (Autor autorSelected : allAutor) {
            if(autorSelected.getNombreautor().toLowerCase().startsWith(query)){                
                filterAutor.add(autorSelected);
            }
        }
        return filterAutor;
    }


    public ListasAutores getAutorData() {
        return autorData;
    }
    
    
    
    public void setAutorData(ListasAutores autorData) {
        this.autorData = autorData;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
}
