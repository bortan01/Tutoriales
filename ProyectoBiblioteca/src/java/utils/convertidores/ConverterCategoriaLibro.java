package utils.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Categorialibro;
import utils.lista.ListasCategoriaLibros;


@FacesConverter ("convertidorCategoriaLibro")
public class ConverterCategoriaLibro implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pos=0;
        if(value != null && value.trim().length() > 0) {
            ListasCategoriaLibros service = (ListasCategoriaLibros) context.getExternalContext().getSessionMap().get("listasCategoriaLibros");
            for(int i=0; i<service.getLstCategorialibro().size(); i++){
                if(service.getLstCategorialibro().get(i).getCodigocategoria().equals(value))
                    pos=i;
            }
            return service.getLstCategorialibro().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Categorialibro) value).getCodigocategoria());            
        }
        else {
            return null;
        }
    }
    
}
