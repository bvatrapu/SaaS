package com.saptool.ui.main;


import com.saptool.tables.ViewProjectsTable;
import com.saptool.tables.ViewProjectsTableModel;
import com.saptool.tables.ViewQueueTable;
import com.saptool.tables.ViewQueueTableModel;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bvatrapu
 */
public class Schedular extends javax.swing.JPanel {
    public static ViewQueueTableModel viewQueueTableModel = null;
    public static String selected_Queue = null;
    /**
     * Creates new form Projects
     */
    public Schedular() {
        initComponents();
        init_Load();
    }

    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        schTable = new javax.swing.JTable();
        btnRun = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSchedule = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        schTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(schTable);

        btnRun.setText("Run");

        btnDelete.setText("Delete");

        btnSchedule.setText("Schedule");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(95, 95, 95)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(205, 205, 205)
                                                .addComponent(btnRun, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(124, 124, 124)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(104, 104, 104)
                                                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRun, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
    }

    public static void init_Load(){
        schTable.setModel(getModel(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+"queue"));
        UI_Design.table_dimenetions_twocolumn(schTable);
        UI_Design.table_ui_style_blue(schTable);
    }
    public static ViewQueueTableModel getModel(String dirPath) {
        int i=1;
        if(dirPath!=null) {
            File file = new File(dirPath);

            String[] names = file.list();
            //build the list
            List<ViewQueueTable> viewFileList = new ArrayList<ViewQueueTable>();
            if (names != null) {
                for (String name : names) {
                    name=name.replaceAll(".properties","");
                    ViewQueueTable viewFileTable = new ViewQueueTable(i, name);
                    viewFileList.add(viewFileTable);
                    i = i + 1;
                }

            }
            viewQueueTableModel = new ViewQueueTableModel(viewFileList);

        }
        return viewQueueTableModel;
    }

    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = schTable.getSelectedRow();
            if(row < 0)
                return;
            int col = schTable.getSelectedColumn();
            if(col < 0)
                return;

            if (schTable.getRowSorter()!=null) {
                row = schTable.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_Queue = (String) schTable.getModel().getValueAt(row, 1);
            GlobalConstants.TABLE_SELECTED_PROJECT = selected_Queue;

            schTable.setSelectionBackground(new Color(48, 48, 48));
            schTable.setSelectionForeground(new Color(255, 255, 255));


        }
    }
    public static void loadProjectTable(){
        schTable.setModel(getModel(GlobalConstants.PROJECTS_FOLDER_PATH));
        UI_Design.table_dimenetions(schTable);
    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable schTable;
    // End of variables declaration
}
