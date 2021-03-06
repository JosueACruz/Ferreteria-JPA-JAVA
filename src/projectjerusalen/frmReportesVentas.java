/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjerusalen;

import BusinessLogic.VentaLogic;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue
 */
public class frmReportesVentas extends javax.swing.JFrame {

    VentaLogic ven = new VentaLogic();
    int idVenta = 0;
    public frmReportesVentas() {
        initComponents();
        mostrarCompra();
    }
    private void mostrarCompra(){
        ven.listarVentas(tableVentas);
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
        btnRango = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        btnGeneral = new javax.swing.JButton();
        btnDetalle = new javax.swing.JButton();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btnPorFecha = new javax.swing.JButton();
        txtMes = new rojeru_san.RSMTextFull();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

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
        jLabel1.setText("Reportes de Ventas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, -1, -1));

        lblNombre.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, -1, -1));

        lblApellido.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, -1, -1));

        lblTelefono.setForeground(new java.awt.Color(233, 69, 96));
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        btnRango.setBackground(new java.awt.Color(26, 26, 46));
        btnRango.setForeground(new java.awt.Color(255, 255, 255));
        btnRango.setText("Ver");
        btnRango.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRangoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 160, 40));

        tableVentas.setBackground(new java.awt.Color(45, 55, 99));
        tableVentas.setForeground(new java.awt.Color(255, 255, 255));
        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Fecha", "Usuario", "TipoVenta", "Total"
            }
        ));
        tableVentas.setFocusable(false);
        tableVentas.setGridColor(new java.awt.Color(153, 153, 153));
        tableVentas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableVentas.setRowHeight(25);
        tableVentas.setSelectionBackground(new java.awt.Color(47, 63, 128));
        tableVentas.setShowVerticalLines(false);
        tableVentas.getTableHeader().setReorderingAllowed(false);
        tableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 690, 450));

        btnGeneral.setBackground(new java.awt.Color(26, 26, 46));
        btnGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnGeneral.setText("General");
        btnGeneral.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralActionPerformed(evt);
            }
        });
        jPanel1.add(btnGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, 150, 40));

        btnDetalle.setBackground(new java.awt.Color(26, 26, 46));
        btnDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalle.setText("Detalle de compra");
        btnDetalle.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });
        jPanel1.add(btnDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 200, 150, 40));

        jDateFecha.setName("JDateFecha"); // NOI18N
        jPanel1.add(jDateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 280, 200, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mes:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, -1, -1));

        btnPorFecha.setBackground(new java.awt.Color(26, 26, 46));
        btnPorFecha.setForeground(new java.awt.Color(255, 255, 255));
        btnPorFecha.setText("Por Fecha");
        btnPorFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorFechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnPorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 340, 150, 40));

        txtMes.setBackground(new java.awt.Color(22, 33, 62));
        txtMes.setForeground(new java.awt.Color(255, 255, 255));
        txtMes.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtMes.setBotonColor(new java.awt.Color(255, 255, 255));
        txtMes.setPlaceholder("");
        txtMes.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 200, 40));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, 240, 180));

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 240, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 1190, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasMouseClicked
        int select = tableVentas.getSelectedRow();
        idVenta = Integer.parseInt(tableVentas.getValueAt(select,0).toString());
    }//GEN-LAST:event_tableVentasMouseClicked

    private void btnRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRangoActionPerformed
        String mes = txtMes.getText();
        if(txtMes.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un mes para generar el reporte 'MM/YYYY'");
        }
        else{
            ven.ReportePorMes(mes);
        }
    }//GEN-LAST:event_btnRangoActionPerformed

    private void btnGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralActionPerformed
        ven.ReporteGeneral();
    }//GEN-LAST:event_btnGeneralActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        if(idVenta == 0)
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una compra");
        }
        else{
            ven.ReportePorID(idVenta);
        }  
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorFechaActionPerformed
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dFormat.format(jDateFecha.getDate());
        if(date.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Dede seleccionar una fecha");
        }
        else{
            ven.ReportePorFecha(date);
        }
    }//GEN-LAST:event_btnPorFechaActionPerformed

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
            java.util.logging.Logger.getLogger(frmReportesVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReportesVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReportesVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReportesVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReportesVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCerrar;
    private javax.swing.JButton btnDetalle;
    private javax.swing.JButton btnGeneral;
    private javax.swing.JButton btnPorFecha;
    private javax.swing.JButton btnRango;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tableVentas;
    private rojeru_san.RSMTextFull txtMes;
    // End of variables declaration//GEN-END:variables
}
