package utils.lista;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import modelo.entidades.PrestamoAlumno;
import session.beans.PrestamoAlumnoFacade;

@ManagedBean (name = "listasPrestamos")
@SessionScoped
public class ListasPrestamos {

   @Inject
   PrestamoAlumnoFacade prestamoFacade;
   public List<PrestamoAlumno> lstPrestamo;
   
   @PostConstruct
   public void init(){
   lstPrestamo = llenarLista();
   }
   public List<PrestamoAlumno> llenarLista(){
   return prestamoFacade.findAll();
   }

    public PrestamoAlumnoFacade getPrestamoFacade() {
        return prestamoFacade;
    }

    public void setPrestamoFacade(PrestamoAlumnoFacade prestamoFacade) {
        this.prestamoFacade = prestamoFacade;
    }

    public List<PrestamoAlumno> getLstPrestamo() {
        return lstPrestamo;
    }

    public void setLstPrestamo(List<PrestamoAlumno> lstPrestamo) {
        this.lstPrestamo = lstPrestamo;
    }

    
   
}
