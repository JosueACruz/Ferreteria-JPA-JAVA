/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjerusalen;

import BusinessLogic.Productos;
import java.math.BigDecimal;
import javax.swing.JTable;

/**
 *
 * @author Josue
 */
public class frmReportesProductos extends javax.swing.JFrame {

    private Productos ProLog = new Productos();
    private int idC;
    public frmReportesProductos() {
        initComponents();
        mostrarProductos();
    }
    
    private void mostrarProductos(){
        ProLog.listarProducto2(tableProduct);
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
        btnGeneral = new javax.swing.JButton();
        txtNombre = new rojeru_san.RSMTextFull();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        cmbOpciones = new javax.swing.JComboBox<>();

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
        jLabel1.setText("Reportes de Productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        lblNombre.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, -1, -1));

        lblApellido.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, -1, -1));

        lblTelefono.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        btnGeneral.setBackground(new java.awt.Color(26, 26, 46));
        btnGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneral.setText("General Reporte");
        btnGeneral.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btnGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, 170, 50));

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

        tableProduct =new JTable()
        {
            public boolean isCellEditable(int row, int column)
            {
                for (int i = 0; 1< tableProduct.getRowCount(); i++)
                {
                    if(row == i)
                    {
                        return false;
                    }
                }
                return true;
            }
        };
        tableProduct.setBackground(new java.awt.Color(45, 55, 99));
        tableProduct.setForeground(new java.awt.Color(255, 255, 255));
        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripcion", "Stock", "Precio Venta", "Fecha de Ingreso", "Marca", "Categoria", "Costo", "Lote"
            }
        ));
        tableProduct.setFocusable(false);
        tableProduct.setGridColor(new java.awt.Color(153, 153, 153));
        tableProduct.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableProduct.setRowHeight(25);
        tableProduct.setSelectionBackground(new java.awt.Color(47, 63, 128));
        tableProduct.setShowVerticalLines(false);
        tableProduct.getTableHeader().setReorderingAllowed(false);
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduct);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 780, 450));

        cmbOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos en general", "Productos por nombre", "Productos por categoria", "Productos por lote", "Productos por proveedor", "Productos por Fecha de Ingreso", "Productos Por Precio Venta", "Productos Por precio Compra", "Productos Por cantidad de productos", "Productos mas vendidos" }));
        jPanel1.add(cmbOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 280, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 1190, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralActionPerformed
        String valor = (String) cmbOpciones.getSelectedItem();
        String nombre = txtNombre.getText();
        if(valor=="Productos en general"){
            ProLog.ReporteGeneral();
        }else if(valor=="Productos por nombre"){
            ProLog.ReportePorNombre(nombre);
        }else if(valor=="Productos por categoria"){
            ProLog.ProductoCategoria(nombre);
        }else if(valor=="Productos por lote"){
            ProLog.ReporteLote(nombre);
        }else if(valor=="Productos por Fecha de Ingreso"){
            ProLog.ProductoFechaIngre(nombre);
        }else if(valor=="Productos Por Precio Venta"){
            ProLog.ProductoPreVenta(nombre);
        }else if(valor=="Productos Por precio Compra"){
            ProLog.ProductoPreCompra(nombre);
        }else if(valor=="Productos Por cantidad de productos"){
            ProLog.ProductoCantidad(nombre);
        }else if(valor=="Productos por proveedor"){
            ProLog.ProductoProveedor(nombre);
        }else if(valor=="Productos mas vendidos"){
            ProLog.ProductoMasVendido();
        }
    }//GEN-LAST:event_btnGeneralActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // Validar que solo escriba letras
        //Esta funcion se encuentra en los eventos del txtApellido en event con el nombre de KeyTyped
    }//GEN-LAST:event_txtNombreKeyTyped

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        String valor = (String) cmbOpciones.getSelectedItem();
        if(valor=="Productos en general"){
            int select=tableProduct.getSelectedRow();
            idC = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 1).toString());
        }else if(valor=="Productos por nombre"){
            int select=tableProduct.getSelectedRow();
            idC = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 1).toString());
        }else if(valor=="Productos por categoria"){
            int select=tableProduct.getSelectedRow();
            idC = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 6).toString());
        }else if(valor=="Productos por lote"){
            int select=tableProduct.getSelectedRow();
            idC = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 12).toString());
        }else if(valor=="Productos por Fecha de Ingreso"){
            int select=tableProduct.getSelectedRow();
            idC = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 8).toString());
        }else if(valor=="Productos Por Precio Venta"){
            int select=tableProduct.getSelectedRow();
            idC = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 7).toString());
        }else if(valor=="Productos Por precio Compra"){
            int select=tableProduct.getSelectedRow();
            idC = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 9).toString());
        }else if(valor=="Productos Por cantidad de productos"){
            int select=tableProduct.getSelectedRow();
            idC = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 10).toString());
        }        
    }//GEN-LAST:event_tableProductMouseClicked

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
            java.util.logging.Logger.getLogger(frmReportesProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReportesProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReportesProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReportesProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReportesProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCerrar;
    private javax.swing.JButton btnGeneral;
    private javax.swing.JComboBox<String> cmbOpciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tableProduct;
    private rojeru_san.RSMTextFull txtNombre;
    // End of variables declaration//GEN-END:variables
}
