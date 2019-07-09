package com.saptool.ui.SmartHub.SmartGen;


import com.saptool.ui.Init;
import com.saptool.ui.UI_Design;

import javax.swing.*;

/**
 *
 * @author bvatrapu
 */
public class TestDataSetup extends javax.swing.JFrame {

    /**
     * Creates new form TestDataSetup
     */
    public TestDataSetup() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        testdataPanel = new javax.swing.JPanel();
        txtTestKey = new javax.swing.JLabel();
        inputKey = new javax.swing.JTextField();
        inputValue = new javax.swing.JTextField();
        txtTestValue = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTestData = new javax.swing.JList<>();
        btnRemove = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        testdataPanel.setBackground(new java.awt.Color(255, 255, 255));
        testdataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TEST DATA SETUP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(153, 0, 204)));

        txtTestKey.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtTestKey.setText("Test Key:");

        txtTestValue.setFont(new java.awt.Font("Tahoma", 0, 20));
        txtTestValue.setText("Test Value:");

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        listTestData.setFont(new java.awt.Font("Tahoma", 0, 22));
        listTestData.setForeground(new java.awt.Color(102, 0, 255));
        jScrollPane1.setViewportView(listTestData);

        btnRemove.setBackground(new java.awt.Color(255, 255, 255));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 18));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout testdataPanelLayout = new javax.swing.GroupLayout(testdataPanel);
        testdataPanel.setLayout(testdataPanelLayout);
        testdataPanelLayout.setHorizontalGroup(
                testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testdataPanelLayout.createSequentialGroup()
                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, testdataPanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(txtTestKey)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(inputKey, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                                .addComponent(txtTestValue)
                                                .addGap(18, 18, 18)
                                                .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31))
                        .addGroup(testdataPanelLayout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGap(34, 34, 34)
                                .addGroup(testdataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnCreate.setText("CREATE");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(testdataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(377, 377, 377)
                                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(testdataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
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

    public static void init_Load(){
        //Frame_Flag.smartgen_testdatasetup=true;
        listTestData.setModel(Init.testdataListmodel);
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        Init.testdataListmodel.removeElement(listTestData.getSelectedValue());
        listTestData.setModel(Init.testdataListmodel);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestDataSetup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTextField inputKey;
    private javax.swing.JTextField inputValue;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JList<String> listTestData;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel testdataPanel;
    private javax.swing.JLabel txtTestKey;
    private javax.swing.JLabel txtTestValue;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    // End of variables declaration
}
