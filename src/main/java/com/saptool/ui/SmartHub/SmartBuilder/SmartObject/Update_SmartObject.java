package com.saptool.ui.SmartHub.SmartBuilder.SmartObject;


import com.saptool.frameworkbuilder.PageBuilder;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Update_SmartObject extends javax.swing.JFrame {

    /**
     * Creates new form New_SmartObject
     */
    public Update_SmartObject() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtObjectName = new javax.swing.JLabel();
        inputObjectName = new javax.swing.JLabel();
        txtObjectValue = new javax.swing.JLabel();
        inputvalue = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnObjectSpy = new javax.swing.JButton();
        rbID = new javax.swing.JRadioButton();
        rbXpath = new javax.swing.JRadioButton();
        rbCSS = new javax.swing.JRadioButton();


        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtObjectName.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtObjectName.setForeground(new java.awt.Color(153, 0, 255));
        txtObjectName.setText("Object Name:");

       // inputObjectName.setEditable(true);

        txtObjectValue.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtObjectValue.setForeground(new java.awt.Color(153, 0, 255));
        txtObjectValue.setText("Value: ");

        inputvalue.setToolTipText("");

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnUpdate.setForeground(new java.awt.Color(153, 0, 153));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnObjectSpy.setBackground(new java.awt.Color(255, 255, 255));
        btnObjectSpy.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnObjectSpy.setForeground(new java.awt.Color(153, 0, 153));
        btnObjectSpy.setText("Object Fire");
        btnObjectSpy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObjectSpyActionPerformed(evt);
            }
        });

        rbID.setBackground(new java.awt.Color(255, 255, 255));
        rbID.setSelected(true);
        rbID.setText("ID");

        rbXpath.setBackground(new java.awt.Color(255, 255, 255));
        rbXpath.setText("XPATH");

        rbCSS.setBackground(new java.awt.Color(255, 255, 255));
        rbCSS.setText("CSS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtObjectName)
                                                .addGap(18, 18, 18)
                                                .addComponent(inputObjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 26, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtObjectValue)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(inputvalue)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnObjectSpy, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(87, 87, 87)))))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(rbID)
                                .addGap(114, 114, 114)
                                .addComponent(rbXpath)
                                .addGap(107, 107, 107)
                                .addComponent(rbCSS)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtObjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputObjectName))
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbID)
                                        .addComponent(rbXpath)
                                        .addComponent(rbCSS))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtObjectValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(202, 202, 202))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(inputvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnObjectSpy, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(55, 55, 55))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void init_Load(){

        inputObjectName.setText(GlobalConstants.SELECTED_PAGE_OBJECT);
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"Under Development !!!");
//        String pageObjectmodel=null;
//        String findby=null;
//        String webelement=null;
//        String val=inputObjectName.getText();
//
//        PageBuilder.updatepageObjectBuilder(val,inputvalue.getText());
//        switch (getIdetifier().toUpperCase()){
//            case "ID":
//                findby = "@FindBy(id=" + val + ")";
//                break;
//
//            case "XPATH":
//                findby = "@FindBy(xpath = " + val + ")";
//                break;
//
//            case "CSS":
//                findby = "@FindBy(css = " + val + ")";
//                break;
//        }
    }

    private void btnObjectSpyActionPerformed(java.awt.event.ActionEvent evt) {
        Generic.openFile(GlobalConstants.SAP_OBJECT_SPY_TOOL);
    }
    public String getIdetifier(){
        if(rbID.isSelected()){
            return rbID.getText();
        }else if(rbCSS.isSelected()){
            return rbCSS.getText();
        } else{
            return rbXpath.getText();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_SmartObject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnObjectSpy;
    private javax.swing.JButton btnUpdate;
    public static javax.swing.JLabel inputObjectName;
    private javax.swing.JTextField inputvalue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbCSS;
    private javax.swing.JRadioButton rbID;
    private javax.swing.JRadioButton rbXpath;
    private javax.swing.JLabel txtObjectName;
    private javax.swing.JLabel txtObjectValue;
    // End of variables declaration
}
