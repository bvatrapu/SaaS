package com.saptool.ui.SmartHub.SmartBuilder.CreateNewPage;


import com.saptool.ui.Frame_Flag;
import com.saptool.ui.Init;
import com.saptool.ui.SmartHub.SmartBuilder.SmartComponent.Templates.Objects_existance;
import com.saptool.ui.UI_Design;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class NavigationByUrl extends javax.swing.JFrame {
    public static HashMap<String,String> addEnv_valu_Hashmap=null;

    /**
     * Creates new form NavigationByUrl
     */
    public NavigationByUrl() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        comboEnvValues = new javax.swing.JComboBox<>();
        inputUrl = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listUrls = new javax.swing.JList<>();
        btnNext = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        UI_Design.frame_boarder(this);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        inputUrl.setFont(new java.awt.Font("Tahoma", 0, 20));
        inputUrl.setForeground(new java.awt.Color(153, 153, 153));

        UI_Design.button_ui_style_violet(btnadd,"Add");

        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        UI_Design.button_ui_style_violet(btnRemove,"Remove");
        btnRemove.setFont(new Font("Tahoma", 0, 18));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        listUrls.setFont(new java.awt.Font("Tahoma", 1, 18));
        listUrls.setForeground(new java.awt.Color(51, 153, 0));
        jScrollPane1.setViewportView(listUrls);


        UI_Design.button_ui_style_violet(btnNext,"NEXT");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnClose.setBorder(null);
        btnClose.setFocusPainted(false);
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(312, 312, 312)
                                                .addComponent(inputUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(comboEnvValues, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(364, 364, 364)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboEnvValues)
                                        .addComponent(inputUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void init_load(){
        //Init.Nav_Url_BySteps_ListModel.removeAllElements();
        addEnv_valu_Hashmap =new HashMap<String,String>();
        addEnv_valu_Hashmap = Generic.readAllProp(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+"environment.properties");
        for (Map.Entry<String, String> entry : addEnv_valu_Hashmap.entrySet()) {
            comboEnvValues.addItem(entry.getValue());
        }
        Init.Nav_Url_BySteps_ListModel.removeAllElements();
    }
    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {
        if(StringUtils.isEmpty(inputUrl.getText()) || !inputUrl.getText().contains("http")){
            JOptionPane.showMessageDialog(null,"Enter url in the field");
        } else{
            if(Generic.verifyList(Init.Nav_Url_BySteps_ListModel,comboEnvValues.getSelectedItem()+"#=#")){
                JOptionPane.showMessageDialog(null,"Already Exist");
            } else {
                Init.Nav_Url_BySteps_ListModel.addElement(comboEnvValues.getSelectedItem() + "#=#" + inputUrl.getText());
                listUrls.setModel(Init.Nav_Url_BySteps_ListModel);
                inputUrl.setText("");
            }
        }
    }

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        Init.Nav_Url_BySteps_ListModel.removeElement(listUrls.getSelectedValue());
    }

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {

        if(comboEnvValues.getItemCount()==listUrls.getModel().getSize()) {
            if (GlobalConstants.Navigation_Both) {
                NavigationBySteps navigationBySteps = new NavigationBySteps();
                navigationBySteps.setVisible(true);
                NavigationBySteps.initLoad();
                dispose();
            } else {
                if (!Init.Nav_Url_BySteps_ListModel.isEmpty()) {
                    ObjectBuilder objectBuilder = new ObjectBuilder();
                    objectBuilder.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Enter Url");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Enter All Enviornment urls");
        }
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartbuilder_CreateNewPage_pageNavigation=false;
        dispose();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NavigationByUrl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnadd;
    public static javax.swing.JComboBox<String> comboEnvValues;
    private javax.swing.JTextField inputUrl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listUrls;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration
}

