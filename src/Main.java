
import java.util.ArrayList;
import programacion.dam.tarea7.beans.Articulo;
import programacion.dam.tarea7.beans.FamiliaArticulo;
import programacion.dam.tarea7.services.CrudArticulos;
import swing.windows.MainFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
       
    }

    private static void TestRapido() {
        CrudArticulos cr = new CrudArticulos();
        System.out.println("-----------------READ-----------------");
        System.out.println(cr.listarArticulos());
        Articulo a = new Articulo("1", "asd", 1d, 3d, 4, new ArrayList<FamiliaArticulo>() {
            {
                add(new FamiliaArticulo("aaaaa"));
                add(new FamiliaArticulo("eeeee"));
            }
        });
        Articulo b = new Articulo("2", "eafasd", 4d, 66d, 2, new ArrayList<FamiliaArticulo>() {
            {
                add(new FamiliaArticulo("iiiiiiiiiiii"));
                add(new FamiliaArticulo("ooooooooo"));
            }
        });

        System.out.println("-----------------CREATE-----------------");
        cr.crearArticuloEnLista(a);
        System.out.println(cr.listarArticulos());

        cr.crearArticuloEnLista(b);
        System.out.println(cr.listarArticulos());
        b.setDescripcion("NUEVA DESCRIPCION");

        System.out.println("-----------------UPDATE-----------------");
        cr.actualizarArticuloEnLista(b);
        System.out.println(cr.listarArticulos());

        System.out.println("-----------------DELETE-----------------");
        cr.borrarArticuloDeLista("1");
        System.out.println(cr.listarArticulos());
    }
}
