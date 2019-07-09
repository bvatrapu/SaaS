package com.saptool.ui.SmartHub.SmartGen;


import com.saptool.ui.Init;
import com.saptool.ui.SmartHub.SmartGen.CodeEasy.String_Frame;
import com.saptool.ui.SmartHub.SmartGen.CodeEasy.VerifyTextOptions;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author bvatrapu
 */
public class Method_Args extends javax.swing.JFrame {

    /**
     * Creates new form Method_Args
     */
    public Method_Args() {
        initComponents();
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMethodArgs = new javax.swing.JList<>();
        btnDone = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        listMethodArgs.addMouseListener(mouseListener);
        jScrollPane1.setViewportView(listMethodArgs);


        UI_Design.button_ui_style_violet(btnDone,"Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void init_Load(){
        listMethodArgs.setModel(Init.METHOD_ARG_VALUE);
    }
    public boolean verifyList(){
        boolean flag=true;
        for(int q=0;q<=Init.METHOD_ARG_VALUE.size()-1;q++){
            if(Init.METHOD_ARG_VALUE.getElementAt(0).toString().contains(" ")){
                flag=false;
                break;
            }
        }
        return flag;
    }
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        String method_args=null;
        String add_method_arg_val=null;
        String selected_table_row=null;
        String temp2=null;
    if(verifyList()) {
        method_args = Init.METHOD_ARG_VALUE.getElementAt(0).toString();
        for (int q = 1; q <= Init.METHOD_ARG_VALUE.size() - 1; q++) {
            method_args = method_args + ", " + Init.METHOD_ARG_VALUE.getElementAt(q).toString();
        }


        selected_table_row = GlobalConstants.selected_table_row.replaceAll(GlobalConstants.args.replaceAll("\\(", ""), method_args);

            if(selected_table_row.contains("static")){
                selected_table_row = selected_table_row.replaceAll("static","").trim();
                add_method_arg_val =GlobalConstants.selected_Tree_Node.replaceAll(".java", "") + "." + selected_table_row;

            } else{
                selected_table_row=selected_table_row.trim();
                add_method_arg_val = Generic.convertFirstcharLowerCase(GlobalConstants.selected_Tree_Node.replaceAll(".java", "")) + "." + selected_table_row;
            }

        Init.Test_Method_args.addElement(add_method_arg_val);
        SetupTestMethodArgs.listTestData.setModel(Init.Test_Method_args);
//
        dispose();
    }else {
        JOptionPane.showMessageDialog(null, "Enter All Arguments", "Warning " , JOptionPane.INFORMATION_MESSAGE);
    }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Method_Args().setVisible(true);
            }
        });
    }

    MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent) {
            if(listMethodArgs.getSelectedValue()==null){
                JOptionPane.showMessageDialog(null, "Select Argument", "Warning " , JOptionPane.INFORMATION_MESSAGE);
            } else {
                GlobalConstants.METHOD_ARG = listMethodArgs.getSelectedValue();
//                if (Init.param_Selected.contains("=")) {
//                    String[] param = Init.param_Selected.split("=");
//                    Init.param_Name = param[0];
//                } else {
//                    Init.param_Name = listMethodArgs.getSelectedValue();
//                }
                if(GlobalConstants.METHOD_ARG.contains("verifyTextOptions")||GlobalConstants.METHOD_ARG.contains("VERIFY_TEXT")){
                    VerifyTextOptions verifyTextOptions=new VerifyTextOptions();
                    verifyTextOptions.setVisible(true);
                } else {
                    String_Frame string_frame = new String_Frame();
                    string_frame.setVisible(true);
                }

            }
        }
    };

    // Variables declaration - do not modify
    private javax.swing.JButton btnDone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JList<String> listMethodArgs;
    // End of variables declaration
}
