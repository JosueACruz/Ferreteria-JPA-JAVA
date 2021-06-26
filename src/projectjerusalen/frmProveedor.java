package projectjerusalen;

import BusinessLogic.proveedor;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Siguache
 */
public class frmProveedor extends javax.swing.JFrame {
    private proveedor prov = new proveedor();
    int idProveedor = -1;
    public frmProveedor() {
        initComponents();
        mostrarProveedores();
    }
    //Listando datos
    public void mostrarProveedores()
    {
        prov.listarProveedores(tableProveedor);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new rojeru_san.RSButtonRiple();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new rojeru_san.RSMTextFull();
        txtDireccion = new rojeru_san.RSMTextFull();
        txtTelefono = new rojeru_san.RSMTextFull();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProveedor = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

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
        jLabel1.setText("PROVEEDOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Direccion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        txtNombre.setBackground(new java.awt.Color(22, 33, 62));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtNombre.setBotonColor(new java.awt.Color(255, 255, 255));
        txtNombre.setPlaceholder("");
        txtNombre.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 370, -1));

        txtDireccion.setBackground(new java.awt.Color(22, 33, 62));
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtDireccion.setBotonColor(new java.awt.Color(255, 255, 255));
        txtDireccion.setPlaceholder("");
        txtDireccion.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 370, -1));

        txtTelefono.setBackground(new java.awt.Color(22, 33, 62));
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtTelefono.setBotonColor(new java.awt.Color(255, 255, 255));
        txtTelefono.setPlaceholder("");
        txtTelefono.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 260, -1));

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
        jScrollPane1.setViewportView(tableProveedor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 940, 250));

        btnGuardar.setBackground(new java.awt.Color(26, 26, 46));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 150, 40));

        btnEditar.setBackground(new java.awt.Color(26, 26, 46));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 150, 40));

        btnEliminar.setBackground(new java.awt.Color(26, 26, 46));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 150, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1190, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedorMouseClicked
        int select = tableProveedor.getSelectedRow();
        idProveedor = Integer.parseInt(tableProveedor.getValueAt(select, 0).toString());
        txtNombre.setText(tableProveedor.getValueAt(select, 1).toString());
        txtDireccion.setText(tableProveedor.getValueAt(select,2).toString());
        txtTelefono.setText(tableProveedor.getValueAt(select, 3).toString());
    }//GEN-LAST:event_tableProveedorMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String proveedor = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        if(proveedor.equals("") || direccion.equals("") || telefono.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
        }
        else
        {
            String mensaje = "";
            mensaje = prov.insertarDatos(proveedor, direccion, telefono);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarProveedores();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String proveedor = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        if(idProveedor == -1)
        {
            JOptionPane.showMessageDialog(null, "Debe escoger un proveedor para editar");
        }
        else if(proveedor.equals("") || direccion.equals("") || telefono.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
        }
        else
        {
            String mensaje = "";
            mensaje = prov.actualizarDatos(idProveedor,proveedor, direccion, telefono);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarProveedores();
            idProveedor = -1;
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(idProveedor == -1)
        {
            JOptionPane.showMessageDialog(null, "Debe escoger un proveedor para eliminar");
        }
        else if ( idProveedor > -1)
        {
            String mensaje = "";
            mensaje = prov.eliminarDato(idProveedor);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarProveedores();
            idProveedor = -1;
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
            java.util.logging.Logger.getLogger(frmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProveedor().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private javax.swing.JTable tableProveedor;
    private rojeru_san.RSMTextFull txtDireccion;
    private rojeru_san.RSMTextFull txtNombre;
    private rojeru_san.RSMTextFull txtTelefono;
    // End of variables declaration//GEN-END:variables
}
