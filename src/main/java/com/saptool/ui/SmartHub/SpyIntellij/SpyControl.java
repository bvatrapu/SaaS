package com.saptool.ui.SmartHub.SpyIntellij;



/**
 *
 * @author bvatrapu
 */
public class SpyControl extends javax.swing.JPanel {

    /**
     * Creates new form Controls
     */
    public SpyControl() {
        initComponents();
    }


    private void initComponents() {

        btnLeft = new javax.swing.JButton();
        btnStartValidate = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnLeft.setBackground(new java.awt.Color(255, 255, 255));
        btnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newicons/Sort_Left_100px_1.png")));
        btnLeft.setBorder(null);
        btnLeft.setFocusPainted(false);

        btnStartValidate.setBackground(new java.awt.Color(204, 204, 255));
        btnStartValidate.setFont(new java.awt.Font("Tahoma", 1, 20));
        btnStartValidate.setText("Start Validate");
        btnStartValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartValidateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(267, 267, 267)
                                .addComponent(btnStartValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(btnStartValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(94, Short.MAX_VALUE))
        );
    }

    private void btnStartValidateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnStartValidate;
    // End of variables declaration
}
