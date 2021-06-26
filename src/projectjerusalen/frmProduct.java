/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjerusalen;

import BusinessLogic.Productos;
import BusinessLogic.sesion;
import Entidad.Categoria;
import Entidad.Lotes;
import Entidad.Marca;
import Entidad.Unidaddemedida;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class frmProduct extends javax.swing.JFrame {

    ///Hay un bug en el combobox, al escoger el primer lote lo toma como nulo.
    
    /**
     * Creates new form frmUsers
     */
    private Productos prod = new Productos();
    private sesion ses = new sesion();
    private int idP = -1;
    
    Locale loc = new Locale("es", "SV");
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
    //
    public frmProduct() {
        initComponents();
        listarProductos();
        llenarCategoria(cmbCategoria);
        llenarLote(cmbLotes);
        llenarMarca(cmbMarca);
        llenarUnidad(cmbUnidad);
        esconderColumnas();
        String date = dateFormat.format(new Date());
        //Date fech = new Date();
        txtFecha.setText(date);
        txtFecha.disable();
    }
    ////Aqui estoy sobrecargando el formulario para que reciva los datos del fromulario compra
    //para la compra
    JTextField product;
    JTextField descrip;
    JTextField lot;
    
    //para la venta
    JTextField prodVent;
    JTextField stockVent;
    JTextField precioVent;
    public frmProduct(JTextField producto,JTextField descripcion ,JTextField lote)
    {
        initComponents();
        //Los metodos del propio formulario
        listarProductos();
        llenarCategoria(cmbCategoria);
        llenarLote(cmbLotes);
        llenarMarca(cmbMarca);
        llenarUnidad(cmbUnidad);
        esconderColumnas();
        String date = dateFormat.format(new Date());
        //Date fech = new Date();
        txtFecha.setText(date);
        txtFecha.disable();
        //prod.forzardenuevo(tableProduct);
        //Los datos que le estan llegando desde la compra
        if(sesion.CProducto.equals("VoyDeCompra"))
        {
            product = producto;
            descrip = descripcion;
            lot = lote;           
        }
        else if(sesion.CProducto.equals("VoyDeVenta"))
        {
            prodVent = producto;
            stockVent = descripcion;
            precioVent = lote;
        }

    }
    private void esconderColumnas(){
        //Ocultando columnas
        //id Marca
        tableProduct.getColumnModel().getColumn(3).setMaxWidth(0);
        tableProduct.getColumnModel().getColumn(3).setMinWidth(0);
        tableProduct.getColumnModel().getColumn(3).setPreferredWidth(0);
        //id CAtegoria
        tableProduct.getColumnModel().getColumn(5).setMaxWidth(0);
        tableProduct.getColumnModel().getColumn(5).setMinWidth(0);
        tableProduct.getColumnModel().getColumn(5).setPreferredWidth(0);
        //id Lote
        tableProduct.getColumnModel().getColumn(11).setMaxWidth(0);
        tableProduct.getColumnModel().getColumn(11).setMinWidth(0);
        tableProduct.getColumnModel().getColumn(11).setPreferredWidth(0);
        //id Unidad de medida
        tableProduct.getColumnModel().getColumn(13).setMaxWidth(0);
        tableProduct.getColumnModel().getColumn(13).setMinWidth(0);
        tableProduct.getColumnModel().getColumn(13).setPreferredWidth(0);
    }
    private void listarProductos()
    {
        //Cambiar la forma de traer los datos para traer todos los id, pero tambien los nombres de cat, lotes etc..
        //y esconder la culumna esa en que aparezca el id, y extraer el id para los insert y cosas asi
        prod.listarProducto2(tableProduct);  
    }
    private void llenarCategoria(JComboBox cmbCategoria)
    {
        prod.listarCategoriacmb(cmbCategoria);
    }
    private void llenarLote(JComboBox cmbLotes)
    {
        prod.listarLotecmb(cmbLotes);
    }
    private void llenarMarca(JComboBox cmbMarca)
    {
        prod.listarMarcacmb(cmbMarca);
    }
    private void llenarUnidad(JComboBox cmbUnidad)
    {
        prod.listarUnidadcmb(cmbUnidad);
    }

//        tableProduct.addMouseListener(new java.awt.event.MouseAdapter(){
//        public void mouseClicked(java.awt.event.MouseEvent e){
//            if(e.getClickCount()==2){
//                int select = tableProduct.getSelectedRow();
//                sesion.idProductoCompra = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
//                product.setText(tableProduct.getValueAt(select, 1).toString());
//                descrip.setText(tableProduct.getValueAt(select, 2).toString());
//                lot.setText(tableProduct.getValueAt(select, 12).toString());
//            }
//        }
//        });

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new rojeru_san.RSMTextFull();
        txtStock = new rojeru_san.RSMTextFull();
        txtFecha = new rojeru_san.RSMTextFull();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new rojeru_san.RSMTextFull();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new rojeru_san.RSMTextFull();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbLotes = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbMarca = new javax.swing.JComboBox<>();
        cmbUnidad = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCosto = new rojeru_san.RSMTextFull();

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
        jLabel1.setText("PRODUCTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Lote:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 100, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripcion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de Ingreso:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));

        txtDescripcion.setBackground(new java.awt.Color(22, 33, 62));
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtDescripcion.setBotonColor(new java.awt.Color(255, 255, 255));
        txtDescripcion.setPlaceholder("");
        txtDescripcion.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 290, -1));

        txtStock.setBackground(new java.awt.Color(22, 33, 62));
        txtStock.setForeground(new java.awt.Color(255, 255, 255));
        txtStock.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtStock.setBotonColor(new java.awt.Color(255, 255, 255));
        txtStock.setPlaceholder("");
        txtStock.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 150, -1));

        txtFecha.setBackground(new java.awt.Color(22, 33, 62));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtFecha.setBotonColor(new java.awt.Color(255, 255, 255));
        txtFecha.setPlaceholder("");
        txtFecha.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 200, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 1010, 200));

        btnGuardar.setBackground(new java.awt.Color(26, 26, 46));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 150, 40));

        btnEditar.setBackground(new java.awt.Color(26, 26, 46));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 150, 40));

        btnEliminar.setBackground(new java.awt.Color(26, 26, 46));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(233, 69, 96)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 150, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Categoria:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 110, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Stock:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        txtPrecio.setBackground(new java.awt.Color(22, 33, 62));
        txtPrecio.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecio.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtPrecio.setBotonColor(new java.awt.Color(255, 255, 255));
        txtPrecio.setPlaceholder("");
        txtPrecio.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 200, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Precio de Venta:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        txtNombre.setBackground(new java.awt.Color(22, 33, 62));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtNombre.setBotonColor(new java.awt.Color(255, 255, 255));
        txtNombre.setPlaceholder("");
        txtNombre.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 290, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Marca:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 110, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Costo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 110, -1));

        cmbLotes.setBackground(new java.awt.Color(22, 33, 62));
        cmbLotes.setEditable(true);
        cmbLotes.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cmbLotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 230, -1));

        cmbCategoria.setBackground(new java.awt.Color(22, 33, 62));
        cmbCategoria.setEditable(true);
        cmbCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 230, -1));

        cmbMarca.setBackground(new java.awt.Color(22, 33, 62));
        cmbMarca.setEditable(true);
        cmbMarca.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cmbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 230, -1));

        cmbUnidad.setBackground(new java.awt.Color(22, 33, 62));
        cmbUnidad.setEditable(true);
        cmbUnidad.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(cmbUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 170, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Unidad de medida:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 170, -1));
        jLabel11.getAccessibleContext().setAccessibleName("Unidaddemedida:");

        txtCosto.setBackground(new java.awt.Color(22, 33, 62));
        txtCosto.setForeground(new java.awt.Color(255, 255, 255));
        txtCosto.setBordeColorFocus(new java.awt.Color(255, 255, 255));
        txtCosto.setBotonColor(new java.awt.Color(255, 255, 255));
        txtCosto.setPlaceholder("");
        txtCosto.setSelectionColor(new java.awt.Color(0, 112, 192));
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 250, -1));

        rSPanelShadow1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(rSPanelShadow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1190, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        if(sesion.CProducto.equals("VoyDeCompra"))
        {
            if(evt.getClickCount() == 1)
            {
                int select = tableProduct.getSelectedRow();
                idP = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
                txtNombre.setText(tableProduct.getValueAt(select, 1).toString());
                txtDescripcion.setText(tableProduct.getValueAt(select, 2).toString());
                cmbMarca.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 3).toString()));
                cmbCategoria.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 5).toString()));
                txtPrecio.setText(tableProduct.getValueAt(select, 7).toString());
                txtFecha.setText(tableProduct.getValueAt(select, 8).toString());
                txtCosto.setText(tableProduct.getValueAt(select, 9).toString());
                txtStock.setText(tableProduct.getValueAt(select, 10).toString());
                cmbLotes.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 11).toString()));
                cmbUnidad.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 13).toString()));

            }
            else if(evt.getClickCount() == 2)
            {
                int select = tableProduct.getSelectedRow();
                sesion.idProductoCompra = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
                product.setText(tableProduct.getValueAt(select, 1).toString());
                descrip.setText(tableProduct.getValueAt(select, 2).toString());
                lot.setText(tableProduct.getValueAt(select, 12).toString());
                this.dispose();
                sesion.CProducto = "";
            }
        }
        else if(sesion.CProducto.equals("VoyDeVenta"))
        {
            if(evt.getClickCount() == 1)
            {
                int select = tableProduct.getSelectedRow();
                idP = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
                txtNombre.setText(tableProduct.getValueAt(select, 1).toString());
                txtDescripcion.setText(tableProduct.getValueAt(select, 2).toString());
                cmbMarca.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 3).toString()));
                cmbCategoria.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 5).toString()));
                txtPrecio.setText(tableProduct.getValueAt(select, 7).toString());
                txtFecha.setText(tableProduct.getValueAt(select, 8).toString());
                txtCosto.setText(tableProduct.getValueAt(select, 9).toString());
                txtStock.setText(tableProduct.getValueAt(select, 10).toString());
                cmbLotes.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 11).toString()));
                cmbUnidad.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 13).toString()));

            }
            else if(evt.getClickCount() == 2)
            {
                int select = tableProduct.getSelectedRow();
                sesion.idProductoVenta = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
                prodVent.setText(tableProduct.getValueAt(select, 1).toString());
                stockVent.setText(tableProduct.getValueAt(select, 10).toString());
                precioVent.setText(tableProduct.getValueAt(select, 7).toString());
                this.dispose();
                sesion.CProducto = "";
            }          
        }
        else if (sesion.CProducto.equals("VoyDeMenu"))
        {
            int select = tableProduct.getSelectedRow();
            idP = Integer.parseInt(tableProduct.getValueAt(select, 0).toString());
            txtNombre.setText(tableProduct.getValueAt(select, 1).toString());
            txtDescripcion.setText(tableProduct.getValueAt(select, 2).toString());
            cmbMarca.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 3).toString()));
            cmbCategoria.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 5).toString()));
            txtPrecio.setText(tableProduct.getValueAt(select, 7).toString());
            txtFecha.setText(tableProduct.getValueAt(select, 8).toString());
            txtCosto.setText(tableProduct.getValueAt(select, 9).toString());
            txtStock.setText(tableProduct.getValueAt(select, 10).toString());
            cmbLotes.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 11).toString()));
            cmbUnidad.setSelectedIndex(Integer.parseInt(tableProduct.getValueAt(select, 13).toString()));
        }

    }//GEN-LAST:event_tableProductMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        try {
            String mensaje = "";
            String nom = txtNombre.getText();
            String desc = txtDescripcion.getText();
            Double sto = Double.parseDouble(txtStock.getText());
            Date fech = dateFormat.parse(txtFecha.getText());
            //Date fech = new Date();
            Double pr = Double.parseDouble(txtPrecio.getText());
            Double cos = Double.parseDouble(txtCosto.getText());
            int cat = cmbCategoria.getSelectedIndex();
            int marc = cmbMarca.getSelectedIndex();
            int lot = cmbLotes.getSelectedIndex();
            int unid = cmbUnidad.getSelectedIndex();
            mensaje = prod.insertarProducto(nom, desc, pr, fech, cos, sto, cat, marc, lot, unid);
            JOptionPane.showMessageDialog(null,mensaje);
            listarProductos();
            esconderColumnas();
        } catch (ParseException ex) {
            Logger.getLogger(frmProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (idP == -1)
        {
            JOptionPane.showMessageDialog(null, "Debe escoger un producto para eliminar");
        }
        else if(idP > -1)
        {
            String mensaje = "";
            mensaje = prod.eliminarProducto(idP);
            JOptionPane.showMessageDialog(null, mensaje);
            listarProductos();
            esconderColumnas();
            idP = -1; 
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //try {
            String mensaje = "";
            String nom = txtNombre.getText();
            String desc = txtDescripcion.getText();
            Double sto = Double.parseDouble(txtStock.getText());
            //Date fech = dateFormat.parse(txtFecha.getText());
            Date fech = new Date();
            Double pr = Double.parseDouble(txtPrecio.getText());
            Double cos = Double.parseDouble(txtCosto.getText());
            int cat = cmbCategoria.getSelectedIndex();
            int marc = cmbMarca.getSelectedIndex();
            int lot = cmbLotes.getSelectedIndex();
            int unid = cmbUnidad.getSelectedIndex();
            if(idP == -1)
            {
                JOptionPane.showMessageDialog(null, "Debe escoger un producto para eliminar");
            }
            else if(idP >-1)
            {
                mensaje = prod.actualizarProducto(idP, nom, desc, pr, fech, cos, sto, cat, marc, lot, unid);
                JOptionPane.showMessageDialog(null, mensaje);
                prod.limpiarModelo(tableProduct);
                //prod.listarProductoDeNuevo(tableProduct);
                listarProductos();
                esconderColumnas();
                idP = -1;
            }
//        } catch (ParseException ex) {
//            Logger.getLogger(frmProduct.class.getName()).log(Level.SEVERE, null, ex);
//        }        
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(frmProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Categoria> cmbCategoria;
    private javax.swing.JComboBox<Lotes> cmbLotes;
    private javax.swing.JComboBox<Marca> cmbMarca;
    private javax.swing.JComboBox<Unidaddemedida> cmbUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.RSPanelShadow rSPanelShadow1;
    private javax.swing.JTable tableProduct;
    private rojeru_san.RSMTextFull txtCosto;
    private rojeru_san.RSMTextFull txtDescripcion;
    private rojeru_san.RSMTextFull txtFecha;
    private rojeru_san.RSMTextFull txtNombre;
    private rojeru_san.RSMTextFull txtPrecio;
    private rojeru_san.RSMTextFull txtStock;
    // End of variables declaration//GEN-END:variables
}
