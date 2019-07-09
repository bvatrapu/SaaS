package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent;


import com.saptool.ui.Init;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Verify extends JFrame {

    public static String Selected_Page=null;
    /**
     * Creates new form Verify
     */
    public Verify() {
        initComponents();
    }


    private void initComponents() {

        comboPage = new JComboBox<>();
        txtPage = new JLabel();
        btnObjects = new JButton();
        btnMethods = new JButton();
        btnActions = new JButton();
        jScrollPane1 = new JScrollPane();
        listVerificationPoint = new JList<>();
        btnDone = new JButton();
        cbVerifyUrl = new JCheckBox();
        btnDelete = new JButton();



        txtPage.setText("Page:  ");

        btnObjects.setText("Objects");
        btnObjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObjectsActionPerformed(evt);
            }
        });

        btnMethods.setText("Methods");
        btnMethods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMethodsActionPerformed(evt);
            }
        });

        btnActions.setText("Actions");
        btnActions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionsActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listVerificationPoint);

        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        cbVerifyUrl.setText("Verify Url");

        btnDelete.setText("Del");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(41, 41, 41)
                                                                .addComponent(btnObjects, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(73, 73, 73)
                                                                .addComponent(btnMethods)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnActions, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(25, 25, 25))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtPage)
                                                                                .addGap(64, 64, 64)
                                                                                .addComponent(comboPage, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(57, 57, 57)
                                                                                .addComponent(cbVerifyUrl)
                                                                                .addGap(2, 2, 2)))))
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDelete))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(239, 239, 239)
                                                .addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPage)
                                        .addComponent(cbVerifyUrl))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnObjects, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMethods, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnActions, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete))
                                .addGap(36, 36, 36)
                                .addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void initLoad(){
        Selected_Page=GlobalConstants.TestScript_Selected_Page_Name;
        String[] pages=null;
        String page=null;

        pages = Generic.getAllFileNames(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER);
        for(int i=0;i<=pages.length-1;i++){
            if(pages[i].contains(".java")){
                page=pages[i].replace(".java", "");
            }
            comboPage.addItem(page);
        }
    }

    private void btnObjectsActionPerformed(java.awt.event.ActionEvent evt) {

        GlobalConstants.TestScript_Selected_Page_Name = comboPage.getSelectedItem().toString();

//        PageObjects pageObjects=new PageObjects();
//        pageObjects.setVisible(true);
//        pageObjects.initLoad();
    }


    private void btnMethodsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnActionsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        String veri=null;
        String final_veri=null;
        GlobalConstants.TestScript_Selected_Page_Name = Selected_Page;
        DefaultListModel defaultListModelVerify=new DefaultListModel();
        defaultListModelVerify.clear();
        for (int i = 0; i < listVerificationPoint.getModel().getSize(); i++) {
            if(veri==null){
                veri=String.valueOf(listVerificationPoint.getModel().getElementAt(i));
            } else {
                veri = veri +" && "+String.valueOf(listVerificationPoint.getModel().getElementAt(i));
            }
        }
        final_veri = "return verify("+veri+")";
        Init.page_method_steps_ListModel.addElement(final_veri);


        //SmartComponent_New.listPageMethodSteps.setModel(Init.page_method_steps_ListModel);
        GlobalConstants.Method_Verify=false;
        dispose();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Verify().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton btnActions;
    private JButton btnDelete;
    private JButton btnDone;
    private JButton btnMethods;
    private JButton btnObjects;
    private JCheckBox cbVerifyUrl;
    private JComboBox<String> comboPage;
    private JScrollPane jScrollPane1;
    public static JList<String> listVerificationPoint;
    private JLabel txtPage;
    // End of variables declaration
}
