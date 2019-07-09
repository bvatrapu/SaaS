package com.saptool.ui.executionlab;

import com.saptool.ui.Init;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import com.saptool.utils.Log;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author bvatrapu
 */
public class Controls extends javax.swing.JPanel {

    HashMap<String,String> testngProjectParams=new HashMap<String,String>();
    public Generic generic = new Generic();

    /**
     * Creates new form Controls
     */
    public Controls() {
        initComponents();
    }

    private void initComponents() {

        btnLeft = new javax.swing.JButton();
        btnRunAll = new javax.swing.JButton();
        btnRunSelected = new javax.swing.JButton();
        btnAddQueue = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnLeft.setBackground(new java.awt.Color(255, 255, 255));
        btnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ExecutionLab/Sort_Left_100px_1.png")));
        btnLeft.setBorder(null);
        btnLeft.setFocusPainted(false);
        btnLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnRunAll.setBackground(new java.awt.Color(255, 255, 255));
        btnRunAll.setFont(new java.awt.Font("Tahoma", 1, 20));
        btnRunAll.setForeground(new java.awt.Color(0, 153, 0));
        btnRunAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ExecutionLab/Check_All_48px.png")));
        btnRunAll.setText("Run All");
        btnRunAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunAllActionPerformed(evt);
            }
        });

        btnRunSelected.setBackground(new java.awt.Color(255, 255, 255));
        btnRunSelected.setFont(new java.awt.Font("Tahoma", 1, 20));
        btnRunSelected.setForeground(new java.awt.Color(51, 204, 0));
        btnRunSelected.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ExecutionLab/Checked_Checkbox_48px.png")));
        btnRunSelected.setText("Run Selected");
        btnRunSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunSelectedActionPerformed(evt);
            }
        });

        btnAddQueue.setBackground(new java.awt.Color(255, 255, 255));
        btnAddQueue.setFont(new java.awt.Font("Tahoma", 1, 20));
        btnAddQueue.setForeground(new java.awt.Color(255, 153, 0));
        btnAddQueue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ExecutionLab/Joining_Queue_48px.png")));
        btnAddQueue.setText("  Add Queue");
        btnAddQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQueueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(btnRunSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnRunAll, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnAddQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAddQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnRunSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(3, 3, 3))
                                                .addComponent(btnRunAll, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(107, Short.MAX_VALUE))
        );
    }

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {
        ExecutionLab.setpanelNotVisible();
        ExecutionLab.testNgParams.setVisible(true);
    }
    private void btnRunAllActionPerformed(java.awt.event.ActionEvent evt) {
        File saas = new File(GlobalConstants.PROJECTS_FOLDER_PATH+File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.FRAMEWORK_FOLDER);
        if(GlobalConstants.NODE_STATUS){

        } else {
            if(!GlobalConstants.HUB_STATUS){
                generic.startHub();
            }
            generic.startNode();
        }

        // TODO add your handling code here:
        int rowCount=ExecutionLab.tblTestSripts.getModel().getRowCount();
        try {
            GlobalConstants.DATE_TIME = Generic.getTime() + "_" + Generic.getDate();
            GlobalConstants.EXECUTION_PROJECT = GlobalConstants.EXECUTIONS_FOLDER_PATH + File.separator + GlobalConstants.DATE_TIME;

            String srcDir  = GlobalConstants.SELECTED_PROJECT_PATH;
            String destDir = GlobalConstants.EXECUTION_PROJECT;
            Generic.copyDirectory(new File(srcDir),new File(destDir));

            Path source = Paths.get(GlobalConstants.CONFIG_TEMP_FOLDER_PATH + File.separator + "Temp_Exec_TestNG.xml");

            String paths_prop_path=GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.projectpaths_properties;
            if(!saas.exists()){
                GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER = Generic.readProp("Scripts_Path",paths_prop_path);

            }
            Path newdir = Paths.get(GlobalConstants.EXECUTION_PROJECT+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER );


            Files.copy(source, newdir.resolve("Temp_Exec_TestNG.xml"), REPLACE_EXISTING);
//            Generic.copyDirectory(new File(source));
            String readPage = Generic.readText(GlobalConstants.EXECUTION_PROJECT+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER+File.separator+"Temp_Exec_TestNG.xml");

            String className = null;
            String tblScript = null;
            for (int count = 0; count < rowCount; count++){
                tblScript=ExecutionLab.tblTestSripts.getModel().getValueAt(count, 1).toString();
                tblScript=tblScript.replaceAll(".java","");

                className = "<class name=\"com.testProject.testSuites."+GlobalConstants.SELECTED_EXEC_NODE_MODULE+"."+tblScript+"\" />";
                readPage = readPage.replace("</classes>",className+System.lineSeparator()+"</classes>");

            }
            String suite_report_name=null;
            suite_report_name=GlobalConstants.SELECTED_EXEC_NODE_MODULE+"_"+ Init.testBrowser;
            readPage=readPage.replace("Temp",suite_report_name);

            Generic.writeText(readPage,GlobalConstants.EXECUTION_PROJECT+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER+File.separator+"Temp_Exec_TestNG.xml",false);


            Init.testNGFile = "Temp_Exec_TestNG";
            if(saas.exists()){
                Init.TestNG_Params.put("platform", Init.testPlatform);
                Init.TestNG_Params.put("browser", Init.testBrowser);

            }

            Init.TestNG_Params.put("suitefile", Init.testNGFile);

           // String banner=null;
            testngProjectParams = Init.readParams_PropHash();
            for (Map.Entry<String, String> entry : testngProjectParams.entrySet()) {
                Init.TestNG_Params.put(entry.getKey(), entry.getValue());
               // banner = entry.getValue();
            }
            if(saas.exists()) {
                GlobalConstants.EXECUTION_NAME = Init.testPlatform.toUpperCase() + "_" + Init.testBrowser.toUpperCase() + "_" + GlobalConstants.SELECTED_EXEC_NODE_MODULE.toUpperCase();
            }else {
                GlobalConstants.EXECUTION_NAME = "Execution_"+GlobalConstants.DATE_TIME;
            }

            RunExecutor runExecutor =  new RunExecutor();

            runExecutor.setVisible(true);
            runExecutor.txtExecName.setText(GlobalConstants.EXECUTION_NAME);
            runExecutor.Run();
        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }

    private void btnRunSelectedActionPerformed(java.awt.event.ActionEvent evt) {
        File saas = new File(GlobalConstants.PROJECTS_FOLDER_PATH+File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.FRAMEWORK_FOLDER);
        if(GlobalConstants.NODE_STATUS){

        } else {
            if(!GlobalConstants.HUB_STATUS){
                generic.startHub();
            }
            generic.startNode();
        }
        try {
            GlobalConstants.DATE_TIME = Generic.getTime() + "_" + Generic.getDate();
            GlobalConstants.EXECUTION_PROJECT = GlobalConstants.EXECUTIONS_FOLDER_PATH + File.separator + GlobalConstants.DATE_TIME;

            String srcDir  = GlobalConstants.SELECTED_PROJECT_PATH;
            String destDir = GlobalConstants.EXECUTION_PROJECT;
            Generic.copyDirectory(new File(srcDir),new File(destDir));

            Path source = Paths.get(GlobalConstants.CONFIG_TEMP_FOLDER_PATH + File.separator + "Temp_Exec_TestNG.xml");
            String paths_prop_path=GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.projectpaths_properties;
            if(!saas.exists()){
                GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER = Generic.readProp("Execution_Path",paths_prop_path);

            }

            Path newdir = Paths.get(GlobalConstants.EXECUTION_PROJECT+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER );
            Files.copy(source, newdir.resolve("Temp_Exec_TestNG.xml"), REPLACE_EXISTING);
//            Generic.copyDirectory(new File(source));
            String readPage = Generic.readText(GlobalConstants.EXECUTION_PROJECT+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER+File.separator+"Temp_Exec_TestNG.xml");

            String className = null;
            String tblScript = null;

            if (ExecutionLab.tblTestSripts.getSelectedRows().length > -1) {
                int[] selectedrows = ExecutionLab.tblTestSripts.getSelectedRows();
                for (int i = 0; i < selectedrows.length; i++) {
                    tblScript=ExecutionLab.tblTestSripts.getValueAt(selectedrows[i], 1).toString();
                    tblScript=tblScript.replaceAll(".java","");

                    className = "<class name=\"com.testProject.testSuites."+GlobalConstants.SELECTED_EXEC_NODE_MODULE+"."+tblScript+"\" />";
                    readPage = readPage.replace("</classes>",className+System.lineSeparator()+"</classes>");
                }
            }


            String suite_report_name=null;
            suite_report_name=GlobalConstants.SELECTED_EXEC_NODE_MODULE+"_"+Init.testBrowser;
            readPage=readPage.replace("Temp",suite_report_name);

            Generic.writeText(readPage,GlobalConstants.EXECUTION_PROJECT+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER+File.separator+"Temp_Exec_TestNG.xml",false);


            Init.testNGFile = "Temp_Exec_TestNG";
            if(saas.exists()){
                Init.TestNG_Params.put("platform", Init.testPlatform);
                Init.TestNG_Params.put("browser", Init.testBrowser);
            }

            Init.TestNG_Params.put("suitefile", Init.testNGFile);

           // String banner=null;
            testngProjectParams = Init.readParams_PropHash();
            for (Map.Entry<String, String> entry : testngProjectParams.entrySet()) {
                Init.TestNG_Params.put(entry.getKey(), entry.getValue());
               // banner = entry.getValue();
            }
            if(saas.exists()) {
                GlobalConstants.EXECUTION_NAME = Init.testPlatform.toUpperCase() + "_" + Init.testBrowser.toUpperCase() + "_" + GlobalConstants.SELECTED_EXEC_NODE_MODULE.toUpperCase();
            }else {
                GlobalConstants.EXECUTION_NAME = "Execution_"+GlobalConstants.DATE_TIME;
            }


            RunExecutor runExecutor =  new RunExecutor();

            runExecutor.setVisible(true);
            runExecutor.txtExecName.setText(GlobalConstants.EXECUTION_NAME);
            runExecutor.Run();
        }catch (Exception e){
            Log.error(e.getMessage());
        }
    }

    private void btnAddQueueActionPerformed(java.awt.event.ActionEvent evt) {
        String tblScript = null;
        String tbScripts = null;
        String script = null;
        int[] selectedrows=null;
        int rowCount=ExecutionLab.tblTestSripts.getModel().getRowCount();
        if(ExecutionLab.tblTestSripts.getSelectedRows().length==0){
            for (int count = 0; count < rowCount; count++){
                tblScript = ExecutionLab.tblTestSripts.getValueAt(count, 1).toString();
                tblScript = tblScript.replaceAll(".java", "");
                tbScripts = tbScripts + "@@@@@" + tblScript;
            }
            if(!StringUtils.isEmpty(tbScripts)) {
                tbScripts = tbScripts.replaceAll("null@@@@@", "");
            }
        } else {
            if (ExecutionLab.tblTestSripts.getSelectedRows().length > 1) {
                selectedrows = ExecutionLab.tblTestSripts.getSelectedRows();
                script = ExecutionLab.tblTestSripts.getValueAt(selectedrows[0], 1).toString();
                script = script.replaceAll(".java", "");
                if (selectedrows.length > 1) {
                    for (int i = 1; i < selectedrows.length; i++) {
                        tblScript = ExecutionLab.tblTestSripts.getValueAt(selectedrows[i], 1).toString();
                        tblScript = tblScript.replaceAll(".java", "");
                        tbScripts = tbScripts + "@@@@@" + tblScript;
                    }
                    tbScripts = tbScripts.replaceAll("null", script);
                } else {
                    tbScripts = script;
                }
            }
        }
        if(StringUtils.isEmpty(tbScripts)){
            JOptionPane.showMessageDialog(null,"Select Test Scipts");
        } else {
            Generic.write_QueueProp(tbScripts);
        }

    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnAddQueue;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRunAll;
    private javax.swing.JButton btnRunSelected;
    // End of variables declaration
}

