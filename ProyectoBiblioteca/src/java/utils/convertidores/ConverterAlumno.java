package utils.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.Alumno;
import utils.lista.ListasAlumnos;


@FacesConverter ("convertidorAlumno")
public class ConverterAlumno implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pos=0;
        if(value != null && value.trim().length() > 0) {
            ListasAlumnos service = (ListasAlumnos) context.getExternalContext().getSessionMap().get("listasAlumnos");
            for(int i=0; i<service.getLstAlumno().size(); i++){
                if(service.getLstAlumno().get(i).getCarnet().equals(value))
                    pos=i;
            }
            return service.getLstAlumno().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       if(value != null) {
            return String.valueOf(((Alumno) value).getCarnet());            
        }
        else {
            return null;
        }
    }
    
}
