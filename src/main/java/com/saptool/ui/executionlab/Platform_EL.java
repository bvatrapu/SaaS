package com.saptool.ui.executionlab;


import com.saptool.ui.Init;

import javax.swing.*;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Platform_EL extends JPanel {

    public static ButtonGroup bgPlatform = new ButtonGroup();
    /**
     * Creates new form Platform_EL
     */
    public Platform_EL() {
        initComponents();
    }

    private void initComponents() {

        iconDesktop = new JLabel();
        rbDesktop = new JRadioButton();
        iconMobile = new JLabel();
        rbMobile = new JRadioButton();
        btnRight = new JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        iconDesktop.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Switch_Host_100px.png")));

        rbDesktop.setBackground(new java.awt.Color(255, 255, 255));
        rbDesktop.setFont(new java.awt.Font("Tahoma", 1, 18));
        rbDesktop.setForeground(new java.awt.Color(0, 51, 153));
        rbDesktop.setText("DESKTOP");
        rbDesktop.setSelected(true);

        iconMobile.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Smartphone_Tablet_100px.png")));

        rbMobile.setBackground(new java.awt.Color(255, 255, 255));
        rbMobile.setFont(new java.awt.Font("Tahoma", 1, 18));
        rbMobile.setForeground(new java.awt.Color(0, 51, 153));
        rbMobile.setText("MOBILE");

        bgPlatform.add(rbDesktop);
        bgPlatform.add(rbMobile);

        btnRight.setBackground(new java.awt.Color(255, 255, 255));
        btnRight.setIcon(new ImageIcon(getClass().getResource("/icons/ExecutionLab/Sort_Right_100px.png")));
        btnRight.setBorder(null);
        btnRight.setFocusPainted(false);
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(227, 227, 227)
                                                .addComponent(iconDesktop))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(219, 219, 219)
                                                .addComponent(rbDesktop)))
                                .addGap(176, 176, 176)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(iconMobile))
                                        .addComponent(rbMobile))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                                .addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(iconMobile)
                                                                .addGap(26, 26, 26))
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                                .addComponent(rbMobile))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(iconDesktop)
                                                .addGap(26, 26, 26)
                                                .addComponent(rbDesktop)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
    }

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {
        Init.testPlatform = getPlatform().toLowerCase();
        ExecutionLab.setpanelNotVisible();
        ExecutionLab.browsers.setVisible(true);
    }
    public static String getPlatform(){
        if(rbDesktop.isSelected()){
            return rbDesktop.getText();
        }else{
            return rbMobile.getText();
        }
    }
    // Variables declaration - do not modify
    public static JRadioButton rbDesktop;
    public static JRadioButton rbMobile;
    private JButton btnRight;
    private JLabel iconDesktop;
    private JLabel iconMobile;
    // End of variables declaration
}
