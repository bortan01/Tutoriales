
import models.Evento;
import models.Expositor;
import models.dao.EventoHibernateDao;
import models.dao.IEventoDao;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.CompruebaDatosDB;
import util.HibernateUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andrés Guzmán F
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos y configuramos las tablas
        CompruebaDatosDB.droptable("drop table eventos");
        CompruebaDatosDB.droptable("drop table expositores");
        CompruebaDatosDB.setup("create table eventos ( id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY, nombre VARCHAR(40), fecha_inicio date, duracion int)");
        CompruebaDatosDB.setup("create table expositores ( id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY, evento_id int, nombre VARCHAR(40), apellido VARCHAR(40))");

        // Obtenemos el Dao desde el Contexto de Spring
        IEventoDao eventDao = new EventoHibernateDao();

        // Creamos los objetos de dominio y sus relaciones
        Evento evento1 = new Evento();
        evento1.setNombre("Curso Spring en Santiago");

        evento1.setExpositores(new HashSet<Expositor>());
        evento1.getExpositores().add(new Expositor("Andrés", "Guzmán"));
        evento1.getExpositores().add(new Expositor("Rod", "Johnson"));
        evento1.getExpositores().add(new Expositor("James", "Gosling"));
        eventDao.save(evento1);

        Evento evento2 = new Evento();
        evento2.setNombre("Taller Hibernate en Santiago");
        evento2.setExpositores(new HashSet<Expositor>());
        evento2.getExpositores().add(new Expositor("Andrés", "Guzmán"));
        evento2.getExpositores().add(new Expositor("John", "Doe"));
        eventDao.save(evento2);

        // Mostramos los datos guardados
        CompruebaDatosDB.checkData("select id, nombre from eventos");
        CompruebaDatosDB.checkData("select id, evento_id, nombre, apellido from expositores");
    }

}
