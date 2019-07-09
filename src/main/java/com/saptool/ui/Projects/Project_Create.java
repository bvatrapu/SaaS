package com.saptool.ui.Projects;

import com.saptool.frameworkbuilder.FrameworkBuilder;
import com.saptool.ui.Frame_Flag;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import com.saptool.utils.Log;
import com.saptool.utils.UnZip;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.SQLOutput;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class Project_Create extends JFrame {

    String projectName=null;
    /**
     * Creates new form Project_Create
     */
    public Project_Create() {
        initComponents();
    }


    private void initComponents() {

        panelBody = new JPanel();
        panelHeader = new JPanel();
        txtCreateNewProject = new JLabel();
        txtMavenJavaTestNG = new JLabel();
        txtProjectName = new JLabel();
        inputProjectName = new JTextField();
        btnCreateProject = new JButton();
        imgRobo = new JLabel();
        btnClose = new javax.swing.JButton();


        setTitle("Project Create");
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,new Color(0,122,181) ));
        setUndecorated(true);
        panelBody.setBackground(new Color(255, 255, 255));

        panelHeader.setBackground(new Color(0, 122, 181));

        txtCreateNewProject.setFont(new Font("Segoe UI", 1, 36));
        txtCreateNewProject.setForeground(new Color(255, 255, 255));
        txtCreateNewProject.setText("Create New Project");

        txtMavenJavaTestNG.setFont(new Font("Tahoma", 3, 16));
        txtMavenJavaTestNG.setForeground(new Color(204, 204, 255));
        txtMavenJavaTestNG.setText("Maven, Java, TestNG");

        GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
                panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(txtCreateNewProject, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMavenJavaTestNG)
                                .addGap(36, 36, 36))
        );
        panelHeaderLayout.setVerticalGroup(
                panelHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtCreateNewProject)
                                .addContainerGap(26, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMavenJavaTestNG)
                                .addContainerGap())
        );

        txtProjectName.setBackground(new Color(255, 255, 255));
        txtProjectName.setFont(new Font("Tahoma", 0, 36));
        txtProjectName.setText("Project name: ");

        inputProjectName.setFont(new Font("Tahoma", 0, 24));

        btnCreateProject.setBackground(new Color(255, 255, 255));
        btnCreateProject.setFont(new Font("Tahoma", 1, 24));
        btnCreateProject.setForeground(new Color(0, 122, 181));
        btnCreateProject.setText("Create Project");
        //btnCreateProject.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      //  btnCreateProject.setBorderPainted(false);
        btnCreateProject.setBorder(BorderFactory.createLineBorder(new Color(0, 122, 181), 2));
        btnCreateProject.setFocusPainted(false);
        btnCreateProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateProjectActionPerformed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreateProject.setBackground(new Color(0, 122, 181));
                btnCreateProject.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreateProject.setBackground(new Color(255, 255, 255));
                btnCreateProject.setForeground(new Color(0, 122, 181));
            }
        });
        imgRobo.setIcon(new ImageIcon(getClass().getResource("/icons/projects/enter_project_robo.png")));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnClose.setForeground(new java.awt.Color(255,102,0));
        btnClose.setText("Close");
//        btnClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnClose.setFocusPainted(false);
        btnClose.setBorder(BorderFactory.createLineBorder(new Color(255,102,0), 2));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseActionPerformed(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClose.setBackground(new Color(255,102,0));
                btnClose.setForeground(new Color(255, 255, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClose.setBackground(new Color(255, 255, 255));
                btnClose.setForeground(new Color(255,102,0));
            }
        });


        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
                panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBodyLayout.createSequentialGroup()
                                .addGap(0, 42, Short.MAX_VALUE)
                                .addComponent(txtProjectName)
                                .addGap(40, 40, 40)
                                .addComponent(inputProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imgRobo)
                                .addContainerGap())
                        .addGroup(panelBodyLayout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(btnCreateProject, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBodyLayout.setVerticalGroup(
                panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBodyLayout.createSequentialGroup()
                                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelBodyLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(imgRobo))
                                        .addGroup(panelBodyLayout.createSequentialGroup()
                                                .addGap(156, 156, 156)
                                                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtProjectName)
                                                        .addComponent(inputProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(25, 25, 25)
                                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCreateProject, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(89, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelBody, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnCloseActionPerformed(java.awt.event.MouseEvent evt) {
        Frame_Flag.projects_CreateProject=false;
        dispose();
    }
    private void btnCreateProjectActionPerformed(java.awt.event.MouseEvent evt) {
        projectName=inputProjectName.getText();
        projectName=Generic.removeSpecialChars(projectName);
        if(projectName ==null || projectName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Project Name", "Warning ", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                GlobalConstants.Project_Name = projectName;
                if (!Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator, projectName)) {

                    FileUtils.copyDirectory(new File(GlobalConstants.TEST_FRAMEWORK_SRC_Path),new File(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName+File.separator+"src"));
                    FileUtils.copyFile(new File(GlobalConstants.TEST_FRAMEWORK_POM_Path),new File(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName+File.separator+"pom.xml"));

                    Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTPAGES_FOLDER);

                    Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER);
                    Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTRESOURCES_FOLDER);
                    Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTDATA_FOLDER);
                    Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER);
                    Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName + File.separator + GlobalConstants.TEST_FRAMEWORK_TESTREPORTS_FOLDER);
                    Generic.createFolder(GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + projectName + File.separator + GlobalConstants.TEST_PROJECT_REPORTS);

                    Generic.createProjectConfig(projectName);
                    GlobalConstants.SELECTED_PROJECT_PATH =GlobalConstants.PROJECTS_FOLDER_PATH+ File.separator+projectName;
                    FrameworkBuilder.updatePOM_ProjectName(projectName);

                    SetupTestNgParams setupTestNgParams=new SetupTestNgParams();
                    setupTestNgParams.setVisible(true);
                    SetupTestNgParams.init_Load();
                    dispose();
                    //new Project_Create_Success();
                    // Projects.loadProjectTable();
//                Project_Create_Success project_create_success =new Project_Create_Success();
//                project_create_success.setVisible(true);

//                try{
//                    Thread t=Thread.currentThread();
//                    //t.sleep(7500);
//                    t.sleep(5500);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//               Project_Create_Success.imgTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tick.png")));
                } else {
                    JOptionPane.showMessageDialog(null, "Project Already Exists", "DONE ", JOptionPane.INFORMATION_MESSAGE);
                }
                // ProcessCommander.createProject_Maven(projectName,"SAPTOOL");

            } catch (Exception e) {
                // Throwing an exception
                e.printStackTrace();
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project_Create().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private JButton btnCreateProject;
    private JLabel imgRobo;
    private JTextField inputProjectName;
    private JPanel panelBody;
    private JPanel panelHeader;
    private JLabel txtCreateNewProject;
    private JLabel txtMavenJavaTestNG;
    private JLabel txtProjectName;
    // End of variables declaration
}
