package com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.saptool.ui.Frame_Flag;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.PageTemplates.CreateVariable;
import com.saptool.ui.SmartHub.SmartBuilder.SmartObject.New_SmartObject;
import com.saptool.ui.UI_Design;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Template extends javax.swing.JFrame {

    public String select_tree_node_value=null;
    /**
     * Creates new form Template
     */
    public Template() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        treePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeTemplates = new javax.swing.JTree();
        exPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        controlPanel = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        treePanel.setBackground(new java.awt.Color(255, 255, 255));

        treeTemplates.setFont(new java.awt.Font("Tahoma", 0, 20));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Templates");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Login_Submit_Form");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Check_Element_Existance");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Check_Element_NOT-Existance");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Click_Link_Verify_Targetpage");
        treeNode1.add(treeNode2);
        treeTemplates.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeTemplates.setRowHeight(27);
        jScrollPane1.setViewportView(treeTemplates);
        treeTemplates.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

                DefaultMutableTreeNode selectedNode_value =
                        (DefaultMutableTreeNode)treeTemplates.getLastSelectedPathComponent();
                select_tree_node_value=selectedNode_value.toString();

                if(select_tree_node_value.contains("Login_Submit_Form")) {
                    txtArea.setText("Login_Submit_Form");
                } else if(select_tree_node_value.contains("Check_Element_Existance")) {
                    txtArea.setText(Template_Examples.Objects_existance);
                } else if(select_tree_node_value.contains("Click_Link_Verify_Targetpage")) {
                    txtArea.setText("Click_Link_Verify_Targetpage");
                } else if(select_tree_node_value.contains("Check_Element_NOT-Existance")){
                    txtArea.setText(Template_Examples.Objects_not_existance);
                }
            }
        });

        javax.swing.GroupLayout treePanelLayout = new javax.swing.GroupLayout(treePanel);
        treePanel.setLayout(treePanelLayout);
        treePanelLayout.setHorizontalGroup(
                treePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        treePanelLayout.setVerticalGroup(
                treePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        exPanel.setBackground(new java.awt.Color(255, 255, 255));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.setFont(new java.awt.Font("Monospaced", 0, 16));
        txtArea.setForeground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(txtArea);

        javax.swing.GroupLayout exPanelLayout = new javax.swing.GroupLayout(exPanel);
        exPanel.setLayout(exPanelLayout);
        exPanelLayout.setHorizontalGroup(
                exPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
        );
        exPanelLayout.setVerticalGroup(
                exPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );

        controlPanel.setBackground(new java.awt.Color(255, 255, 255));

//        btnNext.setBackground(new java.awt.Color(255, 255, 255));
//        btnNext.setText("Next");
        UI_Design.button_ui_style_violet(btnNext,"Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

//        btnClose.setBackground(new java.awt.Color(255, 255, 255));
//        btnClose.setText("Close");
        UI_Design.button_ui_style_violet(btnClose,"Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
                controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPanelLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(165, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
                controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(treePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(exPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(treePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(exPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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
        if(!Frame_Flag.template_Object_existance) {
            switch (select_tree_node_value) {
                case "Check_Element_Existance":
                    if(!Frame_Flag.template_Object_existance) {
                        Objects_existance objects_existance = new Objects_existance();
                        objects_existance.setVisible(true);
                        Objects_existance.init_Load();
                    }
                    Frame_Flag.template_Object_existance=true;
                    Frame_Flag.smartBuilder_smartComponent_temlpate=false;
                    dispose();
                    break;
                case "Check_Element_NOT-Existance":
                    if(!Frame_Flag.template_Object_existance) {
                        Objects_notexistance objects_notexistance = new Objects_notexistance();
                        objects_notexistance.setVisible(true);
                        Objects_notexistance.init_Load();
                    }
                    Frame_Flag.template_Object_existance=true;
                    Frame_Flag.smartBuilder_smartComponent_temlpate=false;
                    dispose();
                    break;
                case "Login_Submit_Form":
                    if(!Frame_Flag.template_Submit_form) {
                        Submit_Form submit_form = new Submit_Form();
                        submit_form.setVisible(true);
                        Submit_Form.init_load();
                    }
                    Frame_Flag.template_Submit_form=true;
                    Frame_Flag.smartBuilder_smartComponent_temlpate=false;
                    dispose();
                    break;
                case "Click_Link_Verify_Targetpage":
                    if(!Frame_Flag.template_click_link_verify_targetpage) {
                        Click_Link_Verify_TargetPage click_link_verify_targetPage = new Click_Link_Verify_TargetPage();
                        click_link_verify_targetPage.setVisible(true);
                        Click_Link_Verify_TargetPage.init_Load();
                    }
                    Frame_Flag.template_click_link_verify_targetpage=true;
                    Frame_Flag.smartBuilder_smartComponent_temlpate=false;
                    dispose();
                    break;

                case "variables":
                    if(!Frame_Flag.template_create_Variable) {
                        CreateVariable createVariable = new CreateVariable();
                        createVariable.setVisible(true);
                    }
                    Frame_Flag.template_create_Variable=true;
                    Frame_Flag.smartBuilder_smartComponent_temlpate=false;
                    dispose();
                    break;

                case "objects":
                    if(!Frame_Flag.smartBuilder_smartObject_New) {
                        New_SmartObject new_smartObject = new New_SmartObject();
                        new_smartObject.setVisible(true);
                    }
                    Frame_Flag.smartBuilder_smartObject_New=true;
                    dispose();
                    break;
            }
        }

    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartBuilder_smartComponent_temlpate=false;
        Frame_Flag.smartBuilder_smartComponent=false;

        dispose();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Template().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNext;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel exPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel treePanel;
    private javax.swing.JTree treeTemplates;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration
}
