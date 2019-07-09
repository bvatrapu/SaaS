package com.saptool.ui.SmartHub;

import com.saptool.ui.SmartHub.SmartBuilder.SmartBuilder;
import com.saptool.ui.main.Main;

/**
 *
 * @author bvatrapu
 */
public class SmartHub extends javax.swing.JPanel {

    /**
     * Creates new form Projects
     */
    public SmartHub() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSmartBuilder = new javax.swing.JButton();
        btnSmartGen = new javax.swing.JButton();
        btnSpyIntelligance = new javax.swing.JButton();

        setBackground(new java.awt.Color(179, 193, 206));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/SATHUb.jpg")));

        btnSmartBuilder.setFont(new java.awt.Font("Tahoma", 0, 32));
        btnSmartBuilder.setForeground(new java.awt.Color(8, 36, 169));
        btnSmartBuilder.setBackground(new java.awt.Color(179, 193, 206));
        btnSmartBuilder.setText("Smart Builder");
        btnSmartBuilder.setBorderPainted(true);
        btnSmartBuilder.setFocusPainted(false);
        btnSmartBuilder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSmartBuilderActionPerformed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSmartBuilder.setBackground(new java.awt.Color(8, 36, 169));
                btnSmartBuilder.setForeground(new java.awt.Color(255, 255, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSmartBuilder.setBackground(new java.awt.Color(179, 193, 206));
                btnSmartBuilder.setForeground(new java.awt.Color(8, 36, 169));
            }
        });

        btnSmartGen.setFont(new java.awt.Font("Tahoma", 0, 32));
        btnSmartGen.setForeground(new java.awt.Color(8, 36, 169));
        btnSmartGen.setBackground(new java.awt.Color(179, 193, 206));
        btnSmartGen.setText("Smart Gen");
        btnSmartGen.setBorderPainted(true);
        btnSmartGen.setFocusPainted(false);
        btnSmartGen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSmartGenActionPerformed(evt);
                //btnSmartBuilderActionPerformed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSmartGen.setBackground(new java.awt.Color(8, 36, 169));
                btnSmartGen.setForeground(new java.awt.Color(255, 255, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSmartGen.setBackground(new java.awt.Color(179, 193, 206));
                btnSmartGen.setForeground(new java.awt.Color(8, 36, 169));
            }
        });

//        btnSmartGen.setBackground(new java.awt.Color(179, 193, 206));
//        btnSmartGen.setText("Smart Gen");
//        btnSmartGen.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnSmartGenActionPerformed(evt);
//            }
//        });

        btnSpyIntelligance.setFont(new java.awt.Font("Tahoma", 0, 32));
        btnSpyIntelligance.setForeground(new java.awt.Color(8, 36, 169));
        btnSpyIntelligance.setBackground(new java.awt.Color(179, 193, 206));
        btnSpyIntelligance.setText("Spy IntelliJ");

        btnSpyIntelligance.setBorderPainted(true);
        btnSpyIntelligance.setFocusPainted(false);
        btnSpyIntelligance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSpyIntelliganceActionPerformed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSpyIntelligance.setBackground(new java.awt.Color(8, 36, 169));
                btnSpyIntelligance.setForeground(new java.awt.Color(255, 255, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSpyIntelligance.setBackground(new java.awt.Color(179, 193, 206));
                btnSpyIntelligance.setForeground(new java.awt.Color(8, 36, 169));
            }
        });

//        btnSpyIntelligance.setBackground(new java.awt.Color(179, 193, 206));
//        btnSpyIntelligance.setText("Spy Intelligance");
//        btnSpyIntelligance.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnSpyIntelliganceActionPerformed(evt);
//            }
//        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSmartBuilder, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(btnSmartGen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(btnSpyIntelligance, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnSmartGen, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                .addComponent(btnSpyIntelligance, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                        .addComponent(btnSmartBuilder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    private void btnSmartBuilderActionPerformed(java.awt.event.MouseEvent evt) {
       Main.setpanelNotVisible();
        Main.panelBody.setBackground(new java.awt.Color(255, 255, 255));
       Main.smartBuilder.setVisible(true);
       SmartBuilder.initLoad();
    }

    private void btnSmartGenActionPerformed(java.awt.event.MouseEvent evt) {
        Main.setpanelNotVisible();
        Main.panelBody.setBackground(new java.awt.Color(255, 255, 255));
        Main.smartGen.setVisible(true);
        Main.smartGen.initLoad();
    }

    private void btnSpyIntelliganceActionPerformed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnSmartBuilder;
    private javax.swing.JButton btnSmartGen;
    private javax.swing.JButton btnSpyIntelligance;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}

