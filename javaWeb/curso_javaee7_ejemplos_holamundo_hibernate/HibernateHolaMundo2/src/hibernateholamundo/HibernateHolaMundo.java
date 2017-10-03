/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateholamundo;

import org.hibernate.*;

/**
 *
 * @author Andres
 */
public class HibernateHolaMundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos la tabla persona
        CompruebaDatosDB.droptable("drop table personas");
        CompruebaDatosDB.droptable("drop table estudiantes");
        CompruebaDatosDB.setup("create table personas ( id int, nombre VARCHAR(30))");
        CompruebaDatosDB.setup("create table estudiantes ( id int, nombre_colegio VARCHAR(30), grado VARCHAR(20))");

        // Creamos el SessionFactory y el objeto de Session hibernate
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        // Comienza el ciclo de vida de las operaciones hibernate bajo una transacción
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Creamos a una Persona y la guardamos
            Persona p1 = new Persona();
            p1.setNombre("Andrés Guzmán");
            session.save(p1);

            // Creamos a otro objeto Persona y lo guardamos.
            Persona p2 = new Persona();
            p2.setNombre("James Gosling");
            session.save(p2);

            // Recibe el objeto persona
            Persona persona = (Persona) session.get(Persona.class, p1.getId());
            System.out.println("Primera persona recibida = " + persona.getNombre());
            persona = (Persona) session.get(Persona.class, p2.getId());
            System.out.println("Primera persona recibida = " + persona.getNombre());

            // Creamos a la objeto Estudiante y lo guardamos
            Estudiante s1 = new Estudiante();
            s1.setColegio("Colegio Camino la Montaña");
            s1.setGrado("1º Básico");
            session.save(s1);

            // Recibe el objeto Estudiante
            Estudiante student = (Estudiante)session. get(Estudiante.class, s1.getId());
            System.out.println("Primer estudiante recibido = " + student.getId() + ", " +
                               "Colegio = " + student.getColegio() + ", " +
                               "Grado = " + student.getGrado());

            tx.commit();
            tx = null;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        // Mostramos los datos guardados
        CompruebaDatosDB.checkData("select * from personas");
        CompruebaDatosDB.checkData("select * from estudiantes");
    }

}
