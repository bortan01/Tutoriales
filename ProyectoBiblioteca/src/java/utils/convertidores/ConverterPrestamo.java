package utils.convertidores;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.entidades.PrestamoAlumno;
import utils.lista.ListasPrestamos;


@FacesConverter ("converterPrestamo")
public class ConverterPrestamo implements Converter{
     @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pos=0;
        if(value != null && value.trim().length() > 0) {
           ListasPrestamos  service = (ListasPrestamos) context.getExternalContext().getSessionMap().get("listasPrestamos");
            for(int i=0; i<service.getLstPrestamo().size(); i++){
                if(service.getLstPrestamo().get(i).getCodigoPrestamo().equals(value))
                    pos=i;
            }
            return service.getLstPrestamo().get(pos);
        }
        else {
            return null;
        }        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if(value != null) {
            return String.valueOf(((PrestamoAlumno) value).getCodigoPrestamo());            
        }
        else {
            return null;
        }
    }

}
