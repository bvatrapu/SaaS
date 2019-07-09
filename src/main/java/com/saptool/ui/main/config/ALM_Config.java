package com.saptool.ui.main.config;

import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class ALM_Config extends javax.swing.JPanel {

    public static ButtonGroup bgAlm = new ButtonGroup();
    public static DefaultListModel alm_config_ListModel= new DefaultListModel();

    public static String alm_prop_path=null;

    /**
     * Creates new form ALM_Config
     */
    public ALM_Config() {
        initComponents();

    }


    private void initComponents() {

        txtAlmIntegration = new javax.swing.JLabel();
        rbOn = new javax.swing.JRadioButton();
        rbOff = new javax.swing.JRadioButton();
        txtAlmURl = new javax.swing.JLabel();
        inputUrl = new javax.swing.JTextField();
        txtUserName = new javax.swing.JLabel();
        inputUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JTextField();
        txtDomain = new javax.swing.JLabel();
        inputDomain = new javax.swing.JTextField();
        txtProject = new javax.swing.JLabel();
        inputProject = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));


        txtAlmIntegration.setFont(new java.awt.Font("Tahoma", 0, 22));
        txtAlmIntegration.setForeground(new java.awt.Color(0, 102, 153));
        txtAlmIntegration.setText("ALM Integration :");

        rbOn.setBackground(new java.awt.Color(255, 255, 255));
        rbOn.setFont(new java.awt.Font("Tahoma", 0, 22));
        rbOn.setForeground(new java.awt.Color(0, 153, 51));
        rbOn.setText("ON");

        rbOff.setBackground(new java.awt.Color(255, 255, 255));
        rbOff.setFont(new java.awt.Font("Tahoma", 0, 22));
        rbOff.setForeground(new java.awt.Color(255, 102, 0));
        rbOff.setText("OFF");

        bgAlm.add(rbOff);
        bgAlm.add(rbOn);

        txtAlmURl.setFont(new java.awt.Font("Tahoma", 0, 22));
        txtAlmURl.setForeground(new java.awt.Color(0, 102, 153));
        txtAlmURl.setText("URL :");

        inputUrl.setFont(new java.awt.Font("Tahoma", 0, 20));

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 22));
        txtUserName.setForeground(new java.awt.Color(0, 102, 153));
        txtUserName.setText("User Name :");

        inputUserName.setFont(new java.awt.Font("Tahoma", 0, 20));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 22));
        txtPassword.setForeground(new java.awt.Color(0, 102, 153));
        txtPassword.setText("Password :");

        inputPassword.setFont(new java.awt.Font("Tahoma", 0, 20));

        txtDomain.setFont(new java.awt.Font("Tahoma", 0, 22));
        txtDomain.setForeground(new java.awt.Color(0, 102, 153));
        txtDomain.setText("Domain :");

        inputDomain.setFont(new java.awt.Font("Tahoma", 0, 20));

        txtProject.setFont(new java.awt.Font("Tahoma", 0, 22));
        txtProject.setForeground(new java.awt.Color(0, 102, 153));
        txtProject.setText("Project :");

        inputProject.setFont(new java.awt.Font("Tahoma", 0, 20));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(txtAlmURl)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(inputUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(txtAlmIntegration)
                                                                        .addGap(40, 40, 40)
                                                                        .addComponent(rbOn)
                                                                        .addGap(39, 39, 39)
                                                                        .addComponent(rbOff)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addComponent(txtDomain, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtProject, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(inputProject, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                                                                        .addComponent(inputDomain)
                                                                        .addComponent(inputPassword)
                                                                        .addComponent(inputUserName)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(184, 184, 184)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(97, 97, 97)
                                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAlmIntegration)
                                        .addComponent(rbOn)
                                        .addComponent(rbOff))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtAlmURl)
                                        .addComponent(inputUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUserName)
                                        .addComponent(inputUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPassword)
                                        .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDomain)
                                        .addComponent(inputDomain, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtProject)
                                        .addComponent(inputProject, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
    }

    public static void init_Load(){
        alm_prop_path=GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.alm_properties;
        if(Generic.readProp("alm_integration",alm_prop_path).equalsIgnoreCase("on")){
            rbOn.setSelected(true);
        }else{
            rbOff.setSelected(true);
        }
        inputUrl.setText(Generic.readProp("alm_url",alm_prop_path));
        inputUserName.setText(Generic.readProp("alm_username",alm_prop_path));
        inputPassword.setText(Generic.readProp("alm_project",alm_prop_path));
        inputDomain.setText(Generic.readProp("alm_password",alm_prop_path));
        inputProject.setText(Generic.readProp("alm_domain",alm_prop_path));
    }
    public static String getAlm(){
        if(rbOn.isSelected()){
            return rbOn.getText();
        }else{
            return rbOff.getText();
        }
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        boolean flag=true;
        if(getAlm().equalsIgnoreCase("on")){
            alm_config_ListModel.addElement("alm_integration"+"=ON");
        } else{
            alm_config_ListModel.addElement("alm_integration"+"=OFF");
        }
        if(StringUtils.isEmpty(inputUrl.getText())){
            flag=false;
            JOptionPane.showMessageDialog(null,"Enter ALM URL");
        } else{
            alm_config_ListModel.addElement("alm_url"+"="+inputUrl.getText());
        }
        if(StringUtils.isEmpty(inputUserName.getText())){
            flag=false;
            JOptionPane.showMessageDialog(null,"Enter ALM UserName");
        }else{
            alm_config_ListModel.addElement("alm_username"+"="+inputUserName.getText());
        }
        if(StringUtils.isEmpty(inputPassword.getText())){
            flag=false;
            JOptionPane.showMessageDialog(null,"Enter ALM Password");
        }else{
            alm_config_ListModel.addElement("alm_password"+"="+inputPassword.getText());
        }
        if(StringUtils.isEmpty(inputProject.getText())){
            flag=false;
            JOptionPane.showMessageDialog(null,"Enter ALM Project");
        }else{
            alm_config_ListModel.addElement("alm_project"+"="+inputProject.getText());
        }
        if(StringUtils.isEmpty(inputDomain.getText())){
            flag=false;
            JOptionPane.showMessageDialog(null,"Enter ALM Domain");
        }else{
            alm_config_ListModel.addElement("alm_domain"+"="+inputDomain.getText());
        }


        if(!Generic.verifyFileExist(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.alm_properties)){
           Generic.createNewFile(GlobalConstants.CONFIG_PROJECTS_FOLDER_PATH+ File.separator+GlobalConstants.SELECTED_PROJECT+File.separator+GlobalConstants.alm_properties);
        }
        if(flag) {
            Generic.write_ALMProp(alm_config_ListModel);
            JOptionPane.showMessageDialog(null,"SUCCESSFULLY SAVED");
        }
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        inputUrl.setText("");
        inputUserName.setText("");
        inputPassword.setText("");
        inputDomain.setText("");
        inputProject.setText("");
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    public static javax.swing.JTextField inputDomain;
    public static javax.swing.JTextField inputPassword;
    public static javax.swing.JTextField inputProject;
    public static javax.swing.JTextField inputUrl;
    public static javax.swing.JTextField inputUserName;
    public static javax.swing.JRadioButton rbOff;
    public static javax.swing.JRadioButton rbOn;
    private javax.swing.JLabel txtAlmIntegration;
    private javax.swing.JLabel txtAlmURl;
    private javax.swing.JLabel txtDomain;
    private javax.swing.JLabel txtPassword;
    private javax.swing.JLabel txtProject;
    private javax.swing.JLabel txtUserName;
    // End of variables declaration
}

