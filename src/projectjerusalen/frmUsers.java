/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjerusalen;

import BusinessLogic.UsersLogic;
import Entidad.Tipousuario;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Siguache
 */
public class frmUsers extends javax.swing.JFrame {

    private static final UsersLogic UserLog = new UsersLogic();
    int idUsuario = -1;

    public frmUsers() {
        initComponents();
        listarTipos(cmbTipo);
        mostrarUsuarios();
        esconderColumnas();
        UserLog.contarusuarios();
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
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new rojeru_san.RSMTextFull();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new rojeru_san.RSMTextFull();
        txtApellido = new rojeru_san.RSMTextFull();
        txtTelefono = new rojeru_san.RSMTextFull();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new rojeru_san.RSMPassView();
        jLabel7 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1140, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(22, 33, 62));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 680));
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
        jLabel1.setText("USUARIOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contrase??a:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 180, -1));

        txtUserName.setBackground(new java.awt.Color(22, 33, 62));
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtUserName.setBotonColor(new java.awt.Color(255, 255, 255));
        txtUserName.setPlaceholder("");
        txtUserName.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 200, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo de Usuario:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        txtNombre.setBackground(new java.awt.Color(22, 33, 62));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtNombre.setBotonColor(new java.awt.Color(255, 255, 255));
        txtNombre.setPlaceholder("");
        txtNombre.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 300, -1));

        txtApellido.setBackground(new java.awt.Color(22, 33, 62));
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtApellido.setBotonColor(new java.awt.Color(255, 255, 255));
        txtApellido.setPlaceholder("");
        txtApellido.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 300, -1));

        txtTelefono.setBackground(new java.awt.Color(22, 33, 62));
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtTelefono.setBotonColor(new java.awt.Color(255, 255, 255));
        txtTelefono.setPlaceholder("");
        txtTelefono.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 300, -1));

        tableUsers.setBackground(new java.awt.Color(45, 55, 99));
        tableUsers.setForeground(new java.awt.Color(255, 255, 255));
        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Telefono", "Tipo de Usuario", "Nombre de Usuario", "Contrase??a"
            }
        ));
        tableUsers.setFocusable(false);
        tableUsers.setGridColor(new java.awt.Color(153, 153, 153));
        tableUsers.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableUsers.setRowHeight(25);
        tableUsers.setSelectionBackground(new java.awt.Color(47, 63, 128));
        tableUsers.setShowVerticalLines(false);
        tableUsers.getTableHeader().setReorderingAllowed(false);
        tableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUsers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 940, 220));

        btnGuardar.setBackground(new java.awt.Color(26, 26, 46));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 150, 40));

        btnEditar.setBackground(new java.awt.Color(26, 26, 46));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 150, 40));

        btnEliminar.setBackground(new java.awt.Color(26, 26, 46));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 150, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre de Usuario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 180, -1));

        txtPassword.setBackground(new java.awt.Color(22, 33, 62));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtPassword.setPlaceholder("");
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 260, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Telefono:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        cmbTipo.setBackground(new java.awt.Color(22, 33, 62));
        cmbTipo.setEditable(true);
        cmbTipo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 230, -1));

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1190, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarUsuarios() {
        UserLog.ListaUsuarios2(tableUsers);
    }

    private void listarTipos( JComboBox cmbTipo) {
        UserLog.listarTipos(cmbTipo);
    }

    private void esconderColumnas() {
        //Ocultando columnas
        //nombre
        tableUsers.getColumnModel().getColumn(1).setMaxWidth(0);
        tableUsers.getColumnModel().getColumn(1).setMinWidth(0);
        tableUsers.getColumnModel().getColumn(1).setPreferredWidth(0);
        //apellido
        tableUsers.getColumnModel().getColumn(2).setMaxWidth(0);
        tableUsers.getColumnModel().getColumn(2).setMinWidth(0);
        tableUsers.getColumnModel().getColumn(2).setPreferredWidth(0);
        //idTipo
        tableUsers.getColumnModel().getColumn(7).setMaxWidth(0);
        tableUsers.getColumnModel().getColumn(7).setMinWidth(0);
        tableUsers.getColumnModel().getColumn(7).setPreferredWidth(0);
        //idUsuario
        tableUsers.getColumnModel().getColumn(0).setMaxWidth(0);
        tableUsers.getColumnModel().getColumn(0).setMinWidth(0);
        tableUsers.getColumnModel().getColumn(0).setPreferredWidth(0);

    }
    private void guardar(){
        String mensaje = "";
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        int Tipo = cmbTipo.getSelectedIndex();
        String username = txtUserName.getText();
        String pass = txtPassword.getText();
        if(nombre.equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
        }
        else if(apellido.equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo apelido no puede estar vacio");
        }
        else if(telefono.equals(""))
        {
             JOptionPane.showMessageDialog(null, "El campo telefono no puede estar vacio");
        }
        else if(Tipo == 0)
        {
             JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de usuario");
        }
        else if(username.equals(""))
        {
             JOptionPane.showMessageDialog(null, "El campo nombre de usuario no puede estar vacio");
        }
        else if(pass.equals(""))
        {
             JOptionPane.showMessageDialog(null, "El campo contrase??a no puede estar vacio");
        }
        else if(Tipo == 1)
        {
            JOptionPane.showMessageDialog(null, "No puede seleccionar el tipo Administrador");
        }
        else{
            mensaje = UserLog.insertarUsuarios(nombre, apellido, telefono, Tipo, username, pass);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarUsuarios();
            esconderColumnas();
        }
        
    }
    private void actualizar()
    {
        String mensaje = "";
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        int Tipo = cmbTipo.getSelectedIndex();
        String username = txtUserName.getText();
        String pass = txtPassword.getText();
        if(nombre.equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
        }
        else if(apellido.equals(""))
        {
            JOptionPane.showMessageDialog(null, "El campo apelido no puede estar vacio");
        }
        else if(telefono.equals(""))
        {
             JOptionPane.showMessageDialog(null, "El campo telefono no puede estar vacio");
        }
        else if(Tipo == 0)
        {
             JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de usuario");
        }
        else if(username.equals(""))
        {
             JOptionPane.showMessageDialog(null, "El campo nombre de usuario no puede estar vacio");
        }
        else if(pass.equals(""))
        {
             JOptionPane.showMessageDialog(null, "El campo contrase??a no puede estar vacio");
        }
        else if(Tipo == 1)
        {
            JOptionPane.showMessageDialog(null, "No puede seleccionar el tipo Administrador");
        }
        else{
            mensaje = UserLog.actualizarUsuario(idUsuario, nombre, apellido, telefono, Tipo, username, pass);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarUsuarios();
            esconderColumnas();
            idUsuario = -1;
        }
    }
    private void tableUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsersMouseClicked
        int select = tableUsers.getSelectedRow();
        idUsuario = Integer.parseInt(tableUsers.getValueAt(select, 0).toString());
        txtNombre.setText(tableUsers.getValueAt(select, 1).toString());
        txtApellido.setText(tableUsers.getValueAt(select, 2).toString());
        txtTelefono.setText(tableUsers.getValueAt(select, 4).toString());
        txtUserName.setText(tableUsers.getValueAt(select, 5).toString());
        txtPassword.setText(tableUsers.getValueAt(select, 6).toString());
//        cmbTipo.setSelectedIndex(Integer.parseInt(tableUsers.getValueAt(select, 7).toString()));
        cmbTipo.setSelectedItem(tableUsers.getValueAt(select, 8));
    }//GEN-LAST:event_tableUsersMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        actualizar();
//        mostrarClientes();
//        esconderColumnas();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(idUsuario == -1) 
        {
            JOptionPane.showMessageDialog(null, "Debe escoger un usuario");
        }
        else if(idUsuario == 1)
        {
            JOptionPane.showMessageDialog(null, "No puede eliminar el administrador");
        }
        else if(idUsuario > 1)
        {
            String mensaje = "";
            mensaje = UserLog.eliminarUsuario(idUsuario);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarUsuarios();
            esconderColumnas();
            idUsuario = -1;
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
            java.util.logging.Logger.getLogger(frmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Tipousuario> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private javax.swing.JTable tableUsers;
    private rojeru_san.RSMTextFull txtApellido;
    private rojeru_san.RSMTextFull txtNombre;
    private rojeru_san.RSMPassView txtPassword;
    private rojeru_san.RSMTextFull txtTelefono;
    private rojeru_san.RSMTextFull txtUserName;
    // End of variables declaration//GEN-END:variables
}
