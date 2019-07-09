package com.saptool.ui.SmartHub.SmartGen.CodeEasy;

import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

public class String_Frame extends javax.swing.JFrame {


    /**
     * Creates new form String
     */
    public String_Frame() {
        initComponents();

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        txtValue = new javax.swing.JLabel();
        inputValue = new javax.swing.JTextField();
        btnDone = new javax.swing.JButton();
        txtMethodTitle = new javax.swing.JLabel();
        txtErrorMesg = new javax.swing.JLabel();

        UI_Design.frame_boarder(this);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnClose.setBorder(null);
        btnClose.setFocusPainted(false);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtValue.setFont(new java.awt.Font("Tahoma", 0, 22));
        txtValue.setForeground(new java.awt.Color(204, 0, 0));
        txtValue.setText("Vlaue: ");

        inputValue.setFont(new java.awt.Font("Tahoma", 0, 22));
        inputValue.setForeground(new java.awt.Color(153, 0, 204));


        UI_Design.button_ui_style_violet(btnDone,"Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        txtMethodTitle.setFont(new java.awt.Font("Tahoma", 0, 25));
        txtMethodTitle.setForeground(new java.awt.Color(0, 0, 255));

        txtErrorMesg.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtErrorMesg.setForeground(new java.awt.Color(255, 0, 51));
        txtErrorMesg.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtMethodTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtErrorMesg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(inputValue, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(txtMethodTitle)
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inputValue, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtErrorMesg)
                                .addGap(26, 26, 26)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 35, Short.MAX_VALUE))
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


    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartgen_Stirng_frame=false;
        dispose();
    }
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        String[] dataType=null;
        int index=Init.METHOD_ARG_VALUE.indexOf(GlobalConstants.METHOD_ARG);

        dataType=GlobalConstants.METHOD_ARG.split(" ");
        if(dataType[0].trim().equalsIgnoreCase("String")){
            Init.METHOD_ARG_VALUE.removeElement(GlobalConstants.METHOD_ARG);
            Init.METHOD_ARG_VALUE.add(index,"\""+inputValue.getText().trim()+"\"");
            dispose();
        } else{
            if(StringUtils.isNumeric(inputValue.getText().trim())){
                Init.METHOD_ARG_VALUE.removeElement(GlobalConstants.METHOD_ARG);
                Init.METHOD_ARG_VALUE.add(index,inputValue.getText().trim());
                dispose();
            } else{
                txtErrorMesg.setText("Enter Interger/ numeric value");
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
                new String_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDone;
    private javax.swing.JTextField inputValue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtMethodTitle;
    private javax.swing.JLabel txtValue;
    private javax.swing.JLabel txtErrorMesg;

    // End of variables declaration
}
