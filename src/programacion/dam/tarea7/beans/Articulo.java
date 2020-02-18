package programacion.dam.tarea7.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roach
 */
public class Articulo implements Serializable{
    
    // Atributos
    private String codArticulo;
    private String descripcion;
    private Double precio;
    private Double descuento;
    private Integer iva;
    private List<FamiliaArticulo> listaFamiliaArticulo;
    
    // Constructores
    public Articulo(){
        listaFamiliaArticulo = new ArrayList<>();
    }
    
    public Articulo(String codArticulo, String descripcion, Double precio, Double descuento, Integer iva,
            ArrayList<FamiliaArticulo> listaFamiliaArticulo){
        this.codArticulo = codArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.listaFamiliaArticulo = listaFamiliaArticulo;        
    }
    
    // Getters y Setters
    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public List<FamiliaArticulo> getListaFamiliaArticulo() {
        return listaFamiliaArticulo;
    }

    public void setListaFamiliaArticulo(List<FamiliaArticulo> listaFamiliaArticulo) {
        this.listaFamiliaArticulo = listaFamiliaArticulo;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codArticulo=" + codArticulo + ", descripcion=" + descripcion + ", precio=" + precio + ", descuento=" + descuento + ", iva=" + iva + ", listaFamiliaArticulo=" + listaFamiliaArticulo + '}';
    }
}


