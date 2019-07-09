package com.saptool.ui.executionlab;


import com.saptool.ui.Init;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class SetupParams extends JFrame {

    public SetupParams() {
        initComponents();
        initLoad();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        txtTestNGParamName = new JLabel();
        inputParameter = new JTextField();
        btnAdd = new JButton();
        jScrollPane1 = new JScrollPane();
        listParams = new JList<>();
        icon = new JLabel();
        btnNext = new JButton();

        setTitle("SetupParams");

        btnAdd.setFocusPainted(false);
        btnNext.setFocusPainted(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTestNGParamName.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtTestNGParamName.setForeground(new java.awt.Color(0, 51, 204));
        txtTestNGParamName.setText("TestNG Param Name:");

        inputParameter.setFont(new java.awt.Font("Tahoma", 1, 18));
        inputParameter.setForeground(new java.awt.Color(0, 0, 255));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnAdd.setForeground(new java.awt.Color(0, 0, 153));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jScrollPane1.setViewportView(listParams);
        listParams.addMouseListener(mouseListener);

        icon.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Setup_Param.jpg")));

        btnNext.setBackground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(txtTestNGParamName, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(inputParameter, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(259, 259, 259)
                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(icon)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputParameter)
                                        .addComponent(txtTestNGParamName, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(icon)
                                                .addGap(140, 140, 140))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                                .addGap(190, 190, 190))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
              /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetupParams().setVisible(true);
            }
        });
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt){
        boolean flag = true;
        if (inputParameter.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter Parameter");
            flag=false;
            return;
        }
        if(flag) {

            // paramNamesAndvaluesListModel.addElement(inputParameter.getText());
            if (Init.paramNameListModel.contains(inputParameter.getText())){
                JOptionPane.showMessageDialog(null, inputParameter.getText()+":  Already Exist !");
            } else {
                Init.paramNameandValuesListModel.addElement(inputParameter.getText());
                Init.paramNameListModel.addElement(inputParameter.getText());

                listParams.setModel(Init.paramNameListModel);
                listParams.setSelectedIndex(0);
                inputParameter.setText("");
            }
        }
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt){
        if(listParams.getSelectedValue().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Select Param");
        }else {
            inputParameter.setText(listParams.getSelectedValue());
            Init.paramNameListModel.removeElement(listParams.getSelectedValue());
            Init.paramNameandValuesListModel.removeElement(listParams.getSelectedValue());
        }
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt){
        //paramNameListModel.removeElement(listParams.getSelectedValue());
    }
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {

        Generic.writeParamProp(Init.paramNameandValuesListModel);


        SetupParamValues setupParamValues=new SetupParamValues();
        setupParamValues.setVisible(true);
        SetupParamValues.initLoad();
        dispose();
    }

    public static void initLoad(){
        Init.globalParamNamesListModel();
        listParams.setModel(Init.paramNameListModel);
    }
    MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent) {
           ParamUpdateDelete paramUpdateDelete=new ParamUpdateDelete();
           paramUpdateDelete.setVisible(true);
        }
    };
    // Variables declaration - do not modify
    private JButton btnAdd;
    private JButton btnNext;
    private JLabel icon;
    public static JTextField inputParameter;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    public static JList<String> listParams;
    private JLabel txtTestNGParamName;
    // End of variables declaration
}
