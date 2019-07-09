package com.saptool.ui.Projects.config;


import com.saptool.frameworkbuilder.FrameworkBuilder;
import com.saptool.ui.Projects.Projects;
import com.saptool.ui.main.Main;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class RenameProject extends javax.swing.JPanel {

    /**
     * Creates new form RenameProject
     */
    public RenameProject() {
        initComponents();
    }


    private void initComponents() {

        txtProjectName = new javax.swing.JLabel();
        inputProjectName = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtProjectName.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtProjectName.setForeground(new java.awt.Color(153, 0, 204));
        txtProjectName.setText("Project Name : ");

        inputProjectName.setFont(new java.awt.Font("Tahoma", 0, 22));
        inputProjectName.setForeground(new java.awt.Color(0, 0, 204));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 22));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(txtProjectName)
                                                .addGap(31, 31, 31)
                                                .addComponent(inputProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(202, 202, 202)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                        .addComponent(txtProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(113, 113, 113)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(267, Short.MAX_VALUE))
        );
    }

    public static void init_Load(){
        inputProjectName.setText(GlobalConstants.SELECTED_PROJECT);
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String oldname=GlobalConstants.SELECTED_PROJECT;
        if(inputProjectName.getText().equalsIgnoreCase(GlobalConstants.SELECTED_PROJECT)){
            JOptionPane.showMessageDialog(null,"Project Name is same as old name");
        } else {
            Generic.writeProp(GlobalConstants.Prop_Selected_Project,inputProjectName.getText());
            File oldName=new File(GlobalConstants.SELECTED_PROJECT_PATH);
            File newName=new File(GlobalConstants.PROJECTS_FOLDER_PATH+File.separator+inputProjectName.getText());

            if(oldName.exists()){
                System.out.println("name::"+oldName.renameTo(newName));
            } else{
                System.out.println("not exist");
            }

            File oldConfig=new File(GlobalConstants.CONFIG_FOLDER_PATH+File.separator+oldname);
            File newConfig=new File(GlobalConstants.CONFIG_FOLDER_PATH+File.separator+inputProjectName.getText());


            GlobalConstants.SELECTED_PROJECT_PATH=GlobalConstants.PROJECTS_FOLDER_PATH+ File.separator+inputProjectName.getText();
            FrameworkBuilder.updatePOM_ProjectName(inputProjectName.getText());
            Generic.writeProp(GlobalConstants.Prop_Project_Path,GlobalConstants.SELECTED_PROJECT_PATH,GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+inputProjectName.getText()+File.separator+GlobalConstants.config_properties);

            Projects.loadProjectTable();
            Main.txtProjectloaded.setVisible(true);
            Main.txtProjectloaded.setFont(new Font("Tahoma", 1, 18));
            Main.txtProjectloaded.setText("Project Loaded:   ");
            Main.txtLoadProjectName.setText(GlobalConstants.Project_Name);
            Main.txtLoadProjectName.setForeground(new Color(102, 0, 153));
        }
    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnUpdate;
    public static javax.swing.JTextField inputProjectName;
    public static javax.swing.JLabel txtProjectName;
    // End of variables declaration
}
