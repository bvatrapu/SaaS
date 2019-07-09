package com.saptool.ui.Projects.config;


import com.saptool.frameworkbuilder.FrameworkBuilder;
import com.saptool.ui.Init;
import com.saptool.ui.Projects.ConfigProjectTestParamValues;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import jdk.nashorn.internal.objects.Global;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ConfigParameterNames extends javax.swing.JPanel {

    /**
     * Creates new form RenameProject
     */
    public ConfigParameterNames() {
        initComponents();
    }


    private void initComponents() {

        txtxTestParameter = new javax.swing.JLabel();
        inputTestParameter = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listParamNames = new javax.swing.JList<>();
        btnCreate = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtxTestParameter.setFont(new java.awt.Font("Tahoma", 1, 20));
        txtxTestParameter.setText("Test Parameter: ");

        inputTestParameter.setFont(new java.awt.Font("Tahoma", 0, 20));
        inputTestParameter.setForeground(new java.awt.Color(153, 153, 153));


        UI_Design.button_ui_style_violet(btnAdd,"Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        UI_Design.button_ui_style_violet(btnRemove,"Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        listParamNames.setFont(new java.awt.Font("Tahoma", 1, 20));
        listParamNames.setForeground(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(listParamNames);

        UI_Design.button_ui_style_violet(btnCreate,"Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txtxTestParameter)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(inputTestParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(48, 48, 48)
                                                                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(230, 230, 230)
                                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtxTestParameter)
                                        .addComponent(inputTestParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(60, Short.MAX_VALUE))
        );
    }

    public static void init_Load(){
        Init.readParams_Prop();
        Init.globalParamNamesListModel();

        listParamNames.removeAll();
        listParamNames.setModel(Init.paramNameListModel);
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag = true;

        if (inputTestParameter.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter Parameter");
            flag=false;
            return;
        }
        if(flag) {
            String input_Param=inputTestParameter.getText().toLowerCase();
            // paramNamesAndvaluesListModel.addElement(inputParameter.getText());
            if (Init.paramNameListModel.contains(input_Param)){
                JOptionPane.showMessageDialog(null, input_Param+":  Already Exist !");
            } else {
                Init.paramNameandValuesListModel.addElement(input_Param);
                Init.paramNameListModel.addElement(input_Param);


                listParamNames.setModel(Init.paramNameListModel);
                listParamNames.setSelectedIndex(0);
                inputTestParameter.setText("");
                inputTestParameter.setFocusable(true);
            }
        }
    }
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        ListSelectionModel lsm = listParamNames.getSelectionModel();
        int firstSelected = lsm.getMinSelectionIndex();
        Init.paramNameListModel.removeElement(listParamNames.getModel().getElementAt(firstSelected));
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
//        File saas = new File(GlobalConstants.PROJECTS_FOLDER_PATH+File.separator+ GlobalConstants.SELECTED_PROJECT +File.separator+GlobalConstants.FRAMEWORK_FOLDER);
////        if(saas.exists()) {
//////            Generic.createProject_Setup(GlobalConstants.Project_Name);
////            Generic.writeParamProp(Init.paramNameListModel);
////            for (int i = 0; i <= Init.paramNameListModel.size() - 1; i++) {
////                FrameworkBuilder.updateTestNGParam_BeforeMethod(Init.paramNameListModel.get(i).toString());
////            }
//////
//////            ConfigProjectTestParamValues configProjectTestParamValues = new ConfigProjectTestParamValues();
//////            configProjectTestParamValues.setVisible(true);
//////            ConfigProjectTestParamValues.init_Load();
////            JOptionPane.showMessageDialog(null, "Successfully  Created");
////        } else{
////
////        }
        Generic.writeParamProp(Init.paramNameListModel);
        JOptionPane.showMessageDialog(null, "Successfully  Created");

    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTextField inputTestParameter;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JList<String> listParamNames;
    private javax.swing.JLabel txtxTestParameter;
    // End of variables declaration
}

