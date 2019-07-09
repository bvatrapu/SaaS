package com.saptool.ui.Projects.config;


import com.saptool.ui.Frame_Flag;
import com.saptool.ui.UI_Design;
import com.saptool.ui.main.Grid;
import com.saptool.utils.GlobalConstants;

import java.awt.*;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ConfigProject extends javax.swing.JFrame {
    GridBagLayout gridBagLayout = new GridBagLayout();
    public static ProjectPaths projectPaths;
    public static ConfigParameterNames configParameterNames;
    public static ConfigParameterValues configParameterValues;

    /**
     * Creates new form ConfigProject
     */
    public ConfigProject() {
        initComponents();
//        if(GlobalConstants.SaaS_PROJECTS){
//            btnProjectPath.setVisible(false);
//        }
        projectPaths=new ProjectPaths();
        configParameterNames=new ConfigParameterNames();
        configParameterValues=new ConfigParameterValues();

        bodyPanel.setLayout(gridBagLayout);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        bodyPanel.add(projectPaths,c);

        c.gridx = 0;
        c.gridy = 0;
        bodyPanel.add(configParameterNames,c);

        c.gridx = 0;
        c.gridy = 0;
        bodyPanel.add(configParameterValues,c);

        setpanelNotVisible();
    }

    public static void setpanelNotVisible(){
        projectPaths.setVisible(false);
        configParameterValues.setVisible(false);
        configParameterNames.setVisible(false);
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        panelControls = new javax.swing.JPanel();
        btnProjectPath = new javax.swing.JButton();
        btnParameters = new javax.swing.JButton();
        btnParaValues = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        bodyPanel = new javax.swing.JPanel();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        panelControls.setBackground(new java.awt.Color(255, 255, 255));
        panelControls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(158, 71, 158), 2));


        UI_Design.button_ui_style_violet(btnProjectPath,"Setup Paths");
        btnProjectPath.setFont(new java.awt.Font("Tahoma", 1, 22));
        btnProjectPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectPathActionPerformed(evt);
            }
        });

        UI_Design.button_ui_style_violet(btnParameters,"Parameters");
        btnParameters.setFont(new java.awt.Font("Tahoma", 1, 22));
        btnParameters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametersActionPerformed(evt);
            }
        });


        UI_Design.button_ui_style_violet(btnParaValues,"Parameter Values");
        btnParaValues.setFont(new java.awt.Font("Tahoma", 1, 22));
        btnParaValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaValuesActionPerformed(evt);
            }
        });

        UI_Design.button_ui_style_violet(btnClose,"Close");
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 22));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelControlsLayout = new javax.swing.GroupLayout(panelControls);
        panelControls.setLayout(panelControlsLayout);
        panelControlsLayout.setHorizontalGroup(
                panelControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnProjectPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnParaValues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelControlsLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelControlsLayout.setVerticalGroup(
                panelControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelControlsLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnProjectPath, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnParameters, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnParaValues, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
        );

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
                bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 712, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
                bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(panelControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnProjectPathActionPerformed(java.awt.event.ActionEvent evt) {
        setpanelNotVisible();
        projectPaths.setVisible(true);
        ProjectPaths.init_Load();
    }

    private void btnParametersActionPerformed(java.awt.event.ActionEvent evt) {
        setpanelNotVisible();
        configParameterNames.setVisible(true);
        ConfigParameterNames.init_Load();
    }

    private void btnParaValuesActionPerformed(java.awt.event.ActionEvent evt) {
        setpanelNotVisible();
        configParameterValues.setVisible(true);
        ConfigParameterValues.init_Load();
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.projects_ConfigProjects=false;
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigProject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnParaValues;
    private javax.swing.JButton btnParameters;
    private javax.swing.JButton btnProjectPath;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelControls;
    // End of variables declaration
}

