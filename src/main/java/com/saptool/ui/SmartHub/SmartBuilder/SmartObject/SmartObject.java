package com.saptool.ui.SmartHub.SmartBuilder.SmartObject;


import com.saptool.tables.ViewPageObjectsTable;
import com.saptool.tables.ViewPageObjectsTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Projects.Projects;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class SmartObject extends javax.swing.JFrame {
    public static ViewPageObjectsTableModel viewPageObjectsTableModel = null;
    public static int arg_incrementer=0;
    public static String selected_Page_Object = null;

    /**
     * Creates new form SmartObject
     */
    public SmartObject() {
        initComponents();
    }

    private void initComponents() {

        btnNew2 = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblObjects = new javax.swing.JTable();
        txtPageName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnNew2.setText("New ");


        setUndecorated(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(244, 233, 0) ));
        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

//        tblObjects.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null, null},
//                        {null, null, null},
//                        {null, null, null},
//                        {null, null, null}
//                },
//                new String [] {
//                        "Sno", "Obj Name", "Obj Type"
//                }
//        ));
        UI_Design.table_ui_style_blue(tblObjects);
        jScrollPane1.setViewportView(tblObjects);
        tblObjects.getSelectionModel().addListSelectionListener(new SelectionListener());

        txtPageName.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtPageName.setForeground(new java.awt.Color(0, 0, 153));
        txtPageName.setText("Page Name");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnNew.setForeground(new java.awt.Color(102, 0, 153));
        btnNew.setText("New");
        btnNew.setFocusPainted(false);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnUpdate.setForeground(new java.awt.Color(102, 0, 153));
        btnUpdate.setText("Update");
        btnUpdate.setFocusPainted(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnDelete.setForeground(new java.awt.Color(102, 0, 153));
        btnDelete.setText("Delete");
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
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
                        .addComponent(jScrollPane1)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtPageName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(txtPageName))
                                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        txtPageName.setText(GlobalConstants.SELECTED_PAGE);
        loadTable();
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        if(!Frame_Flag.smartBuilder_smartObject_New) {
            New_SmartObject new_smartObject = new New_SmartObject();
            new_smartObject.setVisible(true);
        }
        Frame_Flag.smartBuilder_smartObject_New=true;
        Frame_Flag.smartBuilder_smartObject=false;
        dispose();
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        Update_SmartObject update_smartObject=new Update_SmartObject();
        update_smartObject.setVisible(true);
        Update_SmartObject.init_Load();
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartBuilder_smartObject=false;
       dispose();

    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"Under Development !!!");
    }

    public static void loadTable(){
        tblObjects.setModel(getModel());
        UI_Design.table_dimenetions(tblObjects);
    }
    public static ViewPageObjectsTableModel getModel() {
        int i=1;
        List<String> listObjects = new ArrayList<String>();
        listObjects = getObjects();
        List<ViewPageObjectsTable> viewObjects = new ArrayList<ViewPageObjectsTable>();
        for (int j=0;j<=listObjects.size()-1;j++) {

            ViewPageObjectsTable viewFileTable = new ViewPageObjectsTable(i, listObjects.get(j), getObjectType(listObjects.get(j)));
            viewObjects.add(viewFileTable);
            i = i + 1;
        }
        viewPageObjectsTableModel = new ViewPageObjectsTableModel(viewObjects);


        return viewPageObjectsTableModel;
    }
    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblObjects.getSelectedRow();
            if(row < 0)
                return;
            int col = tblObjects.getSelectedColumn();
            if(col < 0)
                return;

            if (tblObjects.getRowSorter()!=null) {
                row = tblObjects.getRowSorter().convertRowIndexToModel(row);
            }
            //tblPages.clearSelection();
            selected_Page_Object = (String) tblObjects.getModel().getValueAt(row, 1);
            GlobalConstants.SELECTED_PAGE_OBJECT=selected_Page_Object;

            tblObjects.setSelectionBackground(Color.ORANGE);
            // txtProjectName.setText(selected_Project.toUpperCase());

        }
    }

    public static String getObjectType(String obj){
        if(obj.contains("lnk")){
            return "Link";
        } if(obj.contains("btn")){
            return "Button";
        } if(obj.contains("chkbox")){
            return "CheckBox";
        } if(obj.contains("input")){
            return "EditBox";
        } if(obj.contains("img")){
            return "Image";
        } if(obj.contains("textarea")){
            return "TextArea";
        } if(obj.contains("radio")){
            return "RadioButton";
        } if(obj.contains("txt")){
            return "Text";
        } else{
            return "Other";
        }
    }
    public static List<String> getObjects() {
        List<String> listObjects = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java");

        String objects=null;
        objects=readPageModel.substring(readPageModel.indexOf("//SAP-START - OBJECT DECLARAITON"),readPageModel.indexOf("//SAP-END - OBJECT DECLARAITON"));

        objects = objects.replaceAll("//SAP-START - OBJECT DECLARAITON","");

//        String[] lines = operations.split(System.getProperty("line.separator"));

        Scanner scanner = new Scanner(objects);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if(line.contains("public WebElement")){
                listObjects.add(line.substring(line.indexOf("\tpublic WebElement "), line.indexOf(";")).replaceAll("public WebElement ",""));
            }
        }
        scanner.close();
        return listObjects;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmartObject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNew2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    public static javax.swing.JTable tblObjects;
    public static javax.swing.JLabel txtPageName;
    // End of variables declaration
}
