package com.saptool.ui.main;


import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Projects.config.ConfigParameterNames;
import com.saptool.ui.Projects.config.ConfigParameterValues;
import com.saptool.ui.Projects.config.RenameProject;
import com.saptool.ui.UI_Design;
import com.saptool.ui.main.config.ALM_Config;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 *
 * @author bvatrapu
 */
public class Saas_Config extends javax.swing.JFrame {

    GridBagLayout gridBagLayout = new GridBagLayout();
    public static RenameProject renameProject;
    public static ConfigParameterNames configParameterNames;
    public static ConfigParameterValues configParameterValues;
    public static ALM_Config alm_config;
    public static String selected_Tree_Node=null;
    /**
     * Creates new form Saas_Config
     */
    public Saas_Config() {
        initComponents();
        renameProject=new RenameProject();
        configParameterNames=new ConfigParameterNames();
        configParameterValues=new ConfigParameterValues();
        alm_config=new ALM_Config();

        bodyPanel.setLayout(gridBagLayout);
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        bodyPanel.add(renameProject,c);

        c.gridx = 0;
        c.gridy = 0;
        bodyPanel.add(configParameterNames,c);

        c.gridx = 0;
        c.gridy = 0;
        bodyPanel.add(configParameterValues,c);

        c.gridx = 0;
        c.gridy = 0;
        bodyPanel.add(alm_config,c);

        setpanelNotVisible();
    }
    public static void setpanelNotVisible(){
        renameProject.setVisible(false);
        configParameterValues.setVisible(false);
        configParameterNames.setVisible(false);
        alm_config.setVisible(false);
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        txtSaasConfig = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeconfig = new javax.swing.JTree();
        bodyPanel = new javax.swing.JPanel();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtSaasConfig.setBackground(new java.awt.Color(255, 255, 255));
        txtSaasConfig.setFont(new java.awt.Font("Tahoma", 0, 30));
        txtSaasConfig.setForeground(new java.awt.Color(51, 0, 255));
        txtSaasConfig.setText("SAAS Configuration");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(txtSaasConfig)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSaasConfig)
                                .addGap(0, 21, Short.MAX_VALUE))
        );

        treeconfig.setFont(new java.awt.Font("Tahoma", 0, 20));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Projects");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Refactor_Project_Name");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Test_Parameters");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Test_Parameter_Values");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Project_Paths");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Mobiles");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mobile_Enviornment");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Mobile_Device");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ALM");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("ALM_Config");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("ExtentReports");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("DataBase");
        treeNode1.add(treeNode2);
        treeconfig.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeconfig.setRowHeight(26);
        jScrollPane1.setViewportView(treeconfig);
        treeconfig.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //   PAGE_METHODS_SELECTION=false;

                DefaultMutableTreeNode selectedNode_module =
                        (DefaultMutableTreeNode)treeconfig.getLastSelectedPathComponent();
                selected_Tree_Node=selectedNode_module.toString();

                switch (selected_Tree_Node){
                    case "Refactor_Project_Name":
                        setpanelNotVisible();
                        renameProject.setVisible(true);
                        RenameProject.init_Load();
                        break;
                    case "Test_Parameters":
                        setpanelNotVisible();
                        configParameterNames.setVisible(true);
                        ConfigParameterNames.init_Load();
                        break;
                    case "Test_Parameter_Values":
                        setpanelNotVisible();
                        configParameterValues.setVisible(true);
                        ConfigParameterValues.init_Load();
                        break;

                    case "ALM_Config":
                        setpanelNotVisible();
                        alm_config.setVisible(true);
                        ALM_Config.init_Load();
                        break;
                    case "ALM":
                        setpanelNotVisible();
                        alm_config.setVisible(true);
                        ALM_Config.init_Load();
                        break;
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
                bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 833, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
                bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                new Saas_Config().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnClose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTree treeconfig;
    private javax.swing.JLabel txtSaasConfig;
    // End of variables declaration
}
