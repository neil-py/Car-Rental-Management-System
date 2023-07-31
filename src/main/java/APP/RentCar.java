/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package APP;

import LIB.Car;
import LIB.DatabaseConnection;
import LIB.Facade;
import LIB.IFacade;
import LIB.Customer;
import LIB.BookRental;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author barra
 */
public class RentCar extends javax.swing.JFrame {

    /**
     * Creates new form RentCar
     */
    public RentCar() {
        initComponents();
        update();
    }
    
    private void update(){ 
        //setting up jTable1 & jTable2 for retrieveal of data from database
        DefaultTableModel tableModel1 = (DefaultTableModel)jTable1.getModel();
        tableModel1.getDataVector().removeAllElements();
        DefaultTableModel tableModel2 = (DefaultTableModel)jTable2.getModel();
        tableModel2.getDataVector().removeAllElements();
        carIDBox.removeAllItems();
        custIDBox.removeAllItems();
        carIDBox.addItem("--- Select ---");
        custIDBox.addItem("--- Select ---");
        jDateChooser1.setCalendar(null);
        jDateChooser2.setCalendar(null);
        try{
            /*connecting to database and selecting
              CARS and CUSTOMERS table*/
            DatabaseConnection connect = DatabaseConnection.getInstance();
            try (Connection conn = connect.getConnection()) {
                Statement stmt1 = conn.createStatement();
                Statement stmt2 = conn.createStatement();
                ResultSet rs1 = stmt1.executeQuery("SELECT * FROM CARS WHERE status = 'Available';");
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM CUSTOMERS WHERE custID not in (SELECT custID FROM RENTALS WHERE status = 'Currently Rented');");
                
                /*while there is a line in the query rs1,
                retrieve the data to fetch to the jTable2*/
                while(rs1.next()){
                    String carID = String.valueOf((int)rs1.getInt("carID"));  
                    carIDBox.addItem(carID);
                    String make = rs1.getString("make");
                    String model = rs1.getString("model");
                    String type = rs1.getString("type");
                    String plateNo = rs1.getString("plateNo");
                    String year = String.valueOf((int)rs1.getInt("year"));
                    
                    String fuelType = rs1.getString("fuelType");
                    String ratePerDay = String.valueOf((double)rs1.getDouble("ratePerDay"));
                    String rowData1[] = {carID, make, model, type, plateNo, year, fuelType, ratePerDay};
                    tableModel1.addRow(rowData1);
                }
                /*while there is a line in the query rs2,
                retrieve the data to fetch to the jTable2*/
                while(rs2.next()){
                    String custID = String.valueOf((int)rs2.getInt("custID"));
                    custIDBox.addItem(custID);
                    String fname = rs2.getString("fname");
                    String lname = rs2.getString("lname");
                    String address = rs2.getString("address");
                    String contactNo = rs2.getString("contactNo");
                    String licenseNo = rs2.getString("licenseNo");
                    String rowData2[] = {custID, fname, lname, address, contactNo, licenseNo};
                    tableModel2.addRow(rowData2);
                }
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
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
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        carIDBox = new javax.swing.JComboBox<>();
        custIDBox = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Rental");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 249, 252));

        jButton1.setBackground(new java.awt.Color(26, 34, 65));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Rent");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(26, 34, 65));
        jLabel4.setText("Return Date");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(26, 34, 65));
        jLabel3.setText("Rent Date");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(26, 34, 65));
        jLabel2.setText("Customer ID");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(26, 34, 65));
        jLabel1.setText("Car ID ");

        carIDBox.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        carIDBox.setForeground(new java.awt.Color(26, 34, 65));
        carIDBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Select ---" }));
        carIDBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carIDBoxActionPerformed(evt);
            }
        });

        custIDBox.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        custIDBox.setForeground(new java.awt.Color(26, 34, 65));
        custIDBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Select ---" }));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(26, 34, 65));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(26, 34, 65));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "customerID", "First Name", "Last Name", "Address", "Contact No.", "License No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
        }

        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(26, 34, 65));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "carID", "Make", "Model", "Type", "Plate No.", "Year", "Fuel Type", "Rate/Day"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carIDBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(custIDBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(jSeparator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(carIDBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(custIDBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void carIDBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carIDBoxActionPerformed
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_carIDBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int carID = Integer.parseInt((String) carIDBox.getSelectedItem());
            int custID = Integer.parseInt((String) custIDBox.getSelectedItem());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date rentDateChoose = jDateChooser1.getDate();
            Date returnDateChoose = jDateChooser2.getDate();

            if (rentDateChoose == null || returnDateChoose == null) {
                JOptionPane.showMessageDialog(this, "ERROR: Insufficient Information!");
            } else {
                String rentDateString = sdf.format(rentDateChoose);
                String returnDateString = sdf.format(returnDateChoose);

                //facade pattern implementation
                IFacade create = new Facade(new BookRental(custID, carID,rentDateString, returnDateString));
                create.registerRental();

                //make the status in selected carID "Rented"
                try {
                    DatabaseConnection connect = DatabaseConnection.getInstance();
                    Connection conn = connect.getConnection();
                    String query = "UPDATE CARS SET status=? WHERE carID=?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, "Rented");
                    pstmt.setInt(2, carID);
                    pstmt.executeUpdate();
                        
                    String query2 = "SELECT CUSTOMERS.lname, CUSTOMERS.fname, CUSTOMERS.licenseNo, CARS.make, CARS.model, CARS.plateNO, RENTALS.totalcost, RENTALS.rentalDate, RENTALS.returnDate FROM RENTALS LEFT JOIN CUSTOMERS ON RENTALS.custID = CUSTOMERS.custID LEFT JOIN CARS ON RENTALS.carID = CARS.carID ORDER BY rentID DESC LIMIT 1;";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query2);
                    if(rs.next()){
                        String lname = rs.getString("lname");
                        String fname = rs.getString("fname");
                        String licenseNo = rs.getString("licenseNo");
                        String carMake = rs.getString("make");
                        String carModel = rs.getString("model");
                        String carPlateNo = rs.getString("plateNo");
                        String totalCost = String.valueOf(rs.getDouble("totalCost"));
                        String rentalDate = rs.getString("rentalDate");
                        String returnDate = rs.getString("returnDate");
                        String info = "Booking Successful!" + "\n" +
                                      "-------------------------------------" + "\n" +
                                      "Name: " + fname + " " + lname + "\n" +
                                      "License: " + licenseNo + "\n" +
                                      "Car: " + carMake + " - " + carModel + " - " + carPlateNo + "\n" +
                                      "Rent Duration: " + rentalDate + " - " + returnDate + "\n" +
                                      "Total Rent Cost: PHP " + totalCost;
                        JOptionPane.showMessageDialog(this, info);
                    }
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error" + e.getMessage());
                }
            }

            update();

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ERROR: Please Check Your Entries and Try Again!");
        }         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        new Menu().setVisible(true);
    }//GEN-LAST:event_formWindowClosed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> carIDBox;
    private javax.swing.JComboBox<String> custIDBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
