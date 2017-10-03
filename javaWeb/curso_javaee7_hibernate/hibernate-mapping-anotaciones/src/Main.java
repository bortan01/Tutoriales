
import java.util.HashSet;
import java.util.Set;
import models.Factura;
import models.Linea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.CompruebaDatosDB;
import util.HibernateUtil;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos las tablas
        CompruebaDatosDB.droptable("drop table facturas");
        CompruebaDatosDB.droptable("drop table lineas");
        CompruebaDatosDB.setup("create table facturas (id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,cliente varchar(40))");
        CompruebaDatosDB.setup("create table lineas (id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,descripcion varchar(40),factura_id int)");

        // Creamos el SessionFactory y el objeto de Session hibernate
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        // Creamos los objetos y sus relaciones.
        Set<Linea> list = new HashSet<Linea>();
        list.add(new Linea("IPhone 3GS"));
        list.add(new Linea("LCD Sony Bravia"));
        list.add(new Linea("UML Gota a Gota"));

        Factura fc = new Factura("BDI TI");
        fc.setLineas(list);

        Set<Linea> list2 = new HashSet<Linea>();
        list2.add(new Linea("Design Patterns Elements of Reusable OOP"));
        list2.add(new Linea("MP3 Player Sony"));

        Factura fc2 = new Factura("John Doe");
        fc2.setLineas(list2);

       // Comienza el ciclo de vida de las operaciones hibernate bajo una transacción
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(fc);
            session.save(fc2);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                e.printStackTrace();
            }
        }  finally {
            session.close();
        }

        // Mostramos los datos guardados
        CompruebaDatosDB.checkData("select * from facturas");
        CompruebaDatosDB.checkData("select * from lineas");
    }

}
