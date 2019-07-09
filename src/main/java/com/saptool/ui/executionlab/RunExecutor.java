package com.saptool.ui.executionlab;

import com.saptool.ui.Init;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import com.saptool.utils.Log;
import com.saptool.utils.ProcessCommander;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class RunExecutor extends javax.swing.JFrame {
    public static Process process = null;
    /**
     * Creates new form RunExecutor
     */
    public RunExecutor() {
        initComponents();
    }


    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        iconMain = new javax.swing.JLabel();
        iconRunCommandor = new javax.swing.JLabel();
        txtExecName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaCommandor = new javax.swing.JTextArea();
        btnStop = new javax.swing.JButton();


        setResizable(false);
        setTitle(GlobalConstants.EXECUTION_NAME);

        btnStop.setFocusPainted(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        iconMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ExecutionLab/Run_commandor.png")));

        iconRunCommandor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ExecutionLab/runExecutor.jpg")));
        iconRunCommandor.setToolTipText("");

        txtExecName.setFont(new java.awt.Font("Tahoma", 1, 24));
        txtExecName.setForeground(new java.awt.Color(153, 0, 255));
        txtExecName.setText("Execution File Name");

        txtAreaCommandor.setBackground(new java.awt.Color(0, 0, 0));
        txtAreaCommandor.setForeground(new java.awt.Color(245, 235, 0));
        txtAreaCommandor.setFont(new Font("Tahoma", 1, 18));
        txtAreaCommandor.setText("fdsafbdsjkagdajkgnfdakgnfkdgmnfdlv, md,vlmfd");
        txtAreaCommandor.setEditable(false);
        //txtAreaCommandor.setColumns(20);
        //txtAreaCommandor.setRows(5);
        jScrollPane1.setViewportView(txtAreaCommandor);

        btnStop.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnStop.setBackground(new java.awt.Color(255, 255, 255));
        btnStop.setForeground(new java.awt.Color(255, 51, 51));
        //btnStop.setBorderPainted(false);
        btnStop.setFocusPainted(false);
        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(iconRunCommandor)
                                                .addGap(170, 170, 170)
                                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 200, Short.MAX_VALUE))
                                        .addComponent(txtExecName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconMain)
                                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(iconMain))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(txtExecName)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(21, 21, 21))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(61, 61, 61)
                                                                .addComponent(iconRunCommandor)))))
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void btnStopActionPerformed(java.awt.event.ActionEvent evt) {
        process.destroy();
        dispose();
    }
    public void Run(){
        Thread object = new Thread(new TestScriptExecuter());
        object.start();
    }

    class TestScriptExecuter implements Runnable{
        @Override
        public void run() {
            try {
                executeTestScripts(GlobalConstants.EXECUTION_PROJECT, Generic.paramBuilder(Init.TestNG_Params));
                Generic.copyDirectory(new File(GlobalConstants.EXECUTION_PROJECT+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTREPORTS_FOLDER),new File(GlobalConstants.SELECTED_PROJECT_PATH + File.separator + GlobalConstants.TEST_PROJECT_REPORTS));
            }catch (Exception e)            {
                // Throwing an exception
                Log.error(e.getMessage());
                //e.printStackTrace();
            }


          //  Generic.folderDelete(GlobalConstants.EXECUTION_PROJECT);
        }

    }
    public void executeTestScripts(String frameworkPath,String testNgParams) throws Exception{
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

      //  String mavenExecutablePath = "call mvn clean compile test -X -f "+frameworkPath;
        String mavenExecutablePath = "call mvn clean compile test -f "+frameworkPath;
        command[2] = mavenExecutablePath+" "+testNgParams;

        try {
            //p = Runtime.getRuntime().exec(command);
            process = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {

                txtAreaCommandor.append(line+"\n");
            }
        } catch (IOException e) {
            Log.error(e.getMessage());
          //  e.printStackTrace();
        }
//        ProcessExecutor processExecutor = new ProcessExecutor();
//        Process p = processExecutor.executeCommand(command);
//         Runtime runtime = Runtime.getRuntime();
//        if(p!=null) {
//            Process process = runtime.exec("C:\\Windows\\notepad.exe " + p);
//        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RunExecutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel iconMain;
    private javax.swing.JLabel iconRunCommandor;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaCommandor;
    public javax.swing.JLabel txtExecName;
    // End of variables declaration
}

