package com.saptool.ui.main;


import com.saptool.utils.Generic;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class HubWarning extends javax.swing.JFrame {
    public Generic generic = new Generic();
    /**
     * Creates new form HubWarning
     */
    public HubWarning() {
        initComponents();
    }


    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        txtMessage = new javax.swing.JLabel();
        btnYes = new javax.swing.JButton();
        btnNO = new javax.swing.JButton();



        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        txtMessage.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtMessage.setForeground(new java.awt.Color(51, 0, 255));
        //txtMessage.setText("Hub is Already running.. Do you want to Stop ?");

        btnYes.setBackground(new java.awt.Color(255, 255, 255));
        btnYes.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnYes.setText("YES");
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYesActionPerformed(evt);
            }
        });

        btnNO.setBackground(new java.awt.Color(255, 255, 255));
        btnNO.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnNO.setText("NO");
        btnNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addGap(98, 98, 98)
                                                .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(108, 108, 108)
                                                .addComponent(btnNO, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNO, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {
        txtMessage.setText("");
        txtMessage.setText("Hub and Node Closing.....");
        generic.stopHub_Node();
        dispose();
    }

    private void btnNOActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HubWarning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnNO;
    private javax.swing.JButton btnYes;
    public static javax.swing.JLabel txtMessage;
    private javax.swing.JPanel panelMain;
    // End of variables declaration
}

