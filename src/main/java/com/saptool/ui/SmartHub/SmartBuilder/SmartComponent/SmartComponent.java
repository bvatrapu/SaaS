package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent;


import com.saptool.tables.ViewPageObjectsTableModel;
import com.saptool.tables.ViewPageOperationsTable;
import com.saptool.tables.ViewPageOperationsTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates.Template;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

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
public class SmartComponent extends javax.swing.JFrame {
    public static ViewPageOperationsTableModel viewPageOperationsTableModel = null;
    public static String selected_Page_Method = null;
    /**
     * Creates new form SmartObject
     */
    public SmartComponent() {
        initComponents();
    }


    private void initComponents() {

        btnNew2 = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMethods = new javax.swing.JTable();
        txtPageName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        inputSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        btnNew2.setText("New ");

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        tblMethods.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "Sno", "Obj Name", "Obj Type"
                }
        ));
        UI_Design.table_ui_style_blue(tblMethods);
        UI_Design.table_dimenetions(tblMethods);
        jScrollPane1.setViewportView(tblMethods);
        tblMethods.getSelectionModel().addListSelectionListener(new SelectionListener());


        txtPageName.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtPageName.setForeground(new java.awt.Color(0, 0, 153));
        txtPageName.setText("Page Name");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnNew.setForeground(new java.awt.Color(102, 0, 153));
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnUpdate.setForeground(new java.awt.Color(102, 0, 153));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnDelete.setForeground(new java.awt.Color(102, 0, 153));
        btnDelete.setText("Delete");
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
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                        .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.setBorder(null);
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
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Search_32px.png")));
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtPageName, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(82, 82, 82))))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(txtPageName)
                                                .addGap(44, 44, 44))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(inputSearch))
                                                .addGap(28, 28, 28)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        txtPageName.setText(GlobalConstants.SELECTED_PAGE);
        loadTable();
    }
    public static void loadTable(){
        tblMethods.setModel(getModel());
        UI_Design.table_dimenetions(tblMethods);
    }
    public static ViewPageOperationsTableModel getModel() {
        int i=1;
        List<String> listMethods = new ArrayList<String>();
        listMethods = getMethods();
        List<ViewPageOperationsTable> viewFileList = new ArrayList<ViewPageOperationsTable>();
        for (int j=0;j<=listMethods.size()-1;j++) {

            ViewPageOperationsTable viewFileTable = new ViewPageOperationsTable(i, listMethods.get(j), "");
            viewFileList.add(viewFileTable);
            i = i + 1;
        }
        viewPageOperationsTableModel = new ViewPageOperationsTableModel(viewFileList);


        return viewPageOperationsTableModel;
    }
    public static List<String> getMethods() {
        List<String> listMethods = new ArrayList<String>();
        String readPageModel = Generic.readText(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER+ File.separator+GlobalConstants.TestScript_Selected_Page_Name+".java");

        String methods=null;
        methods=readPageModel.substring(readPageModel.indexOf("//SAP-START - METHOD DECLARAITON"),readPageModel.indexOf("//SAP-END - METHOD DECLARAITON"));

        methods = methods.replaceAll("//SAP-START - METHOD DECLARAITON","");

//        String[] lines = operations.split(System.getProperty("line.separator"));

        Scanner scanner = new Scanner(methods);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.contains("public")){

                if(line.contains("public void")) {
                    listMethods.add(line.substring(line.indexOf("public void "), line.indexOf("{")).replaceAll("public void ", ""));
                } else {
                    listMethods.add(line.substring(line.indexOf("public String "), line.indexOf("{")).replaceAll("public String ", ""));
                }
            }
        }
        scanner.close();
        return listMethods;
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        if(!Frame_Flag.smartBuilder_smartComponent_temlpate) {
            Template template = new Template();
            template.setVisible(true);
            Frame_Flag.smartBuilder_smartComponent_temlpate=true;
            dispose();

        }

    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"Under Development");
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"Under Development");
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartBuilder_smartComponent=false;
        dispose();
    }
    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblMethods.getSelectedRow();
            if(row < 0)
                return;
            int col = tblMethods.getSelectedColumn();
            if(col < 0)
                return;

            if (tblMethods.getRowSorter()!=null) {
                row = tblMethods.getRowSorter().convertRowIndexToModel(row);
            }
            //tblPages.clearSelection();
            selected_Page_Method = (String) tblMethods.getModel().getValueAt(row, 1);
            GlobalConstants.SELECTED_PAGE=selected_Page_Method;

            tblMethods.setSelectionBackground(Color.ORANGE);
            // txtProjectName.setText(selected_Project.toUpperCase());

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmartComponent().setVisible(true);
            }
        });
    }

    public static void filter(String query){
        TableRowSorter<ViewPageOperationsTableModel> tr=new TableRowSorter<ViewPageOperationsTableModel>(viewPageOperationsTableModel);
        tblMethods.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(query.trim()));
    }

    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        filter(inputSearch.getText());
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNew2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    public static javax.swing.JTable tblMethods;
    public static javax.swing.JLabel txtPageName;
    // End of variables declaration
}
