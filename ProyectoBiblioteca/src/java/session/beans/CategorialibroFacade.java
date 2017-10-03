/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Categorialibro;

/**
 *
 * @author Miranda
 */
@Stateless
public class CategorialibroFacade extends AbstractFacade<Categorialibro> {
    @PersistenceContext(unitName = "ProyectoBibliotecaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorialibroFacade() {
        super(Categorialibro.class);
    }
    
}
