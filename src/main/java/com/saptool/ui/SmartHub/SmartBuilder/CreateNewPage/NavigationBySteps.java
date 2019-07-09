package com.saptool.ui.SmartHub.SmartBuilder.CreateNewPage;

import com.saptool.tables.ViewPageOperationsTable;
import com.saptool.tables.ViewPageOperationsTableModel;
import com.saptool.ui.Frame_Flag;

import com.saptool.ui.Init;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.ViewPageMethodsTable;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.ViewPageMethodsTableModel;
import com.saptool.ui.SmartHub.SmartGen.*;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

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
public class NavigationBySteps extends javax.swing.JFrame {

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
     * Creates new form NavigationBySteps
     */
    public NavigationBySteps() {
        initComponents();
    }


    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        rbPageMethods = new javax.swing.JRadioButton();
        rbPageOperations = new javax.swing.JRadioButton();
        inputBaseUrl = new javax.swing.JTextField();
        inputSearch = new javax.swing.JTextField();
        pagesPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treePages = new javax.swing.JTree();
        tabelPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPageMethods = new javax.swing.JTable();
        controlPanel = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        stepsPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listSteps = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSwap = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnClose.setBorder(null);
        btnClose.setFocusPainted(false);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        rbPageMethods.setBackground(new java.awt.Color(255, 255, 255));
        rbPageMethods.setText("Page Methods");

        rbPageOperations.setBackground(new java.awt.Color(255, 255, 255));
        rbPageOperations.setText("Page Operations");

        bgpagesControls.add(rbPageMethods);
        bgpagesControls.add(rbPageOperations);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                listSteps.requestFocus();
            }
        } );

        inputBaseUrl.setText("Home Page Url or Base page Url");
        inputBaseUrl.setFont(new java.awt.Font("Tahoma", 0, 20));
        inputBaseUrl.setForeground(new java.awt.Color(0, 0, 255));
        inputBaseUrl.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                inputBaseUrl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                if(inputBaseUrl.getText().trim().contains("Home Page Url or Base page Url")){
                    inputBaseUrl.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputBaseUrl.getText())){
                    inputBaseUrl.setText("Home Page Url or Base page Url");
                }
            }

        });

        inputSearch.setText("Search Table");
        inputSearch.setFont(new java.awt.Font("Tahoma", 0, 16));
        inputSearch.setForeground(new java.awt.Color(0, 0, 255));
        inputSearch.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                inputSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                if(inputSearch.getText().trim().contains("Search Table")){
                    inputSearch.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputSearch.getText())){
                    inputSearch.setText("Search Table");
                }
            }

        });
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addComponent(inputBaseUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addComponent(rbPageOperations)
                                                .addGap(33, 33, 33)
                                                .addComponent(rbPageMethods)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(97, 97, 97))))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 21, Short.MAX_VALUE))
                                        .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(inputBaseUrl)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rbPageOperations)
                                                        .addComponent(rbPageMethods))
                                                .addContainerGap())))
        );

        pagesPanel.setBackground(new java.awt.Color(255, 255, 255));
        pagesPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        treePages.setFont(new java.awt.Font("Tahoma", 0, 20));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Pages");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("colors");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("blue");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("violet");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("red");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("yellow");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("sports");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("soccer");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("football");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hockey");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("food");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("hot dogs");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("pizza");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ravioli");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("bananas");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treePages.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treePages.setRowHeight(25);
        jScrollPane2.setViewportView(treePages);
        treePages.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treePages.getLastSelectedPathComponent();
                selected_tree_node=selectedNode_module.toString();
                GlobalConstants.TestScript_Selected_Page_Name=selected_tree_node.replaceAll(".java","");
                if(getRadioselected().equalsIgnoreCase("page operations")){
                    UI_Design.table_ui_style_Vilote_SmartGen(tblPageMethods);
                    tblPageMethods.setModel(getModel_Operations());
                    UI_Design.table_dimenetions_Smartgen(tblPageMethods);

                }else{
                    UI_Design.table_ui_style_Vilote_SmartGen(tblPageMethods);
                    tblPageMethods.setModel(getModel_Methods());
                    UI_Design.table_dimenetions_Smartgen(tblPageMethods);
                }

                // UI_Design.table_dimenetions_ExecutionLab(tblLoad);
            }
        });

        javax.swing.GroupLayout pagesPanelLayout = new javax.swing.GroupLayout(pagesPanel);
        pagesPanel.setLayout(pagesPanelLayout);
        pagesPanelLayout.setHorizontalGroup(
                pagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );
        pagesPanelLayout.setVerticalGroup(
                pagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        tabelPanel.setBackground(new java.awt.Color(255, 255, 255));
        tabelPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblPageMethods.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPageMethods);
        tblPageMethods.getSelectionModel().addListSelectionListener(new SelectionListener());

        javax.swing.GroupLayout tabelPanelLayout = new javax.swing.GroupLayout(tabelPanel);
        tabelPanel.setLayout(tabelPanelLayout);
        tabelPanelLayout.setHorizontalGroup(
                tabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        tabelPanelLayout.setVerticalGroup(
                tabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        controlPanel.setBackground(new java.awt.Color(255, 255, 255));
        controlPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

//        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
//        btnAdd.setText("ADD");
        UI_Design.button_ui_style_violet(btnAdd,"Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

//        btnNext.setBackground(new java.awt.Color(255, 255, 255));
//        btnNext.setText("NEXT");
        UI_Design.button_ui_style_violet(btnNext,"Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
                controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPanelLayout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
                controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
        );

        jScrollPane4.setViewportView(listSteps);

        javax.swing.GroupLayout stepsPanelLayout = new javax.swing.GroupLayout(stepsPanel);
        stepsPanel.setLayout(stepsPanelLayout);
        stepsPanelLayout.setHorizontalGroup(
                stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4)
        );
        stepsPanelLayout.setVerticalGroup(
                stepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Up_Squared_48px.png")));
        btnUp.setActionCommand(upString);
        btnUp.addActionListener(new UpDownListener());

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Drop_Down_48px.png")));
        btnDown.setActionCommand(downString);
        btnDown.addActionListener(new UpDownListener());

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Reduce_48px.png")));
        btnRemove.setActionCommand(deleteString);
        btnRemove.addActionListener(new DeleteButtonListener());

        btnSwap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Root_48px.png")));
        btnSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(controlPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pagesPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tabelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                .addComponent(stepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        mainpanelLayout.setVerticalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tabelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pagesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }



    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
        ObjectBuilder objectBuilder=new ObjectBuilder();
        objectBuilder.setVisible(true);
        dispose();
    }
    public static void initLoad(){
        Init.Nav_Url_BySteps_ListModel.removeAllElements();
        testPages_TreeView();
        rbPageOperations.setSelected(true);
        GlobalConstants.STEP_DESCRIPTION=null;
        GlobalConstants.STEP_EXPECTED=null;
        File fileRoot = new File(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER);
        //Generic.expandAllNodes(treePageMethods, 0, treePageMethods.getRowCount());
        for (int i = 0; i < treePages.getRowCount(); i++) {
            treePages.expandRow(i);
        }

    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        if(Init.Nav_Url_BySteps_ListModel.size()==0){
            if(!StringUtils.isEmpty(inputBaseUrl.getText())) {
                Init.Nav_Url_BySteps_ListModel.addElement("browser.navigateToUrl(\"" + inputBaseUrl.getText() + "\");");
                Init.Nav_Url_BySteps_ListModel.addElement("wait.ToLoad(10)");
            }else{
                JOptionPane.showMessageDialog(null,"Enter Base URL ...");
            }
        }
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

            Init.Nav_Url_BySteps_ListModel.addElement(testScript_selected_Page_Name + "." + selected_table_row);
            listSteps.setModel(Init.Nav_Url_BySteps_ListModel);

        }
    }
    private void btnSwapActionPerformed(ActionEvent evt) {
        int swapEle[]=listSteps.getSelectedIndices();
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

        //defaultListModel.clear();
        for (int i = 0; i < listSteps.getModel().getSize(); i++) {
            //defaultListModel.addElement(String.valueOf(listScriptSteps.getModel().getElementAt(i)));
            Init.TestScript_LisModel.addElement(String.valueOf(listSteps.getModel().getElementAt(i)));
        }

        CreateTestScript.listAutomationSteps.setModel(Init.TestScript_LisModel);

        Init.TestScript_ManualSteps.addElement(GlobalConstants.STEP_DESCRIPTION+"@@@@@"+GlobalConstants.STEP_EXPECTED);

        CreateTestScript.tblManualSteps.setModel(CreateTestScript.getModel());
        UI_Design.table_dimenetions(CreateTestScript.tblManualSteps);
        CreateTestScript.tblManualSteps.setDefaultRenderer(String.class, new CreateTestScript.LineWrapCellRenderer());
        //  defaultListModel.addElement("//SAP-END - METHOD");
//        PageBuilder.scriptBuilder(PageBuilder.script_body_builder(defaultListModel));
//        listScriptSteps.removeSelectionInterval(0,listScriptSteps.getModel().getSize());
        // Init.page_method_steps_ListModel.clear();
       // Frame_Flag.smartgen_addtestscriptStep=false;
        dispose();
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
        Frame_Flag.smartbuilder_CreateNewPage_pageNavigation=false;
        dispose();
    }

    private void btnAssertActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    public static void filter(String query){
        TableRowSorter<ViewPageOperationsTableModel> trObj=new TableRowSorter<ViewPageOperationsTableModel>(viewPageOperationsTableModel);
        tblPageMethods.setRowSorter(trObj);
        trObj.setRowFilter(RowFilter.regexFilter(query));
    }
    public static void testPages_TreeView(){
        File fileRoot = new File(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER);
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);
        treePages.setModel(treeModel);
        treePages.setShowsRootHandles(true);
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
    class UpDownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only when
            //there's a valid selection,
            //so go ahead and move the list item.

            int moveMe = listSteps.getSelectedIndex();

            if (e.getActionCommand().equals(upString)) {
                //UP ARROW BUTTON
                if (moveMe != 0) {
                    //not already at top
                    swap(moveMe, moveMe - 1);
                    listSteps.setSelectedIndex(moveMe - 1);
                    listSteps.ensureIndexIsVisible(moveMe - 1);
                }
            } else {
                //DOWN ARROW BUTTON
                if (moveMe != Init.page_method_steps_ListModel.getSize() - 1) {
                    //not already at bottom
                    swap(moveMe, moveMe + 1);
                    listSteps.setSelectedIndex(moveMe + 1);
                    listSteps.ensureIndexIsVisible(moveMe + 1);
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

            ListSelectionModel lsm = listSteps.getSelectionModel();
            int firstSelected = lsm.getMinSelectionIndex();
            int lastSelected = lsm.getMaxSelectionIndex();
            String stepValue=null;
            int i=0;
            for(int k=firstSelected;k<=lastSelected;k++){
                stepValue=Init.Nav_Url_BySteps_ListModel.get(k).toString();
                i = i+ Generic.getOccurrence(stepValue,"args");
            }

            Init.Nav_Url_BySteps_ListModel.removeRange(firstSelected, lastSelected);

            int size = Init.Nav_Url_BySteps_ListModel.size();

            if (size == 0) {
                //List is empty: disable delete, up, and down buttons.
//                btnDelete.setEnabled(false);
//                btnUp.setEnabled(false);
//                btnDown.setEnabled(false);
//                btnSwap.setEnabled(false);

            } else {
                //Adjust the selection.
                if (firstSelected == Init.Nav_Url_BySteps_ListModel.getSize()) {
                    //Removed item in last position.
                    firstSelected--;
                }
                listSteps.setSelectedIndex(firstSelected);
            }
            GlobalConstants.arg_incrementer=GlobalConstants.arg_incrementer-i;
        }
    }
    private void swap(int a, int b) {
        Object aObject = Init.Nav_Url_BySteps_ListModel.getElementAt(a);
        Object bObject = Init.Nav_Url_BySteps_ListModel.getElementAt(b);
        Init.Nav_Url_BySteps_ListModel.set(a, bObject);
        Init.Nav_Url_BySteps_ListModel.set(b, aObject);
    }
    public static ViewPageOperationsTableModel getModel_Operations() {
        int i=1;
        java.util.List<String> listOperations = new ArrayList<String>();
        listOperations = getOperations();
        java.util.List<ViewPageOperationsTable> viewFileList = new ArrayList<ViewPageOperationsTable>();
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
        java.util.List<String> listMethods = new ArrayList<String>();
        listMethods = getMethods();
        java.util.List<ViewPageMethodsTable> viewFileList = new ArrayList<ViewPageMethodsTable>();
        for (int j=0;j<=listMethods.size()-1;j++) {
            ;
            ViewPageMethodsTable viewFileTable = new ViewPageMethodsTable(i, listMethods.get(j), "");
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewPageMethodsTableModel = new ViewPageMethodsTableModel(viewFileList);


        return viewPageMethodsTableModel;
    }
    public static java.util.List<String> getMethods() {
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
            int row = tblPageMethods.getSelectedRow();
            if(row < 0)
                return;
            int col = tblPageMethods.getSelectedColumn();
            if(col < 0)
                return;

            if (tblPageMethods.getRowSorter()!=null) {
                row = tblPageMethods.getRowSorter().convertRowIndexToModel(row);
            }
            //tblPages.clearSelection();
            selected_table_row = (String) tblPageMethods.getModel().getValueAt(row, 1);


            tblPageMethods.setSelectionBackground(Color.ORANGE);
            // txtProjectName.setText(selected_Project.toUpperCase());

        }
    }

    public static String getRadioselected(){
        if(rbPageOperations.isSelected()){
            return rbPageOperations.getText();
        }else {
            return rbPageMethods.getText();
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NavigationBySteps().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSwap;
    private javax.swing.JButton btnUp;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField inputBaseUrl;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listSteps;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JPanel pagesPanel;
    private static javax.swing.JRadioButton rbPageMethods;
    private static javax.swing.JRadioButton rbPageOperations;
    private javax.swing.JPanel stepsPanel;
    private javax.swing.JPanel tabelPanel;
    private static javax.swing.JTable tblPageMethods;
    private static javax.swing.JTree treePages;
    // End of variables declaration
}
