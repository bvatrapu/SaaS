package com.saptool.ui.SmartHub.SmartGen;


import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;
import com.saptool.utils.GlobalConstants;

import javax.swing.*;

/**
 *
 * @author bvatrapu
 */
public class SetupTestArgs extends javax.swing.JFrame {
    public static DefaultListModel testdata_method= new DefaultListModel();
    static DefaultListModel TestdataListModel= new DefaultListModel();
    /**
     * Creates new form SetTestData
     */
    public SetupTestArgs() {
        initComponents();
    }


    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMethodArgOrder = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMethodTestdata = new javax.swing.JList<>();
        btnDone = new javax.swing.JButton();
        txtTestdataKey = new javax.swing.JLabel();
        comboTestDataKey = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnSetupTestData = new javax.swing.JButton();
        txtTestDatValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtScriptName = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

//        listMethodArgOrder.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
        jScrollPane1.setViewportView(listMethodArgOrder);

//        listMethodTestdata.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
        jScrollPane2.setViewportView(listMethodTestdata);


        UI_Design.button_ui_style_violet(btnDone,"DONE");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        txtTestdataKey.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtTestdataKey.setText("Test data key Name: ");


        UI_Design.button_ui_style_violet(btnAdd,"Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });


        UI_Design.button_ui_style_violet(btnSetupTestData,"TestData Setup");
        btnSetupTestData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupTestDataActionPerformed(evt);
            }
        });

        txtTestDatValue.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtTestDatValue.setForeground(new java.awt.Color(0, 204, 204));
        txtTestDatValue.setText("test data value");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("Method Arguements Order");

        txtScriptName.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtScriptName.setForeground(new java.awt.Color(0, 0, 204));
        txtScriptName.setText("jLabel2");

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(txtScriptName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btnSetupTestData, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(384, 384, 384))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addComponent(txtTestdataKey)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(comboTestDataKey, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(62, 62, 62)
                                                                .addComponent(txtTestDatValue, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1))
                                                                .addGap(53, 53, 53)
                                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(66, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(txtScriptName))
                                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTestdataKey)
                                        .addComponent(comboTestDataKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTestDatValue))
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1)
                                                .addGap(9, 9, 9)))
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addGap(56, 56, 56)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnSetupTestData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDone, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                .addContainerGap(46, Short.MAX_VALUE))
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

    public static void init_Load(String[] listMethods){
        testdata_method.removeAllElements();
        //listMethodArgOrder.removeAll();

        String[] testdata=null;
        String testdataKey=null;

        //testSuites = Generic.getAllFileNames(GlobalConstants.SELECTED_PROJECT_PATH+ File.separator+GlobalConstants.TEST_FRAMEWORK_TESTEXECUTION_FOLDER+"/");
        for(int i=0;i<=listMethods.length-1;i++){
            testdata_method.addElement(listMethods[i]);
        }

        listMethodArgOrder.setModel(testdata_method);
    }
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        int argsLen=testdata_method.size();
        int testargs=listMethodTestdata.getModel().getSize();
        String methodArgbuilder=null;
        if(argsLen==testargs){
            methodArgbuilder = "td(\""+TestdataListModel.get(0).toString()+"\")";
            for(int k=1;k<=testargs-1;k++){
                methodArgbuilder = methodArgbuilder+", td(\""+TestdataListModel.get(k).toString()+"\")";
            }
            methodArgbuilder= GlobalConstants.TestScript_Selected_Page_Name.toLowerCase() + "." + GlobalConstants.SELECTED_METHOD+methodArgbuilder+");";

            if(GlobalConstants.VERIFY_SCRIPT_COMMAND){
                Init.Add_TestScript_step_ListModel.addElement("verify("+methodArgbuilder.replaceAll(";","")+","+"\""+GlobalConstants.STEP_EXPECTED+"\""+");");
                AddTestScriptStep.listMethodSteps.setModel(Init.Add_TestScript_step_ListModel);
                AddTestScriptStep.btnVerify.setEnabled(true);
                AddTestScriptStep.listMethodSteps.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                GlobalConstants.VERIFY_SCRIPT_COMMAND = false;
            } else {
//            int count = string.length() - string.replaceAll("g","").length()
                Init.Add_TestScript_step_ListModel.addElement(methodArgbuilder);
                AddTestScriptStep.listMethodSteps.setModel(Init.Add_TestScript_step_ListModel);
            }
            dispose();
        }else{

            int baltestargs=argsLen - testargs;
            JOptionPane.showMessageDialog(null, "Add "+baltestargs+" more arguments !!");
        }
        TestdataListModel.removeAllElements();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        if(TestdataListModel.contains(comboTestDataKey.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(null, comboTestDataKey.getSelectedItem().toString()+":  Already Added !");
        } else{
            TestdataListModel.addElement(comboTestDataKey.getSelectedItem().toString());
            listMethodTestdata.setModel(TestdataListModel);
        }
    }

    private void btnSetupTestDataActionPerformed(java.awt.event.ActionEvent evt) {
        if(!Frame_Flag.smartgen_testdatasetup){
            TestDataSetup testDataSetup=new TestDataSetup();
            testDataSetup.setVisible(true);
            TestDataSetup.init_Load();
            Frame_Flag.smartgen_testdatasetup=true;
        }
    }

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
       dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetupTestArgs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnSetupTestData;
    public static javax.swing.JComboBox<String> comboTestDataKey;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JList<String> listMethodArgOrder;
    public static javax.swing.JList<String> listMethodTestdata;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel txtScriptName;
    private javax.swing.JLabel txtTestDatValue;
    private javax.swing.JLabel txtTestdataKey;
    // End of variables declaration
}

