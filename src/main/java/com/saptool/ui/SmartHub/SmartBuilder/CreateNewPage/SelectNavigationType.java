package com.saptool.ui.SmartHub.SmartBuilder.CreateNewPage;


import com.saptool.ui.Frame_Flag;
import com.saptool.ui.SmartHub.SmartGen.AddTestScriptStep;
import com.saptool.ui.UI_Design;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class SelectNavigationType extends javax.swing.JFrame {
    public static ButtonGroup bgNavigationType = new ButtonGroup();
    /**
     * Creates new form SelectNavigationType
     */
    public SelectNavigationType() {
        initComponents();
        rbByUrl.setSelected(true);
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        txtHeader = new javax.swing.JLabel();
        rbByUrl = new javax.swing.JRadioButton();
        rbBySteps = new javax.swing.JRadioButton();
        rbBoth = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        txtHeader.setFont(new java.awt.Font("Tahoma", 0, 35));
        txtHeader.setForeground(new java.awt.Color(102, 0, 255));
        txtHeader.setText("Select Page Navigation Type");

        rbByUrl.setBackground(new java.awt.Color(255, 255, 255));
        rbByUrl.setFont(new java.awt.Font("Tahoma", 0, 25));
        rbByUrl.setText("By URL");

        rbBySteps.setBackground(new java.awt.Color(255, 255, 255));
        rbBySteps.setFont(new java.awt.Font("Tahoma", 0, 25));
        rbBySteps.setText("By Steps");

        rbBoth.setBackground(new java.awt.Color(255, 255, 255));
        rbBoth.setFont(new java.awt.Font("Tahoma", 0, 25));
        rbBoth.setText("Both");

        bgNavigationType.add(rbByUrl);
        bgNavigationType.add(rbBoth);
        bgNavigationType.add(rbBySteps);

        UI_Design.button_ui_style_violet(btnNext,"NEXT");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnClose.setBorder(null);
        btnClose.setFocusPainted(false);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(225, 225, 225)
                                                .addComponent(txtHeader))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(rbByUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(110, 110, 110)
                                                .addComponent(rbBySteps, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(113, 113, 113)
                                                .addComponent(rbBoth, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(327, 327, 327)
                                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(136, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtHeader)
                                .addGap(82, 82, 82)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbByUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbBoth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbBySteps, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
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

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {

        if(getNavigationType().equalsIgnoreCase("By URL")){
            GlobalConstants.NAVIGATION_TYPE="BY_URL";
            NavigationByUrl navigationByUrl = new NavigationByUrl();
            navigationByUrl.setVisible(true);
            NavigationByUrl.init_load();
            dispose();
        } else if(getNavigationType().equalsIgnoreCase("By Steps")){
            GlobalConstants.NAVIGATION_TYPE="By_Steps";
                NavigationBySteps navigationBySteps = new NavigationBySteps();
                navigationBySteps.setVisible(true);
                NavigationBySteps.initLoad();


//            AddTestScriptStep addTestScriptStep = new AddTestScriptStep();
//            addTestScriptStep.setVisible(true);
//            AddTestScriptStep.initLoad();
            dispose();
        } else{
            GlobalConstants.NAVIGATION_TYPE="By_Both";
            NavigationByUrl navigationByUrl = new NavigationByUrl();
            navigationByUrl.setVisible(true);
            NavigationByUrl.init_load();
            GlobalConstants.Navigation_Both=true;
            dispose();
        }
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartbuilder_CreateNewPage_pageNavigation=false;
        dispose();
    }

    public static String getNavigationType(){
        if(rbByUrl.isSelected()){
            return rbByUrl.getText();
        }else if(rbBySteps.isSelected()){
            return rbBySteps.getText();
        } else {
            return rbBoth.getText();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectNavigationType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNext;
    private javax.swing.JPanel mainPanel;
    public static javax.swing.JRadioButton rbBoth;
    public static javax.swing.JRadioButton rbBySteps;
    public static javax.swing.JRadioButton rbByUrl;
    private javax.swing.JLabel txtHeader;
    // End of variables declaration
}

