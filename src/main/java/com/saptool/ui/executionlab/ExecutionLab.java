package com.saptool.ui.executionlab;


import com.saptool.tables.ViewExecutionLabTestScriptsTable;
import com.saptool.tables.ViewExecutionLabTestScriptsTableModel;
import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ExecutionLab extends javax.swing.JPanel {
    public static ViewExecutionLabTestScriptsTableModel viewExecutionLabTestScriptsTableModel = null;
    public static String selected_TestScript = null;
    public static String[] selected_TestScripts = null;
    static DefaultMutableTreeNode root;
    GridBagLayout gridBagLayout = new GridBagLayout();
    static DefaultTreeModel treeModel;
    public static boolean boolean_saas=false;
    public static String script_path=null;
    static String value="";

    public static Platform_EL platform;
    public static Browsers_EL browsers;
    public static TestNgParams_EL testNgParams;
    public static Controls controls;
    /**
     * Creates new form ExecutionLabTests
     */
    public ExecutionLab() {
        initComponents();

        platform=new Platform_EL();
        browsers= new Browsers_EL();
        testNgParams = new TestNgParams_EL();
        controls=new Controls();

        panleConfigExec.setLayout(gridBagLayout);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panleConfigExec.add(platform,c);

        c.gridx = 0;
        c.gridy = 0;
        panleConfigExec.add(browsers,c);

        c.gridx = 0;
        c.gridy = 0;
        panleConfigExec.add(testNgParams,c);

        c.gridx = 0;
        c.gridy = 0;
        panleConfigExec.add(controls,c);

        setpanelNotVisible();

    }
    public static void setpanelNotVisible(){
        platform.setVisible(false);
        browsers.setVisible(false);
        testNgParams.setVisible(false);
        controls.setVisible(false);
    }


    private void initComponents() {

        panelScriptsTree = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        treeScripts = new javax.swing.JTree();
        panelTestscriptsTable = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTestSripts = new javax.swing.JTable();
        panelTestSuiteTree = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treeTestSuites = new javax.swing.JTree();
        panleConfigExec = new javax.swing.JPanel();

        setBackground(new Color(255, 255, 255));

        panelScriptsTree.setBackground(new Color(102, 102, 255));

        treeScripts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Scripts", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 18), new Color(102, 0, 204)));
//        treeScripts.setFont(new java.awt.Font("Tahoma", 0, 16));
//        treeScripts.setRowHeight(27);
        jScrollPane3.setViewportView(treeScripts);
        treeScripts.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treeScripts.getLastSelectedPathComponent();
                TreePath treepath = e.getPath();

                Object elements[] = treepath.getPath();
                value = elements[1]+"\\";
                for (int i = 2, n = elements.length; i < n; i++) {
                    value=value+elements[i]+"\\";
                }

                if(boolean_saas) {
                    GlobalConstants.SELECTED_EXEC_NODE_MODULE = selectedNode_module.toString();
                    tblTestSripts.setModel(getModel(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER + File.separator + selectedNode_module));
                    UI_Design.table_dimenetions_ExecutionLab(tblTestSripts);
                } else {
                    tblTestSripts.setModel(getModel(script_path + File.separator + value));
                    UI_Design.table_dimenetions_ExecutionLab(tblTestSripts);
                }
                value=null;
            }

        });

        javax.swing.GroupLayout panelScriptsTreeLayout = new javax.swing.GroupLayout(panelScriptsTree);
        panelScriptsTree.setLayout(panelScriptsTreeLayout);
        panelScriptsTreeLayout.setHorizontalGroup(
                panelScriptsTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3)
        );
        panelScriptsTreeLayout.setVerticalGroup(
                panelScriptsTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3)
        );

        panelTestscriptsTable.setBackground(new Color(153, 255, 255));

//        tblTestSripts.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null}
//                },
//                new String [] {
//                        "Sno", "Test Script Name"
//                }
//        ));
        UI_Design.table_ui_style_blue(tblTestSripts);

        jScrollPane4.setViewportView(tblTestSripts);

        javax.swing.GroupLayout panelTestscriptsTableLayout = new javax.swing.GroupLayout(panelTestscriptsTable);
        panelTestscriptsTable.setLayout(panelTestscriptsTableLayout);
        panelTestscriptsTableLayout.setHorizontalGroup(
                panelTestscriptsTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
        );
        panelTestscriptsTableLayout.setVerticalGroup(
                panelTestscriptsTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTestscriptsTableLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelTestSuiteTree.setBackground(new Color(255, 255, 255));

      //  treeTestSuites.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Test Suites", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 18), new Color(0, 0, 153)));
//        jScrollPane2.setViewportView(treeTestSuites);

        javax.swing.GroupLayout panelTestSuiteTreeLayout = new javax.swing.GroupLayout(panelTestSuiteTree);
        panelTestSuiteTree.setLayout(panelTestSuiteTreeLayout);
        panelTestSuiteTreeLayout.setHorizontalGroup(
                panelTestSuiteTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        panelTestSuiteTreeLayout.setVerticalGroup(
                panelTestSuiteTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
        );

        panleConfigExec.setBackground(new Color(255, 255, 255));

        javax.swing.GroupLayout panleConfigExecLayout = new javax.swing.GroupLayout(panleConfigExec);
        panleConfigExec.setLayout(panleConfigExecLayout);
        panleConfigExecLayout.setHorizontalGroup(
                panleConfigExecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panleConfigExecLayout.setVerticalGroup(
                panleConfigExecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(panelTestSuiteTree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelScriptsTree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelTestscriptsTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panleConfigExec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(panelTestscriptsTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelScriptsTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelTestSuiteTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panleConfigExec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }
    public static void init_Load(){
        //((DefaultTableModel) tblTestSripts.getModel()).setRowCount(0);
        tblTestSripts.setModel(getEmptyModel());
        UI_Design.table_dimenetions_ExecutionLab(tblTestSripts);
        nonSaaSControls();
        setpanelNotVisible();
        platform.setVisible(true);

//        root = new DefaultMutableTreeNode("root", true);
//       getList(root, new File(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER));

    }
    public static void nonSaaSControls(){
        File saas = new File(GlobalConstants.PROJECTS_FOLDER_PATH+File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.FRAMEWORK_FOLDER);
        boolean_saas=saas.exists();
        if(saas.exists()){
            platform.setVisible(true);
            File fileRoot = new File(GlobalConstants.SELECTED_PROJECT_PATH +File.separator+GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER);
            root = new DefaultMutableTreeNode(new FileNode(fileRoot));
            treeModel = new DefaultTreeModel(root);
            treeScripts.setModel(treeModel);
            treeScripts.setShowsRootHandles(true);
            CreateChildNodes ccn =
                    new CreateChildNodes(fileRoot, root);
            new Thread(ccn).start();
        }else{
            String path = Generic.readProp("Scripts_Path",GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.projectpaths_properties);
            script_path = GlobalConstants.SELECTED_PROJECT_PATH +File.separator+path;

            testNgParams.setVisible(true);
            TestNgParams_EL.init_Load();
            TestNgParams_EL.btnLeft.setVisible(false);
            File fileRoot = new File(script_path);
            root = new DefaultMutableTreeNode(new FileNode(fileRoot));
            treeModel = new DefaultTreeModel(root);
            treeScripts.setModel(treeModel);
            treeScripts.setShowsRootHandles(true);
            CreateChildNodes ccn =
                    new CreateChildNodes(fileRoot, root);
            new Thread(ccn).start();
        }
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
                if (file.isDirectory()) {
                    createChildren(file, childNode);
                    node.add(childNode);
                }
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
    private void btnRunAllActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnRunSelectedActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnAddQueueActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnCreateSuiteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnStopAllActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void getList(DefaultMutableTreeNode node, File f) {
        if(f.isDirectory()) {
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(f);
            node.add(child);
            File fList[] = f.listFiles();
            for(int i = 0; i  < fList.length; i++)
                getList(child, fList[i]);
        }

    }
    void doMouseClicked(MouseEvent me) {
        TreePath tp = treeScripts.getPathForLocation(me.getX(), me.getY());
        if (tp != null) {

        }
    }
    public static ViewExecutionLabTestScriptsTableModel getModel(String dirPath) {
        int i=1;
        if(dirPath!=null) {

            File file = new File(dirPath);
            String[] names = file.list();

            //build the list
            List<ViewExecutionLabTestScriptsTable> viewExecutionLabTestScriptsTables = new ArrayList<ViewExecutionLabTestScriptsTable>();
            if (names != null) {
                for (String name : names) {

                  if(name.contains(".java")) {
                      ViewExecutionLabTestScriptsTable viewSmartGenTable = new ViewExecutionLabTestScriptsTable(i, name);
                      viewExecutionLabTestScriptsTables.add(viewSmartGenTable);
                      i = i + 1;
                  }
                    //  }
                }

            }
            viewExecutionLabTestScriptsTableModel = new ViewExecutionLabTestScriptsTableModel(viewExecutionLabTestScriptsTables);
        }
        return viewExecutionLabTestScriptsTableModel;
    }

    public static ViewExecutionLabTestScriptsTableModel getEmptyModel() {
        int i=1;
        List<ViewExecutionLabTestScriptsTable> viewExecutionLabTestScriptsTables = new ArrayList<ViewExecutionLabTestScriptsTable>();
        ViewExecutionLabTestScriptsTable viewSmartGenTable = new ViewExecutionLabTestScriptsTable(i, "");
        viewExecutionLabTestScriptsTables.add(viewSmartGenTable);

        viewExecutionLabTestScriptsTableModel = new ViewExecutionLabTestScriptsTableModel(viewExecutionLabTestScriptsTables);

        return viewExecutionLabTestScriptsTableModel;
    }

    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;

            int row = tblTestSripts.getSelectedRow();
            int[] rows=tblTestSripts.getSelectedRows();
            if(row < 0)
                return;
            if(rows.length < 0)
                return;
            int col = tblTestSripts.getSelectedColumn();
            if(col < 0)
                return;

            if (tblTestSripts.getRowSorter()!=null) {
                row = tblTestSripts.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_TestScript = (String) tblTestSripts.getModel().getValueAt(row, 1);
            GlobalConstants.TABLE_SELECTED_PROJECT = selected_TestScript;
            Init.testScripts.clear();
            for (int rowvalue : rows){
                Init.testScripts.add((String) tblTestSripts.getModel().getValueAt(rowvalue, 1));
            }

            tblTestSripts.setSelectionBackground(Color.ORANGE);
            //  txtProjectName.setText(selected_TestScript.toUpperCase());

        }
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelScriptsTree;
    private javax.swing.JPanel panelTestSuiteTree;
    private javax.swing.JPanel panelTestscriptsTable;
    private javax.swing.JPanel panleConfigExec;
    public static javax.swing.JTable tblTestSripts;
    public static javax.swing.JTree treeScripts;
    public static javax.swing.JTree treeTestSuites;
    // End of variables declaration
}
