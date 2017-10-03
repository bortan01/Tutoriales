/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models.dao;

import models.Evento;
import java.util.List;

public interface IEventoDao {

    public Evento findById(Integer id);

    public List<Evento> findAll();

    public void save(Evento evento);

    public void delete(Evento evento);
}
