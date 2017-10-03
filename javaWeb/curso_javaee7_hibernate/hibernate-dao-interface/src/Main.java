
import java.util.List;
import models.Evento;
import models.EventoDaoHibernateImpl;
import models.IEventoDao;
import util.CompruebaDatosDB;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos y configuramos la tabla de la base de datos.
        CompruebaDatosDB.droptable("drop table eventos");
        CompruebaDatosDB.setup("create table eventos ( id int, nombre VARCHAR(80), fecha_inicio date, duracion int)");

        // Creamos el objeto Dao y asignamos el tipo hacia su interface.
        IEventoDao eventoDao = new EventoDaoHibernateImpl();

        // Ejecutamos el método save del DAO para agregar un objeto Evento
        System.out.println("Ejecutamos el método save del DAO....");
        Evento evento1 = new Evento();
        evento1.setNombre("Conferencia sobre Spring Framework");
        eventoDao.save(evento1);

        Evento evento2 = new Evento();
        evento2.setNombre("Inicio curso Java EE");
        eventoDao.save(evento2);

        // Ejecutamos el método findById del DAO para obtener un evento
        System.out.println("Ejecutamos el método findById del DAO...");
        Evento eventoObtenido = eventoDao.findById(evento1.getId());
        System.out.println("Nombre del evento encontrado = " + eventoObtenido.getNombre());

        // Ejecutamos el método findById del DAO para modificar el evento uno.
        System.out.println("Ejecutamos el método findById del DAO...");
        evento1.setNombre("Conferencia sobre Spring Web MVC");
        eventoDao.save(evento1);

        // Ejecutamos el método findAll del Dao
        System.out.println("Ejecutamos el método findAll del Dao...");
        List<Evento> eventoList = eventoDao.findAll();
        System.out.println("Número de eventos registrados = " + eventoList.size());

        // Desplegamos el listado de eventos registrados
        CompruebaDatosDB.checkData("select id, nombre from eventos");
    }
}
