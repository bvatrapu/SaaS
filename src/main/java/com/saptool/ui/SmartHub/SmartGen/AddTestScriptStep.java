package com.saptool.ui.SmartHub.SmartGen;

import com.saptool.tables.ViewPageObjectsTableModel;
import com.saptool.tables.ViewPageOperationsTable;
import com.saptool.tables.ViewPageOperationsTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;


import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates.Objects_existance;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates.Submit_Form;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.ViewPageMethodsTable;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.ViewPageMethodsTableModel;
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
public class AddTestScriptStep extends javax.swing.JFrame {
    private static final String upString = "Move up";
    private static final String downString = "Move down";
    private static final String deleteString = "Delete";

    public static ButtonGroup bgpagesControls = new ButtonGroup();
    static DefaultMutableTreeNode root;
    static DefaultTreeModel treeModel;
    public static String selected_tree_node=null;
    public static ViewPageOperationsTableModel viewPageOperationsTableModel = null;
    public static ViewPageMethodsTableModel viewPageMethodsTableModel=null;
    public static String selected_table_row = null;

    public static String testScript_selected_Page_Name=null;

    /**
     * Creates new form DeveloperTool
     */
    public AddTestScriptStep() {
        initComponents();
    }


    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        inputSearch = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        rbOperations = new javax.swing.JRadioButton();
        rbMethods = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        treePageMethods = new javax.swing.JTree();
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
        btnStepCreate = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnComment = new javax.swing.JButton();
        btnWait = new javax.swing.JButton();
        btnNegative = new javax.swing.JButton();
        btnVerify = new javax.swing.JButton();
        btnAssert = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaExpected = new javax.swing.JTextArea();
        txtStepCounter = new javax.swing.JLabel();
        btnTestdatasetup = new javax.swing.JButton();

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

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        rbOperations.setBackground(new java.awt.Color(255, 255, 255));
        rbOperations.setFont(new java.awt.Font("Tahoma", 0, 20));
        rbOperations.setForeground(new java.awt.Color(0, 102, 153));
        rbOperations.setText("Operations");
        rbOperations.setToolTipText("");
//        rbOperations.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                tblLoad.setModel(getModel_Operations());
//
//            }
//        });

        rbMethods.setBackground(new java.awt.Color(255, 255, 255));
        rbMethods.setFont(new java.awt.Font("Tahoma", 0, 20));
        rbMethods.setForeground(new java.awt.Color(0, 102, 153));
        rbMethods.setText("Methods");
        rbMethods.setToolTipText("");
//        rbOperations.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                tblLoad.setModel(getModel_Operations());
//
//            }
//        });

        bgpagesControls.add(rbOperations);
        bgpagesControls.add(rbMethods);
        txtStepCounter.setFont(new java.awt.Font("Tahoma", 0, 25));
        txtStepCounter.setForeground(new java.awt.Color(51, 153, 0));
        txtStepCounter.setText("Step:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(rbOperations, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(rbMethods, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(txtStepCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(rbOperations)
                                                .addComponent(rbMethods)
                                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtStepCounter))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        treePageMethods.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Page Methods", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 102, 0)));
        treePageMethods.setFont(new java.awt.Font("Tahoma", 0, 20));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Pages");
        treePageMethods.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treePageMethods.setRowHeight(27);
        jScrollPane5.setViewportView(treePageMethods);
        treePageMethods.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treePageMethods.getLastSelectedPathComponent();
                selected_tree_node=selectedNode_module.toString();
                GlobalConstants.TestScript_Selected_Page_Name=selected_tree_node.replaceAll(".java","");
                if(getRadioselected().equalsIgnoreCase("operations")){
                    UI_Design.table_ui_style_Vilote_SmartGen(tblLoad);
                    tblLoad.setModel(getModel_Operations());
                    UI_Design.table_dimenetions_Smartgen(tblLoad);

                }else{
                    UI_Design.table_ui_style_Vilote_SmartGen(tblLoad);
                    tblLoad.setModel(getModel_Methods());
                    UI_Design.table_dimenetions_Smartgen(tblLoad);
                }

               // UI_Design.table_dimenetions_ExecutionLab(tblLoad);
            }
        });

//        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
//        jPanel2.setLayout(jPanel2Layout);
//        jPanel2Layout.setHorizontalGroup(
//                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
//        );
//        jPanel2Layout.setVerticalGroup(
//                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
//        );
        btnTestdatasetup.setBackground(new java.awt.Color(255, 255, 255));
        btnTestdatasetup.setFont(new java.awt.Font("Tahoma", 0, 24));
        btnTestdatasetup.setText("TestData Setup");
        btnTestdatasetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestdatasetupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addComponent(btnTestdatasetup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTestdatasetup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        tblLoad.getSelectionModel().addListSelectionListener(new SelectionListener());

        javax.swing.GroupLayout tabelPanelLayout = new javax.swing.GroupLayout(tabelPanel);
        tabelPanel.setLayout(tabelPanelLayout);
        tabelPanelLayout.setHorizontalGroup(
                tabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        tabelPanelLayout.setVerticalGroup(
                tabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listMethodSteps.setFont(new java.awt.Font("Tahoma", 0, 20));
        listMethodSteps.setForeground(new java.awt.Color(0, 102, 255));
        //listMethodSteps.setCellRenderer(new MyListCellRenderer());
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
        //btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Add_New_30px.png")));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnStepCreate.setBackground(new java.awt.Color(255, 255, 255));
        btnStepCreate.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnStepCreate.setForeground(new java.awt.Color(0, 153, 51));
        //btnStepCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Ok_30px.png")));
        btnStepCreate.setText("Step Create");
        btnStepCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStepCreateActionPerformed(evt);
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
                                .addComponent(btnStepCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(btnStepCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnComment.setBackground(new java.awt.Color(255, 255, 255));
        btnComment.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnComment.setForeground(new java.awt.Color(102, 0, 102));
        btnComment.setText("Comment");
        btnComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommentActionPerformed(evt);
            }
        });

        btnWait.setBackground(new java.awt.Color(255, 255, 255));
        btnWait.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnWait.setForeground(new java.awt.Color(102, 0, 102));
        btnWait.setText("Wait");
        btnWait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaitActionPerformed(evt);
            }
        });

        btnNegative.setBackground(new java.awt.Color(255, 255, 255));
        btnNegative.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnNegative.setForeground(new java.awt.Color(102, 0, 102));
        btnNegative.setText("Negative");
        btnNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegativeActionPerformed(evt);
            }
        });

        btnVerify.setBackground(new java.awt.Color(255, 255, 255));
        btnVerify.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnVerify.setForeground(new java.awt.Color(102, 0, 102));
        btnVerify.setText("Verify");
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        btnAssert.setBackground(new java.awt.Color(255, 255, 255));
        btnAssert.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnAssert.setForeground(new java.awt.Color(102, 0, 102));
        btnAssert.setText("Assert");
        btnAssert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnNegative)
                                .addGap(18, 18, 18)
                                .addComponent(btnVerify)
                                .addGap(18, 18, 18)
                                .addComponent(btnAssert)
                                .addGap(37, 37, 37)
                                .addComponent(btnWait)
                                .addGap(26, 26, 26)
                                .addComponent(btnComment)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnComment, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(btnWait, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(btnNegative, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(btnVerify, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(btnAssert, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtAreaDescription.setColumns(20);
        txtAreaDescription.setFont(new java.awt.Font("Monospaced", 0, 18));
        txtAreaDescription.setForeground(new java.awt.Color(102, 102, 102));
        txtAreaDescription.setRows(5);
        txtAreaDescription.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20), new java.awt.Color(0, 0, 255)));
        jScrollPane3.setViewportView(txtAreaDescription);

        txtAreaExpected.setColumns(20);
        txtAreaExpected.setFont(new java.awt.Font("Monospaced", 0, 18));
        txtAreaExpected.setForeground(new java.awt.Color(102, 102, 102));
        txtAreaExpected.setRows(5);
        txtAreaExpected.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Expected", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20), new java.awt.Color(0, 0, 255)));
        jScrollPane4.setViewportView(txtAreaExpected);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane4)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tabelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 1, Short.MAX_VALUE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(0, 0, 0))))
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
                                                .addGap(0, 0, 0)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
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
    public static void initLoad(){
        GlobalConstants.STEP_NO= GlobalConstants.STEP_NO+1;
        txtStepCounter.setText("Step: "+Integer.toString(GlobalConstants.STEP_NO));
        Init.Add_TestScript_step_ListModel.removeAllElements();
        testPages_TreeView();
        rbOperations.setSelected(true);
        GlobalConstants.STEP_DESCRIPTION=null;
        GlobalConstants.STEP_EXPECTED=null;
        File fileRoot = new File(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER);
        //Generic.expandAllNodes(treePageMethods, 0, treePageMethods.getRowCount());
        for (int i = 0; i < treePageMethods.getRowCount(); i++) {
            treePageMethods.expandRow(i);
        }

    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {

        testScript_selected_Page_Name=selected_tree_node.toLowerCase().replaceAll(".java","").trim();
        if(selected_table_row.contains("String... args")){
            GlobalConstants.SELECTED_METHOD=selected_table_row.substring(0,selected_table_row.indexOf("String... args"));


            String method=null;
            //methodname=selected_Page_Method.replaceAll("\(String\[\] args\)","");
            String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+selected_tree_node);

            String methodname=selected_table_row.substring(0,selected_table_row.indexOf("("));

            method=readPageModel.substring(readPageModel.indexOf("//SAP - "+methodname+" - START"),readPageModel.indexOf("//SAP - "+methodname+" - END"));

            //int count = methodname.length() - methodname.replaceAll("args","").length() - 1;
            int count = StringUtils.countMatches(method, "args[");

            String[] listMethodargs = new String[count];
            Scanner scanner = new Scanner(method);
            String step=null;
            int i=0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if(line.contains("args[")){

                    step=line.substring(0, line.indexOf("args["));
                    step=step.trim();
                    if(step.contains(",")) {
                        step = step.replaceAll(",", "");
                        step = step.replaceAll(step.substring(0, step.indexOf("(")), "").replaceAll("\\(", "");
                    }

                    listMethodargs[i]=step.replaceAll("\\(","");
                    i=i+1;
                    //listMethodargs.add(step);
                }
            }

            SetupTestMethodArgs setupTestMethodArgs=new SetupTestMethodArgs();
            setupTestMethodArgs.setVisible(true);
            SetupTestMethodArgs.init_Load(listMethodargs);
        } else {
            if(GlobalConstants.VERIFY_SCRIPT_COMMAND){
                Init.Add_TestScript_step_ListModel.addElement("verify("+testScript_selected_Page_Name + "." + selected_table_row+");");
                listMethodSteps.setModel(Init.Add_TestScript_step_ListModel);
                btnVerify.setEnabled(true);
                listMethodSteps.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
                GlobalConstants.VERIFY_SCRIPT_COMMAND = false;
            }else if(GlobalConstants.NEGATIVE_VERIFY_SCRIPT_COMMAND){
                Init.Add_TestScript_step_ListModel.addElement("_verify("+testScript_selected_Page_Name + "." + selected_table_row+");");
                listMethodSteps.setModel(Init.Add_TestScript_step_ListModel);
                btnVerify.setEnabled(true);
                listMethodSteps.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
                GlobalConstants.NEGATIVE_VERIFY_SCRIPT_COMMAND = false;
            } else {
//            int count = string.length() - string.replaceAll("g","").length()
                Init.Add_TestScript_step_ListModel.addElement(testScript_selected_Page_Name+ "." + selected_table_row+";");
                listMethodSteps.setModel(Init.Add_TestScript_step_ListModel);
            }

        }
    }
    private void btnSwapActionPerformed(ActionEvent evt) {
        int swapEle[]=listMethodSteps.getSelectedIndices();
        swap(swapEle[0], swapEle[1]);
    }
    private void btnTestdatasetupActionPerformed(java.awt.event.ActionEvent evt) {
        if(!Frame_Flag.smartgen_testdatasetup){
            TestDataSetup testDataSetup=new TestDataSetup();
            testDataSetup.setVisible(true);
            TestDataSetup.init_Load();
            Frame_Flag.smartgen_testdatasetup=true;
        }
    }
    private void btnStepCreateActionPerformed(java.awt.event.ActionEvent evt) {

        GlobalConstants.STEP_DESCRIPTION=txtAreaDescription.getText();
        GlobalConstants.STEP_EXPECTED=txtAreaExpected.getText();
        if(StringUtils.isEmpty(GlobalConstants.STEP_DESCRIPTION) || StringUtils.isEmpty(GlobalConstants.STEP_EXPECTED)){
            JOptionPane.showMessageDialog(null,"Enter Step Descprtion and Expected");
        } else {
            Init.TestScript_LisModel.addElement(System.lineSeparator());
            Init.TestScript_LisModel.addElement("//Step No: " + GlobalConstants.STEP_NO);
            Init.TestScript_LisModel.addElement("configTestData.stepDescription=" + "\"" + GlobalConstants.STEP_DESCRIPTION + "\"" + ";");
            Init.TestScript_LisModel.addElement("configTestData.stepExpected=" + "\"" + GlobalConstants.STEP_EXPECTED + "\"" + ";");
            //Generic.createFolder(GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+GlobalConstants.SCRIPT_NAME+".java");
            //DefaultListModel defaultListModel=new DefaultListModel();
            //defaultListModel.clear();
            for (int i = 0; i < listMethodSteps.getModel().getSize(); i++) {
                //defaultListModel.addElement(String.valueOf(listScriptSteps.getModel().getElementAt(i)));
                Init.TestScript_LisModel.addElement(String.valueOf(listMethodSteps.getModel().getElementAt(i)));
            }

            CreateTestScript.listAutomationSteps.setModel(Init.TestScript_LisModel);

            Init.TestScript_ManualSteps.addElement(GlobalConstants.STEP_DESCRIPTION + "@@@@@" + GlobalConstants.STEP_EXPECTED);

            CreateTestScript.tblManualSteps.setModel(CreateTestScript.getModel());
            UI_Design.table_dimenetions(CreateTestScript.tblManualSteps);
            CreateTestScript.tblManualSteps.setDefaultRenderer(String.class, new CreateTestScript.LineWrapCellRenderer());
            //  defaultListModel.addElement("//SAP-END - METHOD");
//        PageBuilder.scriptBuilder(PageBuilder.script_body_builder(defaultListModel));
//        listScriptSteps.removeSelectionInterval(0,listScriptSteps.getModel().getSize());
            // Init.page_method_steps_ListModel.clear();
            Frame_Flag.smartgen_addtestscriptStep = false;
            dispose();
        }
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

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartgen_addtestscriptStep=false;
        dispose();
    }

    private void btnNegativeActionPerformed(java.awt.event.ActionEvent evt) {
        btnNegative.setEnabled(false);
        listMethodSteps.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3,new java.awt.Color(255,127,39) ));
        GlobalConstants.NEGATIVE_VERIFY_SCRIPT_COMMAND=true;
        AddTestScriptStep.jlistCellrender();
    }

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {
        btnVerify.setEnabled(false);
        listMethodSteps.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3,new java.awt.Color(255,127,39) ));
        GlobalConstants.VERIFY_SCRIPT_COMMAND=true;
        AddTestScriptStep.jlistCellrender();
    }

    private void btnAssertActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    public static void filter(String query){
        TableRowSorter<ViewPageOperationsTableModel> trObj=new TableRowSorter<ViewPageOperationsTableModel>(viewPageOperationsTableModel);
        tblLoad.setRowSorter(trObj);
        trObj.setRowFilter(RowFilter.regexFilter(query));
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
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTestScriptStep().setVisible(true);
            }
        });
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
                stepValue=Init.Add_TestScript_step_ListModel.get(k).toString();
                i = i+ Generic.getOccurrence(stepValue,"args");
            }

            Init.Add_TestScript_step_ListModel.removeRange(firstSelected, lastSelected);

            int size = Init.Add_TestScript_step_ListModel.size();

            if (size == 0) {
                //List is empty: disable delete, up, and down buttons.
//                btnDelete.setEnabled(false);
//                btnUp.setEnabled(false);
//                btnDown.setEnabled(false);
//                btnSwap.setEnabled(false);

            } else {
                //Adjust the selection.
                if (firstSelected == Init.Add_TestScript_step_ListModel.getSize()) {
                    //Removed item in last position.
                    firstSelected--;
                }
                listMethodSteps.setSelectedIndex(firstSelected);
            }
            GlobalConstants.arg_incrementer=GlobalConstants.arg_incrementer-i;
        }
    }
    private void swap(int a, int b) {
        Object aObject = Init.Add_TestScript_step_ListModel.getElementAt(a);
        Object bObject = Init.Add_TestScript_step_ListModel.getElementAt(b);
        Init.Add_TestScript_step_ListModel.set(a, bObject);
        Init.Add_TestScript_step_ListModel.set(b, aObject);
    }
    public static ViewPageOperationsTableModel getModel_Operations() {
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
    public static List<String> getOperations() {
        List<String> listOperations = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+selected_tree_node);

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
    public static ViewPageMethodsTableModel getModel_Methods() {
        int i=1;
        List<String> listMethods = new ArrayList<String>();
        listMethods = getMethods();
        List<ViewPageMethodsTable> viewFileList = new ArrayList<ViewPageMethodsTable>();
        for (int j=0;j<=listMethods.size()-1;j++) {
            ;
            ViewPageMethodsTable viewFileTable = new ViewPageMethodsTable(i, listMethods.get(j), "");
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewPageMethodsTableModel = new ViewPageMethodsTableModel(viewFileList);


        return viewPageMethodsTableModel;
    }
    public static List<String> getMethods() {
        List<String> listMethods = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+selected_tree_node);

        String methods=null;
        methods=readPageModel.substring(readPageModel.indexOf("//SAP-START - METHOD DECLARAITON"),readPageModel.indexOf("//SAP-END - METHOD DECLARAITON"));

        methods = methods.replaceAll("//SAP-START - METHOD DECLARAITON","");

//        String[] lines = operations.split(System.getProperty("line.separator"));

        Scanner scanner = new Scanner(methods);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.contains("public String")){

                listMethods.add(line.substring(line.indexOf("public String "), line.indexOf("{")).replaceAll("public String ",""));
            } else if(line.contains("public void")){

                listMethods.add(line.substring(line.indexOf("public void "), line.indexOf("{")).replaceAll("public void ",""));
            }
        }
        scanner.close();
        return listMethods;
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
            //tblPages.clearSelection();
            selected_table_row = (String) tblLoad.getModel().getValueAt(row, 1);


            tblLoad.setSelectionBackground(Color.ORANGE);
            // txtProjectName.setText(selected_Project.toUpperCase());

        }
    }

    public static String getRadioselected(){
        if(rbOperations.isSelected()){
            return rbOperations.getText();
        }else {
            return rbMethods.getText();
        }
    }
    static class MyListCellRenderer extends JLabel implements ListCellRenderer {
        public MyListCellRenderer() {
            super();
            //setOpaque(true);
        }
        public Component getListCellRendererComponent(JList paramlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());
            Object textVal=paramlist.getModel().getElementAt(index);

            if(textVal.toString().contains("verify")){
                setFont(new java.awt.Font("Tahoma", 0, 20));
                setForeground(new java.awt.Color(32, 170, 73));
                setBackground(Color.white);
                setEnabled(true);
            } else{
                if(textVal.toString().contains("//")){
                    setFont(new java.awt.Font("Tahoma", 0, 20));
                    setForeground(Color.GRAY);
                    setBackground(Color.white);
                    setEnabled(true);
                } else{
                    setFont(new java.awt.Font("Tahoma", 0, 20));
                    setForeground(new java.awt.Color(0, 102, 255));
                    setBackground(Color.white);
                    setEnabled(true);

                    //  setForeground(Color.GRAY);
                }
            }

//            if (value.toString().contains("//")) {
//                paramlist.setfo
//                setForeground(Color.ORANGE);
//            }

            return this;
        }
    }
    public static void jlistCellrender(){
        listMethodSteps.setCellRenderer(new MyListCellRenderer());
    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnComment;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnNegative;
    private javax.swing.JButton btnStepCreate;
    private javax.swing.JButton btnSwap;
    private javax.swing.JButton btnUp;
    public static javax.swing.JButton btnVerify;
    private javax.swing.JButton btnAssert;
    private javax.swing.JButton btnWait;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public static javax.swing.JList<String> listMethodSteps;
    private javax.swing.JPanel mainPanel;
    public static javax.swing.JRadioButton rbMethods;
    public static javax.swing.JRadioButton rbOperations;
    private javax.swing.JPanel tabelPanel;
    public static javax.swing.JTable tblLoad;
    public static javax.swing.JTree treePageMethods;
    public static javax.swing.JTextArea txtAreaDescription;
    public static javax.swing.JTextArea txtAreaExpected;
    public static javax.swing.JLabel txtStepCounter;
    private javax.swing.JButton btnTestdatasetup;
    // End of variables declaration
}

