package com.saptool.ui.SmartHub.SmartGen;

import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates.Objects_existance;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

/**
 *
 * @author bvatrapu
 */
public class NewTestScript extends javax.swing.JFrame {

    private static final String upString = "Move up";
    private static final String downString = "Move down";
    private static final String deleteString = "Delete";

    public NewTestScript() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        txtScriptName = new javax.swing.JLabel();
        inputScriptName = new javax.swing.JTextField();
        txtSelectTestType = new javax.swing.JLabel();
        comboSelectTestType = new javax.swing.JComboBox<>();
        testdataPanel = new javax.swing.JPanel();
        txtTestKey = new javax.swing.JLabel();
        inputKey = new javax.swing.JTextField();
        inputValue = new javax.swing.JTextField();
        txtTestValue = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTestData = new javax.swing.JList<>();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSwap = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnAddTestType = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        txtScriptName.setFont(new java.awt.Font("Tahoma", 1, 20));
        txtScriptName.setText("Test Script Name:");

        inputScriptName.setFont(new java.awt.Font("Tahoma", 0, 20));
        inputScriptName.setForeground(new java.awt.Color(51, 0, 153));

        txtSelectTestType.setFont(new java.awt.Font("Tahoma", 1, 20));
        txtSelectTestType.setText("Select Test Type:");

        testdataPanel.setBackground(new java.awt.Color(255, 255, 255));
        testdataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TEST DATA SETUP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(153, 0, 204)));

        txtTestKey.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtTestKey.setText("Test Key:");

        txtTestValue.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtTestValue.setText("Test Value:");

//        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
//        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18));
//        btnAdd.setText("Add");
        UI_Design.button_ui_style_violet(btnAdd,"Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        listTestData.setFont(new java.awt.Font("Tahoma", 0, 22));
        listTestData.setForeground(new java.awt.Color(102, 0, 255));
        jScrollPane1.setViewportView(listTestData);

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Up_Squared_48px.png")));
        btnUp.setToolTipText("UP");
        UI_Design.listControls(btnUp);
        btnUp.setActionCommand(upString);
        btnUp.addActionListener(new UpDownListener());


        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Drop_Down_48px.png")));
        btnDown.setToolTipText("DOWN");
        UI_Design.listControls(btnDown);
        btnDown.setActionCommand(downString);
        btnDown.addActionListener(new UpDownListener());


        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Reduce_48px.png")));
        btnRemove.setToolTipText("DELETE");
        UI_Design.listControls(btnRemove);
        btnRemove.setActionCommand(deleteString);
        btnRemove.addActionListener(new DeleteButtonListener());


        btnSwap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Root_48px.png")));
        btnSwap.setToolTipText("SWAP");
        UI_Design.listControls(btnSwap);
        btnSwap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testdataPanelLayout = new javax.swing.GroupLayout(testdataPanel);
        testdataPanel.setLayout(testdataPanelLayout);
        testdataPanelLayout.setHorizontalGroup(
                testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txtTestKey)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputKey, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTestValue)
                                .addGap(18, 18, 18)
                                .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                                                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testdataPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap())))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testdataPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testdataPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(415, 415, 415))
        );
        testdataPanelLayout.setVerticalGroup(
                testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtTestKey)
                                                        .addComponent(txtTestValue)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testdataPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(inputKey, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(btnAdd)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1))
                                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                                .addComponent(btnSwap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );

        UI_Design.button_ui_style_violet(btnNext,"Next");
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 20));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setBorder(null);
        btnClose.setFocusPainted(false);
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnAddTestType.setFocusPainted(false);
        btnAddTestType.setBorder(null);
        btnAddTestType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smartgen/Add_New_48px.png")));
        btnAddTestType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTestTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(382, 382, 382)
                                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(testdataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtScriptName)
                                                                        .addComponent(txtSelectTestType))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(inputScriptName, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                                .addComponent(comboSelectTestType, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(btnAddTestType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtScriptName)
                                        .addComponent(inputScriptName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(txtSelectTestType))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(comboSelectTestType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnAddTestType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40)
                                .addComponent(testdataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        comboSelectTestType.removeAllItems();
        Init.testdataListmodel.removeAllElements();
        String[] allModules=null;
        String moduleName=null;

        allModules = Generic.getAllFileNames(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+"/");
        for(int i=0;i<=allModules.length-1;i++){
            comboSelectTestType.addItem(allModules[i]);
        }

    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartGen_NewTestScript=false;
        dispose();
    }
    private void btnAddTestTypeActionPerformed(java.awt.event.ActionEvent evt) {
      //  if(!Frame_Flag.smartGen_NewTestScript_AddTestType) {
            AddModule addModule = new AddModule();
            addModule.setVisible(true);
           // Frame_Flag.smartGen_NewTestScript_AddTestType=true;
       // }
    }

    private static void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag = true;
        if (inputKey.getText().isEmpty()||inputValue.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter Test data key && value");
            flag=false;
            //return;
        }
        if(flag) {
            Init.testdataListmodel.addElement(inputKey.getText()+"="+inputValue.getText());
            listTestData.setModel(Init.testdataListmodel);
            listTestData.setSelectedIndex(0);
            inputValue.setText("");
            inputKey.setText("");
        }

    }
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
        GlobalConstants.TEST_MODULE_NAME=comboSelectTestType.getSelectedItem().toString();
//        GlobalConstants.TEST_ENV_NAME=comboEnv.getSelectedItem().toString();
        //Generic.writeTestdataJsonFile(testdataListmodel,inputScriptName.getText());
        GlobalConstants.SCRIPT_NAME=inputScriptName.getText();
//        String jpath=GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTDATA_FOLDER+File.separator+GlobalConstants.TEST_MODULE_NAME+File.separator+inputScriptName.getText().toUpperCase()+".json";
        //Json.writeExistingJsonFile(testdataListmodel,inputScriptName.getText(),jpath);

        //Init.TestScript_ManualSteps=new HashMap<String,String>();
        if(!StringUtils.isEmpty(inputScriptName.getText())){
            if(Generic.verifyFileExist(GlobalConstants.SELECTED_PROJECT_PATH+File.separator+GlobalConstants.TEST_FRAMEWORK_TESTSUITES_FOLDER+File.separator+comboSelectTestType.getSelectedItem().toString()+File.separator+inputScriptName.getText()+".java")){
                JOptionPane.showMessageDialog(null,"Script Name: "+inputScriptName.getText()+" already exist");
            } else{
                CreateTestScript createTestScript=new CreateTestScript();
                createTestScript.setVisible(true);
                CreateTestScript.initLoad();
                GlobalConstants.STEP_NO=0;
                Init.TestScript_ManualSteps.removeAllElements();
                Init.TestScript_ManualSteps.clear();
                Init.TestScript_LisModel.removeAllElements();
                Frame_Flag.smartGen_NewTestScript=false;
                dispose();
            }
        } else{
            JOptionPane.showMessageDialog(null,"Enter script name");
        }

    }

    private void btnSwapActionPerformed(ActionEvent evt) {
        int swapEle[]=listTestData.getSelectedIndices();
        swap(swapEle[0], swapEle[1]);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewTestScript().setVisible(true);
            }
        });
    }

    class UpDownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only when
            //there's a valid selection,
            //so go ahead and move the list item.

            int moveMe = listTestData.getSelectedIndex();

            if (e.getActionCommand().equals(upString)) {
                //UP ARROW BUTTON
                if (moveMe != 0) {
                    //not already at top
                    swap(moveMe, moveMe - 1);
                    listTestData.setSelectedIndex(moveMe - 1);
                    listTestData.ensureIndexIsVisible(moveMe - 1);
                }
            } else {
                //DOWN ARROW BUTTON
                if (moveMe != Init.testdataListmodel.getSize() - 1) {
                    //not already at bottom
                    swap(moveMe, moveMe + 1);
                    listTestData.setSelectedIndex(moveMe + 1);
                    listTestData.ensureIndexIsVisible(moveMe + 1);
                }
            }
        }
    }
    class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /*
             * This method can be called only if there's a valid selection, so
             * go ahead and remove whatever's selected.
             */

            ListSelectionModel lsm = listTestData.getSelectionModel();
            int firstSelected = lsm.getMinSelectionIndex();
            int lastSelected = lsm.getMaxSelectionIndex();
            Init.testdataListmodel.removeRange(firstSelected, lastSelected);

            int size = Init.testdataListmodel.size();

            if (size == 0) {
                //List is empty: disable delete, up, and down buttons.
//                btnDelete.setEnabled(false);
//                btnUp.setEnabled(false);
//                btnDown.setEnabled(false);
//                btnSwap.setEnabled(false);

            } else {
                //Adjust the selection.
                if (firstSelected == Init.testdataListmodel.getSize()) {
                    //Removed item in last position.
                    firstSelected--;
                }
                listTestData.setSelectedIndex(firstSelected);
            }
        }
    }
    private void swap(int a, int b) {
        Object aObject = Init.testdataListmodel.getElementAt(a);
        Object bObject = Init.testdataListmodel.getElementAt(b);
        Init.testdataListmodel.set(a, bObject);
        Init.testdataListmodel.set(b, aObject);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddTestType;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSwap;
    private javax.swing.JButton btnUp;
    public static javax.swing.JComboBox<String> comboSelectTestType;
    public static javax.swing.JTextField inputKey;
    public static javax.swing.JTextField inputScriptName;
    public static javax.swing.JTextField inputValue;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JList<String> listTestData;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel testdataPanel;
    private javax.swing.JLabel txtScriptName;
    private javax.swing.JLabel txtSelectTestType;
    private javax.swing.JLabel txtTestKey;
    private javax.swing.JLabel txtTestValue;
    // End of variables declaration
}

