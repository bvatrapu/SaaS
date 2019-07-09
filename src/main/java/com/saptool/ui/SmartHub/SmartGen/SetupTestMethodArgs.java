package com.saptool.ui.SmartHub.SmartGen;


import com.saptool.tables.ViewContsantsTable;
import com.saptool.tables.ViewContsantsTableModel;
import com.saptool.tables.ViewPageObjectsTableModel;
import com.saptool.tables.ViewPageOperationsTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.*;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates.Submit_Form;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bvatrapu
 */
public class SetupTestMethodArgs extends javax.swing.JFrame {
    private static final String upString = "Move up";
    private static final String downString = "Move down";
    private static final String deleteString = "Delete";
    //static DefaultListModel TestdataListModel= new DefaultListModel();
    public static DefaultListModel testdata_method= new DefaultListModel();

    public static ViewPageMethodsTableModel viewPageMethodsTableModel = null;
    public static ViewDriverGenericTableModel viewDriverGenericTableModel = null;
    public static ViewUtilsTableModel viewUtilsTableModel = null;

    public static ViewPageObjectsTableModel viewPageObjectsTableModel = null;
    public static ViewPageOperationsTableModel viewPageOperationsTableModel = null;

    public static ViewContsantsTableModel viewContsantsTableModel=null;


    public static String selected_Tree_Node=null;
    public static String selected_table_row = null;
    static DefaultMutableTreeNode root;
    static DefaultTreeModel treeModel;
    //public static String selected_tree_node=null;

    /**
     * Creates new form TestDataSetupNew
     */
    public SetupTestMethodArgs() {
        initComponents();
    }


    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        inputSearch = new javax.swing.JTextField();
        txtTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        treeTestdata = new javax.swing.JTree();
        jScrollPane5 = new javax.swing.JScrollPane();
        treeConstants = new javax.swing.JTree();
        jScrollPane6 = new javax.swing.JScrollPane();
        treePageMethods = new javax.swing.JTree();
        jScrollPane7 = new javax.swing.JScrollPane();
        treeGenericMethods = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoad = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMethodArgsOrder = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listTestData = new javax.swing.JList<>();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSwap = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnTestdataSetup = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnClose.setFocusPainted(false);
        btnClose.setBorder(null);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        inputSearch.setFont(new java.awt.Font("Tahoma", 0, 20));
        inputSearch.setForeground(new java.awt.Color(0, 153, 204));
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputSearchKeyReleased(evt);
            }
        });

        txtTitle.setFont(new java.awt.Font("Tahoma", 0, 22));
        txtTitle.setForeground(new java.awt.Color(153, 0, 255));
        txtTitle.setText("Method Argument Config");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                .addGap(0, 27, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        treeTestdata.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TESTDATA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(153, 0, 204)));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(GlobalConstants.SCRIPT_NAME);
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("TestData");
        treeNode1.add(treeNode2);
        treeTestdata.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
       // treeTestdata.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        jScrollPane4.setViewportView(treeTestdata);
        treeTestdata.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                selected_table_row=null;
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treeTestdata.getLastSelectedPathComponent();
                selected_Tree_Node=selectedNode_module.toString();
                inputSearch.setText("");
                tblLoad.setModel(getTestDataModel());
                UI_Design.table_dimenetions_testdatasetup(tblLoad);

            }
        });

        treeConstants.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSTANTS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(153, 0, 204)));
        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Framework");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ConfigTestData");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Constants");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ProjectBase");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("GlobalConstants");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeConstants.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane5.setViewportView(treeConstants);
        treeConstants.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                selected_table_row=null;
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treeConstants.getLastSelectedPathComponent();
                selected_Tree_Node=selectedNode_module.toString();
                inputSearch.setText("");
                tblLoad.setModel(getConstantsModel());
                UI_Design.table_dimenetions_testdatasetup(tblLoad);

            }
        });

        treePageMethods.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Page Methods", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(153, 0, 204)));
        jScrollPane6.setViewportView(treePageMethods);
        treePageMethods.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                selected_table_row=null;
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treePageMethods.getLastSelectedPathComponent();
                selected_Tree_Node=selectedNode_module.toString();
                inputSearch.setText("");
                tblLoad.setModel(getMethodsModel());
                UI_Design.table_dimenetions_testdatasetup(tblLoad);

            }
        });

        treeGenericMethods.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generic Methods", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(153, 0, 204)));
        jScrollPane7.setViewportView(treeGenericMethods);
        treeGenericMethods.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //   PAGE_METHODS_SELECTION=false;
                selected_table_row=null;
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treeGenericMethods.getLastSelectedPathComponent();
                selected_Tree_Node=selectedNode_module.toString();
                tblLoad.setModel(getUtilsmodel());
                UI_Design.table_dimenetions_testdatasetup(tblLoad);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(jScrollPane7)
                        .addComponent(jScrollPane6)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

//        tblLoad.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null, null, null},
//                        {null, null, null, null},
//                        {null, null, null, null},
//                        {null, null, null, null}
//                },
//                new String [] {
//                        "Title 1", "Title 2", "Title 3", "Title 4"
//                }
//        ));
        tblLoad.setGridColor(new java.awt.Color(0, 0, 204));
        jScrollPane2.setViewportView(tblLoad);
        tblLoad.getSelectionModel().addListSelectionListener(new SelectionListener());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        listMethodArgsOrder.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Method Arguments Order", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20), new java.awt.Color(0, 0, 204)));
//        listMethodArgsOrder.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
        jScrollPane1.setViewportView(listMethodArgsOrder);

        listTestData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TestData ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20), new java.awt.Color(0, 153, 102)));
//        listTestData.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
        jScrollPane3.setViewportView(listTestData);

        btnUp.setBorder(null);
        btnUp.setFocusPainted(false);
        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Up_Squared_48px.png")));
        btnUp.setToolTipText("UP");
        btnUp.setActionCommand(upString);
        btnUp.addActionListener(new UpDownListener());

        btnDown.setBorder(null);
        btnDown.setFocusPainted(false);
        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Drop_Down_48px.png")));
        btnDown.setToolTipText("DOWN");
        btnDown.setActionCommand(downString);
        btnDown.addActionListener(new UpDownListener());

        btnRemove.setBorder(null);
        btnRemove.setFocusPainted(false);
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Reduce_48px.png")));
        btnRemove.setToolTipText("DELETE");
        btnRemove.setActionCommand(deleteString);
        btnRemove.addActionListener(new DeleteButtonListener());

        btnSwap.setBorder(null);
        btnSwap.setFocusPainted(false);
        btnSwap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Root_48px.png")));
        btnSwap.setToolTipText("SWAP");
        btnSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSwap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane3)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(44, Short.MAX_VALUE))
        );


        UI_Design.button_ui_style_violet(btnAdd,"Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });


        UI_Design.button_ui_style_violet(btnDone,"Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });


        UI_Design.button_ui_style_violet(btnTestdataSetup,"TestData Setup");
        btnTestdataSetup.setFont(new Font("Tahoma", 1, 15));
        btnTestdataSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestdataSetupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnTestdataSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTestdataSetup, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        mainpanelLayout.setVerticalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 766, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void init_Load(String[] listMethods){
        Init.Test_Method_args.removeAllElements();
        testdata_method.removeAllElements();
        UI_Design.table_ui_style_Vilote_testdatasetup(tblLoad);
        testPages_TreeView();
        utils_TreeView();
        for(int i=0;i<=listMethods.length-1;i++){

            testdata_method.addElement(listMethods[i]);
        }

        listMethodArgsOrder.setModel(testdata_method);

    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
       dispose();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String add_method_arg_val=null;
        GlobalConstants.selected_table_row=selected_table_row;
        GlobalConstants.selected_Tree_Node=selected_Tree_Node;
        if(Init.Test_Method_args.contains(selected_table_row)){
            JOptionPane.showMessageDialog(null, selected_Tree_Node+":  Already Added !");
        } else{
            if(selected_Tree_Node.equalsIgnoreCase("TestData")||selected_Tree_Node.equalsIgnoreCase(GlobalConstants.SCRIPT_NAME)){

                Init.Test_Method_args.addElement("td(\""+selected_table_row+"\")");
                listTestData.setModel(Init.Test_Method_args);
            } else{
                if(selected_table_row.contains("static")){
                    selected_table_row=selected_table_row.replaceAll("static ","");
                    if(!selected_table_row.contains("()")) {
                        extract_args(selected_table_row);
                    } else{
                        Init.Test_Method_args.addElement(selected_Tree_Node.replaceAll(".java","")+"."+selected_table_row+";");
                        listTestData.setModel(Init.Test_Method_args);
                    }
                } else{
                    if(!selected_table_row.contains("()")) {
                        extract_args(selected_table_row);
                    } else{
                        add_method_arg_val=Generic.convertFirstcharLowerCase(selected_Tree_Node.replaceAll(".java",""))+"."+selected_table_row;
                        Init.Test_Method_args.addElement(add_method_arg_val+";");
                        listTestData.setModel(Init.Test_Method_args);
                    }

                }
            }
        }

    }

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        int argsLen=listMethodArgsOrder.getModel().getSize();
        int testargs=listTestData.getModel().getSize();
        String methodArgbuilder=null;
        if(argsLen==testargs){
            methodArgbuilder=Init.Test_Method_args.get(0).toString();
           // methodArgbuilder = "td(\""+Init.Test_Method_args.get(0).toString()+"\")";
            for(int k=1;k<=testargs-1;k++){
                methodArgbuilder = methodArgbuilder+","+ Init.Test_Method_args.get(k);
            }

            methodArgbuilder=GlobalConstants.TestScript_Selected_Page_Name.toLowerCase() + "." + GlobalConstants.SELECTED_METHOD+methodArgbuilder+");";

            if(GlobalConstants.VERIFY_SCRIPT_COMMAND){
                Init.Add_TestScript_step_ListModel.addElement("verify("+methodArgbuilder.replaceAll(";","")+","+"\""+GlobalConstants.STEP_EXPECTED+"\""+");");
                AddTestScriptStep.listMethodSteps.setModel(Init.Add_TestScript_step_ListModel);
                AddTestScriptStep.btnVerify.setEnabled(true);
                AddTestScriptStep.listMethodSteps.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                GlobalConstants.VERIFY_SCRIPT_COMMAND = false;
            } else {
//            int count = string.length() - string.replaceAll("g","").length()
                Init.Add_TestScript_step_ListModel.addElement(methodArgbuilder);
                AddTestScriptStep.listMethodSteps.setModel(Init.Add_TestScript_step_ListModel);
            }

            dispose();
        }else{
            if(argsLen>testargs) {
                int baltestargs = argsLen - testargs;
                JOptionPane.showMessageDialog(null, "Add " + baltestargs + " more arguments !!");
            } else{
                int baltestargs = testargs - argsLen;
                JOptionPane.showMessageDialog(null, "Remove " + baltestargs + " arguments !!");
            }
        }

    }

    private void btnTestdataSetupActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSwapActionPerformed(ActionEvent evt) {
        int swapEle[]=listTestData.getSelectedIndices();
        swap(swapEle[0], swapEle[1]);
    }
    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    public static void filter(String query){
        switch (selected_Tree_Node){
            case "Variables":

                break;
            case "Objects":
                TableRowSorter<ViewPageObjectsTableModel> trObj=new TableRowSorter<ViewPageObjectsTableModel>(viewPageObjectsTableModel);
                tblLoad.setRowSorter(trObj);
                trObj.setRowFilter(RowFilter.regexFilter(query));
                break;
            case "Operations":
                TableRowSorter<ViewPageOperationsTableModel> trOper=new TableRowSorter<ViewPageOperationsTableModel>(viewPageOperationsTableModel);
                tblLoad.setRowSorter(trOper);
                trOper.setRowFilter(RowFilter.regexFilter(query));
                break;
            case "Methods":
                TableRowSorter<ViewPageMethodsTableModel> trMethods=new TableRowSorter<ViewPageMethodsTableModel>(viewPageMethodsTableModel);
                tblLoad.setRowSorter(trMethods);
                trMethods.setRowFilter(RowFilter.regexFilter(query));
                break;
            case "Browser":
            case "Element":
            case "Keyboard":
            case "Mouse":
            case "Wait":
            case "DateAndTime":
            case "Excel":
            case "Generic":
            case "RandomGenerator":
                TableRowSorter<ViewUtilsTableModel> trutilMethods=new TableRowSorter<ViewUtilsTableModel>(viewUtilsTableModel);
                tblLoad.setRowSorter(trutilMethods);
                trutilMethods.setRowFilter(RowFilter.regexFilter(query));
                break;
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetupTestMethodArgs().setVisible(true);
            }
        });
    }

    class UpDownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only when
            //there's a valid selection,
            //so go ahead and move the list item.

            int moveMe = listTestData.getSelectedIndex();

            if (e.getActionCommand().equals(upString)) {
                //UP ARROW BUTTON
                if (moveMe != 0) {
                    //not already at top
                    swap(moveMe, moveMe - 1);
                    listTestData.setSelectedIndex(moveMe - 1);
                    listTestData.ensureIndexIsVisible(moveMe - 1);
                }
            } else {
                //DOWN ARROW BUTTON
                if (moveMe != Init.page_method_steps_ListModel.getSize() - 1) {
                    //not already at bottom
                    swap(moveMe, moveMe + 1);
                    listTestData.setSelectedIndex(moveMe + 1);
                    listTestData.ensureIndexIsVisible(moveMe + 1);
                }
            }
        }
    }
    class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /*
             * This method can be called only if there's a valid selection, so
             * go ahead and remove whatever's selected.
             */

            ListSelectionModel lsm = listTestData.getSelectionModel();
            int firstSelected = lsm.getMinSelectionIndex();
            int lastSelected = lsm.getMaxSelectionIndex();
            String stepValue=null;
            int i=0;
            for(int k=firstSelected;k<=lastSelected;k++){
                stepValue=Init.Test_Method_args.get(k).toString();
                i = i+ Generic.getOccurrence(stepValue,"args");

            }

            Init.Test_Method_args.removeRange(firstSelected, lastSelected);

            int size = Init.Test_Method_args.size();

            if (size == 0) {
                //List is empty: disable delete, up, and down buttons.
//                btnDelete.setEnabled(false);
//                btnUp.setEnabled(false);
//                btnDown.setEnabled(false);
//                btnSwap.setEnabled(false);

            } else {
                //Adjust the selection.
                if (firstSelected == Init.Test_Method_args.getSize()) {
                    //Removed item in last position.
                    firstSelected--;
                }
                listTestData.setSelectedIndex(firstSelected);
            }
           // GlobalConstants.arg_incrementer=GlobalConstants.arg_incrementer-i;
        }
    }
    private void swap(int a, int b) {
        Object aObject = Init.Test_Method_args.getElementAt(a);
        Object bObject = Init.Test_Method_args.getElementAt(b);
        Init.Test_Method_args.set(a, bObject);
        Init.Test_Method_args.set(b, aObject);
    }
    public static void testPages_TreeView(){
        File fileRoot = new File(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER);
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);
        treePageMethods.setModel(treeModel);
        treePageMethods.setShowsRootHandles(true);
        CreateChildNodes ccn =
                new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();
    }
    public static void utils_TreeView(){
        File fileRoot = new File(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.FRAMEWORK_UTILGENERIC_FOLDER);
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);
        treeGenericMethods.setModel(treeModel);
        treeGenericMethods.setShowsRootHandles(true);
        CreateChildNodes ccn =
                new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();
    }
    public static class CreateChildNodes implements Runnable {

        private DefaultMutableTreeNode root;

        private File fileRoot;

        public CreateChildNodes(File fileRoot,
                                DefaultMutableTreeNode root) {
            this.fileRoot = fileRoot;
            this.root = root;
        }

        @Override
        public void run() {
            createChildren(fileRoot, root);
        }

        private void createChildren(File fileRoot,
                                    DefaultMutableTreeNode node) {
            File[] files = fileRoot.listFiles();
            if (files == null) return;

            for (File file : files) {
                DefaultMutableTreeNode childNode =
                        new DefaultMutableTreeNode(new FileNode(file));
                createChildren(file, childNode);
                node.add(childNode);
            }
        }

    }
    public static class FileNode {

        private File file;

        public FileNode(File file) {
            this.file = file;
        }

        @Override
        public String toString() {
            String name = file.getName();
            if (name.equals("")) {
                return file.getAbsolutePath();
            } else {
                return name;
            }
        }
    }

    public static ViewUtilsTableModel getUtilsmodel(){
        int i=1;
        String[] methodExtract=null;
        List<String> listMethods = new ArrayList<String>();
        listMethods = getUtils();
        ViewPageMethodsTable viewFileTable=null;
        List<ViewPageMethodsTable> viewFileList = new ArrayList<ViewPageMethodsTable>();
        for (int j=0;j<=listMethods.size()-1;j++) {
            methodExtract=listMethods.get(j).split("#::#");
            if(methodExtract[1]!=null) {
                viewFileTable= new ViewPageMethodsTable(i, methodExtract[0], methodExtract[1]);
            } else{
                viewFileTable = new ViewPageMethodsTable(i, methodExtract[0], "");
            }
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewUtilsTableModel = new ViewUtilsTableModel(viewFileList);


        return viewUtilsTableModel;
    }
    public static List<String> getUtils() {
        List<String> listMethods = new ArrayList<String>();
        String methodName=null;
        String line=null;
        String methoddesc=null;
        String readPageModel = null;
        String[] desc=null;

        readPageModel= Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.FRAMEWORK_UTILGENERIC_FOLDER+ File.separator+selected_Tree_Node);

        if(readPageModel!=null) {
            String methods = null;
            methods = readPageModel.substring(readPageModel.indexOf("//SAP - Methods - START"), readPageModel.indexOf("//SAP - Methods - END"));

            methods = methods.replaceAll("//SAP - Methods - START", "");
            //methods=readPageModel.substring(readPageModel.indexOf("//SAP-START - OPERATION DECLARAITON"),readPageModel.indexOf("//SAP-END - OPERATION DECLARAITON"));

            Scanner scanner = new Scanner(methods);
            String[] methodSplit = null;
            String[] strsplit = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if(line.contains("Method Description")){
                    desc=line.split("::");
                    methoddesc=desc[1].trim();
                }
                if (line.contains("public") && line.contains("{")) {

                    methodName = line.substring(line.indexOf("public "), line.indexOf("{")).replaceAll("public ", "");



                    methodSplit = methodName.split("\\(");

                    strsplit = methodSplit[0].split(" ");

                    methodName = strsplit[strsplit.length - 1];
                    if(line.contains("static")){
                        listMethods.add("static "+methodName + "(" + methodSplit[1]+"#::#"+methoddesc);
                    }else{
                        listMethods.add(methodName + "(" + methodSplit[1]+"#::#"+methoddesc);
                    }


                    methoddesc=null;
                }
            }

            scanner.close();
        }
        return listMethods;
    }

    public static ViewPageMethodsTableModel getMethodsModel() {
        int i=1;
        List<String> listOperations = new ArrayList<String>();
        listOperations = getMethods();
        List<ViewPageMethodsTable> viewFileList = new ArrayList<ViewPageMethodsTable>();
        for (int j=0;j<=listOperations.size()-1;j++) {
            ;
            ViewPageMethodsTable viewFileTable = new ViewPageMethodsTable(i, listOperations.get(j), "");
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewPageMethodsTableModel = new ViewPageMethodsTableModel(viewFileList);


        return viewPageMethodsTableModel;
    }
    public static java.util.List<String> getMethods() {
        java.util.List<String> listMethods = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+selected_Tree_Node);

        String methods=null;
        methods=readPageModel.substring(readPageModel.indexOf("//SAP-START - METHOD DECLARAITON"),readPageModel.indexOf("//SAP-END - METHOD DECLARAITON"));

        methods = methods.replaceAll("//SAP-START - METHOD DECLARAITON","");

        Scanner scanner = new Scanner(methods);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.contains("public")){

                listMethods.add(line.substring(line.indexOf("public String "), line.indexOf("{")).replaceAll("public String ",""));
            }
        }
        scanner.close();
        return listMethods;
    }

    public static ViewContsantsTableModel getTestDataModel() {
        int i=1;
        List<ViewContsantsTable> viewFileList = new ArrayList<ViewContsantsTable>();
        String[] testdata=null;
        for (int j=0;j<=Init.testdataListmodel.size()-1;j++) {
            testdata=Init.testdataListmodel.getElementAt(j).toString().split("=");
            ViewContsantsTable viewFileTable = new ViewContsantsTable(i, testdata[0], testdata[1]);
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewContsantsTableModel = new ViewContsantsTableModel(viewFileList);


        return viewContsantsTableModel;
    }


    public static ViewContsantsTableModel getConstantsModel(){
        int i=1;

        java.util.List<String> listconsts = new ArrayList<String>();
        listconsts = getConstants();
        String[] strConst=null;

        List<ViewContsantsTable> viewFileList = new ArrayList<ViewContsantsTable>();
        for (int j=0;j<=listconsts.size()-1;j++) {
            strConst=listconsts.get(j).split("=");

            ViewContsantsTable viewFileTable = new ViewContsantsTable(i,strConst[0].trim() , strConst[1].trim());
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewContsantsTableModel = new ViewContsantsTableModel(viewFileList);


        return viewContsantsTableModel;
    }
    public static java.util.List<String> getConstants() {
        java.util.List<String> listConstants = new ArrayList<String>();
        String readPageModel =null;
        String[] strConst=null;
        String strConstValue=null;
        String strContname=null;

        if(selected_Tree_Node.contains("ConfigTestData")){
            readPageModel=Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.FRAMEWORK_CONFIGBASE_FOLDER+ File.separator+selected_Tree_Node+".java");
        } else if(selected_Tree_Node.equalsIgnoreCase("Constants")){
            readPageModel=Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.FRAMEWORK_CONSTANTS_FOLDER+ File.separator+selected_Tree_Node+".java");
        } else{
            readPageModel=Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.FRAMEWORK_TESTCONSTANTS_FOLDER+ File.separator+selected_Tree_Node+".java");
        }

        //readPageModel = Generic.readText(dirpath+".java");

        Scanner scanner = new Scanner(readPageModel);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.contains("public")){

                if(!line.contains("public class")) {
                    strConst = line.split("=");
                    strConstValue = strConst[1].replaceAll(";", "").replaceAll("\"", "");
                    strConst = strConst[0].split(" ");
                    strContname = strConst[strConst.length - 1];

                    if(line.contains("static")){
                        listConstants.add("static "+strContname + "=" + strConstValue);
                    } else{
                        listConstants.add(strContname + "=" + strConstValue);
                    }


                }
            }
        }
        scanner.close();
        return listConstants;
    }
    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblLoad.getSelectedRow();
            if(row < 0)
                return;
            int col = tblLoad.getSelectedColumn();
            if(col < 0)
                return;

            if (tblLoad.getRowSorter()!=null) {
                row = tblLoad.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_table_row = (String) tblLoad.getModel().getValueAt(row, 1);
            GlobalConstants.TABLE_SELECTED_PROJECT = selected_table_row;

            tblLoad.setSelectionBackground(Color.ORANGE);
            //  txtProjectName.setText(selected_TestScript.toUpperCase());

        }
    }


    public static void extract_args(String method){
        String args=null;
        String final_arg="";
        String[] multi_args=null;
        String[] dataType=null;
        Init.METHOD_ARG_VALUE.removeAllElements();
           args=method.substring(method.indexOf("("),method.indexOf(")"));
        args=args.replaceAll("\\(","");
        GlobalConstants.args=args;
        if(args.contains(",")) {
            multi_args = args.split(",");
            for(int k=0;k<=multi_args.length-1;k++){
                Init.METHOD_ARG_VALUE.addElement(multi_args[k].trim());
            }

        } else{
            Init.METHOD_ARG_VALUE.addElement(args);
        }


        Method_Args method_args=new Method_Args();
        method_args.setVisible(true);
        Method_Args.init_Load();

    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSwap;
    private javax.swing.JButton btnTestdataSetup;
    private javax.swing.JButton btnUp;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    public static javax.swing.JList<String> listMethodArgsOrder;
    public static javax.swing.JList<String> listTestData;
    private javax.swing.JPanel mainpanel;
    public static javax.swing.JTable tblLoad;
    public static javax.swing.JTree treeConstants;
    public static javax.swing.JTree treeGenericMethods;
    public static javax.swing.JTree treePageMethods;
    public static javax.swing.JTree treeTestdata;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration
}
