/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Zona;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author Emily
 */
public class ControlZona {

    private SessionFactory sesFact;
    private Session ses;
    private Transaction tra;

    private Integer id_zona;
    private int filasAfectadas = 0;

    Zona zona = new Zona();

    public ControlZona(Zona zona) {
        this.zona = zona;
    }

    public ControlZona(int id_zona) {
        this.id_zona = id_zona;
    }

    public ControlZona() {
    }

    private void iniciaOperacion() throws HibernateException {
        sesFact = HibernateUtil.getSessionFactory();
        ses = sesFact.openSession();
        tra = ses.beginTransaction();
    }

    private void manejaException(HibernateException he) throws HibernateException {
        tra.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public void guardarZona() throws HibernateException {
        try {
            iniciaOperacion();
            ses.save(zona);
            tra.commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            ses.close();
        }
    }

    public void actualizarZona(Zona zona) throws HibernateException {
        try {
            iniciaOperacion();
            ses.update(zona);
            tra.commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            ses.close();
        }
    }

    public void eliminarZona(Zona zona) throws HibernateException {
        try {
            iniciaOperacion();
            ses.delete(zona);
            tra.commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            ses.close();
        }
    }

    public Zona obtenerZona() throws HibernateException {
        try {
            iniciaOperacion();
            zona = (Zona) ses.get(Zona.class, id_zona);
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            ses.close();
        }
        return zona;
    }

    public List<Zona> ObtenerlistaDeZonas() throws HibernateException {

        List<Zona> listaDeZonas = null;
        try {
            iniciaOperacion();
            listaDeZonas = ses.createQuery("from Zona").list();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            ses.close();
        }
        return listaDeZonas;
    }
}
