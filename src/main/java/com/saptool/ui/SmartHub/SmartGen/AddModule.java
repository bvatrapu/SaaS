package com.saptool.ui.SmartHub.SmartGen;


import com.saptool.ui.Frame_Flag;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author bvatrapu
 */
public class AddModule extends JFrame {

    /**
     * Creates new form AddModule
     */
    public AddModule() {
        initComponents();
    }


    private void initComponents() {

        inputModuleName = new JTextField();
        btnCreate = new JButton();
        txtModuleName = new JLabel();


        setTitle("AddModule");
        setLocationRelativeTo(null);
        inputModuleName.setFont(new java.awt.Font("Tahoma", 1, 18));
        inputModuleName.setForeground(new java.awt.Color(0, 0, 153));


        UI_Design.button_ui_style_violet(btnCreate,"Create");
        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        txtModuleName.setText("Test Type:     ");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(165, 165, 165)
                                                .addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtModuleName)
                                                        .addComponent(inputModuleName, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtModuleName)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputModuleName, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
        createFolder(GlobalConstants.SELECTED_PROJECT_PATH+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+inputModuleName.getText().toLowerCase());
        createFolder(GlobalConstants.SELECTED_PROJECT_PATH+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTDATA_FOLDER+File.separator+inputModuleName.getText().toLowerCase());
        NewTestScript.initLoad();
        NewTestScript.comboSelectTestType.setSelectedItem(inputModuleName.getText());
       // Frame_Flag.smartGen_NewTestScript_AddTestType=false;
        dispose();
    }

    public void createFolder(String dirPath){
        try {
            File file = new File(dirPath);
            if (file.exists()) {
                JOptionPane.showMessageDialog(null, inputModuleName.getText()+"  Already Exists..", "Warning " , JOptionPane.INFORMATION_MESSAGE);
            } else {
                file.mkdir();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton btnCreate;
    private JTextField inputModuleName;
    private JLabel txtModuleName;
    // End of variables declaration
}

