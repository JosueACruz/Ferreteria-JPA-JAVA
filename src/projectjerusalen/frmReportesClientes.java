/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjerusalen;

import BusinessLogic.ClientesLogic;
import java.math.BigDecimal;

/**
 *
 * @author Josue
 */
public class frmReportesClientes extends javax.swing.JFrame {

    private ClientesLogic ClieLog = new ClientesLogic();
    private int idC;
    public frmReportesClientes() {
        initComponents();
        mostrarClientes();
    }
    private void mostrarClientes(){
        ClieLog.ListaClientes(tableClient);
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
        btnVentas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClient = new javax.swing.JTable();
        btnGeneral = new javax.swing.JButton();
        btnNombre = new javax.swing.JButton();
        txtNombre = new rojeru_san.RSMTextFull();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1186, 704));
        setMinimumSize(new java.awt.Dimension(1186, 704));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1186, 704));
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
        jLabel1.setText("Reportes de Clientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        lblNombre.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, -1, -1));

        lblApellido.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, -1, -1));

        lblTelefono.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        btnVentas.setBackground(new java.awt.Color(26, 26, 46));
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas al cliente");
        btnVentas.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel1.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, 150, 40));

        tableClient.setBackground(new java.awt.Color(45, 55, 99));
        tableClient.setForeground(new java.awt.Color(255, 255, 255));
        tableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Telefono", "Direccion"
            }
        ));
        tableClient.setFocusable(false);
        tableClient.setGridColor(new java.awt.Color(153, 153, 153));
        tableClient.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableClient.setRowHeight(25);
        tableClient.setSelectionBackground(new java.awt.Color(47, 63, 128));
        tableClient.setShowVerticalLines(false);
        tableClient.getTableHeader().setReorderingAllowed(false);
        tableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClient);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 690, 450));

        btnGeneral.setBackground(new java.awt.Color(26, 26, 46));
        btnGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneral.setText("General");
        btnGeneral.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btnGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 280, 150, 40));

        btnNombre.setBackground(new java.awt.Color(26, 26, 46));
        btnNombre.setForeground(new java.awt.Color(255, 255, 255));
        btnNombre.setText("Nombre");
        btnNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });
        jPanel1.add(btnNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 350, 150, 40));

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
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 270, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 1190, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientMouseClicked
        int select=tableClient.getSelectedRow();
        idC = Integer.parseInt(tableClient.getValueAt(select, 0).toString());
        txtNombre.setText(tableClient.getValueAt(select, 1).toString());
    }//GEN-LAST:event_tableClientMouseClicked

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        ClieLog.ReporteVentasPorCLiente(idC);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralActionPerformed
        ClieLog.ReporteGeneral();
    }//GEN-LAST:event_btnGeneralActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        String nombre = txtNombre.getText();
        ClieLog.ReportePorNombre(nombre);
    }//GEN-LAST:event_btnNombreActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked

    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // Validar que solo escriba letras
        //Esta funcion se encuentra en los eventos del txtApellido en event con el nombre de KeyTyped
    }//GEN-LAST:event_txtNombreKeyTyped

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
            java.util.logging.Logger.getLogger(frmReportesClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReportesClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReportesClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReportesClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReportesClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCerrar;
    private javax.swing.JButton btnGeneral;
    private javax.swing.JButton btnNombre;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tableClient;
    private rojeru_san.RSMTextFull txtNombre;
    // End of variables declaration//GEN-END:variables
}