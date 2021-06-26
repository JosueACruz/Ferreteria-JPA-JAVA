/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjerusalen;

import BusinessLogic.lote;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick Siguache
 */
public class frmLotes extends javax.swing.JFrame {

    /**
     * Creates new form frmUsers
     */
    private lote lot = new lote();
    int idLote = -1;
    
    public frmLotes() {
        initComponents();
        mostrarLotes(); 
    }
    
    private void mostrarLotes(){
        lot.listarLote(tableLotes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new rojeru_san.RSButtonRiple();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLote = new rojeru_san.RSMTextFull();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLotes = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new rojeru_san.RSMTextFull();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(22, 33, 62));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setBackground(new java.awt.Color(22, 33, 62));
        btnCerrar.setBorder(null);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/cerrar.png"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 40, 44, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del Lote:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        txtLote.setBackground(new java.awt.Color(22, 33, 62));
        txtLote.setForeground(new java.awt.Color(255, 255, 255));
        txtLote.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtLote.setBotonColor(new java.awt.Color(255, 255, 255));
        txtLote.setPlaceholder("");
        txtLote.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 320, -1));

        tableLotes.setBackground(new java.awt.Color(45, 55, 99));
        tableLotes.setForeground(new java.awt.Color(255, 255, 255));
        tableLotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableLotes.setFocusable(false);
        tableLotes.setGridColor(new java.awt.Color(153, 153, 153));
        tableLotes.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableLotes.setRowHeight(25);
        tableLotes.setSelectionBackground(new java.awt.Color(47, 63, 128));
        tableLotes.setShowVerticalLines(false);
        tableLotes.getTableHeader().setReorderingAllowed(false);
        tableLotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLotesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLotes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 750, 280));

        btnGuardar.setBackground(new java.awt.Color(26, 26, 46));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 150, 40));

        btnEditar.setBackground(new java.awt.Color(26, 26, 46));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 150, 40));

        btnEliminar.setBackground(new java.awt.Color(26, 26, 46));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 150, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripcion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(22, 33, 62));
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtDescripcion.setBotonColor(new java.awt.Color(255, 255, 255));
        txtDescripcion.setPlaceholder("");
        txtDescripcion.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 320, -1));

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1190, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableLotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLotesMouseClicked
        int select = tableLotes.getSelectedRow();
        idLote = Integer.parseInt(tableLotes.getValueAt(select,0).toString());
        txtLote.setText(tableLotes.getValueAt(select, 1).toString());
        txtDescripcion.setText(tableLotes.getValueAt(select,2).toString());
    }//GEN-LAST:event_tableLotesMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String lote = txtLote.getText();
        String descripcion = txtDescripcion.getText();
        if(lote.equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
        }
        else if(descripcion.equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo descripcion no puede estar vacio");
        }
        else
        {
            String mensaje = "";
            mensaje = lot.insertarLote(lote, descripcion);
            JOptionPane.showMessageDialog(null,mensaje);
            mostrarLotes();      
        }     
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //int id = idLote;
        String lote = txtLote.getText();
        String descripcion = txtDescripcion.getText();
        if(idLote == -1)
        {
           JOptionPane.showMessageDialog(null, "Debe escoger un Lote para eliminar"); 
        }
        else if(lote.equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
        }
        else if(descripcion.equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo descripcion no puede estar vacio");
        }
        else{
            String mensaje = "";
            mensaje = lot.actualizarLote(idLote, lote, descripcion);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarLotes();
            idLote = -1;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(idLote == -1)
        {
            JOptionPane.showMessageDialog(null, "Debe escoger un Lote para eliminar");
        }
        else if (idLote > -1 ){
            String mensaje = "";
            mensaje = lot.eliminarLote(idLote);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarLotes();
            idLote = -1; 
        }       
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.hide();
    }//GEN-LAST:event_btnCerrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLotes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private javax.swing.JTable tableLotes;
    private rojeru_san.RSMTextFull txtDescripcion;
    private rojeru_san.RSMTextFull txtLote;
    // End of variables declaration//GEN-END:variables
}
