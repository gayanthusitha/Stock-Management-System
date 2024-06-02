package View;

import Contraller.CashierContraller;
import Contraller.DatabaseContraller;
import Model.Product;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.scene.text.TextAlignment;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;


public class CashierForm extends javax.swing.JFrame {
    
    private DefaultTableModel productTable;
    private Product selectedProduct;
    private CashierContraller cashier;
    
    private DefaultTableModel dataModelInvoice;
    private double total = 0.0;
    
    public CashierForm() {
        initComponents();
        dataModelInvoice = new DefaultTableModel(new String[]{"product_id", "product_name", "product_price", "product_qty", "product_category"}, 0);
        tblInvoice.setModel(dataModelInvoice);
        
        cashier = new CashierContraller();
        
        // Initialize your product table model
        productTable = new DefaultTableModel();
        productTable.addColumn(
                "Product_Id");
        productTable.addColumn(
                "Product_Name");
        productTable.addColumn(
                "Product_Price($)");
        productTable.addColumn(
                "Product_Qty");
        productTable.addColumn(
                "Product_Category");
        // Set the table model for your product table
        tblProduct.setModel(productTable);
        // Load product data
        loadProductData();
    }
    
    // Load product data
    private void loadProductData() {
        List<Product> products = cashier.viewProductDetails();

        // Clear existing data from the table
        productTable.setRowCount(0);

        for (Product product : products) {
            // Add the product data to the table
            productTable.addRow(new Object[]{
                product.getProductId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductQty(),
                product.getProductCategory()
            });
        }
    }
    
    private boolean isItemInInvoice(int productId) {
    for (int i = 0; i < tblInvoice.getRowCount(); i++) {
        int existingItemID = (int) tblInvoice.getValueAt(i, 0);
        if (productId == existingItemID) {
            return true;
        }
    }
    return false;
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInvoice = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAddInvoice = new javax.swing.JButton();
        spnQty = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPayment = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnRemoveInvoice = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cashier");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jPanel1.setBackground(new java.awt.Color(33, 46, 83));

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cashier Dashboard");

        btnRefresh.setBackground(new java.awt.Color(204, 204, 204));
        btnRefresh.setFont(new java.awt.Font("Georgia", 0, 15)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnLogOut.setFont(new java.awt.Font("Georgia", 0, 15)); // NOI18N
        btnLogOut.setText("LogOut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/background_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel5)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(201, 201, 201)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(202, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(33, 46, 83));
        btnSearch.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblProduct.setFont(new java.awt.Font("Georgia", 0, 15)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product_ID", "Product_Name", "Product_Price", "Qty", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        tblInvoice.setFont(new java.awt.Font("Georgia", 0, 15)); // NOI18N
        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product_ID", "Product_Name", "Product_Price($)", "Qty", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblInvoice);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Add the quantity :");

        btnAddInvoice.setBackground(new java.awt.Color(33, 46, 83));
        btnAddInvoice.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnAddInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnAddInvoice.setText("Add to Invoice");
        btnAddInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInvoiceActionPerformed(evt);
            }
        });

        spnQty.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        spnQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10000, 1));
        spnQty.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("Total : ");

        txtTotal.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Payment : ");

        txtPayment.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setText("Balance : ");

        txtBalance.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        btnCalculate.setBackground(new java.awt.Color(33, 46, 83));
        btnCalculate.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnCalculate.setForeground(new java.awt.Color(255, 255, 255));
        btnCalculate.setText("Calculate Balance");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        btnPay.setBackground(new java.awt.Color(33, 46, 83));
        btnPay.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        btnPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPayKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(60, 60, 60)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPayment)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCalculate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRemoveInvoice.setBackground(new java.awt.Color(33, 46, 83));
        btnRemoveInvoice.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnRemoveInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveInvoice.setText("Remove From Invoice");
        btnRemoveInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveInvoiceActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(33, 46, 83));
        btnPrint.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print Invoice");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRemoveInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 31, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(spnQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spnQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        loadProductData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        
        LoginForm loginform = new LoginForm();
        loginform.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnAddInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInvoiceActionPerformed

        int selectedRow = tblProduct.getSelectedRow();

        if(selectedRow != -1){
            try{
                int productId = (int) tblProduct.getValueAt(selectedRow, 0);
                String productName = (String) tblProduct.getValueAt(selectedRow, 1);
                double productPrice = (double) tblProduct.getValueAt(selectedRow, 2);
                int productQty = (int) tblProduct.getValueAt(selectedRow, 3);
                String productCategory = (String) tblProduct.getValueAt(selectedRow, 4);

                int qtyToAdd = (int) spnQty.getValue();
                int qtyFromTable = productQty;

                if(qtyToAdd <= qtyFromTable){
                    if(isItemInInvoice(productId)){
                        JOptionPane.showMessageDialog(this, "The Selecting Item is Already Added!");
                    }else{
                        int newQty = qtyFromTable - qtyToAdd;
                        double newPrice = (double) (productPrice * qtyToAdd);
                        tblProduct.setValueAt(String.valueOf(newQty),selectedRow, 3);
                        dataModelInvoice.addRow(new Object[] {productId, productName, productPrice, String.valueOf(qtyToAdd), newPrice});

                        total += (productPrice * qtyToAdd);
                        txtTotal.setText(String.valueOf(total));
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Quantity to add exceeds the available quantity in stock.");
                }

            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Invalid Quantity Format");
            }
        }
    }//GEN-LAST:event_btnAddInvoiceActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        String searchKey = txtSearch.getText();
        List<Product> searchResults = cashier.searchProduct(searchKey);

        productTable.setRowCount(0);

        for (Product product : searchResults) {
            // Add the search results to the table
            productTable.addRow(new Object[]{
                product.getProductId(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductQty(),
                product.getProductCategory()
            });
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        if (txtTotal.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Invoice Table is Empty!");
        } else if (txtPayment.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Add the Payment!");
        } else {
            double totalchk = Double.parseDouble(txtTotal.getText());
            double paychk = Double.parseDouble(txtPayment.getText());
            if (paychk < totalchk) {
                JOptionPane.showMessageDialog(this, "Payment Can't Be Less Value Than Total!\nPlease Enter Higher Value Than Total!");
            } else {
                if (txtPayment.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Payment Field is Empty!\nPlease Enter The Payment Value!");
                } else {
                    try {
                        double totalAmount = Double.parseDouble(txtTotal.getText());
                        double paymentAmount = Double.parseDouble(txtPayment.getText());
                        double balance = totalAmount - paymentAmount;

                        txtBalance.setText(String.valueOf(balance));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Please Enter Valid Numeric Values!");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void clearInvoice() {
        
        txtTotal.setText("");
        txtPayment.setText("");
        txtBalance.setText("");
    }
    
    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        if (txtBalance.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Before Make Payment");
        } else {
            if (dataModelInvoice.getRowCount() > 0) {
                try (Connection conn = DatabaseContraller.getInstance().getConnection()) {
                    conn.setAutoCommit(false);

                    String insertSalesSQL = "INSERT INTO sales (total, payment, balance) VALUES (?, ?, ?)";
                    try (PreparedStatement insertSalesStatement = conn.prepareStatement(insertSalesSQL, Statement.RETURN_GENERATED_KEYS)) {

                        double totalSaleAmount = 0.0;

                        for (int i = 0; i < dataModelInvoice.getRowCount(); i++) {
                            double price = (double) dataModelInvoice.getValueAt(i, 4);
                            totalSaleAmount += price;
                        }

                        double paymentAmount = Double.parseDouble(txtPayment.getText());
                        double balance = totalSaleAmount - paymentAmount;

                        insertSalesStatement.setDouble(1, totalSaleAmount);
                        insertSalesStatement.setDouble(2, paymentAmount);
                        insertSalesStatement.setDouble(3, balance);

                        insertSalesStatement.executeUpdate();

                        try (ResultSet generatedKeys = insertSalesStatement.getGeneratedKeys()) {
                            int salesID = -1;
                            if (generatedKeys.next()) {
                                salesID = generatedKeys.getInt(1);
                            }
                            
                            String insertSaleItemsSQL = "INSERT INTO saleitems (sales_id, product_id, product_qty, product_price) VALUES (?, ?, ?, ?)";
                            try (PreparedStatement insertSaleItemsStatement = conn.prepareStatement(insertSaleItemsSQL)) {
                                
                                for (int i = 0; i < dataModelInvoice.getRowCount(); i++) {
                                    int itemID = (int) dataModelInvoice.getValueAt(i, 0);
                                    int quantity = Integer.parseInt((String) dataModelInvoice.getValueAt(i, 3));
                                    double price = (double) dataModelInvoice.getValueAt(i, 4);

                                    insertSaleItemsStatement.setInt(1, salesID);
                                    insertSaleItemsStatement.setInt(2, itemID);
                                    insertSaleItemsStatement.setInt(3, quantity);
                                    insertSaleItemsStatement.setDouble(4, price);

                                    insertSaleItemsStatement.executeUpdate();

                                    String updateProductsSQL = "UPDATE product SET product_qty = product_qty - ? WHERE product_id = ?";
                                    try (PreparedStatement updateProductsStatement = conn.prepareStatement(updateProductsSQL)) {
                                        updateProductsStatement.setInt(1, quantity);
                                        updateProductsStatement.setInt(2, itemID);
                                        updateProductsStatement.executeUpdate();
                                    }
                                }                    
                            }
                        }
                    }
                    conn.commit();
                    txtTotal.setText("");
                    txtPayment.setText("");
                    txtBalance.setText("");
                    loadProductData();
                    JOptionPane.showMessageDialog(this, "Payment successful!");
                } catch (SQLException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Payment unsuccessful! Please check the fields.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No items in the invoice table. Please add products first!");
            }
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnPayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPayKeyPressed
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_DECIMAL)) {
            txtPayment.setEditable(true);
        } else {
            txtPayment.setEditable(false);
        }
    }//GEN-LAST:event_btnPayKeyPressed

    private void btnRemoveInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveInvoiceActionPerformed
        int selectedRow = tblInvoice.getSelectedRow();
        if (selectedRow != -1) {
            double price = (double) tblInvoice.getValueAt(selectedRow, 4);
            dataModelInvoice.removeRow(selectedRow);

            total -= price;
            txtTotal.setText(String.valueOf(total));
        } else {
            JOptionPane.showMessageDialog(this, "Please Select A Product!");
        }
    }//GEN-LAST:event_btnRemoveInvoiceActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

          String path = "";
          JFileChooser j = new JFileChooser();
          j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
          int x = j.showSaveDialog(this);
          if(x == JFileChooser.APPROVE_OPTION)
          {
              path = j.getSelectedFile().getPath();
          }
          com.lowagie.text.Document doc = new com.lowagie.text.Document();
          try{
              PdfWriter.getInstance(doc, new FileOutputStream(path +"Invoice.pdf"));
              doc.open();
              PdfPTable tbl = new PdfPTable(5);
              tbl.addCell("Product_ID");
              tbl.addCell("Product_Name");
              tbl.addCell("Product_Price");
              tbl.addCell("Product_Qty");
              tbl.addCell("Product_Category");
              for(int i=0; i< tblInvoice.getRowCount(); i++){
                  String FN = tblInvoice.getValueAt(i, 0).toString();
                  String LN = tblInvoice.getValueAt(i, 1).toString();
                  String DN = tblInvoice.getValueAt(i, 2).toString();
                  String CN = tblInvoice.getValueAt(i, 3).toString();
                  String EN = tblInvoice.getValueAt(i, 4).toString();
                  tbl.addCell(FN);
                  tbl.addCell(LN);
                  tbl.addCell(DN);
                  tbl.addCell(CN);
                  tbl.addCell(EN);
              }
              doc.add(tbl);
              JOptionPane.showMessageDialog(null, "PDF Generated");
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Some thing went wrong");
          }
          doc.close();
          
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(CashierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashierForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInvoice;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemoveInvoice;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnQty;
    private javax.swing.JTable tblInvoice;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtPayment;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
