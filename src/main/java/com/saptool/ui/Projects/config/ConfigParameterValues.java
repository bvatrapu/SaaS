package com.saptool.ui.Projects.config;


import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ConfigParameterValues extends javax.swing.JPanel {
    public static HashMap<String,String> mapParamvalues=new HashMap<String,String>();
    public static DefaultListModel paramvaluesListmodel= new DefaultListModel();
    /**
     * Creates new form RenameProject
     */
    public ConfigParameterValues() {
        initComponents();
    }


    private void initComponents() {

        inputTestParameterValue = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listParamNames = new javax.swing.JList<>();
        btnCreate = new javax.swing.JButton();
        comboParamName = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        inputTestParameterValue.setFont(new java.awt.Font("Tahoma", 0, 20));
        inputTestParameterValue.setForeground(new java.awt.Color(153, 153, 153));


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
        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 20));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });


        comboParamName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectParamActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(230, 230, 230)
                                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(comboParamName, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(inputTestParameterValue, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(162, 162, 162)
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputTestParameterValue, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                        .addComponent(comboParamName))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(60, Short.MAX_VALUE))
        );
    }
    public static void init_Load(){
        Init.readParams_Prop();
        Init.globalParamNamesListModel();
        comboParamName.removeAllItems();
        for(int k = 0; k< Init.paramNameListModel.size(); k++){
            comboParamName.addItem(Init.paramNameListModel.get(k).toString());
        }
        paramvaluesListmodel.removeAllElements();
        if(comboParamName.getItemCount()!=0) {
            String cb_paranName = comboParamName.getSelectedItem().toString();
            mapParamvalues = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+cb_paranName+".properties");
            for (Map.Entry<String, String> entry : mapParamvalues.entrySet()) {
                paramvaluesListmodel.addElement(entry.getValue());
            }
        }
        listParamNames.setModel(paramvaluesListmodel);
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag = true;
        if (inputTestParameterValue.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter param value");
            flag=false;
            //return;
        }
        if(flag) {
            if (paramvaluesListmodel.contains(inputTestParameterValue.getText())){
                JOptionPane.showMessageDialog(null, inputTestParameterValue.getText()+":  Already added !");
            } else {
                paramvaluesListmodel.addElement(inputTestParameterValue.getText());
                listParamNames.setModel(paramvaluesListmodel);
                listParamNames.setSelectedIndex(0);
                inputTestParameterValue.setText("");

            }
        }

    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        paramvaluesListmodel.removeElement(listParamNames.getSelectedValue());

        Generic.writeParamValuesProp(paramvaluesListmodel,comboParamName.getSelectedItem().toString());
    }

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
        Generic.writeParamValuesProp(paramvaluesListmodel,comboParamName.getSelectedItem().toString());
        Generic.writeParamProp(Init.paramNameandValuesListModel);
        JOptionPane.showMessageDialog(null, "Successfully  Created");
    }
    private void comboSelectParamActionPerformed(java.awt.event.ActionEvent evt){
        String cb_paranName = comboParamName.getSelectedItem().toString();
        System.out.println("cb_paranName:"+cb_paranName);
        paramvaluesListmodel.removeAllElements();
        mapParamvalues = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH + File.separator + GlobalConstants.SELECTED_PROJECT + File.separator + cb_paranName + ".properties");
        for (Map.Entry<String, String> entry : mapParamvalues.entrySet()) {

            paramvaluesListmodel.addElement(entry.getValue());
        }

        listParamNames.setModel(paramvaluesListmodel);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRemove;
    public static javax.swing.JComboBox<String> comboParamName;
    private javax.swing.JTextField inputTestParameterValue;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JList<String> listParamNames;
    // End of variables declaration
}
