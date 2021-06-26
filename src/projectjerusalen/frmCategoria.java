/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjerusalen;

import BusinessLogic.CategoryLogic;
import Entidad.Categoria;
import entityMain.entityMain;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Erick Siguache
 */
public class frmCategoria extends javax.swing.JFrame {

    private CategoryLogic CatLog = new CategoryLogic();
    int idCategoria=-1;

    public frmCategoria() {
        initComponents();
        mostrarCategorias();
        //CatLog.idIncrement();
        //System.out.println("id siguiente de categoria: " + CatLog.idIncrement());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new rojeru_san.RSButtonRiple();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCategoria = new rojeru_san.RSMTextFull();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategoria = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();

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
        jLabel1.setText("CATEGORIA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre de la Categoria: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        txtCategoria.setBackground(new java.awt.Color(22, 33, 62));
        txtCategoria.setForeground(new java.awt.Color(255, 255, 255));
        txtCategoria.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtCategoria.setBotonColor(new java.awt.Color(255, 255, 255));
        txtCategoria.setPlaceholder("");
        txtCategoria.setSelectionColor(new java.awt.Color(0, 112, 192));
        txtCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCategoriaMouseClicked(evt);
            }
        });
        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 300, -1));

        tableCategoria.setBackground(new java.awt.Color(45, 55, 99));
        tableCategoria.setForeground(new java.awt.Color(255, 255, 255));
        tableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cateogoria"
            }
        ));
        tableCategoria.setFocusable(false);
        tableCategoria.setGridColor(new java.awt.Color(153, 153, 153));
        tableCategoria.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableCategoria.setRowHeight(25);
        tableCategoria.setSelectionBackground(new java.awt.Color(47, 63, 128));
        tableCategoria.setShowVerticalLines(false);
        tableCategoria.getTableHeader().setReorderingAllowed(false);
        tableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCategoria);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 750, 280));

        btnGuardar.setBackground(new java.awt.Color(26, 26, 46));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 150, 40));

        btnEditar.setBackground(new java.awt.Color(26, 26, 46));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 150, 40));

        btnEliminar.setBackground(new java.awt.Color(26, 26, 46));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 150, 40));

        lblCategoria.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, -1, -1));

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1190, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarCategorias(){
        CatLog.ListaCategoria(tableCategoria);
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nameCat= txtCategoria.getText();
        if(nameCat.isEmpty()){
            JOptionPane.showMessageDialog(null,"Debe escribir la categoria");
        }else{
            String mensaje="";
            mensaje=CatLog.insertarCategoria(nameCat);
            JOptionPane.showMessageDialog(null,"Se ha guardado correctamente");
            mostrarCategorias();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoriaMouseClicked
        int select=tableCategoria.getSelectedRow();
        idCategoria=Integer.parseInt(tableCategoria.getValueAt(select, 0).toString());
        txtCategoria.setText(tableCategoria.getValueAt(select, 1).toString());
    }//GEN-LAST:event_tableCategoriaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nameCat= txtCategoria.getText();
        if(idCategoria == -1)
        {
            JOptionPane.showMessageDialog(null, "Debe escoger una categoria para editar");
        }else if(nameCat.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "El campo no puede quedar vacio");
        }
        else {
            String mensaje = "";
            mensaje=CatLog.actualizarCategoria(idCategoria, nameCat);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarCategorias();
            idCategoria = -1; 
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(idCategoria == -1)
        {
            JOptionPane.showMessageDialog(null, "Debe escoger una categoria para eliminar");
        }
        else if (idCategoria > -1 ){
            String mensaje = "";
            mensaje = CatLog.eliminarCategoria(idCategoria);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarCategorias();
            idCategoria = -1; 
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyTyped
        String area ="";
        char validarN = evt.getKeyChar();
        if (Character.isDigit(validarN)) {
            getToolkit().beep();
            evt.consume();
            area = "Por Favor: Ingrese solo letras en la categoria";

            lblCategoria.setText(area);
        } else if ((int) evt.getKeyChar() >= 33 && (int) evt.getKeyChar() <= 64
                || (int) evt.getKeyChar() >= 91 && (int) evt.getKeyChar() <= 96
                || (int) evt.getKeyChar() >= 123 && (int) evt.getKeyChar() <= 208
                || (int) evt.getKeyChar() >= 210 && (int) evt.getKeyChar() <= 240
                || (int) evt.getKeyChar() >= 242 && (int) evt.getKeyChar() <= 255) {
            getToolkit().beep();
            evt.consume();
            area = "No se permiten caracteres especiales";
            lblCategoria.setText(area);
        }
    }//GEN-LAST:event_txtCategoriaKeyTyped

    private void txtCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCategoriaMouseClicked
        lblCategoria.setText("");
    }//GEN-LAST:event_txtCategoriaMouseClicked

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
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCategoria().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private javax.swing.JTable tableCategoria;
    private rojeru_san.RSMTextFull txtCategoria;
    // End of variables declaration//GEN-END:variables

}
