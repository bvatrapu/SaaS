package com.saptool.ui.Projects;

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
public class ConfigProjectTestParamValues extends javax.swing.JFrame {
    public static HashMap<String,String> mapParamvalues=new HashMap<String,String>();
    public static DefaultListModel paramvaluesListmodel= new DefaultListModel();
    /**
     * Creates new form ConfigProjectTestParamValues
     */
    public ConfigProjectTestParamValues() {
        initComponents();
    }


    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        comboSelectParam = new javax.swing.JComboBox<>();
        inputPAramValue = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listParamValues = new javax.swing.JList<>();
        btnDone = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtParamName = new javax.swing.JLabel();
        txtParamName1 = new javax.swing.JLabel();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        comboSelectParam.setFont(new java.awt.Font("Tahoma", 0, 20));
        comboSelectParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectParamActionPerformed(evt);
            }
        });
        inputPAramValue.setFont(new java.awt.Font("Tahoma", 0, 20));


        UI_Design.button_ui_style_violet(btnadd,"Add");
        btnadd.setFont(new java.awt.Font("Tahoma", 0, 20));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });


        UI_Design.button_ui_style_violet(btnRemove,"Remove");
        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 20));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        listParamValues.setFont(new java.awt.Font("Tahoma", 1, 20));
        listParamValues.setForeground(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(listParamValues);


        UI_Design.button_ui_style_violet(btnDone,"DONE");
        btnDone.setFont(new java.awt.Font("Tahoma", 0, 24));
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnClose.setFocusPainted(false);
        btnClose.setBorder(null);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtParamName.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtParamName.setForeground(new java.awt.Color(51, 51, 255));
        txtParamName.setText("Parameter Name");

        txtParamName1.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtParamName1.setForeground(new java.awt.Color(51, 51, 255));
        txtParamName1.setText("Parameter Value");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(34, 34, 34))
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addGap(55, 55, 55)
                                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtParamName)
                                                                        .addComponent(comboSelectParam, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(43, 43, 43)))
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(inputPAramValue, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtParamName1))))
                                .addContainerGap(45, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(283, 283, 283))
                                        .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtParamName)
                                        .addComponent(txtParamName1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputPAramValue)
                                        .addComponent(comboSelectParam, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
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
    public static void init_Load(){
        Init.readParams_Prop();
        Init.globalParamNamesListModel();

        for(int k = 0; k< Init.paramNameListModel.size(); k++){
            comboSelectParam.addItem(Init.paramNameListModel.get(k).toString());
        }
        paramvaluesListmodel.removeAllElements();

        if(comboSelectParam.getItemCount()!=0) {
            String cb_paranName = comboSelectParam.getSelectedItem().toString();
            mapParamvalues = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+cb_paranName+".properties");
            for (Map.Entry<String, String> entry : mapParamvalues.entrySet()) {
                paramvaluesListmodel.addElement(entry.getValue());
            }
        }
        listParamValues.setModel(paramvaluesListmodel);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag = true;
        if (inputPAramValue.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter param value");
            flag=false;
            //return;
        }
        if(flag) {
            if (paramvaluesListmodel.contains(inputPAramValue.getText())){
                JOptionPane.showMessageDialog(null, inputPAramValue.getText()+":  Already added !");
            } else {
                paramvaluesListmodel.addElement(inputPAramValue.getText());
                listParamValues.setModel(paramvaluesListmodel);
                listParamValues.setSelectedIndex(0);
                inputPAramValue.setText("");
                Generic.writeParamValuesProp(paramvaluesListmodel,comboSelectParam.getSelectedItem().toString());
            }
        }

    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        paramvaluesListmodel.removeElement(listParamValues.getSelectedValue());

        Generic.writeParamValuesProp(paramvaluesListmodel,comboSelectParam.getSelectedItem().toString());
    }

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
       // Generic.writeParamProp(Init.paramNameandValuesListModel);
        dispose();
        new Project_Create_Success();
    }
    private void comboSelectParamActionPerformed(java.awt.event.ActionEvent evt){
        String cb_paranName = comboSelectParam.getSelectedItem().toString();

        paramvaluesListmodel.removeAllElements();
        mapParamvalues = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH + File.separator + GlobalConstants.SELECTED_PROJECT + File.separator + cb_paranName + ".properties");
        for (Map.Entry<String, String> entry : mapParamvalues.entrySet()) {

            paramvaluesListmodel.addElement(entry.getValue());
        }

        listParamValues.setModel(paramvaluesListmodel);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigProjectTestParamValues().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnadd;
    public static javax.swing.JComboBox<String> comboSelectParam;
    private javax.swing.JTextField inputPAramValue;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JList<String> listParamValues;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel txtParamName;
    private javax.swing.JLabel txtParamName1;
    // End of variables declaration
}

