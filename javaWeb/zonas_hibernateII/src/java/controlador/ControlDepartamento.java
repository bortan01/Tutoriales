/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Departamento;
import modelo.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import sv.edu.ues.hibernate.HibernateUtil;
//import sv.edu.ues.hibernate.Departamento;

/**
 *
 * @author Emily
 */
public class ControlDepartamento {

    private SessionFactory sesFact;
    private Session ses;
    private Transaction tra;

    private Integer id_departamento;

    Departamento departamento = new Departamento();

    public ControlDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public ControlDepartamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public ControlDepartamento() {
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

    public void guardarDepartamento() throws HibernateException {
        try {
            iniciaOperacion();
            ses.save(departamento);
            tra.commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            ses.close();
        }
    }

    public void actualizarDepartamento(Departamento departamento) throws HibernateException {
        try {
            iniciaOperacion();
            ses.update(departamento);
            tra.commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            ses.close();
        }
    }

    public void eliminarDepartamento(Departamento departamento) throws HibernateException {
        try {
            iniciaOperacion();
            ses.delete(departamento);
            tra.commit();
        } catch (HibernateException he) {
            manejaException(he);
            throw he;
        } finally {
            ses.close();
        }
    }

    public Departamento obtenerDepartamento() throws HibernateException {

        try {
            iniciaOperacion();
            departamento = (Departamento) ses.get(Departamento.class, id_departamento);

        } catch (Exception e) {
            System.out.println("Error al buscar el departamento" + e);
        } finally {
            ses.close();
        }
        return departamento;
    }

    public List<Departamento> ObtenerlistaDeDepartamentos() throws HibernateException {

        List<Departamento> listaDeDepartamentos = null;
        try {
            iniciaOperacion();
            String hql = "from Departamento d join fetch d.zona as z";
            //String sql = "select d.id_depto, d.nombre_depto, z.nombre_zona from departamento d inner join zona z on d.id_zona = z.id_zona";
            listaDeDepartamentos = ses.createQuery(hql).list();
        } catch (Exception e) {
            System.out.println("Error al buscar departamentos" + e);
        } finally {
            ses.close();
        }
        return listaDeDepartamentos;
    }

}
