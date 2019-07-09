package com.saptool.ui.reports;

import com.saptool.tables.*;
import com.saptool.ui.Projects.Projects;
import com.saptool.ui.UI_Design;
import com.saptool.ui.main.Grid;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Reports extends javax.swing.JPanel {
    public static ViewReportsTableModel viewReportsTableModel = null;
    public static String selected_Report = null;
    /**
     * Creates new form Projects
     */
    public Reports() {
        initComponents();
        chkboxChrome.setSelected(true);
    }


    private void initComponents() {

        btnEditXML = new javax.swing.JLabel();
        robo = new javax.swing.JLabel();
        btnOpen = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReports = new javax.swing.JTable();
        inputSearch = new javax.swing.JTextField();
        iconChrome = new javax.swing.JLabel();
        chkboxChrome = new javax.swing.JCheckBox();
        btnRemove = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        UI_Design.button_ui_style_blue(btnOpen,"OPEN");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });


        UI_Design.table_ui_style_blue(tblReports);
        jScrollPane2.setViewportView(tblReports);
        tblReports.getSelectionModel().addListSelectionListener(new SelectionListener());

//        inputSearch.setFont(new java.awt.Font("Tahoma", 0, 25));
//        inputSearch.setForeground(new java.awt.Color(102, 102, 102));
        inputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputSearchKeyReleased(evt);
            }
        });
        inputSearch.setFont(new java.awt.Font("Tahoma", 0, 22));
        inputSearch.setForeground(new java.awt.Color(153, 153, 255));
        inputSearch.setText("  Search Report");
        inputSearch.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                inputSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                if(inputSearch.getText().trim().contains("Search Report")){
                    inputSearch.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if(StringUtils.isEmpty(inputSearch.getText())){
                    inputSearch.setText("  Search Report");
                }
            }

        });


        chkboxChrome.setBackground(new java.awt.Color(255, 255, 255));
        chkboxChrome.setText("Open in Chrome");

        UI_Design.button_ui_style_blue(btnRemove,"REMOVE");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        iconChrome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Chrome_48px.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1012, 1012, 1012)
                                                .addComponent(robo))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64)
                                                .addComponent(iconChrome))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(171, 171, 171)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnEditXML))
                                                .addGap(144, 144, 144)
                                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(chkboxChrome)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(iconChrome))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkboxChrome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(robo)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditXML)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public static void init_Load(){
        tblReports.setModel(getReportsModel());
        UI_Design.table_dimenetions(tblReports);
    }
    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {
        if(chkboxChrome.isSelected()){
            Thread object = new Thread(new openInChrome());
            object.start();
        } else {
            try {
                File htmlFile = new File(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + "ExtentReports" + File.separator + selected_Report + ".html");
                Desktop.getDesktop().browse(htmlFile.toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    class openInChrome implements Runnable{
        @Override
        public void run() {
            try {
                File f=new File(GlobalConstants.Chrome_Browser_Path_32bit);
                File f64=new File(GlobalConstants.Chrome_Browser_Path_64bit);
                if(f.exists()) {
                    ProcessBuilder pb = new ProcessBuilder(GlobalConstants.Chrome_Browser_Path_32bit, GlobalConstants.SELECTED_PROJECT_PATH + File.separator + "ExtentReports" + File.separator + selected_Report + ".html");
                    pb.start();
                } else{
                    if(f64.exists()) {
                        ProcessBuilder pb = new ProcessBuilder(GlobalConstants.Chrome_Browser_Path_32bit, GlobalConstants.SELECTED_PROJECT_PATH + File.separator + "ExtentReports" + File.separator + selected_Report + ".html");
                        pb.start();
                    } else{
                        JOptionPane.showMessageDialog(null,"Chrome browser is not installed in your machine");
                    }
                }
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }
        }
    }
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        int i = JOptionPane.showConfirmDialog(this, "Do you want delete..");
        if(i==0){
            Generic.fileDelete(GlobalConstants.SELECTED_PROJECT_PATH+File.separator+"ExtentReports"+File.separator+selected_Report+".html");
            tblReports.setModel(getReportsModel());
            UI_Design.table_dimenetions(tblReports);
        }
    }
    public static ViewReportsTableModel getReportsModel() {
        int i=1;

            File file = new File(GlobalConstants.SELECTED_PROJECT_PATH+File.separator+"ExtentReports");
            String[] names = file.list();
            //build the list
            List<ViewReportsTable> viewFileList = new ArrayList<ViewReportsTable>();
            if (names != null) {
                for (String name : names) {
                    // if (new File(dirPath + name).isFile()) {
                if(name.contains(".html")) {
                    name=name.replaceAll(".html","");
                    ViewReportsTable viewFileTable = new ViewReportsTable(i, name, Generic.getFolderCreateDate(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + "ExtentReports" + File.separator + name+".html").toString().substring(0, 10));
                    viewFileList.add(viewFileTable);
                    i = i + 1;
                    //  }
                }
                }

            }
            viewReportsTableModel = new ViewReportsTableModel(viewFileList);


        return viewReportsTableModel;
    }

    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblReports.getSelectedRow();
            if(row < 0)
                return;
            int col = tblReports.getSelectedColumn();
            if(col < 0)
                return;

            if (tblReports.getRowSorter()!=null) {
                row = tblReports.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_Report = (String) tblReports.getModel().getValueAt(row, 1);
            //GlobalConstants.TABLE_SELECTED_PROJECT = selected_Project;

            tblReports.setSelectionBackground(new Color(48, 48, 48));
            tblReports.setSelectionForeground(new Color(255, 255, 255));
            //tblReports.setText(selected_Report.toUpperCase());

        }
    }

    public static void filter(String query){
        TableRowSorter<ViewReportsTableModel> tr=new TableRowSorter<ViewReportsTableModel>(viewReportsTableModel);
        tblReports.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    private void inputSearchKeyReleased(java.awt.event.KeyEvent evt) {
        filter(inputSearch.getText());
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel btnEditXML;
    private javax.swing.JButton btnOpen;
    private javax.swing.JCheckBox chkboxChrome;
    private javax.swing.JLabel iconChrome;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel robo;
    public static javax.swing.JTable tblReports;
    private javax.swing.JButton btnRemove;
    // End of variables declaration
}
