package com.saptool.ui.executionlab;


import com.saptool.ui.Init;
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
public class SetupParamValues extends JFrame {

    public static HashMap<String,String> mapParamvalues=new HashMap<String,String>();
    public static DefaultListModel paramvaluesListmodel= new DefaultListModel();
    /**
     * Creates new form SetupParams
     */
    public SetupParamValues() {
        initComponents();
    }


    private void initComponents() {

        jPanel1 = new JPanel();
        inputvalue = new JTextField();
        btnAdd = new JButton();
        jScrollPane1 = new JScrollPane();
        listParamvalue = new JList<>();
        icon = new JLabel();
        btnFinish = new JButton();
        cbParam = new JComboBox<>();


        setTitle("SetupParamValues");
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        inputvalue.setFont(new java.awt.Font("Tahoma", 1, 18));
        inputvalue.setForeground(new java.awt.Color(0, 0, 255));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnAdd.setForeground(new java.awt.Color(0, 0, 153));
        btnAdd.setFocusPainted(false);
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        listParamvalue.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listParamvalue);

        icon.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Setup_Param.jpg")));

        btnFinish.setBackground(new java.awt.Color(255, 255, 255));
        btnFinish.setText("Finish");
        btnFinish.setFocusPainted(false);
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        cbParam.setMaximumRowCount(100);
        cbParam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbParamActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(259, 259, 259)
                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(cbParam, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(inputvalue, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(icon)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(inputvalue))
                                        .addComponent(cbParam, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(icon)
                                                .addGap(140, 140, 140))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                                .addGap(190, 190, 190))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetupParamValues().setVisible(true);
            }
        });
    }
    public static void initLoad(){

//        Init.paramNamesHashMap=new HashMap<String,String>();
//        cbParam.removeAllItems();
//        Init.paramNamesHashMap = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.param_properties);
//
//        for (Map.Entry<String, String> entry : Init.paramNamesHashMap.entrySet()) {
//            cbParam.addItem(entry.getKey());
//        }

        for(int k=0;k<Init.paramNameListModel.size();k++){
            cbParam.addItem(Init.paramNameListModel.get(k).toString());
        }
        paramvaluesListmodel.removeAllElements();

        if(cbParam.getItemCount()!=0) {
            String cb_paranName = cbParam.getSelectedItem().toString();
            mapParamvalues = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+cb_paranName+".properties");
            for (Map.Entry<String, String> entry : mapParamvalues.entrySet()) {
                paramvaluesListmodel.addElement(entry.getValue());
            }
        }
        listParamvalue.setModel(paramvaluesListmodel);
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag = true;
        if (inputvalue.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter param value");
            flag=false;
            //return;
        }
        if(flag) {
            paramvaluesListmodel.addElement(inputvalue.getText());
            listParamvalue.setModel(paramvaluesListmodel);
            listParamvalue.setSelectedIndex(0);
            inputvalue.setText("");
        }

        Generic.writeParamValuesProp(paramvaluesListmodel,cbParam.getSelectedItem().toString());
       //btnAdd.setText("Add");

    }
    private void cbParamActionPerformed(java.awt.event.ActionEvent evt){
        String cb_paranName = cbParam.getSelectedItem().toString();

        paramvaluesListmodel.removeAllElements();
        mapParamvalues = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH + File.separator + GlobalConstants.SELECTED_PROJECT + File.separator + cb_paranName + ".properties");
        for (Map.Entry<String, String> entry : mapParamvalues.entrySet()) {

            paramvaluesListmodel.addElement(entry.getValue());
        }

        listParamvalue.setModel(paramvaluesListmodel);
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if(listParamvalue.getSelectedValue().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Select Param value");
        }else {
            inputvalue.setText(listParamvalue.getSelectedValue());
            paramvaluesListmodel.removeElement(listParamvalue.getSelectedValue());
        }
        btnAdd.setText("Update");
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        paramvaluesListmodel.removeElement(listParamvalue.getSelectedValue());

        Generic.writeParamValuesProp(paramvaluesListmodel,cbParam.getSelectedItem().toString());
    }

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {


//        paramvaluesListmodel.removeAllElements();
//        String key;
//        HashMap<String,String> map=new HashMap<String,String>();
//        map = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.param_properties);
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            key= entry.getKey();
//            paramvaluesListmodel.addElement(key);
//        }
        TestNgParams_EL.listparams.setModel(Init.paramNameandValuesListModel);
        Generic.writeParamProp(Init.paramNameandValuesListModel);
        dispose();
    }
    // Variables declaration - do not modify
    private JButton btnAdd;
    private JButton btnFinish;
    public static JComboBox<String> cbParam;
    private JLabel icon;
    private JTextField inputvalue;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    public static JList<String> listParamvalue;
    // End of variables declaration
}

