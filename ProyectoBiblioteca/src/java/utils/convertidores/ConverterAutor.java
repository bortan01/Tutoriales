package utils.convertidores;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Autor;
import utils.lista.ListasAutores;

@FacesConverter ("convertidorAutor")
public class ConverterAutor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pos=0;
        if(value != null && value.trim().length() > 0) {
            ListasAutores service = (ListasAutores) context.getExternalContext().getSessionMap().get("listasAutores");
            for(int i=0; i<service.getLstAutor().size(); i++){
                if(service.getLstAutor().get(i).getCodigoautor().equals(value))
                    pos=i;
            }
            return service.getLstAutor().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Autor) value).getCodigoautor());            
        }
        else {
            return null;
        }
    }
    
}
