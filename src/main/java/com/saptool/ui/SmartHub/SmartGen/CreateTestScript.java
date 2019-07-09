package com.saptool.ui.SmartHub.SmartGen;


import com.saptool.frameworkbuilder.ScriptBuilder;
import com.saptool.tables.ViewTestScriptTable;
import com.saptool.tables.ViewTestScriptTableModel;
import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import com.saptool.ui.executionlab.ExecutionLab;
import com.saptool.utils.GlobalConstants;
import com.saptool.utils.Json;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author bvatrapu
 */
public class CreateTestScript extends javax.swing.JFrame {
    public static ViewTestScriptTableModel viewTestScriptTableModel = null;
    /**
     * Creates new form CreateTestScript
     */
    public CreateTestScript() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        txtScriptName = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnAddStep = new javax.swing.JButton();
        btnCreateScript = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAutomationSteps = new javax.swing.JList<>();
        ManualStepsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblManualSteps = new javax.swing.JTable();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        txtScriptName.setFont(new java.awt.Font("Tahoma", 1, 20));
        txtScriptName.setForeground(new java.awt.Color(51, 0, 204));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setBorder(null);
        btnClose.setFocusPainted(false);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        UI_Design.button_ui_style_violet(btnAddStep,"Add Step");
        btnAddStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStepActionPerformed(evt);
            }
        });


        UI_Design.button_ui_style_violet(btnCreateScript,"Create Script");
        btnCreateScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateScriptActionPerformed(evt);
            }
        });

        listAutomationSteps.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Automation Steps", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane1.setViewportView(listAutomationSteps);

        ManualStepsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ManualStepsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manual Steps", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblManualSteps.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        UI_Design.table_ui_style_Vilote_SmartGen(tblManualSteps);
        jScrollPane3.setViewportView(tblManualSteps);

        javax.swing.GroupLayout ManualStepsPanelLayout = new javax.swing.GroupLayout(ManualStepsPanel);
        ManualStepsPanel.setLayout(ManualStepsPanelLayout);
        ManualStepsPanelLayout.setHorizontalGroup(
                ManualStepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
        );
        ManualStepsPanelLayout.setVerticalGroup(
                ManualStepsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManualStepsPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(txtScriptName, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btnAddStep, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(167, 167, 167)
                                                .addComponent(btnCreateScript, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(ManualStepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtScriptName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddStep, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCreateScript, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ManualStepsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    public static void initLoad(){

        txtScriptName.setText(GlobalConstants.SCRIPT_NAME);
        loadTestScriptsTable();
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void btnAddStepActionPerformed(java.awt.event.ActionEvent evt) {
        if(!Frame_Flag.smartgen_addtestscriptStep) {
            AddTestScriptStep addTestScriptStep = new AddTestScriptStep();
            addTestScriptStep.setVisible(true);
            AddTestScriptStep.initLoad();
            Frame_Flag.smartgen_addtestscriptStep=true;
        } else{
            JOptionPane.showMessageDialog(null,"Already opened");
        }
    }
    public static void loadTestScriptsTable(){
        tblManualSteps.setModel(getModel());
    }
    private void btnCreateScriptActionPerformed(java.awt.event.ActionEvent evt) {
        Path source = Paths.get(GlobalConstants.CONFIG_TEMP_FOLDER_PATH + File.separator + "Temp_TestScript.java");
        Path newdir = Paths.get(GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+GlobalConstants.TEST_MODULE_NAME.toLowerCase());
        // UnZip.unZipIt(GlobalConstants.Temp_PAGE_MODEL_Path, GlobalConstants.PROJECTS_FOLDER_PATH + File.separator + GlobalConstants.SELECTED_PROJECT+File.separator+"src/test/java/com/testProject/pages");
        //UnZip.unZipIt(GlobalConstants.Config_Temp_page_model_Path, GlobalConstants.CONFIG_TEMP_FOLDER_PATH);
        try {
            Files.copy(source, newdir.resolve(GlobalConstants.SCRIPT_NAME + ".java"), REPLACE_EXISTING);
            //    UnZip.unZipIt(GlobalConstants.Config_Temp_testScript_model_Path, GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+GlobalConstants.TEST_MODULE_NAME.toLowerCase()+File.separator);
//        Generic.createFolder(GlobalConstants.SELECTED_PROJECT_PATH + File.separator +GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+GlobalConstants.TEST_MODULE_NAME.toLowerCase()+File.separator+GlobalConstants.SCRIPT_NAME+".java");
            DefaultListModel defaultListModel = new DefaultListModel();
            defaultListModel.clear();
            for (int j = 0; j <= listAutomationSteps.getModel().getSize() - 1; j++) {
                defaultListModel.addElement(listAutomationSteps.getModel().getElementAt(j));
            }
            ScriptBuilder.scriptBuilder(ScriptBuilder.script_body_builder(defaultListModel));

            String jpath=GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTDATA_FOLDER+File.separator+GlobalConstants.TEST_MODULE_NAME+File.separator+GlobalConstants.SCRIPT_NAME.toUpperCase()+".json";
            Json.writeExistingJsonFile(Init.testdataListmodel,GlobalConstants.SCRIPT_NAME.toUpperCase(),jpath);
            JOptionPane.showMessageDialog(null, "Successfully Created Test Script:"+GlobalConstants.SCRIPT_NAME, "Info " , JOptionPane.INFORMATION_MESSAGE);
              SmartGen.initLoad();
              ExecutionLab.init_Load();
            dispose();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ViewTestScriptTableModel getModel() {
        int i=1;
        String[] iter=null;
        List<ViewTestScriptTable> viewtestScriptList = new ArrayList<ViewTestScriptTable>();
        // using for-each loop for iteration over Map.entrySet()
        for(int k=0;k<=Init.TestScript_ManualSteps.size()-1;k++){
            iter=Init.TestScript_ManualSteps.get(k).toString().split("@@@@@");
            ViewTestScriptTable viewTestScriptSteps = new ViewTestScriptTable(i, iter[0], iter[1]);
            viewtestScriptList.add(viewTestScriptSteps);
            i = i + 1;
        }
        viewTestScriptTableModel = new ViewTestScriptTableModel(viewtestScriptList);
        return viewTestScriptTableModel;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTestScript().setVisible(true);
            }
        });
    }

    public static class LineWrapCellRenderer  extends JTextArea implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
            this.setText((String)value);
            this.setWrapStyleWord(true);
            this.setLineWrap(true);

            //this.setBackground(Color.YELLOW);

            int fontHeight = this.getFontMetrics(this.getFont()).getHeight();
            int textLength = this.getText().length();

            int lines = textLength / tblManualSteps.getColumnCount() +1;//+1, because we need at least 1 row.

            int height = fontHeight * lines;
            table.setRowHeight(row, height);

//            Color color = UIManager.getColor("Table.gridColor");
//            MatteBorder border = new MatteBorder(1, 1, 0, 0, color);
//            tblManualSteps.setBorder(border);
            tblManualSteps.setShowGrid(true);
            tblManualSteps.setShowVerticalLines(true);
            tblManualSteps.setGridColor(new java.awt.Color(0, 0, 204));
            //UI_Design.table_dimenetions_manualsteps(tblManualSteps);
            UI_Design.table_dimenetions_manualsteps(tblManualSteps);
            return this;
        }
    }
    // Variables declaration - do not modify
    private javax.swing.JPanel ManualStepsPanel;
    private javax.swing.JButton btnAddStep;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreateScript;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JList<String> listAutomationSteps;
    private javax.swing.JPanel mainPanel;
    public static javax.swing.JTable tblManualSteps;
    public static javax.swing.JLabel txtScriptName;
    // End of variables declaration
}

