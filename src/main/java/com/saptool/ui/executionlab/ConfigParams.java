package com.saptool.ui.executionlab;


import com.saptool.ui.Init;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ConfigParams extends JFrame {


   // public static DefaultListModel paramslistmodel= new DefaultListModel();
    /**
     * Creates new form ConfigParams
     */
    public ConfigParams() {
        initComponents();
        initLoad();
    }


    private void initComponents() {

        panelConfigParams = new JPanel();
        btnAddvalue = new JButton();
        btnDone = new JButton();
        btnSetupParams = new JButton();
        jScrollPane2 = new JScrollPane();
        listparams = new JList<>();


        setTitle("Config ParamNames");
        panelConfigParams.setBackground(new java.awt.Color(255, 255, 255));
        panelConfigParams.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnAddvalue.setBackground(new java.awt.Color(255, 255, 255));
        btnAddvalue.setText("Add value");
        btnAddvalue.setFocusPainted(false);
        btnAddvalue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddvalueActionPerformed(evt);
            }
        });

        btnDone.setBackground(new java.awt.Color(255, 255, 255));
        btnDone.setText("Done");
        btnDone.setFocusPainted(false);
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnSetupParams.setBackground(new java.awt.Color(255, 255, 255));
        btnSetupParams.setText("Setup Prameters");
        btnSetupParams.setFocusPainted(false);
        btnSetupParams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupParamsActionPerformed(evt);
            }
        });

        listparams.setBorder(BorderFactory.createTitledBorder(null, "ParamNames", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane2.setViewportView(listparams);

        GroupLayout panelConfigParamsLayout = new GroupLayout(panelConfigParams);
        panelConfigParams.setLayout(panelConfigParamsLayout);
        panelConfigParamsLayout.setHorizontalGroup(
                panelConfigParamsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelConfigParamsLayout.createSequentialGroup()
                                .addGroup(panelConfigParamsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelConfigParamsLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnAddvalue))
                                        .addGroup(panelConfigParamsLayout.createSequentialGroup()
                                                .addGap(208, 208, 208)
                                                .addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelConfigParamsLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnSetupParams, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelConfigParamsLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelConfigParamsLayout.setVerticalGroup(
                panelConfigParamsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelConfigParamsLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnAddvalue)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnDone, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSetupParams, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelConfigParams, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelConfigParams, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void btnAddvalueActionPerformed(java.awt.event.ActionEvent evt) {
        if(listparams.getSelectedValue()==null){
            JOptionPane.showMessageDialog(null, "Select parameter", "Warning " , JOptionPane.INFORMATION_MESSAGE);
        } else {
            Init.param_Selected=listparams.getSelectedValue();
            if(Init.param_Selected.contains("=")) {
                String[] param = Init.param_Selected.split("=");
                Init.param_Name = param[0];
            } else{
                Init.param_Name = listparams.getSelectedValue();
            }

            Init.addValue = new AddValue();
            Init.addValue.setVisible(true);

        }
    }


    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void btnSetupParamsActionPerformed(java.awt.event.ActionEvent evt) {
        Init.setupParams = new SetupParams();
        Init.setupParams.setVisible(true);
        //new SetupParams().setVisible(true);
    }

    public static void initLoad(){
        Map<String, String> hm = new HashMap<>();
        hm.put("LIST","lstOk");
        hm.put("LIST","lstUser");
        hm.put("BUTTON","btnSignIn");
        hm.put("BUTTON","btnSubmit");
        for (String key : hm.keySet()) {

        }
        listparams.setModel(Init.paramNameandValuesListModel);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigParams().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton btnAddvalue;
    private JButton btnDone;
    private JButton btnSetupParams;
    private JScrollPane jScrollPane2;
    public static JList<String> listparams;
    private JPanel panelConfigParams;
    // End of variables declaration
}
