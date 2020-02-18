/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.dam.tarea7.dao;

import java.util.List;
import programacion.dam.tarea7.beans.Articulo;
import programacion.dam.tarea7.dao.exceptions.DAMDaoException;

/**
 *
 * @author user
 */
public interface IArticulosDao {

    public boolean create(Articulo articulo) throws DAMDaoException;

    public boolean create(List<Articulo> articulos) throws DAMDaoException;

    public List<Articulo> read() throws DAMDaoException;

    public Articulo read(String id) throws DAMDaoException;

    public boolean update(Articulo articuloUpdate) throws DAMDaoException;

    public boolean delete(String id) throws DAMDaoException;
    
    

}
