package com.saptool.ui.SmartHub.SmartGen.CodeEasy;

import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import com.saptool.utils.GlobalConstants;

/**
 *
 * @author bvatrapu
 */
public class VerifyTextOptions extends javax.swing.JFrame {

    /**
     * Creates new form VerifyTextOptions
     */
    public VerifyTextOptions() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboOptions = new javax.swing.JComboBox<>();
        btnDone = new javax.swing.JButton();

        UI_Design.frame_boarder(this);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 25));
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Select Option:");

        comboOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXACTMATCH", "EXACTMATCHIGNORECASE", "PARTIAL" }));


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
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel1)
                                                .addGap(72, 72, 72)
                                                .addComponent(comboOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(217, 217, 217)
                                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboOptions)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
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

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        String opt=comboOptions.getSelectedItem().toString();
        String temp1=null;
        switch (opt){
            case "EXACTMATCH":
                temp1="Constants.VERIFY_TEXT_EXACTMATCH";
                break;
            case "EXACTMATCHIGNORECASE":
                temp1="Constants.VERIFY_TEXT_EXACTMATCHIGNORECASE";
                break;
            case "PARTIAL":
                temp1="Constants.VERIFY_TEXT_PARTIAL";
                break;
        }
        int index= Init.METHOD_ARG_VALUE.indexOf(GlobalConstants.METHOD_ARG);
        Init.METHOD_ARG_VALUE.removeElement(GlobalConstants.METHOD_ARG);
        Init.METHOD_ARG_VALUE.add(index,temp1);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerifyTextOptions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnDone;
    private javax.swing.JComboBox<String> comboOptions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration
}
