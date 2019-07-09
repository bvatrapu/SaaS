package com.saptool.ui.main;

import com.saptool.ui.Init;
import com.saptool.ui.executionlab.RunExecutor;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author bvatrapu
 */
public class BuildProject extends javax.swing.JPanel {

    Process process = null;

    /**
     * Creates new form Projects
     */
    public BuildProject() {
        initComponents();
        jLabel1.setVisible(false);
        txtStatus.setVisible(false);
        txtAreaBuildProject.removeAll();
    }


    private void initComponents() {

        btnBuildProject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaBuildProject = new javax.swing.JTextArea();
        imgBuildProject = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBuildProject.setText("Build Project");
        btnBuildProject.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnBuildProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuildProjectActionPerformed(evt);
            }
        });

        txtAreaBuildProject.setColumns(20);
        txtAreaBuildProject.setRows(5);
        jScrollPane1.setViewportView(txtAreaBuildProject);

        imgBuildProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buildProject.png")));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28));
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Status :");



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(imgBuildProject)
                                                .addGap(24, 24, 24))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnBuildProject, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(86, 86, 86)
                                                .addComponent(jLabel1)
                                                .addGap(71, 71, 71)
                                                .addComponent(txtStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(286, 286, 286))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnBuildProject, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imgBuildProject)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(85, Short.MAX_VALUE))
        );
    }
    private void btnBuildProjectActionPerformed(java.awt.event.ActionEvent evt) {
        btnBuildProject.setVisible(false);

        txtStatus.setVisible(true);
        txtStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/build.gif")));
        Thread object = new Thread(new TestScriptExecuter());
        object.start();



//        System.out.println("SELECTED_PROJECT_PATH::"+GlobalConstants.SELECTED_PROJECT_PATH);
//        try {
//            executeTestScripts(GlobalConstants.SELECTED_PROJECT_PATH);
//            //Generic.folderDelete(GlobalConstants.SELECTED_PROJECT_PATH+File.separator+"target");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
    class TestScriptExecuter implements Runnable{
        @Override
        public void run() {
            try {
                executeTestScripts(GlobalConstants.SELECTED_PROJECT_PATH);
                jLabel1.setVisible(true);
                txtStatus.setIcon(null);
                btnBuildProject.setVisible(true);
                if(txtAreaBuildProject.getText().contains("[INFO] BUILD FAILURE")){
                    txtStatus.setFont(new java.awt.Font("Tahoma", 1, 28));
                    txtStatus.setForeground(new java.awt.Color(237, 28, 36));
                    txtStatus.setText("Build Failure");
                } else{
                    txtStatus.setFont(new java.awt.Font("Tahoma", 1, 28));
                    txtStatus.setForeground(new java.awt.Color(34,177, 76));
                    txtStatus.setText("Build Success");
                }
                Generic.folderDelete(GlobalConstants.SELECTED_PROJECT_PATH+File.separator+"target");
            }catch (Exception e)
            {
                // Throwing an exception
                e.printStackTrace();
            }


            //  Generic.folderDelete(GlobalConstants.EXECUTION_PROJECT);
        }

    }
    public void executeTestScripts(String frameworkPath) throws Exception{
        String[] command = new String[3];
        //Logger logger = LoggerFactory.getLogger(SAPTOOL.class);
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            command[0] = "cmd";
            command[1] = "/c";
        }
        else{
            command[0] = "sh";
            command[1] = "-c";
        }

        String mavenExecutablePath = "call mvn clean compile -f"+frameworkPath;
        command[2] = mavenExecutablePath;

        try {
            //p = Runtime.getRuntime().exec(command);
            process = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                txtAreaBuildProject.append(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        ProcessExecutor processExecutor = new ProcessExecutor();
//        Process p = processExecutor.executeCommand(command);
//         Runtime runtime = Runtime.getRuntime();
//        if(p!=null) {
//            Process process = runtime.exec("C:\\Windows\\notepad.exe " + p);
//        }

    }
    // Variables declaration - do not modify
    private javax.swing.JButton btnBuildProject;
    private javax.swing.JLabel imgBuildProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaBuildProject;
    private javax.swing.JLabel txtStatus;
    // End of variables declaration
}
