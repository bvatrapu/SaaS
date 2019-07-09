package com.saptool.ui.SmartHub.SmartBuilder.SmartObject;


import com.saptool.frameworkbuilder.PageBuilder;
import com.saptool.ui.Frame_Flag;
import com.saptool.utils.Generic;
import com.saptool.utils.GlobalConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Bharath Kumar Reddy Vatrapu
 */
public class New_SmartObject extends javax.swing.JFrame {
    public static ButtonGroup bgObjIdentfiers = new ButtonGroup();
    /**
     * Creates new form New_SmartObject
     */
    public New_SmartObject() {
        initComponents();
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtObjectName = new javax.swing.JLabel();
        inputObjectName = new javax.swing.JTextField();
        txtObjectType = new javax.swing.JLabel();
        listObjectType = new javax.swing.JComboBox<>();
        txtValue = new javax.swing.JLabel();
        inputValue = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnObjectSpy = new javax.swing.JButton();
        rbID = new javax.swing.JRadioButton();
        rbXPATH = new javax.swing.JRadioButton();
        rbCSS = new javax.swing.JRadioButton();
        btnClose = new javax.swing.JButton();

        setUndecorated(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(244, 233, 0) ));
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtObjectName.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtObjectName.setForeground(new java.awt.Color(153, 0, 255));
        txtObjectName.setText("Object Name:");

        txtObjectType.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtObjectType.setForeground(new java.awt.Color(153, 0, 255));
        txtObjectType.setText("Object Type:");

        listObjectType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Link", "Button", "RadioButton", "EditBox", "CheckBox", "ComboBox", "Text", "Image", "" }));

        txtValue.setFont(new java.awt.Font("Tahoma", 0, 24));
        txtValue.setForeground(new java.awt.Color(153, 0, 255));
        txtValue.setText("Value: ");

        inputValue.setToolTipText("");

        btnCreate.setBackground(new java.awt.Color(255, 255, 255));
        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnCreate.setForeground(new java.awt.Color(153, 0, 153));
        btnCreate.setText("Create");
        btnCreate.setFocusPainted(false);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnObjectSpy.setBackground(new java.awt.Color(255, 255, 255));
        btnObjectSpy.setFont(new java.awt.Font("Tahoma", 1, 24));
        btnObjectSpy.setForeground(new java.awt.Color(153, 0, 153));
        btnObjectSpy.setText("Object Fire");
        btnObjectSpy.setFocusPainted(false);
        btnObjectSpy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObjectSpyActionPerformed(evt);
            }
        });

        rbID.setBackground(new java.awt.Color(255, 255, 255));
        rbID.setText("ID");

        rbXPATH.setBackground(new java.awt.Color(255, 255, 255));
        rbXPATH.setText("XPATH");

        rbCSS.setBackground(new java.awt.Color(255, 255, 255));
        rbCSS.setText("CSS");

        rbID.setSelected(true);
        bgObjIdentfiers.add(rbID);
        bgObjIdentfiers.add(rbXPATH);
        bgObjIdentfiers.add(rbCSS);

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/smarthub/Close_Window_32px.png")));
        btnClose.setBorder(null);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnObjectSpy, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(txtValue)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(inputValue))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtObjectName)
                                                                        .addComponent(txtObjectType))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(inputObjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(listObjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(rbID)
                                                .addGap(94, 94, 94)
                                                .addComponent(rbXPATH)
                                                .addGap(130, 130, 130)
                                                .addComponent(rbCSS)))
                                .addContainerGap(41, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtObjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputObjectName))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtObjectType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(listObjectType, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbID)
                                        .addComponent(rbXPATH)
                                        .addComponent(rbCSS))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtValue, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                                .addGap(62, 62, 62))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnObjectSpy, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        Frame_Flag.smartBuilder_smartObject_New=false;
        dispose();
        if(!Frame_Flag.smartBuilder_smartObject) {
            SmartObject smartObject = new SmartObject();
            smartObject.setVisible(true);
            SmartObject.init_Load();
            Frame_Flag.smartBuilder_smartObject=true;
        }
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {
        String pageObjectmodel=null;
        String findby=null;
        String webelement=null;
        String val=inputValue.getText();
        String cachelookup = "\t@CacheLookup";
        switch (getIdetifier().toUpperCase()){
            case "ID":
                findby = "@FindBy(id="+"\"" + val +"\""+ ")";
                break;

            case "XPATH":
                findby = "@FindBy(xpath = "+"\"" + val +"\""+ ")";
                break;

            case "CSS":
                findby = "@FindBy(css = " +"\""+ val+"\"" + ")";
                break;
        }
        webelement = "public WebElement "+getObjType() +inputObjectName.getText()+ ";";
        pageObjectmodel = cachelookup+System.lineSeparator()+ "\t"+findby + System.lineSeparator() +"\t"+ webelement+System.lineSeparator();

        PageBuilder.pageObjectBuilder(pageObjectmodel,webelement);
        PageBuilder.pageOperationBuilder(getOperations(listObjectType.getSelectedItem().toString(),inputObjectName.getText()));
        Frame_Flag.smartBuilder_smartObject_New=false;
        dispose();
    }
    public String firstFive(String str) {
        return str.length() < 5 ? str : str.substring(0, 5);
    }
    public String getOperations(String operation,String objName){
        String value=null;
        switch (operation) {
            case "Link":
                value=getLinkOperation(objName);
                break;
            case "Button":
                value=getButtonOperation(objName);
                break;
            case "CheckBox":
                value=getCheckBoxOperations(objName);
                break;
            case "EditBox":
                value=getInputOperation(objName);
                break;
            case "RadioButton":
                value=getRadioButtonOperations(objName);
                break;
            case "ComboBox":
                value=getListOperations(objName);
                break;

        }
        return value;
    }
    public String getLinkOperation(String lnkname){
        String value;
        value = "\tpublic void click"+lnkname+"(){   lnk"+lnkname+".click();   }"+System.lineSeparator();
        return value;
    }
    public String getButtonOperation(String objName){
        String value;
        value = "\tpublic void click"+objName+"(){   btn"+objName+".click();   }"+System.lineSeparator();
        return value;
    }

    public String getInputOperation(String objName){
        String valueEdit;
        String opName;
        if(firstFive(objName).equalsIgnoreCase("input")) {
            opName= objName.replaceAll("input","");
            valueEdit = "\tpublic void enter" + opName + "(String input_value){  " + System.lineSeparator() +
                    "\t\t" + objName + ".sendKeys(input_value); " + System.lineSeparator() +
                    "\t}" + System.lineSeparator();
        } else{
            opName= objName.replaceAll("input","");
            valueEdit = "\tpublic void enter" + opName + "(String input_value){  " + System.lineSeparator() +
                    "\t\tinput" + objName + ".sendKeys(input_value); " + System.lineSeparator() +
                    "\t}" + System.lineSeparator();
        }
        return valueEdit;
    }
    public String getRadioButtonOperations(String objName){
        String value;
        value = "\tpublic void click"+objName+"(){   radio"+objName+".click();   }"+System.lineSeparator();
        return value;
    }
    public String getListOperations(String objName){
        String value;
        value = "\tpublic void select"+objName+"(String itemToSelect){   " +System.lineSeparator()+
                "\t\tSelect list = new Select(list"+objName+");"+System.lineSeparator()+
                "\t\tlist.selectByVisibleText(itemToSelect);"+System.lineSeparator()+
                "\t}";
        return value;
    }
    public String getCheckBoxOperations(String objName){
        String value;
        value = "\tpublic void click"+objName+"(){   chkbox"+objName+".click();   }"+System.lineSeparator();
        return value;
    }
    public String getIdetifier(){
        if(rbID.isSelected()){
            return rbID.getText();
        }else if(rbCSS.isSelected()){
            return rbCSS.getText();
        } else{
            return rbXPATH.getText();
        }
    }
    public String getObjType(){
        String objtype=listObjectType.getSelectedItem().toString();
        if(objtype.equals("Select")){
            JOptionPane.showMessageDialog(null, "Select Object Type", "Warning ", JOptionPane.INFORMATION_MESSAGE);
            return null;

        } else {
            if (objtype.equals("Link")) {
                return "lnk";
            } else if (objtype.equals("Button")) {
                return "btn";
            } else if (objtype.equals("RadioButton")) {
                return "radio";
            } else if (objtype.equals("EditBox")) {
                return "input";
            } else if (objtype.equals("CheckBox")) {
                return "chkbox";
            } else if (objtype.equals("ComboBox")) {
                return "list";
            } else if (objtype.equals("Text")) {
                return "txt";
            } else {
                return "img";
            }
        }
    }
    private void btnObjectSpyActionPerformed(java.awt.event.ActionEvent evt) {
        Generic.openFile(GlobalConstants.SAP_OBJECT_SPY_TOOL);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_SmartObject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnObjectSpy;
    private javax.swing.JCheckBox checkboxCSS;
    private javax.swing.JCheckBox checkboxID;
    private javax.swing.JCheckBox checkboxXpath;
    private javax.swing.JTextField inputObjectName;
    private javax.swing.JTextField inputValue;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> listObjectType;
    private javax.swing.JLabel txtObjectName;
    private javax.swing.JLabel txtObjectType;
    private javax.swing.JLabel txtValue;
    private javax.swing.JRadioButton rbCSS;
    private javax.swing.JRadioButton rbID;
    private javax.swing.JRadioButton rbXPATH;
    // End of variables declaration
}

