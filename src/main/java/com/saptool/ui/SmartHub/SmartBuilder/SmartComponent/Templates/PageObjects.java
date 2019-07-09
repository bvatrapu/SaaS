package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates;


import com.saptool.tables.ViewPageObjectsTable;
import com.saptool.tables.ViewPageObjectsTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.SmartHub.SmartBuilder.SmartObject.SmartObject;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import test.tmp.Sub;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class PageObjects extends javax.swing.JFrame {
    public static ViewPageObjectsTableModel viewPageObjectsTableModel = null;
    public static String selected_Page_Object = null;

    public static String selected_method=null;
    public static String multi_args=null;
    public static String selected_class=null;
    /**
     * Creates new form PageObjects
     */
    public PageObjects() {
        initComponents();
    }


    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblObjects = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        inputSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        UI_Design.table_ui_style_blue(tblObjects);
        jScrollPane1.setViewportView(tblObjects);
        tblObjects.getSelectionModel().addListSelectionListener(new SelectionListener());

        btnClose.setFocusPainted(false);
        btnClose.setBorder(null);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        inputSearch.setFont(new java.awt.Font("Tahoma", 0, 22));
        inputSearch.setForeground(new java.awt.Color(153, 0, 153));
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputSearchKeyReleased(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setFocusPainted(false);
        btnSearch.setBorder(null);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Search_32px.png")));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        UI_Design.button_ui_style_violet(btnAdd,"Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(44, Short.MAX_VALUE))
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

    public static void init_Load(String selected_tree_node,String args){
        selected_class=Generic.convertFirstcharLowerCase(selected_tree_node);
        selected_method= args;

        loadTable();

    }
    public static void loadTable(){
        tblObjects.setModel(getModel());
        UI_Design.table_dimenetions(tblObjects);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smarthub_PageObjects=false;
       dispose();
    }


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        if(selected_method.contains("WebElement")){

            if(selected_method.contains(",")) {
                selected_method = selected_method.replaceAll(selected_method.substring(selected_method.indexOf("WebElement"), selected_method.indexOf(",")), GlobalConstants.SELECTED_PAGE_OBJECT.trim());
            } else{
                selected_method = selected_method.replaceAll(selected_method.substring(selected_method.indexOf("WebElement"), selected_method.indexOf(")")), GlobalConstants.SELECTED_PAGE_OBJECT.trim());
            }

            Init.page_method_steps_ListModel.addElement(selected_class + "." + selected_method);
            Submit_Form.listMethodSteps.setModel(Init.page_method_steps_ListModel);
            Frame_Flag.smarthub_PageObjects = false;
            dispose();
        }

//        if(multi_args==null) {
//            Submit_Form.selected_table_row = Submit_Form.selected_table_row.replaceAll(read_args, GlobalConstants.SELECTED_PAGE_OBJECT);
//            Init.page_method_steps_ListModel.addElement(selected_class + "." + Submit_Form.selected_table_row);
//            Submit_Form.listMethodSteps.setModel(Init.page_method_steps_ListModel);
//            Frame_Flag.smarthub_PageObjects = false;
//            dispose();
//        } else{
//            String strarg=multi_args.replaceAll("webelement",GlobalConstants.SELECTED_PAGE_OBJECT).trim();
////
//
//
//            Submit_Form.selected_table_row = Submit_Form.selected_table_row.replaceAll(read_args,strarg);
//
//            Init.page_method_steps_ListModel.addElement(selected_class + "." + Submit_Form.selected_table_row);
//            Submit_Form.listMethodSteps.setModel(Init.page_method_steps_ListModel);
//            Frame_Flag.smarthub_PageObjects = false;
//            dispose();
//        }
    }

    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        filter(inputSearch.getText());
    }
    public static void filter(String query) {
        TableRowSorter<ViewPageObjectsTableModel> trObj = new TableRowSorter<ViewPageObjectsTableModel>(viewPageObjectsTableModel);
        tblObjects.setRowSorter(trObj);
        trObj.setRowFilter(RowFilter.regexFilter(query));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageObjects().setVisible(true);
            }
        });
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
        } if(obj.contains("list")){
            return "List or Combobox";
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
    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    public static javax.swing.JTable tblObjects;
    // End of variables declaration
}

