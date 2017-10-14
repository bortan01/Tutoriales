package utils.general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import modelo.entidades.Categorialibro;
import utils.lista.ListasCategoriaLibros;

@ManagedBean(name = "autoCompleteBeanCategLibro")
@SessionScoped
public class AutoCompleteBeanCatLib implements Serializable {

    @ManagedProperty("#{listasCategoriaLibros}")
    ListasCategoriaLibros categorialibroData;
    Categorialibro categorialibro;

    public List<Categorialibro> completeCategorialibroDespacho(String query) {
        List<Categorialibro> allCategorialibro = getCategorialibroData().getLstCategorialibro();
        List<Categorialibro> filterCategorialibro = new ArrayList<Categorialibro>();
        for (Categorialibro categorialibroSelected : allCategorialibro) {
            if (categorialibroSelected.getCodigocategoria().toLowerCase().startsWith(query) || categorialibroSelected.getNombrecategoria().toLowerCase().startsWith(query)) {
                filterCategorialibro.add(categorialibroSelected);
            }
        }
        return filterCategorialibro;
    }

    public ListasCategoriaLibros getCategorialibroData() {
        return categorialibroData;
    }

    public void setCategorialibroData(ListasCategoriaLibros categorialibroData) {
        this.categorialibroData = categorialibroData;
    }

    public Categorialibro getCategorialibro() {
        return categorialibro;
    }

    public void setCategorialibro(Categorialibro categorialibro) {
        this.categorialibro = categorialibro;
    }

}
