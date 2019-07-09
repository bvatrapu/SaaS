package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Buttons;


import bsh.StringUtil;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Wait extends javax.swing.JFrame {

    /**
     * Creates new form Comment
     */
    public Wait() {
        initComponents();
    }


    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        txtWait = new javax.swing.JLabel();
        inputWait = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        txtWait.setFont(new java.awt.Font("Segoe UI", 1, 24));
        txtWait.setForeground(new java.awt.Color(51, 0, 204));
        txtWait.setText("Wait in Sec: ");

        inputWait.setFont(new java.awt.Font("Tahoma", 0, 24));
        inputWait.setForeground(new java.awt.Color(102, 102, 102));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.setBorder(null);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });


        UI_Design.button_ui_style_violet(btnDone,"Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(txtWait)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(inputWait, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(366, 366, 366)
                                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtWait)
                                        .addComponent(inputWait, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(btnDone, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                .addContainerGap())
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
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartBuilder_wait=false;
        dispose();
    }

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        if(StringUtils.isNumeric(inputWait.getText())) {
            Init.page_method_steps_ListModel.addElement("Wait.sleep(" + inputWait.getText() + ")");
            Frame_Flag.smartBuilder_wait=false;
            dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Enter number as input");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wait().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDone;
    private javax.swing.JTextField inputWait;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel txtWait;
    // End of variables declaration
}

