package utils.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Libro;
import utils.lista.ListasLibros;


@FacesConverter ("convertidorLibro")
public class ConverterLibro implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pos=0;
        if(value != null && value.trim().length() > 0) {
           ListasLibros  service = (ListasLibros) context.getExternalContext().getSessionMap().get("listasLibros");
            for(int i=0; i<service.getLstLibro().size(); i++){
                if(service.getLstLibro().get(i).getCodigolibro().equals(value))
                    pos=i;
            }
            return service.getLstLibro().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Libro) value).getCodigolibro());            
        }
        else {
            return null;
        }
    }
    
}
