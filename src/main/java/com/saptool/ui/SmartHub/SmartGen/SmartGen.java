package com.saptool.ui.SmartHub.SmartGen;


import com.saptool.frameworkbuilder.FrameworkBuilder;
import com.saptool.tables.ViewProjectsTable;
import com.saptool.tables.ViewProjectsTableModel;
import com.saptool.tables.ViewSmartGenTable;
import com.saptool.tables.ViewSmartGenTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Projects.Projects;
import com.saptool.ui.SmartHub.SmartBuilder.SmartBuilder;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import jdk.nashorn.internal.objects.Global;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bvatrapu
 */
public class SmartGen extends javax.swing.JPanel {
    public static ViewSmartGenTableModel viewSmartGenTableModel = null;
    public static String selected_TestScript = null;
    /**
     * Creates new form Projects
     */
    public SmartGen() {
        initComponents();
    }


    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTestScripts = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtSelectModule = new javax.swing.JLabel();
        comboSelectModule = new javax.swing.JComboBox<>();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setBackground(new Color(255, 255, 255));


        tblTestScripts.setAutoCreateRowSorter(true);
        tblTestScripts.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(102, 102, 255)));
        tblTestScripts.setFont(new Font("Tahoma", 0, 24));
//        tblTestScripts.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null}
//                },
//                new String [] {
//                        "Sno", "Test Script"
//                }
//        ));
//        tblTestScripts.setFocusable(false);
//        tblTestScripts.setGridColor(new Color(255, 255, 255));
//        tblTestScripts.setIntercellSpacing(new Dimension(0, 0));
//        tblTestScripts.setRowHeight(25);
//        tblTestScripts.setSelectionBackground(new Color(204, 0, 255));
//        tblTestScripts.setShowVerticalLines(false);
//        tblTestScripts.getTableHeader().setReorderingAllowed(false);
//        tblTestScripts.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                tblTestScriptsMouseClicked(evt);
//            }
//        });
        UI_Design.table_ui_style_blue(tblTestScripts);
        jScrollPane1.setViewportView(tblTestScripts);
        tblTestScripts.getSelectionModel().addListSelectionListener(new SelectionListener());

        jLabel9.setText("         ");

        txtSelectModule.setFont(new Font("Tahoma", 1, 24));
        txtSelectModule.setForeground(new Color(0, 102, 153));
        txtSelectModule.setText("Select Module:  ");

        comboSelectModule.setToolTipText("");
        comboSelectModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSelectModuleActionPerformed(evt);
            }
        });

//        btnNew.setBackground(new Color(255, 255, 255));
//        btnNew.setFont(new Font("Tahoma", 1, 24));
//        btnNew.setForeground(new Color(0, 0, 153));
//        btnNew.setText("New");
        UI_Design.button_ui_style_violet(btnNew,"New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

//        btnUpdate.setBackground(new Color(255, 255, 255));
//        btnUpdate.setFont(new Font("Tahoma", 1, 24));
//        btnUpdate.setForeground(new Color(0, 0, 153));
//        btnUpdate.setText("Update");
        UI_Design.button_ui_style_violet(btnUpdate,"Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

//        btnDelete.setBackground(new Color(255, 255, 255));
//        btnDelete.setFont(new Font("Tahoma", 1, 24));
//        btnDelete.setForeground(new Color(0, 0, 153));
//        btnDelete.setText("Delete");
        UI_Design.button_ui_style_violet(btnDelete,"Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        UI_Design.button_ui_style_violet(btnView,"View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(107, 107, 107)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txtSelectModule)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(comboSelectModule, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabel9))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(116, 116, 116)
                                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(71, 71, 71)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(325, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(52, 52, 52)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(txtSelectModule)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(comboSelectModule, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(70, 70, 70)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(108, Short.MAX_VALUE))
        );
    }

    public static void initLoad(){
        comboSelectModule.removeAllItems();
        String[] allModules=null;
        String moduleName=null;
        allModules = Generic.getAllFileNames(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+"/");
        for(int i=0;i<=allModules.length-1;i++){
            comboSelectModule.addItem(allModules[i]);
        }
        loadTestScriptsTable();
        UI_Design.table_dimenetions_twocolumn(tblTestScripts);
    }
    private void tblTestScriptsMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        if(!Frame_Flag.smartGen_NewTestScript) {
            NewTestScript newTestScript = new NewTestScript();
            newTestScript.setVisible(true);
            NewTestScript.initLoad();
            Frame_Flag.smartGen_NewTestScript=true;
        }
    }

    public static ViewSmartGenTableModel getModel(String dirPath) {
        int i=1;
        if(dirPath!=null) {
            File file = new File(dirPath);
            String[] names = file.list();
            //build the list
            List<ViewSmartGenTable> viewTestScripts = new ArrayList<ViewSmartGenTable>();
            if (names != null) {
                for (String name : names) {
                    // if (new File(dirPath + name).isFile()) {
                    name = name.replaceAll(".java","");
                    ViewSmartGenTable viewSmartGenTable = new ViewSmartGenTable(i, name);
                    viewTestScripts.add(viewSmartGenTable);
                    i = i + 1;
                    //  }
                }

            }
            viewSmartGenTableModel = new ViewSmartGenTableModel(viewTestScripts);
        }
        return viewSmartGenTableModel;
    }

    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblTestScripts.getSelectedRow();
            if(row < 0)
                return;
            int col = tblTestScripts.getSelectedColumn();
            if(col < 0)
                return;

            if (tblTestScripts.getRowSorter()!=null) {
                row = tblTestScripts.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_TestScript = (String) tblTestScripts.getModel().getValueAt(row, 1);
            GlobalConstants.TABLE_SELECTED_PROJECT = selected_TestScript;

            tblTestScripts.setSelectionBackground(Color.ORANGE);
          //  txtProjectName.setText(selected_TestScript.toUpperCase());

        }
    }
    public static void loadTestScriptsTable(){
        tblTestScripts.setModel(getModel(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+comboSelectModule.getSelectedItem().toString()));
    }

    private void comboSelectModuleActionPerformed(java.awt.event.ActionEvent evt){
        String cb_module = comboSelectModule.getSelectedItem().toString();
        tblTestScripts.setModel(getModel(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+cb_module));
        UI_Design.table_dimenetions_twocolumn(tblTestScripts);
    }

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {
        Thread object = new Thread(new openPage());
        object.start();
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        Thread object = new Thread(new openPage());
        object.start();
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if(Generic.fileDelete(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+comboSelectModule.getSelectedItem()+File.separator+selected_TestScript+".java")){
           // FrameworkBuilder.deletePageInit_TestBase(selected_Page);
            loadTestScriptsTable();
            UI_Design.table_dimenetions_twocolumn(tblTestScripts);
            JOptionPane.showMessageDialog(null,comboSelectModule.getSelectedItem()+"::  is Deleted");
        } else {
            JOptionPane.showMessageDialog(null,"Unable to delete :: "+comboSelectModule.getSelectedItem()+":: Restart the app and try again..");
        }
    }
    class openPage implements Runnable{
        @Override
        public void run() {
            try {

                ProcessBuilder pb = new ProcessBuilder(GlobalConstants.SublimeText_Path, GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+comboSelectModule.getSelectedItem()+File.separator+selected_TestScript+".java");
                pb.start();
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    public static javax.swing.JComboBox<String> comboSelectModule;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblTestScripts;
    private javax.swing.JLabel txtSelectModule;
    // End of variables declaration
}
