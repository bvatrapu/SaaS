package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.PageTemplates;


import com.saptool.frameworkbuilder.FrameworkBuilder;
import com.saptool.frameworkbuilder.PageBuilder;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class CreateVariable extends javax.swing.JFrame {

    /**
     * Creates new form CreateVariable
     */
    public CreateVariable() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        txtSelectDataType = new javax.swing.JLabel();
        comboDataType = new javax.swing.JComboBox<>();
        txtEnterName = new javax.swing.JLabel();
        txtEnterValue = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        inputValue = new javax.swing.JTextField();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        txtSelectDataType.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtSelectDataType.setForeground(new java.awt.Color(153, 51, 255));
        txtSelectDataType.setText("Select DataType:");

        comboDataType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "String", "int", "float", "char", "boolean" }));

        txtEnterName.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtEnterName.setForeground(new java.awt.Color(153, 51, 255));
        txtEnterName.setText("Enter Name:");

        txtEnterValue.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtEnterValue.setForeground(new java.awt.Color(153, 51, 255));
        txtEnterValue.setText("Enter Value");


        UI_Design.button_ui_style_violet(btnAdd,"Add");
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 20));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClose.setBorder(null);
        btnClose.setFocusPainted(false);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtSelectDataType)
                                                        .addComponent(txtEnterName)
                                                        .addComponent(txtEnterValue))
                                                .addGap(29, 29, 29)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboDataType, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(198, 198, 198)
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboDataType)
                                        .addComponent(txtSelectDataType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEnterName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtEnterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.template_create_Variable=false;
        dispose();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String strVar=null;
        if(!StringUtils.isEmpty(inputName.getText())){
            if(StringUtils.isEmpty(inputValue.getText())) {
                strVar = comboDataType.getSelectedItem().toString() + " " + inputName.getText()+ " = null;";
            } else{
                strVar = comboDataType.getSelectedItem().toString() + " " + inputName.getText()+ " = "+"\""+inputValue.getText()+"\""+";";
            }
            String pagePath = GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java";
            String readPageModel = Generic.readText(pagePath);

            if(readPageModel.contains(comboDataType.getSelectedItem().toString() + " " + inputName.getText())){
                JOptionPane.showMessageDialog(null,"Variable "+inputName.getText()+" Already declared");
            } else{
                PageBuilder.pageBuilder(strVar,"VARIABLE");
                Frame_Flag.template_create_Variable=false;
                dispose();
            }

        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateVariable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox<String> comboDataType;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputValue;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel txtEnterName;
    private javax.swing.JLabel txtEnterValue;
    private javax.swing.JLabel txtSelectDataType;
    // End of variables declaration
}

