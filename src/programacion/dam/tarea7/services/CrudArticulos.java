package programacion.dam.tarea7.services;

import programacion.dam.tarea7.dao.StreamManager;
import swing.utils.MsgDialog;
import java.io.Serializable;
import java.util.List;
import programacion.dam.tarea7.beans.Articulo;
import programacion.dam.tarea7.dao.IArticulosDao;
import programacion.dam.tarea7.dao.exceptions.DAMDaoException;

/**
 *
 * @author Roach
 * @since 2020-02-17
 */
public class CrudArticulos implements Serializable {

    private final transient IArticulosDao articulosSrv = new StreamManager();

    // CREATE
    // ***************************************************************** //    
    /**
     * Metodo que crea un articulo en la lista, si este no existe previamente.
     * Para ello se utiliza el metodo buscarArticuloPorCodigo:
     *
     * @see buscarArticuloPorCodigo
     *
     * @param articulo
     * @return resultado de la creacion
     */
    public boolean crearArticuloEnLista(Articulo articulo) {
        try {
            if (null == articulo || null == articulo.getCodArticulo()) {
                throw new DAMDaoException("El articulo a crear no es valido");
            }

            String codigoArticuloBuscar = articulo.getCodArticulo();
            Articulo articuloEncontrado = null;
            List<Articulo> articulos = articulosSrv.read();
            if (null != articulos && !articulos.isEmpty()) {
                articuloEncontrado = articulosSrv.read(codigoArticuloBuscar);
            }

            if (null != articuloEncontrado) {
                MsgDialog.showWarning("Ya existe un articulo con el codigo ".concat(codigoArticuloBuscar));
                return false;
            }

            System.out.println("PREINSERT");
            return articulosSrv.create(articulo);
        } catch (DAMDaoException ex) {
            MsgDialog.showError(ex.getMessage());
            return false;
        }
    }

    // READ
    // ***************************************************************** //    
    /**
     * Metodo que busca en la lista de articulos, y devuelve el coincidente con
     * el codigo llegado por parametro.
     *
     * @param codigoArticulo
     * @return articulo localizado | null
     */
    public Articulo buscarArticuloPorCodigo(String codigoArticulo) {
        try {
            return articulosSrv.read(codigoArticulo);
        } catch (DAMDaoException ex) {
            MsgDialog.showError(ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo que devuelve la lista de articulos.
     *
     * @return listaArticulos
     */
    public List<Articulo> listarArticulos() {
        try {
            return articulosSrv.read();
        } catch (DAMDaoException ex) {
            return null;
        }
    }

    // UPDATE
    // ***************************************************************** //    
    /**
     * Metodo que actualiza un articulo existente en la lista de articulos.
     *
     * Primero se actualizaron los datos del articulo con los nuevos pasados
     * como parametro.
     *
     * @see actualizarDatosArticulo
     *
     * Despues se actualziara el listado de familias de dicho articulo con los
     * que vengan del nuevo articulo.
     *
     * @see actualizarListasFamilias
     *
     * Si no existe, se notificara con un panel con el mensaje correspondiente.
     *
     * @param articulo articulo con los datos actualizados
     */
    public void actualizarArticuloEnLista(Articulo articulo) {
        try {
            if (null == articulo) {
                MsgDialog.showError("El articulo no existe");
                return;
            }

            if (null == articulo.getCodArticulo()) {
                MsgDialog.showError("El articulo no tiene codigo.");
                return;
            }

            List<Articulo> listaArticulos;
            try {
                listaArticulos = articulosSrv.read();
            } catch (DAMDaoException ex) {
                MsgDialog.showError("La lista esta vacia, no se puede actualizar.");
                return;
            }

            //Tratando de localizar el articulo en el listado...
            final String codigoArticuloBuscar = articulo.getCodArticulo();
            Articulo articuloEncontrado = articulosSrv.read(codigoArticuloBuscar);

            if (null == articuloEncontrado) {
                MsgDialog.showWarning("No existe un articulo con codigo ".concat(codigoArticuloBuscar));
                return;
            }

            articulosSrv.update(articulo);
        } catch (DAMDaoException ex) {
            MsgDialog.showError(ex.getMessage());
        }
    }

    // DELETE
    // ***************************************************************** //    
    /**
     * Metodo que elimina un articulo existente en la lista.
     *
     * Si existe un articulo con el mismo codigo que el articulo llegado por
     * parametro se elimina de la lista.
     *
     * @param codigoArticulo
     * @return resultado de la operacion
     */
    public boolean borrarArticuloDeLista(String codigoArticulo) {
        try {
            Articulo articuloEncontrado = articulosSrv.read(codigoArticulo);

            if (null == articuloEncontrado) {
                MsgDialog.showWarning("No existe un articulo con codigo ".concat(codigoArticulo));
                return false;
            }

            return articulosSrv.delete(codigoArticulo);
        } catch (DAMDaoException ex) {
            MsgDialog.showError(ex.getMessage());
            return false;
        }
    }
}

// ********************************************************************** //
// *********************** CRUD fichero Articulos *********************** //
// ********************************************************************** //

