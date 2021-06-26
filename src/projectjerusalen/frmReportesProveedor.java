/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjerusalen;

import BusinessLogic.Productos;
import BusinessLogic.proveedor;
import java.math.BigDecimal;
import javax.swing.JTable;

/**
 *
 * @author Josue
 */
public class frmReportesProveedor extends javax.swing.JFrame {

    proveedor Prov = new proveedor();
    Productos ProLog = new Productos();
    private int idC;
    public frmReportesProveedor() {
        initComponents();
        mostrarProductos();
    }
    
    private void mostrarProductos(){
        Prov.listarProveedores(tableProveedor);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new rojeru_san.RSButtonRiple();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        btnProduxProvee = new javax.swing.JButton();
        txtNombre = new rojeru_san.RSMTextFull();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProveedor = new javax.swing.JTable();
        btnGeneral1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1186, 704));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(22, 33, 62));
        jPanel1.setMinimumSize(new java.awt.Dimension(1080, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setBackground(new java.awt.Color(22, 33, 62));
        btnCerrar.setBorder(null);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/cerrar.png"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 44, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reportes de Proveedor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        lblNombre.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, -1, -1));

        lblApellido.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, -1, -1));

        lblTelefono.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        btnProduxProvee.setBackground(new java.awt.Color(26, 26, 46));
        btnProduxProvee.setForeground(new java.awt.Color(255, 255, 255));
        btnProduxProvee.setText("Productos por Proveedor");
        btnProduxProvee.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnProduxProvee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProduxProveeActionPerformed(evt);
            }
        });
        jPanel1.add(btnProduxProvee, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, 170, 50));

        txtNombre.setBackground(new java.awt.Color(22, 33, 62));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtNombre.setBotonColor(new java.awt.Color(255, 255, 255));
        txtNombre.setPlaceholder("Nombre");
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 230, 270, 50));

        tableProveedor.setBackground(new java.awt.Color(45, 55, 99));
        tableProveedor.setForeground(new java.awt.Color(255, 255, 255));
        tableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Direccion", "Telefono"
            }
        ));
        tableProveedor.setFocusable(false);
        tableProveedor.setGridColor(new java.awt.Color(153, 153, 153));
        tableProveedor.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableProveedor.setRowHeight(25);
        tableProveedor.setSelectionBackground(new java.awt.Color(47, 63, 128));
        tableProveedor.setShowVerticalLines(false);
        tableProveedor.getTableHeader().setReorderingAllowed(false);
        tableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableProveedor);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 740, 310));

        btnGeneral1.setBackground(new java.awt.Color(26, 26, 46));
        btnGeneral1.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneral1.setText("General Reporte");
        btnGeneral1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGeneral1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneral1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGeneral1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, 170, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 1190, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnProduxProveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProduxProveeActionPerformed
        String nombre = txtNombre.getText();
        ProLog.ProductoProveedor(nombre);
    }//GEN-LAST:event_btnProduxProveeActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // Validar que solo escriba letras
        //Esta funcion se encuentra en los eventos del txtApellido en event con el nombre de KeyTyped
    }//GEN-LAST:event_txtNombreKeyTyped

    private void tableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedorMouseClicked
        int select=tableProveedor.getSelectedRow();
        idC = Integer.parseInt(tableProveedor.getValueAt(select, 0).toString());
        txtNombre.setText(tableProveedor.getValueAt(select, 1).toString());
    }//GEN-LAST:event_tableProveedorMouseClicked

    private void btnGeneral1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneral1ActionPerformed
        Prov.ReporteGeneralProveedor();
    }//GEN-LAST:event_btnGeneral1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmReportesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReportesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReportesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReportesProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReportesProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCerrar;
    private javax.swing.JButton btnGeneral1;
    private javax.swing.JButton btnProduxProvee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTable tableProduct1;
    private javax.swing.JTable tableProveedor;
    private rojeru_san.RSMTextFull txtNombre;
    // End of variables declaration//GEN-END:variables
}