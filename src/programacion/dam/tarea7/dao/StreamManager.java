package programacion.dam.tarea7.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import programacion.dam.tarea7.beans.Articulo;
import static programacion.dam.tarea7.dao.StreamManager.ARCHIVO_ARTICULOS;
import programacion.dam.tarea7.dao.exceptions.DAMDaoException;

public class StreamManager implements IArticulosDao {

    public static final String ARCHIVO_ARTICULOS = "articulos.dat";

    public StreamManager() {
        init();
    }
    
    /**
     * M�todo que agrega un art�culo al fichero.
     *
     * @param articulo datos del articulo a agregar
     * @return resultado de la operaci�n
     * @throws programacion.dam.tarea7.dao.exceptions.DAMDaoException
     */
    @Override
    public boolean create(Articulo articulo) throws DAMDaoException {

        List<Articulo> listaArticulos = read();
        if (null == listaArticulos) {
            listaArticulos = new ArrayList<>();
        }
        System.out.println("EMPTY");
        listaArticulos.add(articulo);

        try {
            return write(listaArticulos);
        } catch (IOException ex) {
            throw new DAMDaoException("No se ha podido registrar el art�culo");
        }
    }

    /**
     * M�todo que agrega art�culos al fichero.
     *
     * @param articulos lista de articulos a agregar
     * @return resultado de la operaci�n
     * @throws programacion.dam.tarea7.dao.exceptions.DAMDaoException
     *
     */
    @Override
    public boolean create(List<Articulo> articulos) throws DAMDaoException {

        List<Articulo> listaArticulos = read();
        if (null == listaArticulos) {
            listaArticulos = new ArrayList<>();
        }
        listaArticulos.addAll(articulos);
        try {
            return write(listaArticulos);
        } catch (IOException ex) {
            Logger.getLogger(StreamManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * M�todo para leer los art�culos del fichero
     *
     * @return lista de art�culos
     * @throws programacion.dam.tarea7.dao.exceptions.DAMDaoException
     */
    @Override
    public List<Articulo> read() throws DAMDaoException {
        try (
                ObjectInputStream objetoEntrada = new ObjectInputStream(
                        new FileInputStream(ARCHIVO_ARTICULOS));) {
            return (List<Articulo>) objetoEntrada.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new DAMDaoException("No se ha podido recuperar la lista de Art�culos");
        }
    }

    /**
     * M�todo para buscar un art�culo de la lista de art�culos
     *
     * @param id codigo del art�culo
     * @return articulo localizado | null
     * @throws programacion.dam.tarea7.dao.exceptions.DAMDaoException
     */
    @Override
    public Articulo read(String id) throws DAMDaoException {
        List<Articulo> articulos = read();

        return articulos.stream()
                .filter(articulo -> id.equals(articulo.getCodArticulo()))
                .findFirst()
                .orElse(null);
    }

    /**
     * M�todo que aelimina un art�culo al fichero.
     *
     * @param id
     * @return resultado de la operaci�n
     * @throws programacion.dam.tarea7.dao.exceptions.DAMDaoException
     */
    @Override
    public boolean delete(String id) throws DAMDaoException {
        try {
            List<Articulo> listaArticulos = read();
            if (listaArticulos == null || listaArticulos.isEmpty()) {
                return false;
            }

            listaArticulos.removeIf(articulo -> id.equals(articulo.getCodArticulo()));

            return write(listaArticulos);
        } catch (IOException ex) {
            throw new DAMDaoException("No se pudo eliminar el art�culo con id: ".concat(id));        }
    }

    @Override
    public boolean update(Articulo articuloUpdate) throws DAMDaoException {
        List<Articulo> articulos = read();
        articulos.forEach(articulo -> {
            if (articuloUpdate.getCodArticulo().equals(articulo.getCodArticulo())){
                articulo.setDescripcion(articuloUpdate.getDescripcion());
                articulo.setDescuento(articuloUpdate.getDescuento());
                articulo.setIva(articuloUpdate.getIva());
                articulo.setListaFamiliaArticulo(articuloUpdate.getListaFamiliaArticulo());
                articulo.setPrecio(articuloUpdate.getPrecio());
            }
        });
        
        try {
            return write(articulos);
        } catch (IOException ex) {
            throw new DAMDaoException("No se pudo actualizar el art�culo");
        }
    }

    /**
     * M�todo que escribe el contenido de la lista pasada como par�metro al
     * fichero.
     *
     * @param listaArticulos de datos a a�adir
     * @return resultado de la escritura
     * @throws java.io.IOException
     */
    private boolean write(List<Articulo> listaArticulos) throws IOException {
        // Escribimos la lista en el fichero
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(
                new FileOutputStream(ARCHIVO_ARTICULOS))) {
            // Escribimos la lista en el fichero
            objetoSalida.writeObject(listaArticulos);
        }
        return true;

    }
    
    private void init(){
        try {
            File f = new File(ARCHIVO_ARTICULOS);
            if (!f.exists()){
                System.out.println("NO EXISTE");
                write(new ArrayList<>());
            }
        } catch (IOException ex) {
            Logger.getLogger(StreamManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
