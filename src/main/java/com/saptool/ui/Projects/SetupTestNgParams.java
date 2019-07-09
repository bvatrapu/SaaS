package com.saptool.ui.Projects;


import com.saptool.frameworkbuilder.FrameworkBuilder;
import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class SetupTestNgParams extends JFrame {

    /**
     * Creates new form SetupParams
     */
    public SetupTestNgParams() {
        initComponents();
    }


    private void initComponents() {

        jPanel1 = new JPanel();
        txtTestNGParamName = new JLabel();
        inputParameter = new JTextField();
        btnAdd = new JButton();
        jScrollPane1 = new JScrollPane();
        listParams = new JList<>();
        //icon = new javax.swing.JLabel();
        btnNext = new JButton();
        txtProjectBasedParams = new JLabel();
        txtDefaultParams = new JLabel();
        txtDefaultParams1 = new JLabel();
        btnRemove = new javax.swing.JButton();


        setTitle("SetupTestNgParams");
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTestNGParamName.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtTestNGParamName.setForeground(new java.awt.Color(0, 51, 204));
        txtTestNGParamName.setText("TestNG Param Name:");

        inputParameter.setFont(new java.awt.Font("Tahoma", 1, 18));
        inputParameter.setForeground(new java.awt.Color(0, 153, 51));

        btnAdd.setBackground(new java.awt.Color(0, 122, 181));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("+");
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        listParams.setFont(new java.awt.Font("Tahoma", 1, 18));
        listParams.setForeground(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(listParams);

//        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newpackage/images (4).jpg")));


        UI_Design.button_ui_style_blue(btnNext,"Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        txtProjectBasedParams.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtProjectBasedParams.setForeground(new java.awt.Color(102, 0, 204));
        txtProjectBasedParams.setText("Project based Parameters:");

        txtDefaultParams.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtDefaultParams.setForeground(new java.awt.Color(102, 0, 204));
        txtDefaultParams.setText("Default Parameters:");

        txtDefaultParams1.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtDefaultParams1.setForeground(new java.awt.Color(0, 153, 51));
        txtDefaultParams1.setText("browser, platform and enviornment");

//        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGap(69, 69, 69))
//                                               // .addComponent(icon)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGap(41, 41, 41)
//                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                                .addComponent(txtTestNGParamName, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
//                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                                                                .addComponent(inputParameter, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
//                                                                .addGap(18, 18, 18)
//                                                                .addComponent(btnAdd))
//                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 797, GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(txtProjectBasedParams)
//                                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                                .addComponent(txtDefaultParams)
//                                                                .addGap(18, 18, 18)
//                                                                .addComponent(txtDefaultParams1))))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGap(333, 333, 333)
//                                                .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
//                                .addContainerGap(30, Short.MAX_VALUE))
//        );
//        jPanel1Layout.setVerticalGroup(
//                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addGap(50, 50, 50)
//                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(txtDefaultParams)
//                                        .addComponent(txtDefaultParams1))
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
//                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
//                                        .addComponent(inputParameter)
//                                        .addComponent(txtTestNGParamName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
//                                .addGap(48, 48, 48)
//                                .addComponent(txtProjectBasedParams)
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//                               // .addComponent(icon)
//                                .addGap(40, 40, 40)
//                                .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
//                                .addGap(32, 32, 32))
//        );

       // btnRemove.setText("Remove");
        UI_Design.button_ui_style_violet(btnRemove,"Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(69, 69, 69))
                                               // .addComponent(icon))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtTestNGParamName, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(inputParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnAdd))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtProjectBasedParams)
                                                                .addGap(129, 129, 129)
                                                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtDefaultParams)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtDefaultParams1))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(333, 333, 333)
                                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDefaultParams)
                                        .addComponent(txtDefaultParams1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputParameter)
                                        .addComponent(txtTestNGParamName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtProjectBasedParams)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                //.addComponent(icon)
                                .addGap(40, 40, 40)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void init_Load(){
        Init.paramNameListModel.removeAllElements();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetupTestNgParams().setVisible(true);
            }
        });
    }
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        ListSelectionModel lsm = listParams.getSelectionModel();
        int firstSelected = lsm.getMinSelectionIndex();
//        int lastSelected = lsm.getMaxSelectionIndex();
//
//        Init.paramNameListModel.removeRange(firstSelected, lastSelected);
        Init.paramNameListModel.removeElement(listParams.getModel().getElementAt(firstSelected));
//        int size = Init.paramNameListModel.size();
//
//        if (size == 0) {
//            //List is empty: disable delete, up, and down buttons.
////                btnDelete.setEnabled(false);
////                btnUp.setEnabled(false);
////                btnDown.setEnabled(false);
////                btnSwap.setEnabled(false);
//
//        } else {
//            //Adjust the selection.
//            if (firstSelected == Init.paramNameListModel.getSize()) {
//                //Removed item in last position.
//                firstSelected--;
//            }
//            listParams.setSelectedIndex(firstSelected);
//        }
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt){
        boolean flag = true;

        if (inputParameter.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter Parameter");
            flag=false;
            return;
        }
        if(flag) {
            String input_Param=inputParameter.getText().toLowerCase();
            // paramNamesAndvaluesListModel.addElement(inputParameter.getText());
            if (Init.paramNameListModel.contains(input_Param)){
                JOptionPane.showMessageDialog(null, input_Param+":  Already Exist !");
            } else {
                Init.paramNameandValuesListModel.addElement(input_Param);
                Init.paramNameListModel.addElement(input_Param);


                listParams.setModel(Init.paramNameListModel);
                listParams.setSelectedIndex(0);
                inputParameter.setText("");
                inputParameter.setFocusable(true);
            }
        }
    }
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
        Generic.createProject_Setup(GlobalConstants.Project_Name);
        for(int i=0;i<=Init.paramNameListModel.size()-1;i++){
            FrameworkBuilder.updateTestNGParam_BeforeMethod(Init.paramNameListModel.get(i).toString());
        }

                   // Generic.writeParamProp(Init.paramNameListModel);
        dispose();
        ConfigProjectTestParamValues configProjectTestParamValues=new ConfigProjectTestParamValues();
        configProjectTestParamValues.setVisible(true);
        ConfigProjectTestParamValues.init_Load();

//        SetupParamValues setupParamValues=new SetupParamValues();
//        setupParamValues.setVisible(true);
//        SetupParamValues.initLoad();

    }
    // Variables declaration - do not modify
    private JButton btnAdd;
    private JButton btnNext;
    private javax.swing.JButton btnRemove;
    //private javax.swing.JLabel icon;
    private JTextField inputParameter;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JList<String> listParams;
    private JLabel txtDefaultParams;
    private JLabel txtDefaultParams1;
    private JLabel txtProjectBasedParams;
    private JLabel txtTestNGParamName;
    // End of variables declaration
}

