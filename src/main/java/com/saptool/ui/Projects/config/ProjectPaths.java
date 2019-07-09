package com.saptool.ui.Projects.config;

import com.saptool.ui.Projects.Project_Warning;
import com.saptool.ui.ui_utils.Progressbar;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author bvatrapu
 */
public class ProjectPaths extends javax.swing.JPanel {

    public static DefaultListModel paths_config_ListModel= new DefaultListModel();
    public static String paths_prop_path=null;

    /**
     * Creates new form RenameProject
     */
    public ProjectPaths() {
        initComponents();
    }

    private void initComponents() {

        txtScripts = new javax.swing.JLabel();
        inputScripts = new javax.swing.JTextField();
        btnExecution = new javax.swing.JLabel();
        inputExecution = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        bntReset = new javax.swing.JButton();
        btnFolderScripts = new javax.swing.JButton();
        btnFolderExecution = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        txtScripts.setFont(new java.awt.Font("Tahoma", 1, 18));
        txtScripts.setForeground(new java.awt.Color(0, 51, 204));
        txtScripts.setText("Test Scripts Path:");

        inputScripts.setToolTipText("");

        btnExecution.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnExecution.setForeground(new java.awt.Color(0, 51, 204));
        btnExecution.setText("Test Execution Path:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        bntReset.setText("Reset");
        bntReset.setToolTipText("");
        bntReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntResetActionPerformed(evt);
            }
        });

//        btnFolderScripts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Opened_Folder_32px.png")));
        btnFolderScripts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFolderScriptsActionPerformed(evt);
            }
        });
     //   btnFolderExecution.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Opened_Folder_32px.png")));
        btnFolderExecution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFolderExecutionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txtScripts)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(inputScripts, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(btnFolderScripts, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnExecution)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(inputExecution, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnFolderExecution, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)
                                                .addComponent(bntReset, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(txtScripts)
                                                                .addComponent(inputScripts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnFolderScripts, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnExecution)
                                                        .addComponent(inputExecution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(btnFolderExecution, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(184, 184, 184)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bntReset, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(172, Short.MAX_VALUE))
        );
    }
    public static void init_Load(){
        paths_prop_path=GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.projectpaths_properties;

        inputScripts.setText(Generic.readProp("Scripts_Path",paths_prop_path));
        inputExecution.setText(Generic.readProp("Execution_Path",paths_prop_path));

    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag=true;
        if(StringUtils.isEmpty(inputScripts.getText())){
            flag=false;
            JOptionPane.showMessageDialog(null,"Enter ALM URL");
        } else{

            paths_config_ListModel.addElement("Scripts_Path"+"="+inputScripts.getText());
        }
        if(StringUtils.isEmpty(inputExecution.getText())){
            flag=false;
            JOptionPane.showMessageDialog(null,"Enter ALM URL");
        } else{
            paths_config_ListModel.addElement("Execution_Path"+"="+inputExecution.getText());
        }
        if(!Generic.verifyFileExist(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.projectpaths_properties)){
            Generic.createNewFile(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.projectpaths_properties);
        }
        if(flag) {
            Generic.write_PathProp(paths_config_ListModel);
            JOptionPane.showMessageDialog(null,"SUCCESSFULLY SAVED");
        }
    }

    private void bntResetActionPerformed(java.awt.event.ActionEvent evt) {
        inputScripts.setText("");
        inputExecution.setText("");
    }
    private void btnFolderScriptsActionPerformed(java.awt.event.ActionEvent evt) {
        String dirPath=null;
        dirPath=Generic.choosefolderPath();
        String scriptPath[]=dirPath.split("src");
        File pompath=new File(scriptPath[0]+File.separator+"pom.xml");
        if(pompath.exists()){
            inputScripts.setText("src"+scriptPath[1]);
        } else {
            JOptionPane.showMessageDialog(null,"This is not Maven Project...... Select Maven Project");
        }

    }
    private void btnFolderExecutionActionPerformed(java.awt.event.ActionEvent evt) {
        String dirPath=null;
        dirPath=Generic.choosefolderPath();
        String scriptPath[]=dirPath.split("src");
        File pompath=new File(scriptPath[0]+File.separator+"pom.xml");
        if(pompath.exists()){
            inputExecution.setText("src"+scriptPath[1]);
        } else {
            JOptionPane.showMessageDialog(null,"This is not Maven Project...... Select Maven Project");
        }
    }
    // Variables declaration - do not modify
    private javax.swing.JButton bntReset;
    private javax.swing.JLabel btnExecution;
    private javax.swing.JButton btnFolderExecution;
    private javax.swing.JButton btnFolderScripts;
    private javax.swing.JButton btnSave;
    private static javax.swing.JTextField inputExecution;
    private static javax.swing.JTextField inputScripts;
    private javax.swing.JLabel txtScripts;
    // End of variables declaration
}

