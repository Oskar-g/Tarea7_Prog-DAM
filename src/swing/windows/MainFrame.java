/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.windows;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import programacion.dam.tarea7.beans.Articulo;
import programacion.dam.tarea7.services.CrudArticulos;

/**
 *
 * @author user
 */
public class MainFrame extends javax.swing.JFrame {

    CrudArticulos articulosSrv = new CrudArticulos();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    private TableModel getTableModel() {
        List<Articulo> articulos = articulosSrv.listarArticulos();
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{
                    "ID",
                    "DESCRIPCION",
                    "PRECIO",
                    "PRECIO",
                    "DESCUENTO",
                    "IVA"
                }
                , 0);
        if (articulos == null || articulos.isEmpty()) {
            return tableModel;
        }

        articulos.forEach((art) -> {
            tableModel.addRow(new Object[]{
                art.getCodArticulo(),
                art.getDescripcion(),
                art.getPrecio(),
                art.getDescuento(),
                art.getIva()
            });
        });
        return tableModel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        articulosTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        articulosTable.setModel(getTableModel());
        articulosTable.setColumnSelectionAllowed(true);
        articulosTable.setName(""); // NOI18N
        articulosTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(articulosTable);
        articulosTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable articulosTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}