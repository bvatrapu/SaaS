package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates;


import com.saptool.frameworkbuilder.PageBuilder;
import com.saptool.tables.*;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.*;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Buttons.Comment;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Buttons.EnterUrl;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Buttons.Wait;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Submit_Form extends javax.swing.JFrame {

    public static boolean flag_self=true;
    private static final String upString = "Move up";
    private static final String downString = "Move down";
    private static final String deleteString = "Delete";

    public static String selected_table_row = null;
    public static String selected_method=null;

    static boolean page_object=false;
    static String read_args=null;

    public static String readClassFile=null;

    public static ViewPageMethodsTableModel viewPageMethodsTableModel = null;
    public static ViewDriverGenericTableModel viewDriverGenericTableModel = null;
    public static ViewUtilsTableModel viewUtilsTableModel = null;

    public static ViewPageObjectsTableModel viewPageObjectsTableModel = null;
    public static ViewPageOperationsTableModel viewPageOperationsTableModel = null;
    public static ViewPageVariableTableModel viewPageVariableTableModel=null;

    public static String selected_Tree_Node=null;

    /**
     * Creates new form DeveloperTool
     */
    public Submit_Form() {
        initComponents();
        treeDeveloperMode.setEnabled(false);
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        inputSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        inputMethodName = new javax.swing.JTextField();
        inputMethodDesc = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        treeUtils = new javax.swing.JTree();
        jScrollPane5 = new javax.swing.JScrollPane();
        treePageMethods = new javax.swing.JTree();
        jScrollPane6 = new javax.swing.JScrollPane();
        treeConstants = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        treeDeveloperMode = new javax.swing.JTree();
        tabelPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoad = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMethodSteps = new javax.swing.JList<>();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSwap = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnComment = new javax.swing.JButton();
        btnWait = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        inputSearch.setFont(new java.awt.Font("Tahoma", 0, 22));
        inputSearch.setForeground(new java.awt.Color(153, 0, 153));
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputSearchKeyReleased(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setBorder(null);
        btnSearch.setFocusPainted(false);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Search_32px.png")));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        inputMethodName.setFont(new java.awt.Font("Tahoma", 0, 22));
        inputMethodName.setForeground(new java.awt.Color(153, 153, 255));
        inputMethodName.setText("  Method Name");
        inputMethodName.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                inputMethodName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                if(inputMethodName.getText().trim().contains("Method Name")){
                    inputMethodName.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputMethodName.getText())){
                    inputMethodName.setText("  Method Name");
                }
            }

        });

        inputMethodDesc.setFont(new java.awt.Font("Tahoma", 0, 22));
        inputMethodDesc.setForeground(new java.awt.Color(153, 153, 255));
        inputMethodDesc.setText("  Method Description");
        inputMethodDesc.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(inputMethodDesc.getText().trim().contains("Method Description")){
                    inputMethodDesc.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputMethodDesc.getText())){
                    inputMethodDesc.setText("  Method Description");
                }
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(inputMethodName, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(inputMethodDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(inputMethodName)
                                                .addComponent(inputMethodDesc)
                                                .addComponent(inputSearch)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        treeUtils.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Utilities", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 102, 0)));
        treeUtils.setFont(new java.awt.Font("Tahoma", 0, 20));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Utils");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("DriverGeneric");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Browser");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Element");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Keyboard");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mouse");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Wait");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Generic");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("DateAndTime");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Excel");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Generic");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("RandomGenerator");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeUtils.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeUtils.setRowHeight(27);
        jScrollPane4.setViewportView(treeUtils);
        treeUtils.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
             //   PAGE_METHODS_SELECTION=false;
                flag_self=false;
                selected_table_row=null;
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treeUtils.getLastSelectedPathComponent();
                selected_Tree_Node=selectedNode_module.toString();
                tblLoad.setModel(getUtilsmodel(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.FRAMEWORK_UTILGENERIC_FOLDER+File.separator+selectedNode_module));
                UI_Design.table_dimenetions_newMethod(tblLoad);
            }
        });

        treePageMethods.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Page Methods", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 102, 0)));
        treePageMethods.setFont(new java.awt.Font("Tahoma", 0, 20));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode(GlobalConstants.SELECTED_PAGE);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Variables");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Objects");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Operations");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Methods");
        treeNode1.add(treeNode2);
        treePageMethods.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treePageMethods.setRowHeight(27);
        jScrollPane5.setViewportView(treePageMethods);

        treePageMethods.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                selected_table_row=null;
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treePageMethods.getLastSelectedPathComponent();
                selected_Tree_Node=selectedNode_module.toString();
                inputSearch.setText("");
                flag_self=true;
                switch (selected_Tree_Node){
                    case "Variables":
                        tblLoad.setModel(getVariableModel());
                        UI_Design.table_dimenetions_newMethod(tblLoad);
                        break;
                    case "Objects":
                        tblLoad.setModel(getObjectsModel());
                        UI_Design.table_dimenetions_newMethod(tblLoad);
                        break;
                    case "Operations":
                        tblLoad.setModel(getOperationModel());
                        UI_Design.table_dimenetions_newMethod(tblLoad);
                        break;
                    case "Methods":
                        tblLoad.setModel(getMethodsModel());
                        UI_Design.table_dimenetions_newMethod(tblLoad);
                        break;

                }

            }
        });

        treeConstants.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Constants", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 102, 0)));
        treeConstants.setFont(new java.awt.Font("Tahoma", 0, 20));
        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Constants");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ConfigTestData");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("GlobalConstants");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("TestConstants");
        treeNode1.add(treeNode2);
        treeConstants.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeConstants.setRowHeight(27);
        jScrollPane6.setViewportView(treeConstants);

        treeDeveloperMode.setFont(new java.awt.Font("Tahoma", 0, 20));
        treeDeveloperMode.setForeground(new java.awt.Color(0, 51, 204));
        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("DeveloperMode");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("DataTypes");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("int");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("float");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("char");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("boolean");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("String");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Operators");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("+");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("-");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("*");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("/");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("%");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("++");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("--");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Conditions");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("If");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("If...Else");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Switch");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("case");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Loops");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("While");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("For");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Break");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Continue");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Arrays");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("String[]");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("String[][]");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("int[]");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("int[][]");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Exception");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Try..Catch");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Modifiers");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("public");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("private");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("protected");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("final");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("abstract");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("static");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("synchronized");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ArrayList");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Define_ArrayList");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("add(String)");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("get(int)");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("set(int,String)");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("remove(int)");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("clear()");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("size()");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("HashMap");
        treeNode1.add(treeNode2);
        treeDeveloperMode.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeDeveloperMode.setRowHeight(27);
        jScrollPane3.setViewportView(treeDeveloperMode);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(jScrollPane6)
                        .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabelPanel.setBackground(new java.awt.Color(255, 255, 255));
        tabelPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblLoad.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(tblLoad);
        UI_Design.table_ui_style_blue(tblLoad);
        UI_Design.table_dimenetions_newMethod(tblLoad);
        tblLoad.getSelectionModel().addListSelectionListener(new SelectionListener());

        javax.swing.GroupLayout tabelPanelLayout = new javax.swing.GroupLayout(tabelPanel);
        tabelPanel.setLayout(tabelPanelLayout);
        tabelPanelLayout.setHorizontalGroup(
                tabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        tabelPanelLayout.setVerticalGroup(
                tabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabelPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane2.setViewportView(listMethodSteps);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );

        btnUp.setBorder(null);
        btnUp.setFocusPainted(false);
        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Up_Squared_60px.png")));
        btnUp.setToolTipText("UP");
        btnUp.setActionCommand(upString);
        btnUp.addActionListener(new UpDownListener());

        btnDown.setBorder(null);
        btnDown.setFocusPainted(false);
        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Drop_Down_60px.png")));
        btnDown.setToolTipText("DOWN");
        btnDown.setActionCommand(downString);
        btnDown.addActionListener(new UpDownListener());

        btnDelete.setBorder(null);
        btnDelete.setFocusPainted(false);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Reduce_60px.png")));
        btnDelete.setToolTipText("DELETE");
        btnDelete.setActionCommand(deleteString);
        btnDelete.addActionListener(new DeleteButtonListener());


        btnSwap.setBorder(null);
        btnSwap.setFocusPainted(false);
        btnSwap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Root_60px.png")));
        btnSwap.setToolTipText("SWAP");
        btnSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });
        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnAdd.setForeground(new java.awt.Color(153, 0, 153));
        btnAdd.setFocusPainted(false);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Add_New_30px.png")));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(255, 255, 255));
        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnCreate.setForeground(new java.awt.Color(0, 153, 51));
        btnCreate.setFocusPainted(false);
        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Ok_30px.png")));
        btnCreate.setText("CREATE");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnComment.setBackground(new java.awt.Color(255, 255, 255));
        btnComment.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnComment.setForeground(new java.awt.Color(102, 0, 102));
        btnComment.setFocusPainted(false);
        btnComment.setText("Comment");
        btnComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommentActionPerformed(evt);
            }
        });

        btnWait.setBackground(new java.awt.Color(255, 255, 255));
        btnWait.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnWait.setForeground(new java.awt.Color(102, 0, 102));
        btnWait.setFocusPainted(false);
        btnWait.setText("Wait");
        btnWait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnComment)
                                .addGap(38, 38, 38)
                                .addComponent(btnWait)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnComment, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(btnWait, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tabelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(202, 202, 202)
                                                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(tabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                                                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    public static void init_load(){
        Init.page_method_steps_ListModel.removeAllElements();
        tblLoad.setModel(getOperationModel());
        UI_Design.table_dimenetions_newMethod(tblLoad);
        selected_Tree_Node="Operations";
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        addMethod();

    }

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
        if(StringUtils.isEmpty(inputMethodName.getText())||inputMethodName.getText().trim().contains("Method Name")||StringUtils.isEmpty(inputMethodDesc.getText())||inputMethodDesc.getText().trim().contains("Method Desciption")){
            JOptionPane.showMessageDialog(null,"Enter Correct MethodName");
            inputMethodName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        } else {
            if (listMethodSteps.getModel().getSize() == 0) {
                JOptionPane.showMessageDialog(null, "Develop Method steps");
            } else {
                GlobalConstants.Method_Name = Generic.removeSpecialChars(inputMethodName.getText());
                GlobalConstants.Method_Description = inputMethodDesc.getText();

                DefaultListModel defaultListModel = new DefaultListModel();
                defaultListModel.clear();
                String methodStep = null;
                String args = null;
                String[] multi_args = null;
                String temp1 = null;
                String temp2 = null;
                for (int i = 0; i < listMethodSteps.getModel().getSize(); i++) {
                    methodStep = String.valueOf(listMethodSteps.getModel().getElementAt(i));

                    if (methodStep.contains("(")) {
                        args = methodStep.substring(methodStep.indexOf("("), methodStep.indexOf(")"));
                        args = args.replaceAll("\\(", "");
                        if (args.contains(",")) {
                            multi_args = args.split(",");
                            for (int j = 0; j <= multi_args.length - 1; j++) {

                                if (multi_args[j].contains(" ")) {
                                    if (temp2 == null) {
                                        temp2 = "args[" + GlobalConstants.arg_incrementer + "]";
                                        GlobalConstants.arg_incrementer = GlobalConstants.arg_incrementer + 1;
                                    } else {
                                        temp2 = temp2 + "," + "args[" + GlobalConstants.arg_incrementer + "]";
                                        GlobalConstants.arg_incrementer = GlobalConstants.arg_incrementer + 1;
                                    }

                                } else {
                                    if (temp2 == null) {
                                        temp2 = multi_args[j];

                                    } else {
                                        temp2 = temp2 + "," + multi_args[j];
                                    }
                                }
                            }

                            args = methodStep.replaceAll(args, temp2);

                            defaultListModel.addElement(args);
                            temp2 = null;
                        } else {
                            if (args.contains(" ")) {

                                args = methodStep.replaceAll(args, "args[" + GlobalConstants.arg_incrementer + "]");

                                defaultListModel.addElement(args);
                                GlobalConstants.arg_incrementer = GlobalConstants.arg_incrementer + 1;
                            } else {

                                defaultListModel.addElement(methodStep);
                            }
                        }
                        //  defaultListModel.addElement(String.valueOf(listMethodSteps.getModel().getElementAt(i)));
                    } else {
                        defaultListModel.addElement(methodStep);
                    }
                }
                    String pagePath = GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER + File.separator + GlobalConstants.TestScript_Selected_Page_Name + ".java";
                    String readPageModel = Generic.readText(pagePath);
                    if (readPageModel.contains("public String " + GlobalConstants.Method_Name)) {
                        JOptionPane.showMessageDialog(null, "Already exist Mehthod with Name::" + GlobalConstants.Method_Name);
                    } else {
                        PageBuilder.pageBuilder(PageBuilder.method_temp_Submit_form_Builder(defaultListModel,inputMethodDesc.getText()), "METHOD");
                        Frame_Flag.template_Submit_form = false;
                        Frame_Flag.smartBuilder_smartComponent = false;
                        Frame_Flag.smartBuilder_smartComponent_temlpate = false;
                        dispose();

                    }

                }

        }
        GlobalConstants.arg_incrementer=0;
    }

    private void btnCommentActionPerformed(java.awt.event.ActionEvent evt) {
        if(!Frame_Flag.smartBuilder_comment) {
            Comment comment = new Comment();
            comment.setVisible(true);
            Frame_Flag.smartBuilder_comment=true;
        }
    }

    private void btnWaitActionPerformed(java.awt.event.ActionEvent evt) {
        if(!Frame_Flag.smartBuilder_wait){
            Wait wait=new Wait();
            wait.setVisible(true);
            Frame_Flag.smartBuilder_wait=true;
        }
    }

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void btnSwapActionPerformed(ActionEvent evt) {
        int swapEle[]=listMethodSteps.getSelectedIndices();
        swap(swapEle[0], swapEle[1]);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.template_Object_existance=false;
        Frame_Flag.template_Submit_form=false;
        Frame_Flag.template_click_link_verify_targetpage=false;
        Frame_Flag.smartBuilder_smartComponent=false;
        Frame_Flag.smartBuilder_smartComponent_temlpate=false;
        dispose();
    }

    public static void addMethod(){
        boolean flag = true;

        String[] args=null;
        String rep_arg=null;
        if (selected_table_row==null){
            JOptionPane.showMessageDialog(null,"Select Operation or Method !!!");
            flag=false;
            return;
        }

        if(flag) {

            selected_method=selected_table_row;
            if(selected_method.contains("WebElement")) {
                if (!Frame_Flag.smarthub_PageObjects) {
                    PageObjects pageObjects = new PageObjects();
                    pageObjects.setVisible(true);
                    PageObjects.init_Load(selected_Tree_Node, selected_method);
                    Frame_Flag.smarthub_PageObjects = true;
                }
            } else{
                if(flag_self){
                    Init.page_method_steps_ListModel.addElement(selected_method);
                    listMethodSteps.setModel(Init.page_method_steps_ListModel);
                } else{
                    Init.page_method_steps_ListModel.addElement(Generic.convertFirstcharLowerCase(selected_Tree_Node)+"."+selected_method);
                    listMethodSteps.setModel(Init.page_method_steps_ListModel);
                }
            }
//            if (selected_method.contains("(")) {
//                read_args = selected_method.substring(selected_method.indexOf("("), selected_method.indexOf(")"));
//                if (selected_method.contains("()")) {
//                    if(selected_Tree_Node.equalsIgnoreCase("variables")||selected_Tree_Node.equalsIgnoreCase("objects")||selected_Tree_Node.equalsIgnoreCase("operations")||selected_Tree_Node.equalsIgnoreCase("methods")) {
//                        Init.page_method_steps_ListModel.addElement(selected_method);
//                        listMethodSteps.setModel(Init.page_method_steps_ListModel);
//                    }else{
//                        Init.page_method_steps_ListModel.addElement(Generic.convertFirstcharLowerCase(selected_Tree_Node)+"."+selected_table_row);
//                        listMethodSteps.setModel(Init.page_method_steps_ListModel);
//                    }
//                } else {
//                    if(read_args.contains(",")) {
//                        args = read_args.split(",");
//                        read_args=read_args.replaceAll("\\(","");
//                        if(args[0].contains("WebElement")){
//                            rep_arg="webelement";
//                        } else{
//                            rep_arg = "args[" + GlobalConstants.arg_incrementer + "]";
//                            GlobalConstants.arg_incrementer = GlobalConstants.arg_incrementer + 1;
//                        }
//
//                        for (int k = 1; k <= args.length-1; k++) {
//
//                            if(args[k].contains("WebElement")){
//
//                                rep_arg=rep_arg + "," + "webelement";
//                            } else{
//
//                                rep_arg = rep_arg + "," + "args[" + GlobalConstants.arg_incrementer + "]";
//                                GlobalConstants.arg_incrementer = GlobalConstants.arg_incrementer + 1;
//                            }
//
//                        }
//                        if(rep_arg.contains("webelement")){
//                            if(!Frame_Flag.smarthub_PageObjects) {
//                                PageObjects pageObjects = new PageObjects();
//                                pageObjects.setVisible(true);
//                                PageObjects.init_Load(selected_Tree_Node,read_args,rep_arg);
//                                Frame_Flag.smarthub_PageObjects=true;
//                            }
//                        } else {
//                            read_args = read_args.replaceAll("\\(", "");
//                            selected_method = selected_method.replaceAll(read_args, rep_arg);
//                            GlobalConstants.arg_incrementer = GlobalConstants.arg_incrementer + 1;
//                        }
//                    } else{
//                        read_args=read_args.replaceAll("\\(","");
//                        if(read_args.contains("WebElement")){
//                            if(!Frame_Flag.smarthub_PageObjects) {
//                                PageObjects pageObjects = new PageObjects();
//                                pageObjects.setVisible(true);
//                                PageObjects.init_Load(selected_Tree_Node,read_args,null);
//                                Frame_Flag.smarthub_PageObjects=true;
//                            }
//                            page_object=true;
//
//                        } else {
//                            rep_arg = "args[" + GlobalConstants.arg_incrementer + "]";
//                            selected_method = selected_method.replaceAll(read_args, rep_arg);
//                            GlobalConstants.arg_incrementer = GlobalConstants.arg_incrementer + 1;
//
//                            Init.page_method_steps_ListModel.addElement(selected_method);
//                            listMethodSteps.setModel(Init.page_method_steps_ListModel);
//                        }
//                    }
//
//                    //GlobalConstants.arg_incrementer = GlobalConstants.arg_incrementer + 1;
//
//                    //selected_table_row=null;
//                }

//            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Submit_Form().setVisible(true);
            }
        });
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

    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        filter(inputSearch.getText());
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

    public static ViewPageObjectsTableModel getObjectsModel() {
        int i=1;
        java.util.List<String> listObjects = new ArrayList<String>();
        listObjects = getObjects();
        java.util.List<ViewPageObjectsTable> viewObjects = new ArrayList<ViewPageObjectsTable>();
        for (int j=0;j<=listObjects.size()-1;j++) {

            ViewPageObjectsTable viewFileTable = new ViewPageObjectsTable(i, listObjects.get(j), getObjectType(listObjects.get(j)));
            viewObjects.add(viewFileTable);
            i = i + 1;
        }
        viewPageObjectsTableModel = new ViewPageObjectsTableModel(viewObjects);


        return viewPageObjectsTableModel;
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
    public static java.util.List<String> getObjects() {
        List<String> listObjects = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+GlobalConstants.SELECTED_PAGE+".java");

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
    public static ViewPageOperationsTableModel getOperationModel() {
        int i=1;
        List<String> listOperations = new ArrayList<String>();
        listOperations = getOperations();
        List<ViewPageOperationsTable> viewFileList = new ArrayList<ViewPageOperationsTable>();
        for (int j=0;j<=listOperations.size()-1;j++) {
            ;
            ViewPageOperationsTable viewFileTable = new ViewPageOperationsTable(i, listOperations.get(j), "");
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewPageOperationsTableModel = new ViewPageOperationsTableModel(viewFileList);


        return viewPageOperationsTableModel;
    }
    public static java.util.List<String> getOperations() {
        java.util.List<String> listOperations = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java");

        String operations=null;
        operations=readPageModel.substring(readPageModel.indexOf("//SAP-START - OPERATION DECLARAITON"),readPageModel.indexOf("//SAP-END - OPERATION DECLARAITON"));

        operations = operations.replaceAll("//SAP-START - OPERATION DECLARAITON","");

        Scanner scanner = new Scanner(operations);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.contains("public")){

                listOperations.add(line.substring(line.indexOf("public void "), line.indexOf("{")).replaceAll("public void ",""));
            }
        }
        scanner.close();
        return listOperations;
    }

    public static ViewPageVariableTableModel getVariableModel() {
        int i=1;
        List<String> listOperations = new ArrayList<String>();
        listOperations = getVaraibles();
        String[] varvalues=null;
        List<ViewPageOperationsTable> viewFileList = new ArrayList<ViewPageOperationsTable>();
        for (int j=0;j<=listOperations.size()-1;j++) {
            varvalues=listOperations.get(j).split("=");

            ViewPageOperationsTable viewFileTable = new ViewPageOperationsTable(i, varvalues[0], varvalues[1].replace(";",""));
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewPageVariableTableModel = new ViewPageVariableTableModel(viewFileList);


        return viewPageVariableTableModel;
    }
    public static java.util.List<String> getVaraibles() {
        java.util.List<String> listVariables = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java");

        String variables=null;
        variables=readPageModel.substring(readPageModel.indexOf("//SAP-START - VARIABLE DECLARAITON"),readPageModel.indexOf("//SAP-END - VARIABLE DECLARAITON"));

        variables = variables.replaceAll("//SAP-START - VARIABLE DECLARAITON","");
        String[] var=null;
        String[] varName=null;
        Scanner scanner = new Scanner(variables);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if(!StringUtils.isEmpty(line)){
                if(line.contains("=")) {
                    var = line.split("=");
                    varName = var[0].split(" ");

                    if(!StringUtils.isEmpty(varName[1])) {
                        listVariables.add(varName[1].trim() + "=" + var[1]);
                    }

                }else{
                    varName = line.split(" ");

                    listVariables.add(varName[1].trim() + "=" + "null");

                }
            }
        }
        scanner.close();
        return listVariables;
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
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java");

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
    class UpDownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only when
            //there's a valid selection,
            //so go ahead and move the list item.

            int moveMe = listMethodSteps.getSelectedIndex();

            if (e.getActionCommand().equals(upString)) {
                //UP ARROW BUTTON
                if (moveMe != 0) {
                    //not already at top
                    swap(moveMe, moveMe - 1);
                    listMethodSteps.setSelectedIndex(moveMe - 1);
                    listMethodSteps.ensureIndexIsVisible(moveMe - 1);
                }
            } else {
                //DOWN ARROW BUTTON
                if (moveMe != Init.page_method_steps_ListModel.getSize() - 1) {
                    //not already at bottom
                    swap(moveMe, moveMe + 1);
                    listMethodSteps.setSelectedIndex(moveMe + 1);
                    listMethodSteps.ensureIndexIsVisible(moveMe + 1);
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

            ListSelectionModel lsm = listMethodSteps.getSelectionModel();
            int firstSelected = lsm.getMinSelectionIndex();
            int lastSelected = lsm.getMaxSelectionIndex();
            String stepValue=null;
            int i=0;
            for(int k=firstSelected;k<=lastSelected;k++){
                stepValue=Init.page_method_steps_ListModel.get(k).toString();
                i = i+Generic.getOccurrence(stepValue,"args");

            }

            Init.page_method_steps_ListModel.removeRange(firstSelected, lastSelected);

            int size = Init.page_method_steps_ListModel.size();

            if (size == 0) {
                //List is empty: disable delete, up, and down buttons.
//                btnDelete.setEnabled(false);
//                btnUp.setEnabled(false);
//                btnDown.setEnabled(false);
//                btnSwap.setEnabled(false);

            } else {
                //Adjust the selection.
                if (firstSelected == Init.page_method_steps_ListModel.getSize()) {
                    //Removed item in last position.
                    firstSelected--;
                }
                listMethodSteps.setSelectedIndex(firstSelected);
            }
            GlobalConstants.arg_incrementer=GlobalConstants.arg_incrementer-i;
        }
    }
    private void swap(int a, int b) {
        Object aObject = Init.page_method_steps_ListModel.getElementAt(a);
        Object bObject = Init.page_method_steps_ListModel.getElementAt(b);
        Init.page_method_steps_ListModel.set(a, bObject);
        Init.page_method_steps_ListModel.set(b, aObject);
    }

    public static ViewUtilsTableModel getUtilsmodel(String dirPath){
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

        if(selected_Tree_Node.equalsIgnoreCase("Browser")||selected_Tree_Node.equalsIgnoreCase("Element")||selected_Tree_Node.equalsIgnoreCase("Keyboard")||selected_Tree_Node.equalsIgnoreCase("Mouse")||selected_Tree_Node.equalsIgnoreCase("Wait")){
            readPageModel= Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.FRAMEWORK_DRIVERGENERIC_FOLDER+ File.separator+selected_Tree_Node+".java");
        } else if(selected_Tree_Node.equalsIgnoreCase("DriverGeneric")||selected_Tree_Node.equalsIgnoreCase("Generic")){

        } else{
            readPageModel= Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.FRAMEWORK_UTILGENERIC_FOLDER+ File.separator+selected_Tree_Node+".java");
        }

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

                    //if(!methodName.contains(nodename+"(ConfigTestData")||!methodName.contains("class "+nodename)) {


                    methodSplit = methodName.split("\\(");

                    strsplit = methodSplit[0].split(" ");

                    methodName = strsplit[strsplit.length - 1];


                    listMethods.add(methodName + "(" + methodSplit[1]+"#::#"+methoddesc);
                    methoddesc=null;
                }
            }

            scanner.close();
        }
        return listMethods;
    }



    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnComment;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSwap;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton btnWait;
    private javax.swing.JTextField inputMethodDesc;
    private javax.swing.JTextField inputMethodName;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JList<String> listMethodSteps;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel tabelPanel;
    public static javax.swing.JTable tblLoad;
    private javax.swing.JTree treeConstants;
    private javax.swing.JTree treeDeveloperMode;
    private javax.swing.JTree treePageMethods;
    private javax.swing.JTree treeUtils;
    // End of variables declaration
}
